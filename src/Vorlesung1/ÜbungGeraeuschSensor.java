package Vorlesung1;

import java.io.IOException;

public class ÜbungGeraeuschSensor {

  GeraeuschSensor sensor;
  public ÜbungGeraeuschSensor() throws IOException, Exception {
    
    try (GeraeuschSensor sensor = new GeraeuschSensor())
    {
      
    }
  }

  public void verbindungBeenden(GeraeuschSensor sensor) throws IOException
  {
    
  }
}
