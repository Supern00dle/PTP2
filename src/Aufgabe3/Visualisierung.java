/**
 * PTP2 Praktikum
 * Aufgabe 3
 * 01.12.2016
 * Manuel Scholz & Leo Peters
 */
package Aufgabe3;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Visualisierung extends Application {
  
  private final static int anzahlGleise = 10;
  private static Rectangle gleise[];
  
  private static Rangierbahnhof bahnhof = null;
  @Override
  public void start(Stage primaryStage) {
    primaryStage.setTitle("Rangierbahnhof");
    StackPane wurzel = new StackPane();
    
    
    gleise = new Rectangle[anzahlGleise];
    for(int i = 0; i < anzahlGleise; i++)
    {
      gleise[i] = new Rectangle(50+20*i, 10, 8, 100);
      gleise[i].setFill(Color.GRAY);
    }
    
    Group root =  new Group();
    root.getChildren().addAll(gleise);
    
    Scene scene = new Scene(root, 300, 250);
    primaryStage.setScene(scene);
    primaryStage.show();
    
  }
  
  
  public static void update()
  {
      for(int i = 0; i < anzahlGleise; i++)
      {
        if(!bahnhof.gleisIstFrei(i))
        {
          gleise[i].setFill(Color.RED);
        }
        else
        {
          gleise[i].setFill(Color.GRAY);
        }
      }
  }

  public static void main(String[] args) {
    
    Rangierbahnhof bahnhof0 = new Rangierbahnhof(anzahlGleise);
    bahnhof = bahnhof0;
    
    Simulation sim = new Simulation(bahnhof);
    sim.start();
    
    launch(args);
    
  }
}