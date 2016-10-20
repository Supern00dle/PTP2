/** PTP2 Praktikum 1
 * 20.10.2016
 * Manuel Scholz, Leo Peters
 */
package Aufgabe1_2;

import java.util.ArrayList;


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
  
  public Messung getMessung(int i)
  {
    return messungen.get(i);
  }
  
  public int getAnzahlMessungen()
  {
    
    return messungen.size();
  }
  

}
