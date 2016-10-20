/**
 * 
 */
package Aufgabe1_3;

import static org.junit.Assert.*;

import org.junit.Test;
import Aufgabe1_3.ArrayListe;
import Aufgabe1_3.Generics;
/**
 * @author Manuel Scholz
 *
 */
public class GenericsTest {
  /**
   * Test method for {@link Aufgabe1_3.Generics#pruefeObErstesObjektZahlIst(Aufgabe1_3.ArrayListe)}.
   */
  @Test
  public final void testPruefeObErstesObjektZahlIst() {
    ArrayListe<String> stringListe = new ArrayListe<String>();
    ArrayListe<Integer> intListe = new ArrayListe<Integer>();
    stringListe.hinzufuegen("Java ist toll und so....");
    stringListe.hinzufuegen("mehr string");
    stringListe.hinzufuegen("ik");
    
    intListe.hinzufuegen(3);
    intListe.hinzufuegen(5);
    intListe.hinzufuegen(124);
    intListe.hinzufuegen(-43);
    
    assertTrue(Generics.pruefeObErstesObjektZahlIst(intListe));
    assertFalse(Generics.pruefeObErstesObjektZahlIst(stringListe));
    
    
    
  }

}
