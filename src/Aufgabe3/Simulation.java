/**
 * PTP2 Praktikum
 * Aufgabe 3
 * 01.12.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe3;

import Aufgabe3.Rangierbahnhof;
import Aufgabe3.Lokfuehrer.Arbeit;

public class Simulation extends Thread {
  private Rangierbahnhof bahnhof;
  private Lokfuehrer lokfuehrer;

  public Simulation(Rangierbahnhof bahnhof) {
    this.bahnhof = bahnhof;
  }


  @Override
  public void run() {

    while (!Thread.interrupted()) {
      int aufgabe = (int) (Math.random() * 2);
      int gleis = (int) (Math.random() * bahnhof.getAnzahlGleise());
      if (aufgabe == 1) {
        lokfuehrer = new Lokfuehrer(bahnhof, Arbeit.ZUGAUSFAHREN, gleis);
      } else if (aufgabe == 0) {
        lokfuehrer = new Lokfuehrer(bahnhof, Arbeit.ZUGEINFAHREN, gleis);
      }
      lokfuehrer.start();

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }

      Visualisierung.update();
    }
  }
}
