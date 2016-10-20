/** PTP2 Praktikum 1
 * 20.10.2016
 * @author Manuel Scholz, Leo Peters
 */
package Aufgabe1_1;

import static org.junit.Assert.*;
import org.junit.Test;

public class PruefungsleistungTest {

	/**
	 * Test method for {@link Aufgabe1_1.Pruefungsleistung#Pruefungsleistung()}.
	 */
	@Test
	public final void testPruefungsleistung() {
		Pruefungsleistung leistung1 = new Pruefungsleistung("PM1", 1.3);
		Pruefungsleistung leistung2 = new Pruefungsleistung("PM1", 1.3);
		Pruefungsleistung leistung3 = new Pruefungsleistung("PM2", 1.5);
		assertEquals(leistung1, leistung2);
		assertNotEquals(leistung1.getNote(), leistung3.getNote(), 0);
		assertNotEquals(leistung1.getModul(), leistung3.getModul(), 0);
	}

	/**
	 * Test method for {@link Aufgabe1_1.Pruefungsleistung#getModul()}.
	 */
	@Test
	public final void testGetModul() {
		Pruefungsleistung leistung1 = new Pruefungsleistung("PM2", 1.4);
		Pruefungsleistung leistung2 = new Pruefungsleistung("PM2", 1.4);
		assertEquals(leistung1.getModul(), leistung2.getModul());
		Pruefungsleistung leistung3 = new Pruefungsleistung("PM1", 1.1);
		assertNotEquals(leistung1.getModul(), leistung3.getModul());
	}

	/**
	 * Test method for {@link Aufgabe1_1.Pruefungsleistung#getNote()}.
	 */
	@Test
	public final void testGetNote() {
		Pruefungsleistung leistung1 = new Pruefungsleistung("Fach", 1.1);
		Pruefungsleistung leistung2 = new Pruefungsleistung("Fach", 1.1);
		assertEquals(leistung1.getNote(), leistung2.getNote(), 0);
		Pruefungsleistung leistung3 = new Pruefungsleistung("AnderesFach", 1.3);
		assertNotEquals(leistung3.getNote(), leistung1.getNote(), 0);
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEquals() {
		Pruefungsleistung leistung1 = new Pruefungsleistung("PM2", 1.1);
		Pruefungsleistung leistung2 = new Pruefungsleistung("PM2", 1.1);
		Pruefungsleistung leistung3 = new Pruefungsleistung("PM1", 1.4);
		assertEquals(leistung1.equals(leistung2), true);
		assertEquals(leistung3.equals(leistung1), false);
	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	public final void testToString() {
		Pruefungsleistung leistung1 = new Pruefungsleistung("PM2", 1.1);
		assertEquals(leistung1.toString(), "Modul: PM2\nNote: 1.1");
	}
}
