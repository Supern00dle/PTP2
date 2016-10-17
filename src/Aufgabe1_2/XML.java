
package Aufgabe1_2;

import java.io.File;
import java.util.ArrayList;

import javax.lang.model.util.Elements;
import javax.xml.parsers.*;

import org.w3c.dom.*;

/**
 * @author Manuel Scholz, Leo Peters
 * 
 */
public class XML {
  ArrayList<Sensor> sensoren;

  public static void main(String[] args) {
    File xmlFilePath = new File("src/Aufgabe1_2/sensor.xml");

    XML xml = new XML();
    xml.init();
    try {
      xml.importSensoren(xmlFilePath);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public void init() {
    sensoren = new ArrayList<Sensor>();
  }

  public Sensor importSensoren(File XMLtoImport) throws Exception {
    Sensor neuerSensor;
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(XMLtoImport);

    Node sensorNode = document.getDocumentElement();
    neuerSensor = new Sensor(((Element) sensorNode).getTagName());

    for (int i = 0; i < sensorNode.getChildNodes().getLength(); i++) {
      Node kindKnoten = sensorNode.getChildNodes().item(i);
      if (kindKnoten instanceof Element) {
        Element kindElement = (Element) kindKnoten;

        neuerSensor.addMessung(new Messung(kindElement.getAttribute("wert"), kindElement.getAttribute("zeitstempel")));
      }
    }

    return null;

  }
}
