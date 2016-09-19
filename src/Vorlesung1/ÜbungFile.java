/**
 * 
 */
package Vorlesung1;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ÜbungFile {
  BufferedReader reader;
  File filename;
  List<String> liste;
  
  public ÜbungFile() {
    reader = null;
    filename = new File("Dateipfad");
    liste = new ArrayList<String>();
    try {
    reader = new BufferedReader(new FileReader(filename));
    } catch (FileNotFoundException e) {
    schliessen(reader);
    e.printStackTrace();
    }
    
    //lese alle Zeilen aus
    //gehe in die letzte zeile
    //String zu Zahl
    //+1
    //Zahl zu String
    //schreiben
    
    schliessen(reader);
    
  }
  
  
  private void schliessen(BufferedReader reader)
  {
    try {
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
