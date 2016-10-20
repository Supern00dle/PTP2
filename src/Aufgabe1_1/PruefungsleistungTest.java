/** PTP2 Praktikum 1
 * 20.10.2016
 * @author Manuel Scholz, Leo Peters
 */
package Aufgabe1_1;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 * @author Manuel Scholz
 *
 */
public class PruefungsleistungTest {

  /**
   * @throws java.lang.Exception
   */
  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @Before
  public void setUp() throws Exception {
  }

  /**
   * @throws java.lang.Exception
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * Test method for {@link Aufgabe1_1.Pruefungsleistung#Pruefungsleistung()}.
   */
  @Test
  public final void testPruefungsleistung() {
    Pruefungsleistung leistung1 = new Pruefungsleistung("Fach", 1.1);
    Pruefungsleistung leistung2 = new Pruefungsleistung("Fach", 1.1);
    assertEquals(leistung1, leistung2);
    
  }

  /**
   * Test method for {@link Aufgabe1_1.Pruefungsleistung#getModul()}.
   */
  @Test
  public final void testGetModul() {
    Pruefungsleistung leistung1 = new Pruefungsleistung("Fach", 1.1);
    Pruefungsleistung leistung2 = new Pruefungsleistung("Fach", 1.1);
    assertEquals(leistung1.getModul(), leistung2.getModul());   
    Pruefungsleistung leistung3 = new Pruefungsleistung("AnderesFach", 1.1);
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
