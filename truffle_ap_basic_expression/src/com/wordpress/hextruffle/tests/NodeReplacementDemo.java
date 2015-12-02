package com.wordpress.hextruffle.tests;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleRuntime;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RootNode;

public class NodeReplacementDemo {
	static class IntAdderTestRootNode extends RootNode {

		@Children
		private final IntNode[] children;

		public IntAdderTestRootNode(IntNode[] children) {
			super(null);
			this.children = children;
		}

		@Override
		public Object execute(VirtualFrame frame) {
			int sum = 0;
			for (IntNode child : children) {
				sum += child.execute();
			}
			return sum;
		}
	}

	static abstract class IntNode extends Node {

		public IntNode() {
			super(null);
		}

		abstract int execute();
	}

	static class UnresolvedIntNode extends IntNode {

		private final String value;

		public UnresolvedIntNode(String value) {
			this.value = value;
		}

		@Override
		int execute() {
			int intValue = Integer.parseInt(value);
			ResolvedIntNode newNode = this.replace(new ResolvedIntNode(intValue));
			return newNode.execute();
		}
	}

	static class ResolvedIntNode extends IntNode {

		private final int value;

		ResolvedIntNode(int value) {
			this.value = value;
		}

		@Override
		int execute() {
			return value;
		}
	}

	public static void main(String[] args) {
		TruffleRuntime runtime = Truffle.getRuntime();
		UnresolvedIntNode left = new UnresolvedIntNode("1");
		UnresolvedIntNode right = new UnresolvedIntNode("2");
		IntAdderTestRootNode root = new IntAdderTestRootNode(new IntNode[]{left, right});
		root.getChildren().forEach((node) -> {
			System.out.println("Currentlye is a child node with type "+node.getClass().getName());
		});
	        CallTarget target = runtime.createCallTarget(root);
	        System.out.println("Nowall the root node, which tells us that 1 + 2 = " + target.call());
	        root.getChildren().forEach((node) -> {
			System.out.println("Currentlye is a child node with type "+node.getClass().getName());
		});
                System.out.println("Nowall the root node, which tells us that 1 + 2 = " + target.call());
	}
}