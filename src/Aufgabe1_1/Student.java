package Aufgabe1_1;

import java.util.List;

/**
 * @author Manuel Scholz, Leo Peters
 *
 */
public class Student implements Comparable<Student> {
  private String vorname;
  private String nachname;
  private int matrikelnummer;
  private Pruefungsleistung[] pruefungsleistungen;

  /**
   * 
   */
  public Student(String vorname, String nachname, int Matrikelnummer) {
    this.vorname = vorname;
    this.nachname = nachname;
    this.matrikelnummer = matrikelnummer;
    pruefungsleistungen = null;
    // TODO Auto-generated constructor stub

  }

  /**
   * @return the vorname
   */
  public String getVorname() {
    return vorname;
  }

  /**
   * @return the nachname
   */
  public String getNachname() {
    return nachname;
  }

  /**
   * @return the matrikelnummer
   */
  public int getMatrikelnummer() {
    return matrikelnummer;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#equals()
   */
  @Override
  public boolean equals(Object obj) {
    return false;

  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + matrikelnummer;
    result = prime * result + ((nachname == null) ? 0 : nachname.hashCode());
    result = prime * result + ((pruefungsleistungen == null) ? 0 : pruefungsleistungen.hashCode());
    result = prime * result + ((vorname == null) ? 0 : vorname.hashCode());
    return result;
  }

  /*
   * (non-Javadoc)
   * 
   * @see java.lang.Comparable#compareTo(java.lang.Object)
   */
  @Override
  public int compareTo(Student o) {
    
    //Wirf nullpointer wenn anderes Object null, 
    //http://openbook.rheinwerk-verlag.de/javainsel/javainsel_08_001.html
    if(o == null)
    {
      throw new NullPointerException();
    }
    
    return 0;
  }
}
