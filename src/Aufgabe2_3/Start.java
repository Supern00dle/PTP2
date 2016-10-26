/**Aufgaben: In dieser Aufgabe erstellen Sie die Simulation eines Flughafens. Diese besteht aus einem
*Flughafen und beliebig vielen Flugzeugen. Beide werden durch je eine Klasse repräsentiert, und beide sind
*Threads.
*/
package Aufgabe2_3;

/**
 * @author Manuel Scholz
 *
 */
public class Start {

  /**
   * @param args
   */
  public static void main(String[] args) {

    Flughafen f = new Flughafen();
    f.start();
    
  }

}
