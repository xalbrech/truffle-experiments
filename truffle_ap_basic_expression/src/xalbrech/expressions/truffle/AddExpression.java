package expressions.truffle;

public class AddExpression extends EvaluatedExpression {

	public AddExpression(EvaluatedExpression... arguments) {
		super(arguments);
		// TODO Auto-generated constructor stub
	}

	public double execute() {
		double result = 0D;
		for (EvaluatedExpression argument : arguments) {
			result += argument.execute();
		}
		return result;
	}
	
}
