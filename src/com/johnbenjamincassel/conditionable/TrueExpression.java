package com.johnbenjamincassel.conditionable;

import java.util.HashSet;

import com.johnbenjamincassel.utilities.datastructures.HashToHashSet;


public class TrueExpression extends TerminalExpression {

	public boolean bind(String v, Object o) { return false; }

	public boolean canBeSatisfied() {
		return true;
	}

	public void collectVariables(HashSet<String> set) {}

	public boolean isSatisfied() {
		return true;
	}

	public void unbind(String v, Object o) { }

	@Override
	public HashSet<Object> getBindings(String var) {
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
}
