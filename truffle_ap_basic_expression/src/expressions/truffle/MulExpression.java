package expressions.truffle;

public class MulExpression extends EvaluatedExpression {
	
	public MulExpression(EvaluatedExpression... arguments) {
		super(arguments);
	}

	public double execute() {
		double result = 1D;
		for (EvaluatedExpression argument : arguments) {
			result *= argument.execute();
		}
		return result;
	}

}
