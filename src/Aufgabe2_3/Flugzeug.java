/**
 * Programmiertechnik 2 Aufgabenblatt 2
 * 10.11.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe2_3;

import Aufgabe2_3.Flughafen;
import Aufgabe2_3.Status;

public class Flugzeug extends Thread {
  private Flughafen flughafen;
  private String id;
  private int flugdauer;
  private int startzeit;
  private int zeit;
  private Status status;

  /**
   * Konstruktor eines neuen Flugzeugs.
   * 
   * @param id
   *          Die Flugnummer des Flugzeugs.
   * @param flugdauer
   *          Die Flugdauer des Flugzeugs.
   * @param flughafen
   *          Der Zielflughafen des Flughafen des Flugzeugs.
   * @param startzeit
   *          Die Startzeit (in Millisekunden seit Programmstart) des Flugzeugs.
   */
  public Flugzeug(String id, int flugdauer, Flughafen flughafen, int startzeit) {
    this.id = id;
    this.flugdauer = flugdauer;
    this.flughafen = flughafen;
    this.startzeit = startzeit;
    status = Status.FLUG;
    zeit = startzeit;
  }

  /**
   * setzt die Zeit für das flugzeug nötig um aktuelle zeit gemeldet zu bekommen
   * 
   * @param zeit
   */
  public void setZeit(int zeit) {
    this.zeit = zeit;
  }

  @Override
  /**
   * Die run() Funktion des Threads. Zum neuen Thread starten NICHT diese
   * Funktion aufrufen! Rufe stattdessen start() auf.
   * 
   * Wenn der Thread interrupted wird, endet er.
   */
  public void run() {
    while (!isInterrupted()) {
      if (zeit - startzeit >= flugdauer && status != Status.GELANDET) {
        status = Status.LANDE;
        flughafen.landen(this);
      }
    }
  }

  /**
   * Setzt den Status des Flugzeugs auf gelandet.
   */
  public void gelandet() {
    status = Status.GELANDET;
  }

  /**
   * Gibt true wenn das Flugzeug gelandet.
   * 
   * @return
   */
  public boolean istGelandet() {

    return status == Status.GELANDET;
  }

  /**
   * Macht to String und so
   */
  @Override
  public String toString() {
    return id + "\nStart: " + startzeit + "\nDauer: " + flugdauer + "\nStatus: " + status;
  }
}
