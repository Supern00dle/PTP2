
package Aufgabe1_2;

import java.io.File;
import java.util.ArrayList;

import javax.swing.text.DocumentFilter;
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

  /**
   * Konstruktor der Klasse XML
   */
  public XML() {
    sensoren = new ArrayList<Sensor>();
  }

  /**
   * Importiert eine XML Datei voll Sensoren
   * 
   * @param XMLtoImport
   *          die XML Datei zum importieren
   * @throws Exception
   */
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

  /**
   * Exportiert das Objekt Sensor mit allen seinen Messwerten.
   * 
   * @param sensor
   *          Der zu exportierende Sensor
   * @param datei
   *          Die Zieldatei
   * @throws Exception
   */
  public void exportSensor(Sensor sensor, File datei) throws Exception {
    //Erstelle eine DocumentBuilderFactory
    DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
    Document doc = docBuilder.newDocument();
    
    //Erstelle den Doctype
    DOMImplementation domImpl = doc.getImplementation();
    DocumentType doctype = domImpl.createDocumentType("Sensor",
        "SYSTEM",
        "sensor.dtd");
    System.out.println(doctype.toString());
    doc.appendChild(doctype);
 
    //Erstelle den Sensor
    Element rootElement = doc.createElement("Sensor");
    rootElement.setAttribute("id", "Export");
    
    //fuege die Messungen hinzu
    for (int i = 0; i < this.sensoren.get(0).getAnzahlMessungen(); i++) {
      Messung m = this.sensoren.get(0).getMessung(i);
      Element messung = doc.createElement("Messung");
      messung.setAttribute("wert", m.getWert() + "");
      messung.setAttribute("zeitstempel", m.getZeitstempel());
      rootElement.appendChild(messung);
    }
    
    //Fuege Sensor zum Dokument hinzu
    doc.appendChild(rootElement);

    //Schreibe das Dokument in eine Datei
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, "sensor.dtd");
    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(datei);
    transformer.transform(source, result);

  }
}
