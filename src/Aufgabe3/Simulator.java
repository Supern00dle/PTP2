/**
 * 
 */
package Aufgabe3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Manuel Scholz
 *
 */
public class Simulator {
  
  private static int anzahlLockfuehrer = 5;
  private static int anzahlZuege = 20;
  
  Rangierbahnhof bahnhof;
  List<Lockfuehrer> fuehrer;
  List<Zug> zuege;
  
  public Simulator()
  {
    zuege = new ArrayList<Zug>();
    fuehrer = new ArrayList<Lockfuehrer>();
  }
  


  public void starteSimulation() {
    // Endlos Simulationsschleife
    bahnhof = new Rangierbahnhof();
    fuehrer = new ArrayList<Lockfuehrer>();
    while (true) {
      //halte die anzahl der Lockfuehrer und Zuege Konstant
      if(fuehrer.size() < anzahlLockfuehrer)
      {
        while( fuehrer.size() <= anzahlLockfuehrer)
        {
          fuehrer.add(new Lockfuehrer(bahnhof));
          System.out.println("erstelle Lockfuehrer");
        }
        while( zuege.size() <= anzahlZuege)
        {
          zuege.add(new Zug());
          System.out.println("Erstelle Zug");
        }
      }
      
      
    }
  }
  
  public static void main(String[] args)
  {
    Simulator sim = new Simulator();
    sim.starteSimulation();
  }
  
}
