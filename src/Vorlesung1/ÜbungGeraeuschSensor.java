package Vorlesung1;

import java.io.IOException;

public class �bungGeraeuschSensor {

  GeraeuschSensor sensor;
  public �bungGeraeuschSensor() throws IOException, Exception {
    
    try (GeraeuschSensor sensor = new GeraeuschSensor())
    {
      
    }
  }

  public void verbindungBeenden(GeraeuschSensor sensor) throws IOException
  {
    
  }
}
