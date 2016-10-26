/** Aufgabe 2.2: Streams
*+Lernziele: Streams erzeugen, verarbeiten und terminieren
*Aufgaben:
*�  Gegeben ist ein String-Array mit Benutzereingaben, die korrigiert werden sollen. Schreiben Sie dazu
*eine Verarbeitung mit einer Streams-Kette, die folgende Funktionalit�t bietet:
*o  Entfernen von null-Eingaben
*o  Abschneiden der Leerzeichen am Anfang und Ende
*o  Konvertierung von Klein- zu Gro�buchstaben
*o  Ersetzen ĮAE, ֮OE, ܮUE, ߮SS 
*o  K�rzen der Strings auf maximal 8 Zeichen
*�  Im Ergebnis sollen die Strings in einer List<T> vorliegen.
*�  Beispiel:
*{"Eingabe ", "�u�eres ", null, "Strassen-Feger", " ein Haus" } � [EINGABE, AEUSSERE, STRASSEN, EIN HAUS]
*/
package Aufgabe2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * @author Manuel Scholz
 *
 */
public class Streams {

  /**
   * 
   */
  public Streams() {
  }

  /**
   * @param args
   */
  public static void main(String[] args) {
    List<String> st = new ArrayList<String>();
    st.add("Eingabe ");
    st.add("�u�eres ");
    st.add(null);
    st.add("Strassen-Feger");
    st.add(" ein Haus");
  //  Pattern leerzeichen = Pattern.compile("[*/s/w][/w*/s");
    Predicate<String> leerzeichen = wort -> wort.contains("S") ;
    st.stream().anyMatch(leerzeichen);
    //st.stream().anyMatch(Pattern.compile("[/s]"))

//    Entfernen von null-Eingaben
//    o  Abschneiden der Leerzeichen am Anfang und Ende
//    o  Konvertierung von Klein- zu Gro�buchstaben
//    o  Ersetzen �->AE, �->OE, �->UE, �->SS
//    o  K�rzen der Strings auf maximal 8 Zeichen
  }

}
