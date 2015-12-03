package xalbrech.expressions.truffle;

import java.io.IOException;

import com.oracle.truffle.api.CallTarget;
import com.oracle.truffle.api.TruffleLanguage;
import com.oracle.truffle.api.frame.MaterializedFrame;
import com.oracle.truffle.api.instrument.Visualizer;
import com.oracle.truffle.api.instrument.WrapperNode;
import com.oracle.truffle.api.nodes.Node;
import com.oracle.truffle.api.source.Source;

public class ExpressionLanguage extends TruffleLanguage<Object> {

	@Override
	protected Object createContext(com.oracle.truffle.api.TruffleLanguage.Env arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected WrapperNode createWrapperNode(Node arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object evalInContext(Source arg0, Node arg1, MaterializedFrame arg2) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object findExportedSymbol(Object arg0, String arg1, boolean arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Object getLanguageGlobal(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Visualizer getVisualizer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean isInstrumentable(Node arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected boolean isObjectOfLanguage(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected CallTarget parse(Source arg0, Node arg1, String... arg2) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
