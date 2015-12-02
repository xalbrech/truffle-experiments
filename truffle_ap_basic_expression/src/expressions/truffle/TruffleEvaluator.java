package expressions.truffle;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleRuntime;
import com.oracle.truffle.api.frame.FrameDescriptor;

public class TruffleEvaluator {
	

	private RootCallTarget target;
	
	EvaluatedExpression expression;
	
	public TruffleEvaluator(EvaluatedExpression expression) {
		this.expression = expression;
		TruffleRuntime runtime = Truffle.getRuntime();
		FrameDescriptor frameDescriptor = new FrameDescriptor();		
		target = runtime.createCallTarget(new RootExpression(frameDescriptor, expression));
//		dcn = Truffle.getRuntime().createDirectCallNode(target);
	}

	public double evaluate() {		
		return (Double) target.call();		
	}

}
