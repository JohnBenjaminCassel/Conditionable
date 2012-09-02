package com.johnbenjamincassel.conditionable;

import java.util.HashSet;

import com.johnbenjamincassel.utilities.datastructures.HashToHashSet;


public abstract class BinaryExpression implements AbstractExpression {

	protected AbstractExpression m_first_expression;
	protected AbstractExpression m_second_expression;
	
	public BinaryExpression(AbstractExpression first_expression, 
			AbstractExpression second_expression) {
		m_first_expression = first_expression;
		m_second_expression = second_expression;
	}

	public boolean bind(String v, Object o) {
		boolean first = m_first_expression.bind(v, o); 
		boolean second = m_second_expression.bind(v, o);
		return first || second;
	}
	
	public void collectVariables(HashSet<String> set) {
		m_first_expression.collectVariables(set);
		m_second_expression.collectVariables(set);
	}
	
	public void unbind(String v, Object o) {
		m_first_expression.unbind(v, o);
		m_second_expression.unbind(v, o);
	}
	
	public HashSet<Object> getBindings(String var) {
		HashSet<Object> first_bindings = m_first_expression.getBindings(var);
		HashSet<Object> second_bindings =m_second_expression.getBindings(var);
		if(first_bindings == null) {
			return second_bindings;
		}
		if(second_bindings == null) { return first_bindings; }
		HashSet<Object> combined_bindings = new HashSet<Object>(first_bindings);
		combined_bindings.retainAll(second_bindings);
		return combined_bindings;
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
		return m_second_expression.getConditions(m_first_expression.getConditions(set));
	}
	
	@Override
	public HashSet<AbstractExpression> collectSubexpressions(
			HashSet<AbstractExpression> subexpressions) {
		subexpressions.add(this);
		subexpressions.add(m_first_expression);
		subexpressions.add(m_second_expression);
		return subexpressions;
	}
}
