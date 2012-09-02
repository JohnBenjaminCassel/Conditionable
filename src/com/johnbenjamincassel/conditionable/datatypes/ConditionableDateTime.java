package com.johnbenjamincassel.conditionable.datatypes;

import java.util.ArrayList;

import org.joda.time.DateTime;

import com.johnbenjamincassel.conditionable.Conditionable;
import com.johnbenjamincassel.utilities.datastructures.DateTimeWrapper;

public class ConditionableDateTime  implements Conditionable {

	DateTime m_date_time;
	
	public ConditionableDateTime(DateTime date_time) {
		m_date_time = date_time;
	}
	
	@Override
	public boolean evaluateCondition(String condition,
			ArrayList<Object> arguments) {
		if(condition.equals("after")) {
			if(arguments.size() < 1) { 
				return false; 
			}
			DateTime arg_date;
			if(arguments.get(0) instanceof String && arguments.get(0).equals("time")) {
				arg_date = parseDate(arguments);
				if(arg_date == null) {
					return false;
				}
			} 
			else if(arguments.get(0) instanceof DateTime) {
				arg_date = (DateTime) arguments.get(0);
			}
			else {
				return false;
			}
			return m_date_time.isAfter(arg_date);
			
		}
		return false;
	}

	public static DateTime parseDate(ArrayList<Object> args) {	
		DateTimeWrapper dtw = new DateTimeWrapper();
		for(int index = 1;index < args.size();index++) {
			dtw.setNextMagnitude(Integer.parseInt((String) args.get(index)));
		}
		return dtw.getDateTime();
	}
	
	
	
}
