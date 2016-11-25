
package Aufgabe3;

/**
 * Aufgabe: Lokf�hrer sind als Thread implementiert. Ein Lokf�hrer hat immer genau eine von zwei m�glichen
 * Aufgaben: Entweder einen neuen Zug auf ein bestimmtes Gleis einfahren oder einen Zug (der dort steht)
 * aus einem bestimmten Gleis ausfahren. Hat ein Lokf�hrer eine der beiden Aktionen erfolgreich
 * durchgef�hrt, dann muss dieses Ereignis auf der Konsole ausgegeben werden.
 */
/**
 * @author Manuel Scholz & Leo Peters
 *
 */
public class Lockfuehrer extends Thread {

  Zug zug;

  public enum lockfuehrerStatus {
    ARBEITSSUCHEND, ARBEITEND, ENTLASSEN
  }

  private enum konsolenOutputs {
    ZUGEINGEFAHREN, ZUGAUSGEFAHREN
  }

  private lockfuehrerStatus arbeitsstatus;

  /**
   * 
   */
  public Lockfuehrer() {
    arbeitsstatus = lockfuehrerStatus.ARBEITSSUCHEND;
    zug = null;
  }

  @Override
  public void run() {
    while (arbeitsstatus != lockfuehrerStatus.ENTLASSEN) {
      
      //Hab ich einen Zug? Entlasse mich
      if (zug != null) {
        entlasseLockfuehrer();
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

  public void weiseZugZu(Zug zug) {
    this.zug = zug;
  }
}
