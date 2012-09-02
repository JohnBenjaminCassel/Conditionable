package com.johnbenjamincassel.conditionable;

import java.util.HashSet;

import com.johnbenjamincassel.utilities.datastructures.HashToHashSet;


public interface AbstractExpression {
	public void collectVariables(HashSet<String> set);

	public boolean bind(String v, Object o);

	public boolean canBeSatisfied();

	public boolean isSatisfied();
	
	public HashSet<AbstractExpression> collectSubexpressions(
			HashSet<AbstractExpression>  subexpressions);

	public void unbind(String v, Object o);

	public HashSet<Object> getBindings(String var);

	public HashToHashSet<String, Object> getAllBindings();

	public HashSet<ConditionalExpressionInterface> getConditions(HashSet<ConditionalExpressionInterface> set);

	
}
