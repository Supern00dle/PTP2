/**
 * 
 */
package Aufgabe3;

/**
 * @author Manuel Scholz & Leo Peters
 *
 */
public class Rangierbahnhof extends Thread {
  
  /**
   * Konstruktor der Klasse Rangierbahnhof.
   */
  public Rangierbahnhof() {
  }


  /**
   * Laesst einen Zug von einem Gleis
   * 
   * @param zug
   *          Der Auszufahrende Zug.
   */
  public synchronized Zug zugAusfahrenLassen(Zug zug) {
    return null;
  }

  /**
   * Laesst einen Zug auf ein Gleis einfahren.
   * 
   * @param zug
   *          Der einzufahrende Zug.
   * @param gleis
   *          Das Gleis.
   */
  public synchronized void zugEinfahrenLassen(Zug zug) {
    
  }

  
  @Override
  public void run()
  {
    
  }

}
