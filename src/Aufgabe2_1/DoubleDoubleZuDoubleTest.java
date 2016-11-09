package Aufgabe2_1;

import static org.junit.Assert.*;
import org.junit.Test;

import Aufgabe2_1.DoubleDoubleZuDouble;

public class DoubleDoubleZuDoubleTest {
	@Test
	public void testeInterface() {
		DoubleDoubleZuDouble wert1 = (a, b) -> a * b;
		assertEquals(21, wert1.werteAus(3, 7), 0);
		wert1 = (a, b) -> (-b) / a;
		assertEquals(-7, wert1.werteAus(3, 21), 0);
	}
}
