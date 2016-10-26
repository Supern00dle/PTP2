/**
 * 
 */
package Aufgabe2_3;

import java.util.List;

/**
 * @author Manuel Scholz
 *
 */
public class Flughafen extends Thread {
  
  private List<Flugzeug> flugzeuge;
  private int anzahlFlugzeuge;

  /**
   * 
   */
  public Flughafen() {
    // TODO Auto-generated constructor stub
  }
  
  public void flugzeugHinzufuegen(Flugzeug fz)
  {
    
  }
  
  private Flugzeug erzeugeFlugzeug(Flughafen f, int i)
  {
    
    return null;
  }

  
  public static void main(String[] args) {

    Flughafen f = new Flughafen();
    f.start();
    
  }
}
