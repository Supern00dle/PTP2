/**
 * 
 */
package Aufgabe1_3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Manuel Scholz
 *
 */
public class ArrayListeTest {

  ArrayListe<Integer> intListe;
  ArrayListe<String> stringListe;
  ArrayListe<Double> doubleListe;
  ArrayListe<Character> charListe;

  /**
   * Test method for {@link Aufgabe1_3.ArrayListe#ArrayListe()}.
   */
  @Test
  public final void testArrayListe() {
    intListe = new ArrayListe<Integer>();
    stringListe = new ArrayListe<String>();
    doubleListe = new ArrayListe<Double>();
    charListe = new ArrayListe<Character>();
  }

  /**
   * Test method for {@link Aufgabe1_3.ArrayListe#hinzufuegen(java.lang.Object)}
   * .
   */
  @Test
  public final void testHinzufuegen() {
    intListe = new ArrayListe<Integer>();
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(4);
    intListe.hinzufuegen(6);
    intListe.hinzufuegen(-325);
    intListe.hinzufuegen(58639);

    stringListe = new ArrayListe<String>();
    stringListe.hinzufuegen("aaa");
    stringListe.hinzufuegen("BBB");
    stringListe.hinzufuegen("ccdcd   cdcdcd   dcdcd");
    stringListe.hinzufuegen("afnewkn");

    doubleListe = new ArrayListe<Double>();
    doubleListe.hinzufuegen(3.141592);
    doubleListe.hinzufuegen(-500000.0);
    doubleListe.hinzufuegen(-0.00000001);
    doubleListe.hinzufuegen(2.0);
    doubleListe.hinzufuegen(238572.248543);

    charListe = new ArrayListe<Character>();
    charListe.hinzufuegen('a');
    charListe.hinzufuegen('.');
    charListe.hinzufuegen('!');
    charListe.hinzufuegen('ß');
  }

  /**
   * Test method for {@link Aufgabe1_3.ArrayListe#get(int)}.
   */
  @Test
  public final void testGet() {
    intListe = new ArrayListe<Integer>();
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(4);
    intListe.hinzufuegen(6);
    intListe.hinzufuegen(-325);
    intListe.hinzufuegen(58639);

    assertTrue(intListe.get(0) == 2);
    assertTrue(intListe.get(1) == 4);
    assertTrue(intListe.get(2) == 6);
    assertTrue(intListe.get(3) == -325);
    assertTrue(intListe.get(4) == 58639);

    stringListe = new ArrayListe<String>();
    stringListe.hinzufuegen("aaa");
    stringListe.hinzufuegen("BBB");
    stringListe.hinzufuegen("ccdcd   cdcdcd   dcdcd");
    stringListe.hinzufuegen("afnewkn");

    assertTrue(stringListe.get(0) == "aaa");
    assertTrue(stringListe.get(1) == "BBB");
    assertTrue(stringListe.get(2) == "ccdcd   cdcdcd   dcdcd");
    assertTrue(stringListe.get(3) == "afnewkn");

    doubleListe = new ArrayListe<Double>();
    doubleListe.hinzufuegen(3.141592);
    doubleListe.hinzufuegen(-500000.0);
    assertTrue(doubleListe.get(0) == 3.141592);
    assertTrue(doubleListe.get(1) == -500000.0);

    charListe = new ArrayListe<Character>();
    charListe.hinzufuegen('a');
    charListe.hinzufuegen('.');
    assertTrue(charListe.get(0) == 'a');
    assertTrue(charListe.get(1) == '.');

  }

  /**
   * Test method for {@link Aufgabe1_3.ArrayListe#entfernen(java.lang.Object)}.
   */
  @Test
  public final void testEntfernen() {
    intListe = new ArrayListe<Integer>();
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(6);

    intListe.entfernen(2);
    assertNotNull(intListe.get(0));
    assertTrue(intListe.get(0) == 6);

  }

  /**
   * Test method for {@link Aufgabe1_3.ArrayListe#entferneElementAnIndex(int)}.
   */
  @Test
  public final void testEntferneElementAnIndex() {

    intListe = new ArrayListe<Integer>();
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(6);

    intListe.entferneElementAnIndex(1);
    assertNotNull(intListe.get(1));
  }

  /**
   * Test method for {@link Aufgabe1_3.ArrayListe#getAnzahlElemente()}.
   */
  @Test
  public final void testGetAnzahlElemente() {
    intListe = new ArrayListe<Integer>();
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(6);
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(6);

    assertTrue(intListe.getAnzahlElemente() == 5);
  }

  /**
   * Test method for {@link Aufgabe1_3.ArrayListe#toString()}.
   */
  @Test
  public final void testToString() {
    intListe = new ArrayListe<Integer>();
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(6);
    intListe.hinzufuegen(2);
    intListe.hinzufuegen(6);
    assertTrue(intListe.toString().equals(" 2 2 6 2 6"));
  }

}
