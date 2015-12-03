package xalbrech.expressions.simple;

import com.oracle.truffle.api.frame.VirtualFrame;

public class AddExpression extends EvaluatedExpression {

	public AddExpression(EvaluatedExpression... arguments) {
		super(arguments);
		// TODO Auto-generated constructor stub
	}

	public double evaluate(VirtualFrame frame) {
		double result = 0D;
		
		for (EvaluatedExpression argument : arguments) {
			result += argument.evaluate(frame);
		}
		return result;
	}
	
}
