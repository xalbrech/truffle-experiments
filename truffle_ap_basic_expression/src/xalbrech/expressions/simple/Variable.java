package xalbrech.expressions.simple;

public class Variable extends EvaluatedExpression {
	
	private String variableName;

	public Variable(String variableName) {
		super();
		this.variableName = variableName;
	}

	@Override
	public double evaluate() {
		return VariableValues.getValue(this.variableName);
	}

}
