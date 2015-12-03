package expressions.truffle;

import com.oracle.truffle.api.nodes.Node;

public abstract class EvaluatedExpression extends Node {
	
	@Children protected final EvaluatedExpression[] arguments;
	
	public EvaluatedExpression(EvaluatedExpression... arguments) {
		this.arguments = arguments;
	}
	
	public abstract double execute();
	
}
