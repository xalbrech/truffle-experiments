package xalbrech.expressions.truffle;

import java.util.HashMap;
import java.util.Map;

public class VariableValues {
	
	private static Map<String, Double> variableValues = new HashMap<>();
	
	static {
		variableValues.put("A", 1D);
		variableValues.put("B", 3D);
		variableValues.put("C", 5D);
	}

	public static double getValue(String variableName) {
		return variableValues.get(variableName);
	}

}
