package com.johnbenjamincassel.conditionable.datatypes;

import java.util.ArrayList;

import com.johnbenjamincassel.conditionable.Conditionable;

public class ConditionableDouble implements Conditionable {

	private Double m_d;

	public ConditionableDouble(Double d) {
		m_d = d;
	}

	public boolean evaluateCondition(String condition, ArrayList<Object> arguments) {
		if(condition.equals(">")) {
			double other = ((ConditionableDouble) arguments.get(0)).getValue();
			return m_d.compareTo(other) > 0;
		}
		return false;
	}
	
	public String toString() { 
		return m_d.toString();
	}
	
	public Double getValue() { return m_d; }
}
