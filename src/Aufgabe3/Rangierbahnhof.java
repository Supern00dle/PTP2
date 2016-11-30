/**
 * PTP2 Praktikum
 * Aufgabe 3
 * 01.12.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe3;

import java.util.List;

import Aufgabe3.Zug.Position;

/**
 * @author Manuel Scholz & Leo Peters
 *
 */
public class Rangierbahnhof extends Thread {

  public static final int KEINFREIESGLEIS = -1;
  private final int maximalAnzahlZuege = 20;
  private final int anzahlGleise = 8;
  private final long zugEinfahrZeit = 5000; // ms
  private final long zugAusfahrZeit = 5000; // ms
  private Zug[] gleis; // repraesentiert die Gleise

  /**
   * Konstruktor der Klasse Rangierbahnhof.
   */
  public Rangierbahnhof() {
    gleis = new Zug[anzahlGleise];
  }

  /**
   * Laesst einen Zug von einem Gleis ausfahren
   * 
   * @param zug
   *          Der Auszufahrende Zug.
   */
  public synchronized void zugAusfahrenLassen(Zug zug) {
    try {
      wait(zugAusfahrZeit);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    befreieGleis(zug);
  }

  /**
   * Laesst einen Zug auf ein Gleis einfahren.
   * 
   * @param zug
   *          Der einzufahrende Zug.
   */
  public synchronized void zugEinfahrenLassen(Zug zug) {
    if (getFreieGleise() > 0) {
      try {
        wait(zugEinfahrZeit);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      belegeGleis(zug);
    }
  }

  public int getBelegteGleise() {
    int belegteGleise = 0;
    for (int i = 0; i < gleis.length; i++) {
      if (gleis[i] != null) {
        belegteGleise++;
      }
    }
    return belegteGleise;
  }

  /**
   * Gibt das Gleis unter einem Zug zurueck.
   * 
   * @param z
   *          Der Zug
   * @return Die Gleisnummer, wenn -1, dann ist der zug nicht auf dem Bahnhof.
   */
  private int getGleisVonZug(Zug z) {
    int gleisDesZuges = -1;
    for (int i = 0; i < gleis.length; i++) {
      if (gleis[i].equals(z)) {
        gleisDesZuges = i;
        break;
      }
    }

    return gleisDesZuges;

  }

  /**
   * Gibt ein freies Gleis zurueck.
   * 
   * @return Das freie Gleis. wenn -1, dann ist kein Gleis frei;
   */
  private int getFreiesGleis() {
    for (int i = 0; i < gleis.length; i++) {
      if (gleis[i] == null) {
        return i;
      }
    }
    return KEINFREIESGLEIS;
  }

  public int getFreieGleise() {
    int freieGleise = 0;
    for (int i = 0; i < gleis.length; i++) {
      if (gleis[i] == null) {
        freieGleise++;
      }
    }
    return freieGleise;
  }

  /**
   * Belegt ein Gleis mit einem Zug
   * 
   * @param z
   *          Der Zug
   * @param i
   *          Die Gleisnummer
   */
  private void belegeGleis(Zug z, int i) {
    // TODO: handling wenn Gleis belegt
    gleis[i] = z;
  }

  /**
   * Belegt das nächste freie Gleis mit einem Zug
   * 
   * @param z
   *          der Zug
   */
  private void belegeGleis(Zug z) {
    // TODO: handling wenn kein freies Gleis
    gleis[getFreiesGleis()] = z;
  }

  /**
   * Befreit ein Gleis von seinem Zug
   * 
   * @param z
   *          Der Zug
   */
  private void befreieGleis(Zug z) {
    int g = getGleisVonZug(z);
    if (g != -1) {
      gleis[g] = null;
    }
  }

  public Zug getAusfahrbarenZug()
  {
    Zug z = null;
    
    while()
      if(gleis[i] != null)
      {
        
      }
        
    
  }

  @Override
  public void run() {

  }

  /**
   * Loescht den Zug aus der Zugliste
   * 
   * @param z
   *          Der zu loeschende Zug
   */
  public void entferneZug(Zug z) {

  }

}
