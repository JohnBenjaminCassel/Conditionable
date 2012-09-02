package com.johnbenjamincassel.conditionable;


public class ConditionableVariable extends Variable<Conditionable> {

	public ConditionableVariable(String name) { super(name,Conditionable.class); }

	public boolean canBeSatisfied() {
		return (! m_is_bound) || bindingsContainConditionable(); 
	}
	
	public boolean isSatisfied() {
		return m_is_bound && bindingsContainConditionable(); 
	}
	
	private boolean bindingsContainConditionable() {
		for(Object bind_value : m_bind_values) {
			if(bind_value instanceof Conditionable) {
				return true;
			}
		}
		return false;
	}
}
