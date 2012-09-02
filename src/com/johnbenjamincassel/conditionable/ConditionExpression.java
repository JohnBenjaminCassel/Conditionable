package com.johnbenjamincassel.conditionable;

import java.util.ArrayList;
import java.util.HashSet;

import com.johnbenjamincassel.utilities.datastructures.HashToHashSet;

public class ConditionExpression extends TerminalExpression implements ConditionalExpressionInterface {

	private ConditionableVariable m_cond_var;
	private ArrayList<Value> m_arguments;
	private String m_condition;

	public ConditionExpression(ConditionableVariable cond_var, String condition) {
		m_cond_var = cond_var;
		m_arguments = new ArrayList<Value>();
		m_condition = condition;
 	}
	
	public void addArgument(Value arg) {
		m_arguments.add(arg);
	}
	
	public boolean bind(String v, Object o) {
		
		boolean bound = m_cond_var.bind(v, o);
		for(Value arg : m_arguments) {
			if(arg.bind(v, o)) {
				bound=true;
			}
		}
		return bound;
	}

	public boolean canBeSatisfied() {
		for(Value arg : m_arguments) {
			if(arg.canBeSatisfied()) {
				if(! arg.isSatisfied()) { return true; }
			}
			else {
				return false;
			}
		}
		if(m_cond_var.canBeSatisfied()) {
			if(! m_cond_var.isSatisfied()) { return true; }
		}
		else {
			return false;
		}
		return isSatisfied();
	}

	public Variable getConditionVariable() {
		return m_cond_var;
	}
	
	public void collectVariables(HashSet<String> set) {
		m_cond_var.collectVariables(set);
		for(Value arg : m_arguments) {
			arg.collectVariables(set);
		}		
	}

	public boolean isSatisfied() {
		for(Value arg : m_arguments) { 
			if(! arg.isSatisfied()) { return false; }
		}
		if(! m_cond_var.isSatisfied()) { return false; }
		
		ArrayList<Object> arguments = new ArrayList<Object>();
		for(Conditionable cond : m_cond_var.getBindValues()) {	
			if(isSatisfiedHelper(cond, 0, arguments)) {
				return true;
			}
		}
		return false;
	}
	
	private boolean isSatisfiedHelper(Conditionable cond,
			int arg_index, ArrayList<Object> arguments) {
		if(arg_index == m_arguments.size()) {
			return cond.evaluateCondition(m_condition, arguments);
		}
		for(Object arg: m_arguments.get(arg_index).getBindValues()) {
			arguments.add(arg);
			if(isSatisfiedHelper(cond, arg_index+1, arguments)) {
				return true;
			}
			arguments.remove(arg_index);
		}
		return false;
	}
	

	public void unbind(String v, Object o) {
		m_cond_var.unbind(v, o);
		for(Value arg : m_arguments) {
			arg.unbind(v, o);
		}
	}
	
	public String getCondition() {
		return m_condition;
	}

	@Override
	public HashSet<Object> getBindings(String var) {
		
		HashSet<Object> bindings = m_cond_var.getBindings(var);
		for(Value arg : m_arguments) {
			HashSet<Object> arg_bindings = arg.getBindings(var);
			if(arg_bindings == null) { continue; }
			if(bindings != null) {
				bindings.retainAll(arg_bindings);
			}
			else {
				bindings=arg_bindings;
			}
		}
		return bindings;
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
	public HashSet<ConditionalExpressionInterface> getConditions(HashSet<ConditionalExpressionInterface> set) {
		set.add(this);
		return set;
	}

	public ArrayList<Value> getArguments() {
		return m_arguments;
	}
}
