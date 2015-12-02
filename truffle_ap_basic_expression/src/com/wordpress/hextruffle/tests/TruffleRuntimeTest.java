package com.wordpress.hextruffle.tests;

import com.oracle.truffle.api.RootCallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleRuntime;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.RootNode;

public class TruffleRuntimeTest {
	private TruffleRuntime runtime;

	private TruffleRuntimeTest() {
		this.runtime = Truffle.getRuntime();

	}

	private static RootNode createIntegerReturningRootNode() {
		return new RootNode() {
			@Override
			public Object execute(VirtualFrame frame) {
				return 127;
			}
		};
	}
	
	private static RootNode createStringReturningRootNode() {
		return new RootNode() {
			@Override
			public Object execute(VirtualFrame frame) {
				return "Hello world!";
			}
		};
	}
	
	
	
	private void runTest(){
		System.out.println("Werunning on a Truffle runtime named \""+runtime.getName()+"\"");
		RootNode intNode = createIntegerReturningRootNode();
	        RootCallTarget intTgt = runtime.createCallTarget(intNode);
	        System.out.println("Raninteger root node through a call target and got: "+intTgt.call()); //takes a vararg Object... arguments, but we pass no args.
	        RootNode sNode = createStringReturningRootNode();
	        RootCallTarget sTgt = runtime.createCallTarget(sNode);
	        System.out.println("Ranstring root node through a call target and got: "+sTgt.call()); //takes a vararg Object... arguments, but we pass no args.
	}
	
	public static void main(String[] args) {
		TruffleRuntimeTest test = new TruffleRuntimeTest();
		test.runTest();
	}
}