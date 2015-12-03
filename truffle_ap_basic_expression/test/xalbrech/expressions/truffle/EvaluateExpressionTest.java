package xalbrech.expressions.truffle;

import static org.junit.Assert.*;

import org.junit.Test;

import xalbrech.expressions.truffle.AddExpression;
import xalbrech.expressions.truffle.EvaluatedExpression;
import xalbrech.expressions.truffle.MulExpression;
import xalbrech.expressions.truffle.TruffleEvaluator;
import xalbrech.expressions.truffle.Variable;

public class EvaluateExpressionTest {

	@Test
	public void testEvaluate() {
		
		TruffleEvaluator evaluator = new TruffleEvaluator(new AddExpression(new Variable("A"), 
				new MulExpression(new Variable("B"), 
						new Variable("C"))));
		double result = evaluator.evaluate();
		assertEquals(16D, result, 0D);
	}
	
	@Test
	public void testEvaluateMillionTimes() {
		
		EvaluatedExpression expression = new AddExpression(new Variable("A"), 
												new MulExpression(new Variable("B"), 
																  new Variable("C")));
		
		TruffleEvaluator evaluator = new TruffleEvaluator(expression);
		
		for (int i=0; i<100_000; i++) {
			evaluator.evaluate();
		}
		
		long start = System.nanoTime();
		
		for (int i=0; i<1_000_000; i++) {
			evaluator.evaluate();
		}
		
		long stop = System.nanoTime();

		System.out.println((stop - start) / 1_000_000D);
	}

}