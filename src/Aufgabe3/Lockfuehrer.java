
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
public class Lockfuehrer extends Thread{

  private enum konsolenOutputs{
    ZUGEINGEFAHREN,
    ZUGAUSGEFAHREN
  }
  /**
   * 
   */
  public Lockfuehrer() {
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public void run()
  {
    
  }
  
  private void konsolenOutput(konsolenOutputs e)
  {
    switch(e)
    {
      case ZUGEINGEFAHREN:
      {
      //Hier die Meldung, dass der Lockfuehrer den Zug eingefahren hat.
        break;
      }
      case ZUGAUSGEFAHREN:
      {
        //Hier die Meldung, dass der Lockfuehrer den Zug ausgefahren hat.
        break;
      }

    }
  }

}
