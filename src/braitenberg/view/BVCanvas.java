package braitenberg.view;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import javafx.application.Platform;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.scene.transform.Rotate;
import braitenberg.braitenbergvehikel.BVSimulation;
import braitenberg.braitenbergvehikel.BraitenbergVehikel;
import braitenberg.braitenbergvehikel.Vektor2;

/**
 * Zeichenfläche für eine Braitenberg-Vehikle-Simulation.
 * 
 * @author Philipp Jenke
 */
public class BVCanvas extends Canvas implements Observer {

  /**
   * Bild eines Vehikels. Achtung: Package mit dem Bild muss korrekt angegeben
   * werden.
   */
  private Image bvImage = new Image("braitenberg/assets/braitenberg_vehikel.png");

  private Image abstImage = new Image("braitenberg/assets/icon_abstossung.png");
  
  private Image attrImage = new Image("braitenberg/assets/icon_attraktion.png");
  /**
   * Referenz auf die Simulation.
   */
  private final BVSimulation sim;

  public BVCanvas(int breite, int hoehe, BVSimulation sim) {
    super(breite, hoehe);
    this.sim = sim;   
    sim.addObserver(this);
    
    for(int i = 0; i < sim.getAnzahlVehikel(); i++) {
      sim.getVehikel(i).addObserver(this);
    }
  }

  /**
   * Zeichnet die gesamte Simulation neu.
   */
  public void zeichneSimulation() {
    GraphicsContext gc = getGraphicsContext2D();
    // Alles löschen
    gc.setFill(Color.WHITE);
    gc.fillRect(0, 0, getWidth(), getHeight());
    // Vehikel zeichnen
    for (int i = 0; i < sim.getAnzahlVehikel(); i++) {
      zeichneVehikel(gc, sim.getVehikel(i));
    }
    // Signal zeichnen
    zeichneSignal(gc, sim.getSignal());
  }

  /**
   * Rechnet von Welt- und Bild-Koordinaten um.
   */
  public Point welt2BildKoordinaten(Vektor2 position) {
    return new Point((int) (position.x() + getWidth() / 2), (int) (getHeight() / 2 - position.y()));
  }
  public Vektor2 welt2BildVektor(Vektor2 position)
  {
    return new Vektor2((position.x() + getWidth() / 2),(getHeight() / 2 - position.y()));
  }

  /**
   * Rotiert den aktuellen Grafik-Kontext (zum Zeichnen eines rotierten Bildes).
   */
  private void rotieren(GraphicsContext gc, double winkel, double px, double py) {
    Rotate r = new Rotate(winkel, px, py);
    gc.setTransform(r.getMxx(), r.getMyx(), r.getMxy(), r.getMyy(), r.getTx(), r.getTy());
  }

  /**
   * Zeichnet ein Bild gedreht.
   */
  private void zeichneGedrehtesBild(GraphicsContext gc, Image image, double winkel, double x, double y) {
    // Zustand auf dem Stack sichern
    gc.save();
    rotieren(gc, winkel, x + image.getWidth() / 2, y + image.getHeight() / 2);
    gc.drawImage(image, x, y);
    // Zustand wiederherstellen
    gc.restore();
  }

  /**
   * Zeichnet ein Braitenberg-Vehikel.
   */
  protected void zeichneVehikel(GraphicsContext gc, BraitenbergVehikel bv) {
    Image verhalten;
    if(bv.getBewegung().getId().equals("ATTRAKTION")) {
      verhalten = attrImage;
    } else {
      verhalten = abstImage;
    }
       
    Point p = welt2BildKoordinaten(bv.getPosition());
    double winkelInGrad = bv.getRotationGradImUhrzeigersinn();
    int x = (int) (p.x - bv.getSeitenlaenge() / 2);
    int y = (int) (p.y - bv.getSeitenlaenge() / 2);
    
    //Zeichne BV
    zeichneGedrehtesBild(gc, bvImage, winkelInGrad, x, y);
    
    //Zeichne Namen
    gc.setTextAlign(TextAlignment.LEFT);
    gc.setTextBaseline(VPos.CENTER);
    gc.setFont(new Font("Comic Sans MS", 15));
    gc.setFill(Color.BLACK);
    gc.fillText(bv.getName(), x+bvImage.getWidth(), y+bvImage.getHeight());
    
    //Zeichne Verhalten
    zeichneGedrehtesBild(gc, verhalten,0, x+bvImage.getWidth(), y);
    
    
  }

  /**
   * Zeichnet das Signal.
   */
  private void zeichneSignal(GraphicsContext gc, Vektor2 signal) {
    int breite = 10;
    int offset = 2;
    Point p = welt2BildKoordinaten(signal);
    gc.setFill(Color.BLACK);
    gc.fillOval(p.x - breite / 2 - offset, p.y - breite / 2 - offset, breite + offset * 2, breite + offset * 2);
    gc.setFill(Color.YELLOW);
    gc.fillOval(p.x - breite / 2, p.y - breite / 2, breite, breite);
  }

  @Override
  public void update(Observable o, Object arg) {
    // Zeichenroutine wird im JavaFX-Thread aufgerufen.
    Platform.runLater(new Runnable() {
      @Override
      public void run() {
        zeichneSimulation();
      }
    });
  }
}
