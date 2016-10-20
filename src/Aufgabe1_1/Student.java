/** PTP2 Praktikum 1
 * 20.10.2016
 * @author Manuel Scholz, Leo Peters
 */
package Aufgabe1_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
	
public class Student implements Comparable<Student>, Comparator<String> {
	private String vorname;
	private String nachname;
	private int matrikelnummer;
	private List<Pruefungsleistung> leistungen;

	/**
	 * Konstruktor der Klasse Student
	 * 
	 * @param vorname
	 * 				Vorname des Studenten
	 * @param nachname
	 * 				Nachname des Studenten
	 * @param matrikelnummer
	 * 				Die Matrikelnummer des Studenten	 * 
	 */
	public Student(String vorname, String nachname, int matrikelnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.matrikelnummer = matrikelnummer;
		leistungen = new ArrayList<>();
	}

	/**
	 * @return Der Vorname des Students
	 */
	public String getVorname() {
		return vorname;
	}

	/**
	 * @return Der Nachname des Students
	 */
	public String getNachname() {
		return nachname;
	}

	/**
	 * @return Die Matrikelnummer des Students
	 */
	public int getMatrikelnummer() {
		return matrikelnummer;
	}

	/**
	 * Vergleicht diesen Studenten mit einem anderen Objekt, vorzugsweise einem
	 * Student. Studenten sind gleich, wenn sie die gleiche Matrikelnummer
	 * haben.
	 * 
	 * @param obj
	 *            das zu vergleichende Objekt
	 * 
	 * @return true wenn gleicher Student
	 */
	@Override
	public boolean equals(Object obj) {

		if (obj.getClass().equals(this.getClass())) {
			Student andererStudent = (Student) obj;
			if (andererStudent.getMatrikelnummer() == this.getMatrikelnummer()) {
				return true;
			}
		}
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
		result = prime * result + ((leistungen == null) ? 0 : leistungen.hashCode());
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

		// Wirf nullpointer wenn anderes Object null,
		// http://openbook.rheinwerk-verlag.de/javainsel/javainsel_08_001.html
		if (o == null) {
			throw new NullPointerException();
		}
		if (o.equals(this)) {
			return 0;
		} else if (o.getMatrikelnummer() > this.getMatrikelnummer()) {
			return o.getMatrikelnummer() - this.getMatrikelnummer();
		} else {
			return this.getMatrikelnummer() - o.getMatrikelnummer();
		}

	}

	/**
	 * Fuegt der Liste von Pruefungsleistungen eine Leistung hinzu
	 * 
	 * @param pruefungsleistung
	 */
	public void addPruefungsleistung(Pruefungsleistung pruefungsleistung) {
		leistungen.add(pruefungsleistung);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(String o1, String o2) {
		// Wirft NullpointerException wenn ein Objekt null
		if(o1 == null || o2 == null) {
			throw new NullPointerException();
		}
		
		return o1.compareTo(o2);
	}
	  /**
	   * Gibt das Objekt als String zurueck.
	   */
	@Override
	public String toString() {
		String toString = "Student: " + vorname + " " + nachname + "\nMatrikelnummer: " + matrikelnummer + "\n";
		for (int i = 0; i < leistungen.size(); i++) {
			toString += leistungen.get(i).toString();
		}
		return toString;
	}
}
