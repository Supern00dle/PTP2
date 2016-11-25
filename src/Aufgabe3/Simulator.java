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
  
  Rangierbahnhof bahnhof;
  List<Lockfuehrer> fuehrer;
  


  public void starteSimulation() {
    // Endlos Simulationsschleife
    bahnhof = new Rangierbahnhof();
    fuehrer = new ArrayList<Lockfuehrer>();
    while (true) {

    }
  }
  
}
