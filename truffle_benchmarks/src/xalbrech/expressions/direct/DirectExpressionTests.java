package xalbrech.expressions.direct;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.infra.Blackhole;

import xalbrech.expressions.simple.AddExpression;
import xalbrech.expressions.simple.EvaluatedExpression;
import xalbrech.expressions.simple.MulExpression;
import xalbrech.expressions.simple.SimpleEvaluator;
import xalbrech.expressions.simple.Variable;

@BenchmarkMode(Mode.SampleTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@State(Scope.Thread)
@Fork(jvmArgs="-server")
public class DirectExpressionTests {
	

	private Variable a;
	private Variable b;
	private Variable c;

	@Setup
	public void setUp() {
		a = new Variable("A");
		b = new Variable("B");
		c = new Variable("C");
	}
	
	@Benchmark
	public void evaluate(Blackhole bh) {
			bh.consume(a.evaluate() + b.evaluate() * c.evaluate());
	}

}