package com.johnbenjamincassel.conditionable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.antlr.runtime.RecognitionException;
import org.junit.*;

import com.johnbenjamincassel.conditionable.datatypes.ConditionableDouble;

public class ConditionableTest {

	@Test
	public void parseSatisfiable() {
		try {
			HashMap<String, Double> real_values = new HashMap<String, Double>();
			real_values.put("$x", 3.0);
			real_values.put("$y", 2.0);
			real_values.put("$z", 1.0);
			BacktrackingEvaluator be 
				= new BacktrackingEvaluator(
					ConditionableImplementationParser.parseExpression("cond $x > [$y] && cond $y > [$z]"));
			ArrayList<Object> values = new ArrayList<Object>();
			for(double i : new double[]{1,3,2}) {
				values.add(new ConditionableDouble(i));
			}
			HashMap<String, Object> results = be.evaluate(values);
			if(results == null) { Assert.fail("null results"); }
			
			
			for(Map.Entry<String, Object> entry 
					: results.entrySet()) { 
				double real_value = real_values.get(entry.getKey());
				double entry_value = ((ConditionableDouble) entry.getValue()).getValue();
				Assert.assertEquals(real_value, entry_value, 0.0000001);
			}
			
			values.add(new ConditionableDouble(4.));
			results = be.evaluate(values);
			if(results == null) { Assert.fail("null results"); }
			
			real_values.put("$x", 41.0);
			real_values.put("$y", 34.0);
			real_values.put("$z", 32.0);
			
			values = new ArrayList<Object>();
			for(double i : new double[]{32,34,41}) {
				values.add(new ConditionableDouble(i));
			}
			results = be.evaluate(values);
			for(Map.Entry<String, Object> entry 
					: results.entrySet()) { 
				double real_value = real_values.get(entry.getKey());
				double entry_value = ((ConditionableDouble) entry.getValue()).getValue();
				Assert.assertEquals(real_value, entry_value, 0.0000001);
			}
			
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
		
	}
	
	@Test
	public void testUnsatisfiable() {
		try {
			BacktrackingEvaluator be 
				= new BacktrackingEvaluator(
						ConditionableImplementationParser.parseExpression("cond $x > [$y] && cond $y > [$x]"));
			ArrayList<Object> values = new ArrayList<Object>();
			for(double i : new double[]{1,3,2,5,4}) {
				values.add(new ConditionableDouble(i));
			}
			Assert.assertNull(be.evaluate(values));
		} catch (RecognitionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail(e.getMessage());
		}
	ArrayList<Object> values = new ArrayList<Object>();
	for(double i : new double[]{1,3,2}) {
		values.add(new ConditionableDouble(i));
	}
	}
	
	public static void main(String[] args) {
		new ConditionableTest().parseSatisfiable();
	}
}
