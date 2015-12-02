package expressions.simple;

import com.oracle.truffle.api.frame.VirtualFrame;

public class Variable extends EvaluatedExpression {
	
	private String variableName;

	public Variable(String variableName) {
		super();
		this.variableName = variableName;
	}

	@Override
	public double evaluate(VirtualFrame frame) {
		return VariableValues.getValue(this.variableName);
	}

}
