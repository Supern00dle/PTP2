
package Aufgabe3;

import Aufgabe3.Zug.Position;

/**
 * Aufgabe: Lokführer sind als Thread implementiert. Ein Lokführer hat immer genau eine von zwei möglichen
 * Aufgaben: Entweder einen neuen Zug auf ein bestimmtes Gleis einfahren oder einen Zug (der dort steht)
 * aus einem bestimmten Gleis ausfahren. Hat ein Lokführer eine der beiden Aktionen erfolgreich
 * durchgeführt, dann muss dieses Ereignis auf der Konsole ausgegeben werden.
 */
/**
 * @author Manuel Scholz & Leo Peters
 *
 */
public class Lockfuehrer extends Thread {

  private Zug zug;
  private final int zugAusfahrZeit = 5000; // ms
  private final int zugEinfahrZeit = 5000; // ms
  private Rangierbahnhof bahnhof;

  public enum lockfuehrerStatus {
    ARBEITSSUCHEND, ARBEITEND, ENTLASSEN
  }

  private enum konsolenOutputs {
    ZUGEINGEFAHREN, ZUGAUSGEFAHREN
  }

  public enum Arbeit {
    ZUGAUSFAHREN, ZUGEINFAHREN
  }

  private lockfuehrerStatus arbeitsstatus;

  /**
   * 
   */
  public Lockfuehrer(Zug zug, Rangierbahnhof bahnhof) {
    arbeitsstatus = lockfuehrerStatus.ARBEITSSUCHEND;
    this.zug = zug;
    this.bahnhof = bahnhof;
  }

  public Lockfuehrer(Rangierbahnhof bahnhof) {
    arbeitsstatus = lockfuehrerStatus.ARBEITSSUCHEND;
    this.bahnhof = bahnhof;
  }

  @Override
  public void run() {
    while (zug == null) {
      sucheJobAusfahren();
      if (zug == null) {
        sucheJobEinfahren();
      }
      if (zug == null) {
        // warte wenn nach einmaliger Suche noch kein Zug vorhanden ist.
        try {
          wait(200);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
    if (zug.getPosition() == Position.EINFAHREND) {
      bahnhof.zugEinfahrenLassen(zug);
      konsolenOutput(konsolenOutputs.ZUGEINGEFAHREN);
    } else if (zug.getPosition() == Position.AUFGLEIS) {
      bahnhof.zugAusfahrenLassen(zug);
      konsolenOutput(konsolenOutputs.ZUGAUSGEFAHREN);
    } else if (zug.getPosition() == Position.AUSFAHREND) {
      zug = null;
    }

  }

  /**
   * Entlaesst einen Lockfuerer
   */
  public lockfuehrerStatus entlasseLockfuehrer() {
    arbeitsstatus = lockfuehrerStatus.ENTLASSEN;
    return arbeitsstatus;
  }

  /**
   * Erstellt einen Konsolenoutput.
   * 
   * @param e
   *          Welcher Konsolenoutput gewaehlt werden soll.
   */
  private void konsolenOutput(konsolenOutputs e) {
    switch (e) {
    case ZUGEINGEFAHREN: {
      // Hier die Meldung, dass der Lockfuehrer den Zug eingefahren hat.
      break;
    }
    case ZUGAUSGEFAHREN: {
      // Hier die Meldung, dass der Lockfuehrer den Zug ausgefahren hat.
      break;
    }
    default: {
      // Defaultmeldung...
    }
    }
  }

  private synchronized void sucheJob() {
    zug = bahnhof.getAusfahrbarenZug();
    this.sucheJobEinfahren();
  }

  private synchronized void sucheJobEinfahren() {
    zug = new Zug();
  }

  public void weiseZugZu(Zug zug) {
    this.zug = zug;
  }
}
