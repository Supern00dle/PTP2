
package Aufgabe3;

import Aufgabe3.Zug.position;

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
  private final int zugAusfahrZeit = 800; // ms
  private final int zugEinfahrZeit = 800; // ms
  private Rangierbahnhof bahnhof;
  private Simulator sim;

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
  public Lockfuehrer(Zug zug, Rangierbahnhof bahnhof, Simulator sim) {
    arbeitsstatus = lockfuehrerStatus.ARBEITSSUCHEND;
    this.zug = zug;
    this.bahnhof = bahnhof;
    this.sim = sim;
  }

  public Lockfuehrer(Rangierbahnhof bahnhof, Simulator sim) {
    arbeitsstatus = lockfuehrerStatus.ARBEITSSUCHEND;
    this.bahnhof = bahnhof;
    this.sim = sim;
  }

  @Override
  public void run() {

    while (zug == null) {
      sucheJob();
      if (zug == null) {
        // warte wenn nach einmaliger Suche noch kein Zug vorhanden ist.
        synchronized (this) {
          try {
            wait(200);
          } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        }
      } else {

        if (zug.getPosition() == position.EINFAHREND) {
          bahnhof.zugEinfahrenLassen(zug);
          konsolenOutput(konsolenOutputs.ZUGEINGEFAHREN);
          zug = null;
        } else if (zug.getPosition() == position.EINFAHREND) {
          bahnhof.zugAusfahrenLassen(zug);
          konsolenOutput(konsolenOutputs.ZUGAUSGEFAHREN);
          zug = null;
        } else if (zug.getPosition() == position.AUSGEFAHREN) {
          zug = null;
        }
      }
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
        System.out.println("Zug eingefahren");
        break;
      }
      case ZUGAUSGEFAHREN: {
        System.out.println("Zug ausgefahen");
        break;
      }
      default: {
        // Defaultmeldung...
      }
    }
  }

  private void sucheJob() {
    if (bahnhof.getFreieGleise() == 0) {
      zug = bahnhof.getAusfahrbarenZug();
    } else if (bahnhof.getBelegteGleise() == 0) {
      zug = sim.getEinfahrbarenZug();
    } else {
      switch ((int) Math.random() * 2) {
        case 0: {
          zug = bahnhof.getAusfahrbarenZug();
          break;
        }
        case 1: {
          zug = sim.getEinfahrbarenZug();
          break;
        }
      }

    }
  }

  public void weiseZugZu(Zug zug) {
    this.zug = zug;
  }
}
