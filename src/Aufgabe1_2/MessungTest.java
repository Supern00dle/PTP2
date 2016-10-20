/** PTP2 Praktikum 1
 * 20.10.2016
 * @author Manuel Scholz, Leo Peters
 */
package Aufgabe1_2;

import static org.junit.Assert.*;
import org.junit.Test;
import java.time.LocalDateTime;

public class MessungTest {
	@Test
	public final void testMessung1() {
		Messung messung1 = new Messung("24,2", "2016-06-23T16:51:40.408");
		Messung messung2 = new Messung("24,2", "2016-06-23T16:51:40.408");
		assertEquals(messung1.getWert(), 24.2, 0);
		assertNotEquals(messung1, messung2);
	}
	@Test
	public final void testMessung2() {
		Messung messung1 = new Messung("24,2", "2016-06-23T16:51:40.409");
		Messung messung2 = new Messung("24,2", "2016-06-23T16:51:40.408");
		assertEquals(messung1.getWert(), messung2.getWert(), 0);
	}
	@Test
	public final void testMessung3() {
		Messung messung1 = new Messung("24,2", "2016-06-23T16:51:40.409");
		Messung messung2 = new Messung("24,2", "2016-06-23T16:51:40.408");
		assertEquals(messung1.getWert(), messung2.getWert(), 0);
		assertNotEquals(messung1.getZeitstempel(), messung2.getZeitstempel());
	}
	@Test
	public final void testGetWert() {
		Messung messung1 = new Messung(20.0);
		assertEquals(messung1.getWert(), 20.0, 0);
	}
	@Test
	public final void testGetZeitstempel() {
		Messung messung1 = new Messung("24,2", "2016-06-23T16:51:40.408");
		assertEquals(messung1.getZeitstempel(), "2016-06-23T16:51:40.408");
	}
	@Test
	public final void testToString() {
		Messung messung1 = new Messung(20.0, "2016-06-23T16:51:40.408");
		assertEquals(messung1.toString(), "20.0 2016-06-23T16:51:40.408");
	}
	
}
