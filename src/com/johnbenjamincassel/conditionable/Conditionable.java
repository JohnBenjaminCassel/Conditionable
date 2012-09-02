package com.johnbenjamincassel.conditionable;

import java.util.ArrayList;

public interface Conditionable {

	public boolean evaluateCondition(String condition, ArrayList<Object> arguments);
}
