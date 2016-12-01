/**
 * PTP2 Praktikum
 * Aufgabe 3
 * 01.12.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe3;

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
    arbeitAusfuehren();
  }

  /**
   * Je nachdem, welche Arbeit der Lokfuehrer hat, wird entweder ein Zug von
   * Gleis aus- oder eingefahren.
   */

  private synchronized void arbeitAusfuehren() {
    while (!kannAuftragAusfuehren(arbeit, gleis)) {
      try {
        wait();
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
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
  /**
   * Ueberprueft, ob der Auftrag ausgefuehrt werden kann.
   * @param arbeit
   * Die Arbeit, die ueberprueft werden soll
   * @param gleis
   * Auf welchem Gleis die Arbeit ausgefuehrt werden soll.
   * @return  true, wenn ausgefuehrt werden kann, false wenn nicht.
   */
  private boolean kannAuftragAusfuehren(Arbeit arbeit, int gleis) {
    if (arbeit == Arbeit.ZUGEINFAHREN && bahnhof.gleisIstFrei(gleis) == true) {
      return true;
    } else if (arbeit == Arbeit.ZUGEINFAHREN && bahnhof.gleisIstFrei(gleis) == false) {
      return false;
    } else if (arbeit == Arbeit.ZUGAUSFAHREN && bahnhof.getZug(gleis) != null) {
      return true;
    } else {
      return false;
    }
  }
}
