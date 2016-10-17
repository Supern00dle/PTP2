/**
 * 
 */
package Aufgabe1_2;

import java.time.LocalDateTime;

/**
 * @author Manuel Scholz
 *
 */
public class Messung {

  private final double wert;
  private final LocalDateTime zeitstempel;


  /**
   * Generiert eine Messung am angegebenen Zeitpunkt und Wert.
   * 
   * @param wert Der Messwert als String
   * @param zeitstempel Der Zeitpunkt als String
   */
  public Messung(String wert, String zeitstempel) {
 
    // ersetze das Komma mit einem Punkt im String
    wert = wert.replaceAll(",", ".");
    this.wert = Double.valueOf(wert);

    this.zeitstempel = LocalDateTime.parse(zeitstempel);
  }
  
  /**
   * Generiert eine Messung am angegebenen Zeitpunkt und Wert.
   * 
   * @param wert Der Messwert als double
   * @param zeitstempel Der Zeitpunkt als String
   */
  public Messung(double wert, String zeitstempel) {
    this.wert = wert;
    this.zeitstempel = LocalDateTime.parse(zeitstempel);
  }
  
  /**
   * Generiert eine Messung am angegebenen Zeitpunkt und Wert.
   * 
   * @param wert Der Messwert als double
   * @param zeitstempel Der Zeitpunkt als LocalDateTime
   */
  public Messung(double wert, LocalDateTime zeitstempel) {
    this.wert = wert;
    this.zeitstempel = zeitstempel;
  }
  
  /**
   * Generiert eine Messung am jetzigen Zeitpunkt mit angegebenem Wert.
   */
  public Messung(double wert) {
    this.wert = wert;
    zeitstempel = LocalDateTime.now();
  }
  
  /**
   * Generiert eine Messung am jetzigen Zeitpunkt mit zufälligem Messwert.
   */
  public Messung() {
    wert = generateMesswert();
    zeitstempel = LocalDateTime.now();
  }
  
  /**
   * Generiert einen Messwert im Bereich von 0 bis 40
   * 
   * @return einen double zwischen 0 und 40
   */
  private double generateMesswert() {
    return Math.random() * 40;
  }
  
  @Override
  public String toString()
  {
   return wert + " " + zeitstempel.toString(); 
  }
  
}
