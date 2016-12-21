/**
 * Prof. Philipp Jenke
 * Hochschule für Angewandte Wissenschaften (HAW), Hamburg
 * Lecture demo program.
 */
package braitenberg;

import braitenberg.braitenbergvehikel.BVBewegungAbstossung;
import braitenberg.braitenbergvehikel.BVBewegungAttraktion;
import braitenberg.braitenbergvehikel.BVSimulation;
import braitenberg.braitenbergvehikel.BraitenbergVehikel;
import braitenberg.braitenbergvehikel.Vektor2;
import braitenberg.view.BVCanvas;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * JavaFX Anwendung zur Darstellung und Interaktion mit einer
 * Braitenberg-Vehikel-Simulation.
 * 
 * @author Philipp Jenke
 */
public class BVAnwendung extends Application {

  public void ComboBoxhinzufuegen(ComboBox<String> comboBox, BraitenbergVehikel vehikel) {
    comboBox.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent arg) {
        if(comboBox.getValue() == "ATTRAKTION") {
          vehikel.setBewegung(new BVBewegungAttraktion());
        } else {
          vehikel.setBewegung(new BVBewegungAbstossung());
        }
      }
    });
  }
  
  @Override
  public void start(Stage primaryStage) {
    // Simulation zusammenstellen
    BVSimulation sim = erzeugeSimulationsszene();

    // Canvas setzen
    BVCanvas canvas = new BVCanvas(600, 600, sim);
    
    canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent mouseEvent) {
        double x = mouseEvent.getX() - canvas.getWidth() / 2;
        double y = -(mouseEvent.getY() - canvas.getHeight() / 2);
        sim.setSignal(x, y);
      }
    });
    
    canvas.zeichneSimulation();

    // Szenengraph aufbauen
    primaryStage.setTitle("Braitenberg-Vehikel!");
    BorderPane wurzel = new BorderPane();
    wurzel.setCenter(canvas);

    Button button = new Button();
    button.setText("Simuliere!");
    CheckBox checkbox = new CheckBox();
    checkbox.setText("Simuliere");
    GridPane simulationsGitter = new GridPane();
    GridPane bewegungsGitter = new GridPane();
    ObservableList<String> listeBewegung = FXCollections.observableArrayList("ATTRAKTION", "ABSTOSSUNG");
    
    for(int i = 0; i < sim.getAnzahlVehikel(); i++) {
      ComboBox<String> bewegungBox = new ComboBox<String>(listeBewegung);
      Label nameVehikel = new Label(sim.getVehikel(i).getName());
      bewegungsGitter.add(nameVehikel, 0, i);
      bewegungsGitter.add(bewegungBox, 1, i);
      
      if(sim.getVehikel(i).getBewegung() instanceof BVBewegungAttraktion) {
        bewegungBox.setValue("ATTRAKTION");
      } else {
        bewegungBox.setValue("ABSTOSSUNG");
      }
      ComboBoxhinzufuegen(bewegungBox, sim.getVehikel(i));
    }
    simulationsGitter.add(button, 0, 0);
    simulationsGitter.add(checkbox, 0, 1);
    wurzel.setLeft(simulationsGitter);
    wurzel.setRight(bewegungsGitter);
    
    button.setOnAction(new EventHandler<ActionEvent>(){
      @Override
      public void handle(ActionEvent event) {
        System.out.println("Schritt");
        sim.simulationsSchritt();
      }
    });
    checkbox.setOnAction(new EventHandler<ActionEvent>() {
      @Override
      public void handle(ActionEvent event) {
        if(checkbox.isSelected()) {
          sim.starteSimThread();
        } else {
          sim.beendeSimThread();
        }
      }
    });
    
    primaryStage.setScene(new Scene(wurzel, 850, 600));
    primaryStage.show();
  }

  /**
   * Erzeugt eine Simulationsszene zum Testen.
   */
  public BVSimulation erzeugeSimulationsszene() {
    BraitenbergVehikel vehikel1 = new BraitenbergVehikel("Susi", new BVBewegungAttraktion());
    BraitenbergVehikel vehikel2 = new BraitenbergVehikel("Mike", new BVBewegungAbstossung(), new Vektor2(-100, 100),
        new Vektor2(1, 0));
    BVSimulation sim = new BVSimulation();
    sim.vehikelHinzufuegen(vehikel1);
    sim.vehikelHinzufuegen(vehikel2);
    return sim;
  }

  public static void main(String[] args) {
    launch(args);
  }
}
