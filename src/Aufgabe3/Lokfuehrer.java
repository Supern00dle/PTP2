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

  public Lokfuehrer(Rangierbahnhof bahnhof, Arbeit arbeit) {
    // arbeitsstatus = lockfuehrerStatus.ARBEITSSUCHEND;
    this.arbeit = arbeit;
    this.bahnhof = bahnhof;
  }

  @Override
  public void run() {
    while (zug == null) {
      if (arbeit == Arbeit.ZUGAUSFAHREN) {
        sucheZugAusfahren();
      } else if (arbeit == Arbeit.ZUGEINFAHREN) {
        if (bahnhof.getFreieGleise() > 1) {
        sucheZugEinfahren();
        } else {
          interrupt();
        }
      }
    }
    if (zug.getPosition() == Position.EINFAHREND)
    {
      bahnhof.zugEinfahrenLassen(zug);
      konsolenOutput(konsolenOutputs.ZUGEINGEFAHREN);
      interrupt();
    } else if (zug.getPosition() == Position.AUFGLEIS) {
      bahnhof.zugAusfahrenLassen(zug);
      konsolenOutput(konsolenOutputs.ZUGAUSGEFAHREN);
      interrupt();
    } else if (zug.getPosition() == Position.AUSFAHREND) {
      zug = null;
      interrupt();
    }
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
      System.out.println("Der Zug: " + zug + " ist in den Bahnhof eingefahren.");
      break;
    }
    case ZUGAUSGEFAHREN: {
      System.out.println("Der Zug: " + zug + " wurde aus dem Bahnhof ausgefahren.");
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
