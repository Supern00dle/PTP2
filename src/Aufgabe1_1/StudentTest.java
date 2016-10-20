/** PTP2 Praktikum 1
 * 20.10.2016
 * @author Manuel Scholz, Leo Peters
 */
package Aufgabe1_1;

import static org.junit.Assert.*;
import org.junit.Test;

public class StudentTest {
	/**
	 * Test method for {@link Aufgabe1_1.Student#Student()}.
	 */
	@Test
	public final void testStudent() {
		Student student1 = new Student("Leo", "Peters", 123456);
		Student student2 = new Student("Leo", "Peters", 123456);
		Student student3 = new Student("Manuel", "Scholz", 654321);
		assertEquals(student1, student2);
		assertNotEquals(student1, student3);
	}

	/**
	 * Test method for {@link Aufgabe1_1.Student#getVorname()}.
	 */
	@Test
	public final void testGetVorname() {
		Student student1 = new Student("Leo", "Peters", 123456);
		Student student2 = new Student("Manuel", "Scholz", 654321);
		assertEquals(student1.getVorname(), "Leo");
		assertNotEquals(student1.getVorname(), student2.getVorname());
	}

	/**
	 * Test method for {@link Aufgabe1_1.Student#getNachname()}.
	 */
	@Test
	public final void testGetNachname() {
		Student student1 = new Student("Leo", "Peters", 123456);
		Student student2 = new Student("Manuel", "Scholz", 654321);
		assertEquals(student1.getNachname(), "Peters");
		assertNotEquals(student1.getNachname(), student2.getNachname());
	}

	/**
	 * Test method for {@link Aufgabe1_1.Student#getMatrikelNummer()}.
	 */
	@Test
	public final void testgetMatrikelnummer() {
		Student student1 = new Student("Leo", "Peters", 123456);
		Student student2 = new Student("Manuel", "Scholz", 654321);
		assertEquals(student1.getMatrikelnummer(), 123456);
		assertNotEquals(student1.getMatrikelnummer(), student2.getMatrikelnummer());
	}

	/**
	 * Test method for {@link java.lang.Object#equals(java.lang.Object)}.
	 */
	@Test
	public final void testEquals() {
		Student student1 = new Student("Leo", "Peters", 123456);
		Student student2 = new Student("Manuel", "Scholz", 654321);
		Student student3 = new Student("Leo", "Peters", 123456);
		assertEquals(student1, student3);
		assertNotEquals(student1, student2);
	}
	/**
	 * Test method for {@link java.lang.Object#hashCode(java.lang.Object)}.
	 */
	@Test
	public final void testHashCode() {
		Student student1 = new Student("Leo", "Peters", 123456);
		Student student2 = new Student("Manuel", "Scholz", 654321);
		Student student3 = new Student("Leo", "Peters", 123456);
		assertEquals(student1.hashCode(), student3.hashCode());
		assertNotEquals(student1.hashCode(), student2.hashCode());
	}
	/**
	 * Test method for {@link java.lang.Object#compareTo(java.lang.Object)}.
	 */
	@Test
	public final void testCompareTo() {
		Student student1 = new Student("Leo", "Peters", 123456);
		Student student2 = new Student("Manuel", "Scholz", 654321);
		Student student3 = new Student("Leo", "Peters", 123456);
		assertEquals(student1.compareTo(student1), 0);
		assertTrue(student1.compareTo(student2) > 0);
		assertFalse(student2.compareTo(student3) < 0);
	}
	/**
	 * Test method for {@link Aufgabe1_1.Student#addPruefungsleistung()}.
	 */
	@Test
	public final void testAddPruefungsleistung() {
		Student student1 = new Student("Leo", "Peters", 123456);
		Pruefungsleistung leistung1 = new Pruefungsleistung("PM2", 1.1);
		assertNotEquals(student1.toString(), "Student: Leo Peters\nMatrikelnummer: 123456\nModul: PM2\nNote: 1.1");
		student1.addPruefungsleistung(leistung1);
		assertEquals(student1.toString(), "Student: Leo Peters\nMatrikelnummer: 123456\nModul: PM2\nNote: 1.1");

	}

	/**
	 * Test method for {@link java.lang.Object#toString()}.
	 */
	@Test
	public final void testToString() {
		Student student1 = new Student("Leo", "Peters", 123456);
		Student student2 = new Student("Manuel", "Scholz", 654321);
		Pruefungsleistung leistung1 = new Pruefungsleistung("PM2", 1.1);
		student1.addPruefungsleistung(leistung1);
		student2.addPruefungsleistung(leistung1);
		assertEquals(student1.toString(), "Student: Leo Peters\nMatrikelnummer: 123456\nModul: PM2\nNote: 1.1");
		assertNotEquals(student2.toString(), student1.toString());
	}
}
