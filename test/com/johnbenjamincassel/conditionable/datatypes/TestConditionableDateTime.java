package com.johnbenjamincassel.conditionable.datatypes;

import java.util.ArrayList;



import org.joda.time.DateTime;
import org.junit.Assert;
import org.junit.Test;


public class TestConditionableDateTime {
	
	@Test
	public void testAfterCondition() {
		DateTime reference_date = new DateTime(2005,1,1,1,1,1,1);
		ConditionableDateTime cdt 
			= new ConditionableDateTime(reference_date);
		
		ArrayList<Object> arguments 
			= new ArrayList<Object>();
		for(String arg : new String[]{"time", "2004", "5", "1"}) {
			arguments.add(arg);
		}
		Assert.assertNotNull(cdt);
		Assert.assertTrue(cdt.evaluateCondition("after", arguments));
		arguments = new ArrayList<Object>();
		for(String arg : new String[]{"time", "2005", "2", "8"}) {
			arguments.add(arg);
		}
		Assert.assertFalse(cdt.evaluateCondition("after", arguments));
	}
}
