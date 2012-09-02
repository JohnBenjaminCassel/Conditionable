package com.johnbenjamincassel.conditionable;

import java.util.HashSet;

import com.johnbenjamincassel.utilities.datastructures.HashToHashSet;


public class NotExpression implements AbstractExpression {

	public AbstractExpression m_ae;
	
	public NotExpression(AbstractExpression ae) {
		m_ae = ae;
	}
	
	public boolean bind(String v, Object o) {
		return m_ae.bind(v, o);
	}

	public boolean canBeSatisfied() {
		return m_ae.canBeSatisfied();
	}

	public void collectVariables(HashSet<String> set) {
		m_ae.collectVariables(set);
	}

	public boolean isSatisfied() {
		return ! m_ae.isSatisfied();
	}

	public void unbind(String v, Object o) {
		m_ae.unbind(v, o);
	}

	@Override
	public HashSet<Object> getBindings(String var) {
		return m_ae.getBindings(var);
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
		return m_ae.getConditions(set);
	}

	@Override
	public HashSet<AbstractExpression> collectSubexpressions(
			HashSet<AbstractExpression> subexpressions) {
		subexpressions.add(this);
		return m_ae.collectSubexpressions(subexpressions);
	}
}
