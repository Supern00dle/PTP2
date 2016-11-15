
package Aufgabe3;

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
