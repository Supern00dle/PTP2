/**PTP2 Praktikum 1
 * 20.10.2016
 * @author Manuel Scholz, Leo Peters
 */
package Aufgabe1_1;
public class Pruefungsleistung {

  private final String modul;
  private final double note;

  /**
   * Konstruktor der Klasse Pruefungsleistung
   * 
   * @param modul
   *          Der Name des Moduls
   * 
   * @param note
   *          Die Note des Moduls
   */
  public Pruefungsleistung(String modul, double note) {
    this.modul = modul;
    this.note = note;
  }

  /**
   * @return Gibt den Modulnamen zurueck.
   */
  public String getModul() {
    return modul;
  }

  /**
   * @return Gibt die Note zurueck.
   */
  public double getNote() {
    return note;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals()
   */
  @Override
  public boolean equals(Object obj) {
    if (obj.getClass() == this.getClass()) {
      Pruefungsleistung andereLeistung = (Pruefungsleistung) obj;
      if (andereLeistung.getModul().equals(this.getModul()) 
          && andereLeistung.getNote() == this.getNote()) {
        return true;
      }
    }
    return false;
  }
  /**
   * Gibt das Objekt als String zurueck.
   */
  @Override
  public String toString() {
	  String toString = "Modul: " + modul + "\nNote: " + note;
	  return toString;
  }
}
