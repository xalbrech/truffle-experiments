package com.wordpress.hextruffle.tests;

import java.util.Random;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.Truffle;
import com.oracle.truffle.api.TruffleRuntime;
import com.oracle.truffle.api.frame.VirtualFrame;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.nodes.RootNode;

public class MutliReplacementTest {

    static abstract class ReadWriteIntNode extends Node {

        public ReadWriteIntNode() {
            super(null);
        }

        abstract void executeWrite(int newVal);

        abstract int executeRead();
    }

    static class MutableNode extends ReadWriteIntNode {
        private int value;

        public MutableNode(int value_) {
            super();
            this.value = value_;
        }

        @Override
        void executeWrite(int newVal) {
            System.out.println("TRACEte to a mutable node.");
            this.value = newVal;
        }

        @Override
        int executeRead() {
            return value;
        }
    }

    static class ImmutableNode extends ReadWriteIntNode {
        private final int replacementsSoFar;
        private final int value;

        public ImmutableNode(int value, int replacementsSoFar) {
            super();
            this.value = value;
            this.replacementsSoFar = replacementsSoFar;
        }

        public ImmutableNode(int value) {
            super();
            this.value = value;
            this.replacementsSoFar = 0;
        }

        @Override
        void executeWrite(int newVal) {
            System.out.println("TRACEd to replace node, with " + replacementsSoFar + " replacements so far.");
            if (newVal != value) {
                if (replacementsSoFar > 2) {
                    System.out.println("TRACEugh replacements, moving to a mutable node.");
                    this.replace(new MutableNode(newVal));
                    return;
                } else {
                    System.out.println("TRACE lacing with another immutable node.");
                    ImmutableNode newNode = new ImmutableNode(value, replacementsSoFar + 1);
                    this.replace(newNode);
                }
            }

        }

        @Override
        int executeRead() {
            return value;
        }
    }

    static class TestNode extends RootNode {

        public String getNodeType() {
            return internalNode.getClass().getName();
        }

        private @Child ReadWriteIntNode internalNode;

        public TestNode(ReadWriteIntNode internalNode) {
            super();
            this.internalNode = internalNode;
        }

        @Override
        public Object execute(VirtualFrame frame) {
            int toWrite = new Random().nextInt(100);
            internalNode.executeWrite(toWrite);
            return toWrite;
        }

    }

    public static void main(String[] args) {
        TruffleRuntime runtime = Truffle.getRuntime();
        TestNode root = new TestNode(new ImmutableNode(42));
        CallTarget tgt = runtime.createCallTarget(root);
        for (int i = 0; i < 6; i++) {
            System.out.println("The is a " + root.getNodeType());
            System.out.println("Wrote " + tgt.call());
        }
    }
}