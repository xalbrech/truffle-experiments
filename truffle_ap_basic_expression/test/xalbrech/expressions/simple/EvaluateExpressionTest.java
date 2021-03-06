package xalbrech.expressions.simple;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import xalbrech.expressions.simple.AddExpression;
import xalbrech.expressions.simple.EvaluatedExpression;
import xalbrech.expressions.simple.MulExpression;
import xalbrech.expressions.simple.SimpleEvaluator;
import xalbrech.expressions.simple.Variable;

public class EvaluateExpressionTest {

	@Test
	public void testEvaluate() {
		
		SimpleEvaluator evaluator = new SimpleEvaluator();
		double result = evaluator.evaluate(new AddExpression(new Variable("A"), 
											new MulExpression(new Variable("B"), 
															new Variable("C"))));
		assertEquals(16D, result, 0D);
	}
	
	@Test
	public void testEvaluateMillionTimes() {
		
		SimpleEvaluator evaluator = new SimpleEvaluator();
		EvaluatedExpression expression = new AddExpression(new Variable("A"), 
												new MulExpression(new Variable("B"), 
																  new Variable("C")));
		
		for (int i=1; i<10_000; i++) {
			evaluator.evaluate(expression);
		}
		
		long start = System.nanoTime();
		for (int i=1; i<1_000_000; i++) {
			evaluator.evaluate(expression);
		}
		System.out.println((System.nanoTime() - start) / 1_000_000D);
	}

}