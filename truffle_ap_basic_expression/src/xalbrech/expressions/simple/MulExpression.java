package xalbrech.expressions.simple;

public class MulExpression extends EvaluatedExpression {
	
	public MulExpression(EvaluatedExpression... arguments) {
		super(arguments);
	}

	public double evaluate() {
		double result = 1D;
		for (EvaluatedExpression argument : arguments) {
			result *= argument.evaluate();
		}
		return result;
	}

}
