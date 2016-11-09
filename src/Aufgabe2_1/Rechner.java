/**
 * Programmiertechnik 2 Aufgabenblatt 2
 * 10.11.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe2_1;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BinaryOperator;

	public class Rechner {
		Map<Operation, BinaryOperator<Double>> operation;

		/**
		 * initialisiert die vier Rechenarten in einer HashMap
		 */
		public Rechner()
		{
			operation = new HashMap<Operation, BinaryOperator<Double>>();

			BinaryOperator<Double> addieren = (a, b) -> a + b;
			operation.put(Operation.ADDITION, addieren);

			BinaryOperator<Double> subtrahieren = (a, b) -> a - b;
			operation.put(Operation.SUBTRAKTION, subtrahieren);

			BinaryOperator<Double> multiplizieren = (a, b) -> a * b;
			operation.put(Operation.MULTIPLIKATION, multiplizieren);

			BinaryOperator<Double> dividieren = (a, b) -> a / b;
			operation.put(Operation.DIVISION, dividieren);
		}

		public double berechne(Operation operator, double wert1, double wert2)
		{
			return operation.get(operator).apply(wert1, wert2);
		}
}
