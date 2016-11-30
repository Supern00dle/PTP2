/**
 * 
 */
package Aufgabe3;

/**
 * @author Manuel Scholz & Leo Peters
 *
 */
public class Zug {
  
  public enum Position
  {
    EINFAHREND, AUFGLEIS, AUSGEFAHREN
  }

  private Position pos;
  /**
   * Konstruktor für die Klasse Zug.
   */
  public Zug() {
    
    pos = Position.EINFAHREND;
   
  }
  
  public void setPosition(Position position)
  {
    pos = position;
  }
  
  public Position getPosition()
  {
    return pos;
  }
  

}
