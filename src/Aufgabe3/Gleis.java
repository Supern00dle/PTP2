/**
 * 
 */
package Aufgabe3;

/**
 * @author Manuel Scholz & Leo Peters
 *
 */
public class Gleis {

  private int gleisnummer;
  private Zug zug;

  /**
   * Konstruktor der Klasse Gleis
   * 
   * @param gleisnummer
   *          Die Nummer des Gleises
   */
  public Gleis(int gleisnummer) {
    this.gleisnummer = gleisnummer;
  }

  /**
   * Getter der Gleisnummer
   * 
   * @return Die Gleisnummer
   */
  public int getGleisnummer() {
    return gleisnummer;
  }

  /**
   * Funktion zum einfahren eines Zuges.
   * 
   * @param zug
   *          Der Zug der auf dieses Gleis einfahren soll
   * @return True wenn der Zug einfahren konnte, False wenn bereits ein Zug
   *         drauf steht.
   */
  public boolean zugEinfahren(Zug zug) {
    if (this.zug != null) {
      return false;
    } else {
      this.zug = zug;
      return true;
    }
  }

  /**
   * Funktion zum ausfahren eines Zuges.
   * 
   * @return Der ausgefahrene Zug.
   */
  public Zug zugAusfahren() {
    // da return das Ende der Funktion ist, muss zum ausgeben von zug dieser
    // zuvor gerettet werden.
    Zug tempZug = zug;
    zug = null;
    return tempZug;
  }

  /**
   * Getter für den Zug, welcher auf diesem Gleis steht.
   * 
   * @return Der Zug der auf dem Gleis steht.
   */
  public Zug getZug() {
    return zug;
  }

}
