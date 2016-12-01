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
  private final int zugAusfahrZeit = 5000; // ms
  private final int zugEinfahrZeit = 5000; // ms
  private Rangierbahnhof bahnhof;
  private Arbeit arbeit;
  private int gleis;

  // public enum lockfuehrerStatus {
  // ARBEITSSUCHEND, ARBEITEND, ENTLASSEN
  // }

  private enum konsolenOutputs {
    ZUGEINGEFAHREN, ZUGAUSGEFAHREN
  }

  public enum Arbeit {
    ZUGAUSFAHREN, ZUGEINFAHREN
  }

  // private lockfuehrerStatus arbeitsstatus;

  /**
   * 
   */
  public Lokfuehrer(Arbeit arbeit) {
    // arbeitsstatus = lockfuehrerStatus.ARBEITSSUCHEND;
    this.arbeit = arbeit;
  }

  public Lokfuehrer(Rangierbahnhof bahnhof, Arbeit arbeit, int gleis) {
    // arbeitsstatus = lockfuehrerStatus.ARBEITSSUCHEND;
    this.arbeit = arbeit;
    this.bahnhof = bahnhof;
    this.gleis = gleis;
  }

  @Override
  public void run() {
    arbeitAusführen();
  }
  
  private void arbeitAusführen() {
    if (arbeit == Arbeit.ZUGEINFAHREN) {
      zug = new Zug();
      bahnhof.zugEinfahrenLassen(zug, gleis);
      konsolenOutput(konsolenOutputs.ZUGEINGEFAHREN);
    } else if (arbeit == Arbeit.ZUGAUSFAHREN) {
      bahnhof.zugAusfahrenLassen(gleis);
      konsolenOutput(konsolenOutputs.ZUGAUSGEFAHREN);
    }     
  }
  public int getGleis() {
    return gleis;
  }
  
  public Arbeit getArbeit() {
    return arbeit;
  }
  /**
   * Entlaesst einen Lockfuehrer durch interrupt()
   */
  public void entlasseLockfuehrer() {
    interrupt();
  }
  // public lockfuehrerStatus entlasseLockfuehrer() {
  // arbeitsstatus = lockfuehrerStatus.ENTLASSEN;
  // return arbeitsstatus;
  // }

  /**
   * Erstellt einen Konsolenoutput.
   * 
   * @param e
   *          Welcher Konsolenoutput gewaehlt werden soll.
   */
  private void konsolenOutput(konsolenOutputs e) {
    switch (e) {
    case ZUGEINGEFAHREN: {
      System.out.println("Der Zug: " + zug.toString() + " ist in den Bahnhof eingefahren.");
      break;
    }
    case ZUGAUSGEFAHREN: {
      System.out.println("Der Zug: wurde aus dem Bahnhof ausgefahren.");
      break;
    }
    default: {
      // Defaultmeldung...
    }
    }
  }

  private synchronized void sucheZugAusfahren() {
    Zug zug1 = bahnhof.getAusfahrbarenZug();
    if (zug1 != null) {
      weiseZugZu(zug1);
    }
  }

  private synchronized void sucheZugEinfahren() {
    weiseZugZu(new Zug());
  }

  public void weiseZugZu(Zug zug) {
    this.zug = zug;
  }
}
