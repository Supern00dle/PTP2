/**
 * 
 */
package Aufgabe1_2;

import java.util.ArrayList;

/**
 * @author Manuel Scholz
 *
 */
public class Sensor {

  private String id;
  private ArrayList<Messung> messungen;
  
  /**
   * 
   */
  public Sensor(String sensorID) {
    this.id = sensorID;
    messungen = new ArrayList<Messung>();
  }
  
  public void addMessung(Messung m)
  {
    messungen.add(m);
  }

  /**
   * @return the sensorID
   */
  public String getSensorID() {
    return id;
  }

  /**
   * @param sensorID the sensorID to set
   */
  public void setSensorID(String sensorID) {
    this.id = sensorID;
  }
  
  public void importMessungen()
  {
    
    
  }
  

}
