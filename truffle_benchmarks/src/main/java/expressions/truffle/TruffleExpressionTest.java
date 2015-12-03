package expressions.truffle;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

public class EvaluateExpressionTest {

	private EvaluatedExpression expression;
	private TruffleEvaluator evaluator;

	@Setup
	public void setUp() {
		expression = new AddExpression(new Variable("A"), 
				new MulExpression(new Variable("B"), 
								  new Variable("C")));	
		evaluator = new TruffleEvaluator(expression);
	}
	
	@Benchmark
	public void testEvaluateMillionTimes() {
		evaluator.evaluate();
	}

}