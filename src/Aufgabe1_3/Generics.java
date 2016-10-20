package Aufgabe1_3;

/**
 * @author Manuel Scholz, Leo Peters
 *
 */
public class Generics {
  
  
  /**
   * Testing
   * @param args
   */
  public static void main(String[] args)
  {
    
  }


  /**
   * Die Funktion prueft, ob das erste Objekt in der ArrayListe eine Zahl ist,
   * @param t die ArrayListe die ueberprueft werden soll.
   * @return True wenn das erste Objekt eine Zahl ist.
   */
  @SuppressWarnings("rawtypes")
  public static boolean pruefeObErstesObjektZahlIst(ArrayListe<?> t) {
    if (t.getAnzahlElemente() > 0) {
      Class c = t.get(0).getClass();
      if (c.equals(Integer.class) || c.equals(Double.class) || c.equals(float.class) || c.equals(long.class)
          || c.equals(char.class)) {
        return true;
      }
    }
    return false;
  }

}
