package xalbrech.expressions.truffle;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import xalbrech.expressions.truffle.AddExpression;
import xalbrech.expressions.truffle.EvaluatedExpression;
import xalbrech.expressions.truffle.MulExpression;
import xalbrech.expressions.truffle.TruffleEvaluator;
import xalbrech.expressions.truffle.Variable;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Fork(jvmArgs="-server")
public class TruffleExpressionTest {

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
	public void evaluate() {
		evaluator.evaluate();
	}

}