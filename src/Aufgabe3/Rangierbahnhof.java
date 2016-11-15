/**
 * 
 */
package Aufgabe3;

/**
 * @author Manuel Scholz & Leo Peters
 *
 */
public class Rangierbahnhof {

  private final int anzahlGleise = 10; // parameter fuer die groesse des
                                       // Bahnhofs. Soll in keiner Funkion
                                       // verwendet werden!

  private Zug[] zuege;
  private Gleis[] gleise;

  /**
   * Konstruktor der Klasse Rangierbahnhof.
   */
  public Rangierbahnhof() {
    erstelleGleise(anzahlGleise);
  }

  private void erstelleGleise(int anzahl) {
    gleise = new Gleis[anzahl];
    for (int i = 0; i < anzahl; i++) {
      gleise[i] = new Gleis(i + 1);
    }
  }

  public synchronized void zugAusfahrenLassen(Zug zug, Gleis gleis) {

    
  }

  public synchronized void zugAusfahrenLassen(Zug zug, int gleisnummer) {
    Gleis gleis = getGleisFromGleisnummer(gleisnummer);
    zugAusfahrenLassen(zug, gleis);
  }

  public synchronized void zugEinfahrenLassen(Zug zug, Gleis gleis) {

  }

  public synchronized void zugEinfahrenLassen(Zug zug, int gleisnummer) {
    Gleis gleis = getGleisFromGleisnummer(gleisnummer);
    zugEinfahrenLassen(zug, gleis);
  }

  /**
   * Gibt das Gleis mit der angegebenen Gleisnummer zurueck.
   * 
   * @param gleisnummer
   *          Die Nummer des gewollten Gleises
   * @return Das Gleis mit der angegebenen Nummer. Wenn null, dann gibt es kein
   *         Gleis mit der angegebenen Nummer.
   */
  private Gleis getGleisFromGleisnummer(int gleisnummer) {
    Gleis gleis = null;
    for (int i = 0; i < gleise.length; i++) {
      if (gleise[i].getGleisnummer() == gleisnummer) {
        gleis = gleise[i];
      }
    }

    return gleis;
  }

}
