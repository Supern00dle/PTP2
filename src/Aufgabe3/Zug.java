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

  /**
   * Konstruktor für die Klasse Zug.
   */
  public Zug() {
    zugNummer = zugNummerZaehler;
    zugNummerZaehler++;
  }

  public String toString() {
    String toString = "" + zugNummer;
    return toString;
  }

}
