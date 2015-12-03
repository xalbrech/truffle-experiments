package expressions.simple;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
public class SimpleExpressionTests {
	
	private SimpleEvaluator evaluator;
	private EvaluatedExpression expression;

	@Setup
	public void setUp() {
		evaluator = new SimpleEvaluator();
		expression = new AddExpression(new Variable("A"), 
												new MulExpression(new Variable("B"), 
																  new Variable("C")));
	}
	
	@Benchmark
	public void evaluate() {
			evaluator.evaluate(expression);
	}

}