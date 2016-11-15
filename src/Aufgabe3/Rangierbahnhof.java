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
      gleise[i] = new Gleis(i);
    }
  }

  /**
   * Laesst einen Zug von einem Gleis
   * 
   * @param zug
   *          Der Auszufahrende Zug.
   */
  public synchronized Zug zugAusfahrenLassen(Zug zug) {
    return getGleisFromZug(zug).zugAusfahren();
  }

  /**
   * Laesst einen Zug auf ein Gleis einfahren.
   * 
   * @param zug
   *          Der einzufahrende Zug.
   * @param gleis
   *          Das Gleis.
   */
  public synchronized void zugEinfahrenLassen(Zug zug, Gleis gleis) {
    gleis.zugEinfahren(zug);
  }
  
  /**
   * Laesst einen Zug auf ein Gleis einfahren.
   * 
   * @param zug
   *          Der einzufahrende Zug.

   */
  public synchronized void zugEinfahrenLassen(Zug zug) {
  }

  /**
   * Laesst einen Zug auf ein Gleis einfahren.
   * 
   * @param zug
   *          Der einzufahrende Zug.
   * @param gleisnummer
   *          Die Gleisnummer.
   */
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

  /**
   * Gibt das Gleis unter einem bestimmten Zug zurueck.
   * 
   * @param zug
   *          Der Zug unter dem geschaut werden soll
   * @return Das Gleis unter dem Zug. Wenn null steht der Zug auf keinem
   *         bekannten Gleis im Rangierbahnhof.
   */
  private Gleis getGleisFromZug(Zug zug) {
    Gleis gleis = null;
    for (int i = 0; i < gleise.length; i++) {
      if (gleise[i].getZug().equals(zug)) {
        gleis = gleise[i];
      }
    }
    return gleis;
  }

  /**
   * Gibt die Anzahl freier Gleise im Rangierbahnhof aus.
   * 
   * @return Die Anzahl der freien Gleise.
   */
  private int getAnzahlFreierGleise() {
    int anzahl = 0;
    for (int i = 0; i < gleise.length; i++) {
      if (gleise[i].getZug() == null) {
        anzahl++;
      }
    }
    return anzahl;
  }

}
