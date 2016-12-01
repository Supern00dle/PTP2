/**
 * PTP2 Praktikum
 * Aufgabe 3
 * 01.12.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe3;

import Aufgabe3.Zug.Position;

/**
 * Aufgabe: Lokführer sind als Thread implementiert. Ein Lokführer hat immer
 * genau eine von zwei möglichen Aufgaben: Entweder einen neuen Zug auf ein
 * bestimmtes Gleis einfahren oder einen Zug (der dort steht) aus einem
 * bestimmten Gleis ausfahren. Hat ein Lokführer eine der beiden Aktionen
 * erfolgreich durchgeführt, dann muss dieses Ereignis auf der Konsole
 * ausgegeben werden.
 */

public class Lokfuehrer extends Thread {

  private Zug zug = null;
  private Rangierbahnhof bahnhof;
  private Arbeit arbeit;
  private int gleis;

  /**
   * Enum zur Ausgabe auf der Konsole.
   */
  private enum konsolenOutputs {
    ZUGEINGEFAHREN, ZUGAUSGEFAHREN
  }

  /**
   * Enum für die Aufträge der Lokfuehrer.
   */
  public enum Arbeit {
    ZUGAUSFAHREN, ZUGEINFAHREN
  }

  /**
   * Initialisiert einen Lokfuehrer mit einem Bahnhof einem Auftrag und einem
   * bestimmten Gleis.
   * 
   * @param bahnhof
   *          Der Bahnhof, auf welchem der Lokfuehrer seiner Arbeit nachgeht
   * 
   * @param arbeit
   *          Den Auftrag, den der Lokfuehrer ausführen muss.
   * 
   * @param gleis
   *          Der Index des Gleises, auf welchem der Lokfuehrer einen Zug ein-
   *          oder ausfährt.
   */
  public Lokfuehrer(Rangierbahnhof bahnhof, Arbeit arbeit, int gleis) {
    this.arbeit = arbeit;
    this.bahnhof = bahnhof;
    this.gleis = gleis;
  }

  public int getGleis() {
    return gleis;
  }

  public Arbeit getArbeit() {
    return arbeit;
  }

  /**
   * Run Methode für Threads.
   */
  @Override
  public void run() {
    arbeitAusführen();
  }

  /**
   * Je nachdem, welche Arbeit der Lokfuehrer hat, wird entweder ein Zug von
   * Gleis aus- oder eingefahren.
   */

  private void arbeitAusführen() {
    if (arbeit == Arbeit.ZUGEINFAHREN) {
      zug = new Zug();
      bahnhof.zugEinfahrenLassen(zug, gleis);
      konsolenOutput(konsolenOutputs.ZUGEINGEFAHREN);
    } else if (arbeit == Arbeit.ZUGAUSFAHREN) {
      zug = bahnhof.getZug(gleis);
      bahnhof.zugAusfahrenLassen(gleis);
      konsolenOutput(konsolenOutputs.ZUGAUSGEFAHREN);
    }
  }

  /**
   * Erstellt ein Konsolenoutput.
   * 
   * @param output
   *          Welcher Konsolenoutput gewaehlt werden soll.
   */
  private void konsolenOutput(konsolenOutputs output) {
    switch (output) {
    case ZUGEINGEFAHREN: {
      System.out.println("Der Zug: " + zug.toString() + " ist in den Bahnhof eingefahren.");
      break;
    }
    case ZUGAUSGEFAHREN: {
      System.out.println("Der Zug: " + zug.toString() + " wurde aus dem Bahnhof ausgefahren.");
      break;
    }
    default: {
      System.out.println("Nichts geschieht");
    }
    }
  }
}
