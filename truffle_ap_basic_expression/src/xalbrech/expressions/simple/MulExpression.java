package xalbrech.expressions.simple;

import com.oracle.truffle.api.frame.VirtualFrame;

public class MulExpression extends EvaluatedExpression {
	
	public MulExpression(EvaluatedExpression... arguments) {
		super(arguments);
	}

	public double evaluate(VirtualFrame frame) {
		double result = 1D;
		for (EvaluatedExpression argument : arguments) {
			result *= argument.evaluate(frame);
		}
		return result;
	}

}
