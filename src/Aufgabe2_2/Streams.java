/**
 * Programmiertechnik 2 Aufgabenblatt 2
 * 10.11.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
  private String[] stringEingabe;

  /**
   * Konstruktor der Klasse Streams
   * 
   * @param stringEingabe
   *          Alle einzugebenden Strings
   */
  public Streams(String... stringEingabe) {

    this.stringEingabe = stringEingabe;

  }

  /**
   * Diese Methode bearbeitet die stringEingabe und gibt den bearbeiteten als
   * List aus. Funktionalit�t bietet die Funktion: - Entfernen von null-Eingaben
   * - Abschneiden der Leerzeichen am Anfang und Ende - Konvertierung von Klein-
   * zu Gro�buchstaben - Ersetzen � -> AE, � -> OE, � -> UE, � ->SS - K�rzen der
   * Strings auf maximal 8 Zeichen
   * 
   * @return
   */
  public List<String> stringEingabeBearbeiten() {

    List<String> listEingabe = new ArrayList<String>();
    for (String string : stringEingabe) {
      listEingabe.add(string);
    }

    listEingabe = listEingabe.stream()

        .filter(wort -> wort != null).map(String::toUpperCase).map(String::trim).map(wort -> wort.replace("�", "AE"))
        .map(wort -> wort.replace("�", "OE")).map(wort -> wort.replace("�", "UE")).map(wort -> {
          if (wort.length() > 7)
            return wort.substring(0, 8);
          return wort;
        }).collect(Collectors.toList());

    return listEingabe;
  }

  /**
   * Main method for Streams.
   * 
   * @param args
   */
  public static void main(String args[]) {
    Streams s = new Streams("Eingabe ", "�u�eres ", null, "Strassen-Feger", " ein Haus");
    System.out.println(s.stringEingabeBearbeiten().toString());
  }
}
