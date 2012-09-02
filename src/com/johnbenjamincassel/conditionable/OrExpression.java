package com.johnbenjamincassel.conditionable;


public class OrExpression extends BinaryExpression {

	

	public OrExpression(AbstractExpression first_expression, 
			AbstractExpression second_expression) {
		super(first_expression, second_expression);
	
	}
	


	public boolean canBeSatisfied() {
		return m_first_expression.canBeSatisfied() 
			|| m_second_expression.canBeSatisfied();
	}




	public boolean isSatisfied() {
		return m_first_expression.isSatisfied() 
			|| m_second_expression.isSatisfied();
	}


}
