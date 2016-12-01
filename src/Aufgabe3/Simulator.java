/**
 * PTP2 Praktikum
 * Aufgabe 3
 * 01.12.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe3;

import java.util.ArrayList;
import java.util.List;

public class Simulator {
  
  private static int anzahlLockfuehrer = 5;
  private static int anzahlZuege = 20;
  
  Rangierbahnhof bahnhof;
  List<Lokfuehrer> fuehrer;
  List<Zug> zuege;
  
  public Simulator()
  {
    zuege = new ArrayList<Zug>();
    fuehrer = new ArrayList<Lokfuehrer>();
  }
  


  public void starteSimulation() {
    // Endlos Simulationsschleife
    bahnhof = new Rangierbahnhof(10);
    fuehrer = new ArrayList<Lokfuehrer>();
    while (true) {
      //halte die anzahl der Lockfuehrer und Zuege Konstant
      if(fuehrer.size() < anzahlLockfuehrer)
      {
        while( fuehrer.size() <= anzahlLockfuehrer)
        {
          fuehrer.add(new Lokfuehrer(bahnhof));
          System.out.println("erstelle Lockfuehrer");
        }
        while( zuege.size() <= anzahlZuege)
        {
          zuege.add(new Zug());
          System.out.println("Erstelle Zug");
        }
      }
      
      
    }
  }
  
  public static void main(String[] args)
  {
    Simulator sim = new Simulator();
    sim.starteSimulation();
  }
  
}
