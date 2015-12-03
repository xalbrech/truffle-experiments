package xalbrech.expressions.simple;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import xalbrech.expressions.simple.AddExpression;
import xalbrech.expressions.simple.EvaluatedExpression;
import xalbrech.expressions.simple.MulExpression;
import xalbrech.expressions.simple.SimpleEvaluator;
import xalbrech.expressions.simple.Variable;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Fork(jvmArgs="-server")
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