/**
 * PTP2 Praktikum
 * Aufgabe 3
 * 01.12.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe3;

import Aufgabe3.Zug.Position;

public class Rangierbahnhof extends Thread {

  private Zug[] gleis; // repraesentiert die Gleise

  /**
   * Konstruktor der Klasse Rangierbahnhof.
   */
  public Rangierbahnhof(int anzahlGleise) {
    gleis = new Zug[anzahlGleise];
  }

  /**
   * Gibt die Anzahl der Gleise zurück.
   */
  public int getAnzahlGleise() {
    return gleis.length;
  }

  /**
   * Gibt einen Zug aufgrund seines Indexes im gleisArray zurück.
   * 
   * @param index
   *          Index ist die Gleisnummer, auf dem der Zug steht
   * 
   * @return Gibt den Zug auf dem Gleis zurück
   */
  public Zug getZug(int index) {
    return gleis[index];
  }

  /**
   * Laesst einen Zug von einem Gleis ausfahren
   * 
   * @param zug
   *          Der Auszufahrende Zug.
   */
  public synchronized void zugAusfahrenLassen(int gleis) {
    try {
      wait(500);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    befreieGleis(gleis);
    notifyAll();
  }

  /**
   * Laesst einen Zug auf ein Gleis einfahren.
   * 
   * @param zug
   *          Der einzufahrende Zug.
   */
  public synchronized void zugEinfahrenLassen(Zug zug, int gleis) {
    try {
      wait(500);
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    belegeGleis(zug, gleis);
    notifyAll();
  }

  /**
   * Belegt ein Gleis mit einem Zug
   * 
   * @return Wenn false zurückgegeben wird, ist das Gleis bereits belegt. Wenn
   *         true zurückgegeben wird, hat das belegen geklappt.
   * 
   * @param z
   *          Der Zug
   * @param i
   *          Die Gleisnummer
   */
  private boolean belegeGleis(Zug z, int i) {
    if (gleis[i] == null) {
      gleis[i] = z;
      z.setPosition(Position.EINFAHREND);
      return true;
    } else {
      return false;
    }
  }

  /**
   * Überprüft ob ein bestimmtes Gleis frei ist oder nicht.
   * 
   * @param gleis
   *          Ein Gleis, von dem man wissen möchte, ob es frei ist.
   * @return Gibt true zurück, wenn Gleis frei ist. False, wenn nicht.
   */
  public boolean gleisIstFrei(int gleis) {
    if (this.gleis[gleis] == null) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * Befreit ein Gleis von seinem Zug
   * 
   * @param z
   *          Der Zug
   */
  private void befreieGleis(int g) {
    gleis[g] = null;
  }
}
