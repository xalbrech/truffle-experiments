package xalbrech.expressions.truffle;

import com.oracle.truffle.api.frame.FrameDescriptor;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public class RootExpression extends RootNode {
	
	@Child protected EvaluatedExpression expression;
	
	public RootExpression(FrameDescriptor frameDescriptor, EvaluatedExpression expression) {
		super(null, frameDescriptor);
		this.expression = expression;
	}
	
	@Override
	public Object execute(VirtualFrame frame) {
		return expression.execute(); 	
	}
 
}
