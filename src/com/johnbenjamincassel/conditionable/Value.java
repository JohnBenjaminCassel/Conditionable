package com.johnbenjamincassel.conditionable;

import java.util.HashSet;

public interface Value<T> extends  AbstractExpression {
	HashSet<T> getBindValues();
}
