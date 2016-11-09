package Aufgabe2_1;

import static org.junit.Assert.*;
import org.junit.Test;
import Aufgabe2_1.Rechner;

public class RechnerTest {

	@Test
	public void testBerechne()
	{
		Rechner rechner1 = new Rechner();
		assertEquals(21, rechner1.berechne(Operation.MULTIPLIKATION, 3, 7), 0);
		assertEquals(3, rechner1.berechne(Operation.DIVISION, 21, 7), 0);
		assertEquals(-4, rechner1.berechne(Operation.SUBTRAKTION, 3, 7), 0);
		assertEquals(10, rechner1.berechne(Operation.ADDITION, 3, 7), 0);
	}
}
