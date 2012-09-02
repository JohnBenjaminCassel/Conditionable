package com.johnbenjamincassel.conditionable;

import java.util.ArrayList;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.johnbenjamincassel.utilities.CollectionPrinter;
import com.johnbenjamincassel.utilities.datastructures.HashToArrayList;
import com.johnbenjamincassel.utilities.datastructures.HashToHashSet;

public class Variable<T> extends TerminalExpression implements Value {

	String m_name;
	HashSet<T> m_bind_values = null;
	boolean m_is_bound = false;
	HashToHashSet<String,T> m_pointwise_constraints 
		= new HashToHashSet<String,T>();
	private Class<T> m_type;
	Logger  m_logger;

	
	public Variable(String name, Class<T> type) { 
		m_name = name;
		m_type = type;
		m_logger = Logger.getLogger("com.johnbenjamincassel.conditionable");
	}
	
	public boolean bind(String v, Object o) {		
		if(m_name.equals(v)) {
			if(m_pointwise_constraints.containsKey(v)) { 
				throw new RuntimeException("double binding of root variable: " + v);
			}
			if(! m_type.isInstance(o)) {
				m_bind_values = null;
			}
			else {
				m_pointwise_constraints.put(v, (T) o);
				recalculateBindValues();
			}
			m_logger.debug("bound " + v + " to " + o);
			m_is_bound = true;
			return true;
		}
		return false;
	}
	
	public void addConstraintSet(String v, HashSet<T> constraintSet) {
		m_logger.debug("constraining "+v 
				+ " with "+CollectionPrinter.getCollectionString(constraintSet));
		m_pointwise_constraints.putAll(v, constraintSet);
		recalculateBindValues();
	}

	public boolean canBeSatisfied() { 
		return (!m_is_bound) || satisfiesConstraints(); 
	}

	public boolean isSatisfied() { 
		boolean satisfied = m_is_bound && satisfiesConstraints();
		
		if(satisfied) {
			StringBuffer sb = new StringBuffer(m_name+" is satisfied by ");
			if(m_bind_values == null) {
				sb.append("null");
			}
			else {
				sb.append(CollectionPrinter.getCollectionString(m_bind_values));
			}
			m_logger.debug(sb.toString());
		} 
		return satisfied; 
	}
	
	private boolean satisfiesConstraints() {
		return (m_bind_values != null) && (! m_bind_values.isEmpty());
	}
	
	public void collectVariables(HashSet<String> set) {
		set.add(m_name);
	}

	
	public void unbind(String v, Object o) {
		if(m_pointwise_constraints.containsKey(v)) {
			m_pointwise_constraints.removeAll(v);
			recalculateBindValues();
		}
	}

	private void recalculateBindValues() {
		m_bind_values = null;
		for(HashSet<T> constraint_set 
				: m_pointwise_constraints.values()) {
			// CollectionPrinter.printCollection(constraint_set);
			if(m_bind_values == null) {
				m_bind_values = new HashSet<T>(constraint_set);
			}
			else {
				m_bind_values.retainAll(constraint_set);
			}
		}
		
		m_logger.debug("bind value of "+m_name+" is now " +
			((m_bind_values == null) 
				? "null" 
				: CollectionPrinter.getCollectionString(m_bind_values)
			)	
		);
		
			
		
		m_is_bound = (m_bind_values != null);
	}

	public HashSet<T> getBindValues() { return m_bind_values; }
	
	public String getName() { return m_name; }



	@Override
	public HashSet<Object> getBindings(String var) {
		if(var.equals(m_name)) { 
			return (HashSet<Object>) getBindValues(); 
		}
		return null;
	}
	
	@Override
	public HashToHashSet<String, Object> getAllBindings() {
		HashSet<String> variables = new HashSet<String>();
		collectVariables(variables);
		HashToHashSet<String, Object> all_bindings = new HashToHashSet<String, Object>();
		for(String var: variables) {
			all_bindings.putAll(var, getBindings(var));
		}
		return all_bindings;
	}
	
	@Override
	public HashSet<ConditionalExpressionInterface> getConditions(
			HashSet<ConditionalExpressionInterface> set) {
		return set;
	}

	public boolean isBound() {
		return m_is_bound;
	}
}
