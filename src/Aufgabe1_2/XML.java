
package Aufgabe1_2;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

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
      xml.importSensor(xmlFilePath);
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    System.out.println("");

    try {
      xml.exportSensor(xml.sensoren.get(0), new File("src/Aufgabe1_2/Export.xml"));

    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

  public void init() {
    sensoren = new ArrayList<Sensor>();
  }

  public void importSensor(File XMLtoImport) throws Exception {
    Sensor neuerSensor;
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(XMLtoImport);

    Node sensorNode = document.getDocumentElement();
    neuerSensor = new Sensor(((Element) sensorNode).getAttribute("id"));

    for (int i = 0; i < sensorNode.getChildNodes().getLength(); i++) {
      Node kindKnoten = sensorNode.getChildNodes().item(i);
      if (kindKnoten instanceof Element) {
        Element kindElement = (Element) kindKnoten;

        neuerSensor.addMessung(new Messung(kindElement.getAttribute("wert"), kindElement.getAttribute("zeitstempel")));
      }
    }
    sensoren.add(neuerSensor);

  }

  public void exportSensor(Sensor sensor, File datei) throws Exception {
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    Document doc = docBuilder.newDocument();
    Element rootElement = doc.createElement("Sensor");
    rootElement.setAttribute("id", "Export");
    for(int i = 0; i < this.sensoren.get(0).getAnzahlMessungen(); i++)
    {
      Messung m = this.sensoren.get(0).getMessung(i);
      Element messung = doc.createElement("Messung");
      messung.setAttribute("wert", m.getWert()+"");
      messung.setAttribute("zeitstempel", m.getZeitstempel());
      rootElement.appendChild(messung);
    }
    
    doc.appendChild(rootElement);

    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(datei);
    transformer.transform(source, result);

  }
}
