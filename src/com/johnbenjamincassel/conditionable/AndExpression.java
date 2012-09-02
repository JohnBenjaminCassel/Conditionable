package com.johnbenjamincassel.conditionable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;

public class AndExpression extends BinaryExpression {

	public static AbstractExpression formAndChain(LinkedList<? extends AbstractExpression> expressions) {
		int size = expressions.size();
		if(size == 1) {
			return expressions.get(0);
		}else if(size == 2) {
			return new AndExpression(expressions.get(0), expressions.get(1));
		}
		else if(size > 2) {
			AbstractExpression ae = expressions.pollFirst();
			return new AndExpression(ae, formAndChain(expressions));
		}
		return null;
		
	}
	
	public AndExpression(AbstractExpression first_expression, 
			AbstractExpression second_expression) {
		super(first_expression, second_expression);
	}

	public boolean canBeSatisfied() {
		return m_first_expression.canBeSatisfied() 
			&& m_second_expression.canBeSatisfied();
	}

	public boolean isSatisfied() {
		return m_first_expression.isSatisfied() 
			&& m_second_expression.isSatisfied();
	}



	

	
}
