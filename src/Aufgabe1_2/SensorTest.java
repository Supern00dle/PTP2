/**
 * 
 */
package Aufgabe1_2;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Manuel Scholz
 *
 */
public class SensorTest {

  /**
   * Test method for {@link Aufgabe1_2.Sensor#Sensor(java.lang.String)}.
   */
  @Test
  public final void testSensor() {
    Sensor sensor = new Sensor("test");

  }

  /**
   * Test method for {@link Aufgabe1_2.Sensor#addMessung(Aufgabe1_2.Messung)}.
   */
  @Test
  public final void testAddMessung() {
    Sensor sensor = new Sensor("testtest");
    sensor.addMessung(new Messung(50));
  }

  /**
   * Test method for {@link Aufgabe1_2.Sensor#getSensorID()}.
   */
  @Test
  public final void testGetSensorID() {
    Sensor sensor = new Sensor("testname");
    assertEquals(sensor.getSensorID(), "testname");
  }

  /**
   * Test method for {@link Aufgabe1_2.Sensor#setSensorID(java.lang.String)}.
   */
  @Test
  public final void testSetSensorID() {
    Sensor sensor = new Sensor("testname");
    assertEquals(sensor.getSensorID(), "testname");
    sensor.setSensorID("testname2");
    assertEquals(sensor.getSensorID(), "testname2");

  }

  /**
   * Test method for {@link Aufgabe1_2.Sensor#getMessung(int)}.
   */
  @Test
  public final void testGetMessung() {
    Sensor sensor = new Sensor("testtest");
    sensor.addMessung(new Messung(69));
    assertTrue(sensor.getMessung(0).getWert() == 69);
  }

  /**
   * Test method for {@link Aufgabe1_2.Sensor#getAnzahlMessungen()}.
   */
  @Test
  public final void testGetAnzahlMessungen() {
    Sensor sensor = new Sensor("testtest");
    sensor.addMessung(new Messung(69));
    sensor.addMessung(new Messung(79));
    sensor.addMessung(new Messung(89));
    assertEquals(sensor.getAnzahlMessungen(), 3);
    
    
    
  }

}
