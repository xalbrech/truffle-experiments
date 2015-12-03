package xalbrech.expressions.truffle;

public class Variable extends EvaluatedExpression {
	
	private String variableName;

	public Variable(String variableName) {
		super();
		this.variableName = variableName;
	}

	@Override
	public double execute() {
		return VariableValues.getValue(this.variableName);
	}

}
