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
  public static final int ERFOLG = 0;
  public static final int FEHLER = -1;
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
      if (kannAuftragAusfuehren(lokfuehrer.getArbeit(), gleis)) {
      lokfuehrer.start();
      } else {
        warteSchlange.add(lokfuehrer);
        pruefeWarteschlange();
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
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
  private boolean kannAuftragAusfuehren(Arbeit arbeit, int gleis) {
    if (arbeit == Arbeit.ZUGEINFAHREN && bahnhof.gleisIstFrei(gleis) == ERFOLG) {
      return true;
    } else if (arbeit == Arbeit.ZUGEINFAHREN && bahnhof.gleisIstFrei(gleis) == FEHLER) {
        return false;
      } else if (arbeit == Arbeit.ZUGAUSFAHREN && bahnhof.getZug(gleis) != null) {
        return true;
      } else {
        return false;
      }
    }
}
