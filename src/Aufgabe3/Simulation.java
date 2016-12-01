/**
 * PTP2 Praktikum
 * Aufgabe 3
 * 01.12.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe3;

import java.util.ArrayList;
import java.util.List;

import Aufgabe3.Lokfuehrer.Arbeit;

public class Simulation extends Thread{

  Rangierbahnhof bahnhof;
  Lokfuehrer lokfuehrer;
  
  public void run() {
    bahnhof = new Rangierbahnhof(10);
  
   while(true) {
      int zufall = (int) (Math.random()*2);
      if (zufall == 1) {
        lokfuehrer = new Lokfuehrer(bahnhof, Arbeit.ZUGAUSFAHREN);
      } else if (zufall == 0) {
        lokfuehrer = new Lokfuehrer(bahnhof, Arbeit.ZUGEINFAHREN);
      }
      lokfuehrer.start();
      try {
        sleep(500);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
  public static void main(String[] args) {
    Simulation sim = new Simulation();
    sim.start();
  }
}
