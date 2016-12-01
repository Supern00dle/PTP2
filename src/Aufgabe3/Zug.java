/**
 * PTP2 Praktikum
 * Aufgabe 3
 * 01.12.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe3;

public class Zug {
  private static int zugNummerZaehler = 0;
  private int zugNummer;
  public enum Position
  {
    EINFAHREND, AUFGLEIS, AUSFAHREND
  }

  public Position pos;
  /**
   * Konstruktor für die Klasse Zug.
   */
  public Zug() {
    zugNummer = zugNummerZaehler;
    zugNummerZaehler++;
    pos = Position.EINFAHREND;
   
  }
  
  public void setPosition(Position position)
  {
    pos = position;
  }
  
  public Position getPosition()
  {
    return pos;
  }
  public String toString() {
    String toString = "" + zugNummer;
    return toString;
  }

}
