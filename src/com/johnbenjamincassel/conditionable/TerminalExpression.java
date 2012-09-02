package com.johnbenjamincassel.conditionable;

import java.util.HashSet;

public abstract class TerminalExpression implements AbstractExpression {
	
	@Override
	public HashSet<AbstractExpression> collectSubexpressions(
			HashSet<AbstractExpression> subexpressions) {
		subexpressions.add(this);
		return subexpressions;
	}
}
