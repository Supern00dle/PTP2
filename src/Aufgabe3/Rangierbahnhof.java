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
  public static final int FEHLER = -1;
  public static final int ERFOLG = 0;
  private final int maximalAnzahlZuege = 20;
  private final int anzahlGleise = 8;
  private final int zugEinfahrZeit = 5000; // ms
  private final int zugAusfahrZeit = 5000; // ms
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
    // TODO Zug stirbt?!
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
      zug.setPosition(Position.AUFGLEIS);
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
   * Gibt das Gleis eines Zuges zurueck.
   * 
   * @param z
   *          Der Zug
   * @return Die Gleisnummer, wenn -1, dann ist der zug nicht auf dem Bahnhof.
   */
  private int getGleisVonZug(Zug z) {
    for (int i = 0; i < gleis.length; i++) {
      if (gleis[i].equals(z)) {
        return i;
      }
    }
    return FEHLER;
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
    return FEHLER;
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
   * @return Wenn -1 zurückgegeben wird, ist das Gleis bereits belegt.
   *         Wenn 0 zurückgegeben wird, hat das belegen geklappt.
   * 
   * @param z
   *          Der Zug
   * @param i
   *          Die Gleisnummer
   */
  private int belegeGleis(Zug z, int i) {
    if (gleis[i] == null) {
      gleis[i] = z;
      z.setPosition(Position.EINFAHREND);
      return ERFOLG;
    } else {
      return FEHLER;
    }
  }

  /**
   * Belegt das nächste freie Gleis mit einem Zug
   * 
   * @param z
   *          der Zug
   */
  private int belegeGleis(Zug z) {
    int freiesGleis = getFreiesGleis();
    if (freiesGleis != FEHLER) {
      gleis[getFreiesGleis()] = z;
      z.setPosition(Position.EINFAHREND);
      return ERFOLG;
    } else {
      return FEHLER;
    }
  }

  /**
   * Befreit ein Gleis von seinem Zug
   * 
   * @param z
   *          Der Zug
   */
  private void befreieGleis(Zug z) {
    int g = getGleisVonZug(z);
    if (g != FEHLER) {
      gleis[g] = null;
      z.setPosition(Position.AUSFAHREND);
    }
  }

  public Zug getAusfahrbarenZug() {
    for(int i = 0; i < gleis.length; i++) {
      if(gleis[i] != null && gleis[i].getPosition() == Position.AUFGLEIS) {
        return gleis[i];
      }
    }
    return null;
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
