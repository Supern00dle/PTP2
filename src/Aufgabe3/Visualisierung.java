/**
 * PTP2 Praktikum
 * Aufgabe 3
 * 01.12.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe3;

import javax.swing.plaf.synth.SynthSplitPaneUI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Visualisierung extends Application {
  
  private final static int anzahlGleise = 10;
  
  private static Rangierbahnhof bahnhof = null;
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Rangierbahnhof");
    StackPane wurzel = new StackPane();
    Scene scene = new Scene(wurzel, 300, 250);
    
    Rectangle[] gleise = new Rectangle[anzahlGleise];
    Rectangle[] andereGleise = new Rectangle[anzahlGleise];
    for(int i = 0; i < anzahlGleise; i++)
    {
      gleise[i] = new Rectangle(10, 10, 5, 200);
     // andereGleise[i] = new Rectangle(0, 10, 5, 200);
      gleise[i].setFill(Color.GRAY);

      wurzel.getChildren().addAll(gleise[i]);  
    }
    
  
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    
    Rangierbahnhof bahnhof0 = new Rangierbahnhof(anzahlGleise);
    bahnhof = bahnhof0;
    
    Simulation sim = new Simulation(bahnhof);
    sim.start();
    
    launch(args);
  }
}