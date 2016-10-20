package Aufgabe1_3;

/**
 * @author Manuel Scholz, Leo Peters
 *
 */
public class Generics {

  /**
   * Diese main methode erstellt ein Objekt der Klasse ArrayListe und erstellt
   * ein paar Objekte dafür und prueft ob das erste Objekt eine Zahl ist
   * 
   * @param args
   */
  public static void main(String[] args) {

  }
  
  public static boolean pruefeObErstesObjektZahlIst(ArrayListe<?> t)
  {
    
    if(t.anzahlElemente > 0)
    {
      for(int i = 0; i < t.getAnzahlElemente(); i++)
      {
        
      }
      return true;
    }
    return false; 
  }

}
