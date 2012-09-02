package com.johnbenjamincassel.conditionable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import org.apache.log4j.Logger;

import com.johnbenjamincassel.utilities.CollectionPrinter;
import com.johnbenjamincassel.utilities.datastructures.HashToHashSet;

public class BacktrackingEvaluator <T> {
	
	AbstractExpression m_expression;
	Logger  m_logger;
	public BacktrackingEvaluator(AbstractExpression expression) {
		m_expression = expression;
		m_logger = Logger.getLogger("com.johnbenjamincassel.conditionable");
	}
	
	public synchronized HashMap<String, Object> evaluate(ArrayList<T> values) {
		HashSet<String> available_vars = new HashSet<String>();
		m_expression.collectVariables(available_vars);
		HashToHashSet<String, Object> bindings 
			= tryBinding(values, values.size() - 1, available_vars);
		if(bindings==null) { return null; }
		return bindings.pickOneFromEachSet();
	}

	private HashToHashSet<String, Object> tryBinding(ArrayList<T> values, int values_index, 
			HashSet<String> available_vars) {
		if(m_expression.isSatisfied()) { 
			return m_expression.getAllBindings();
		}
		
		if(values_index < 0) {
			return null;
		}
		
		T value = values.get(values_index);
		ArrayList<String> vars = new ArrayList<String>(available_vars);
		HashToHashSet<String, Object> bindings = null;
		for(String var : vars) {
			m_logger.debug("Satisfying var: "+ var);
			HashSet current_bindings = m_expression.getBindings(var); 
			
			if(current_bindings != null) {
				m_logger.debug("Current bindings: " + 
						CollectionPrinter.getCollectionString(current_bindings));
				if(current_bindings.isEmpty()) { continue; }
				available_vars.remove(var);
				bindings = tryBinding(values, values_index, available_vars);
				available_vars.add(var);
				if(bindings != null){
					return bindings;
				}
			}
			m_expression.bind(var,value);
			if((values_index != 0) 
					? m_expression.canBeSatisfied() 
					: m_expression.isSatisfied()) {
				available_vars.remove(var);
				bindings = tryBinding(values, values_index -1, available_vars);
				available_vars.add(var);
			}
			m_expression.unbind(var, value);
			if(bindings != null){
				bindings.put(var, value);
				return bindings;
			}
		}
		return tryBinding(values, values_index -1, available_vars);
	}
}
