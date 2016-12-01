/**
 * PTP2 Praktikum
 * Aufgabe 3
 * 01.12.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import Aufgabe3.Rangierbahnhof;
import Aufgabe3.Lokfuehrer.Arbeit;

public class Simulation extends Thread {
  private Rangierbahnhof bahnhof;
  private Lokfuehrer lokfuehrer;
  private List<Lokfuehrer> warteSchlange;
  public List<Zug> zugliste;
  
  public Simulation(Rangierbahnhof bahnhof) {
    this.bahnhof = bahnhof;
    warteSchlange = new ArrayList<Lokfuehrer>();
    zugliste = new ArrayList<Zug>();
    for (int i = 0; i < bahnhof.getAnzahlGleise(); i++) {
      zugliste.add(bahnhof.getZug(i));
    }
  }

  @Override
  public void run() {
  
   while(!Thread.interrupted()) {
      int aufgabe = (int) (Math.random()*2);
      int gleis = (int) (Math.random()*bahnhof.getAnzahlGleise());
      if (aufgabe == 1) {
        lokfuehrer = new Lokfuehrer(bahnhof, Arbeit.ZUGAUSFAHREN, gleis);
      } else if (aufgabe == 0) {
        lokfuehrer = new Lokfuehrer(bahnhof, Arbeit.ZUGEINFAHREN, gleis);
      } 
      lokfuehrer.start();
      if (kannAuftragAusfuehren(lokfuehrer.getArbeit(), gleis)) {
      
      }
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
      Visualisierung.update();
    }
  }
  private void pruefeWarteschlange() {
    for (Iterator<Lokfuehrer> iterator = warteSchlange.iterator(); iterator.hasNext();) {
      Lokfuehrer lokfuehrer = iterator.next();
      if (kannAuftragAusfuehren(lokfuehrer.getArbeit(), lokfuehrer.getGleis())) {
        warteSchlange.remove(lokfuehrer);
        lokfuehrer.start();
        break;
      }
    }
  }
}
