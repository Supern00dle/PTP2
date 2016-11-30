/**
 * 
 */
package Aufgabe3;

/**
 * @author Manuel Scholz & Leo Peters
 *
 */
public class Zug {
  
  public enum position
  {
    EINFAHREND, AUFGLEIS, AUSGEFAHREN
  }

  private position pos;
  /**
   * Konstruktor für die Klasse Zug.
   */
  public Zug() {
    
    pos = position.EINFAHREND;
   
  }
  
  public void setPosition(position p)
  {
    pos = p;
  }
  
  public position getPosition()
  {
    return pos;
  }
  

}
