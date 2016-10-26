/**
 * 
 */
package Aufgabe2_1;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import Aufgabe2_1.Rechner.Operation;

/**
 * @author Manuel Scholz
 *
 */
public class Rechner implements DoubleDoubleZuDouble {

  public enum Operation
  {
    addiere,
    subtrahiere,
    multipliziere,
    dividiere
  }

  
  public Rechner() {
    List<Operation> op = new List<Operation>();
  }
  
  public double berechne(Operation o, double w1, double w2)
  {
    switch(o){
      case addiere:
        break;
      
      case subtrahiere:
        break;
      case multipliziere:
        break;
      case dividiere:
        break;
    }
    return 0;
  }

  /* (non-Javadoc)
   * @see Aufgabe2.DoubleDoubleZuDouble#werteAus(double, double)
   */
  @Override
  public double werteAus(double d1, double d2) {
    // TODO Auto-generated method stub
    return 0;
  }

}
