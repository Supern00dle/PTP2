/**
 * 
 */
package Aufgabe2_3;

/**
 * @author Manuel Scholz
 *
 */
public class Flugzeug extends Thread{
  
  private Flughafen flughafen;
  private String id;
  private int flugdauer;
  private int startzeit;
  private Status status;
  private int zeit;

  /**
   * 
   */
  public Flugzeug() {
    // TODO Auto-generated constructor stub
  }
  
  @Override
  public void run()
  {
    
  }
  
  public boolean istGelandet()
  {
    return true;
  }
  
  @Override
  public String toString()
  {
    
    return null;
  }
  
  public void setZeit(int i)
  {
    
  }
}
