package com.johnbenjamincassel.conditionable;

import java.util.HashSet;

import com.johnbenjamincassel.utilities.datastructures.HashToHashSet;


public class Constant<T> extends TerminalExpression implements Value {

	private T m_value;
	private HashSet<Object> m_value_set;

	public Constant(T object) {
		m_value = object;
		m_value_set = new HashSet<Object>(); 
		m_value_set.add(m_value); 
	}
	
	public boolean bind(String v, Object o) { return false; }

	public boolean canBeSatisfied() {
		return true;
	}

	public void collectVariables(HashSet<String> set) { }

	public boolean isSatisfied() { return true; }

	public void unbind(String v, Object o) {}

	public HashSet<Object> getBindValues() {
		return m_value_set;
	}
	
	public T getValue() { return m_value; }

	@Override
	public HashSet<Object> getBindings(String var) {
		return null;
	}

	@Override
	public HashToHashSet<String, Object> getAllBindings() {
		return new HashToHashSet<String, Object>();
	}
	
	@Override
	public HashSet<ConditionalExpressionInterface> getConditions(
			HashSet<ConditionalExpressionInterface> set) {
		return set;
	}
}
