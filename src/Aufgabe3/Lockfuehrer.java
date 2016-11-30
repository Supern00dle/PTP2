
package Aufgabe3;

import Aufgabe3.Zug.position;

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

  private Zug zug;
  private final int zugAusfahrZeit = 800; //ms
  private final int zugEinfahrZeit = 800; //ms
  private Rangierbahnhof bahnhof;

  public enum lockfuehrerStatus {
    ARBEITSSUCHEND, ARBEITEND, ENTLASSEN
  }

  private enum konsolenOutputs {
    ZUGEINGEFAHREN, ZUGAUSGEFAHREN
  }
  
  public enum Arbeit{
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
    
    while(zug == null)
    {
      sucheJob();
      if(zug == null)
      {
        //warte wenn nach einmaliger Suche noch kein Zug vorhanden ist.
        try {
          wait(200);
        } catch (InterruptedException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
      
    
    if(zug.getPosition() == position.EINFAHREND)
    {
      bahnhof.zugEinfahrenLassen(zug);
      konsolenOutput(konsolenOutputs.ZUGEINGEFAHREN);
    }
    else if( zug.getPosition() == position.EINFAHREND)
    {
      bahnhof.zugAusfahrenLassen(zug);
      konsolenOutput(konsolenOutputs.ZUGAUSGEFAHREN);
    }
    else if( zug.getPosition() == position.AUSGEFAHREN)
    {
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
  
  private void sucheJob()
  {
    if(bahnhof.getFreieGleise() == 0)
    {
      
    }
  }

  public void weiseZugZu(Zug zug) {
    this.zug = zug;
  }
}