/**
 * 
 */
package Aufgabe1_3;

/**
 * @author Manuel Scholz
 *
 */
public class ArrayListe<T> {

  private int anzahlElemente;
  private Object[] elemente;

  /**
   * 
   */
  public ArrayListe() {
    elemente = new Object[10];
  }

  /**
   * Fuegt das gegebene Objekt der ArrayListe hinzu.
   * 
   * @param object
   *          Das zu speichernde Objekt. Falls das Objekt nicht dem gleichen Typ
   *          T entspricht, wird eine exception geworfen.
   */
  public void hinzufuegen(T object) {
    elemente[getFreierPlatz()] = object;
    anzahlElemente++;
  }

  /**
   * Bei Aufruf wird die Arraygroesse von elemente um 10 erhoeht.
   */
  private void erhoeheArrayGroesse() {
    Object[] tempElemente = elemente;
    elemente = new Object[tempElemente.length + 10];
    for (int i = 0; i < tempElemente.length; i++) {
      elemente[i] = tempElemente[i];
    }
    tempElemente = null; // loesche das temporaere array (needed?)
  }

  /**
   * Gibt das Objekt an Position i zurueck.
   * 
   * @param i
   *          Die angefragte Position
   * @return Das Objekt an Position i. Wenn kein Objekt an der Stelle ist, oder
   *         i nichtmehr im Array ist, ist die rückgabe null!
   */
  public T get(int i) {
    if (i > elemente.length) {
      return null;
    }
    return (T) elemente[i];
  }

  /**
   * Entfernt alle Objekte aus dem Array, die gleich dem gegebenem Objekt sind.
   * Wenn das gegebene Objekt null ist, oder nicht vorhanden ist, passiert
   * nichts.
   * 
   * @param Object
   */
  public void entfernen(T object) {
    if (object == null) {
      return;
    }

    for (int i = 0; i < elemente.length; i++) {
      if (elemente[i].equals(object)) {
        // Element rausloeschen
        elemente[i] = null;
        anzahlElemente--;
      }
    }
    //raeume das Array zum schluss auf
    schiebeArrayAuf();

  }

  /**
   * Gibt die Position des letzten Elements im Array zurueck.
   * 
   * @return Die Position des letzten Elements
   */
  private int getLetztesObjekt() {
    int posLetztesElement = -1;
    for (int i = 0; i < elemente.length; i++) {
      if (elemente[i] != null) {
        posLetztesElement = i;
      }
    }
    return posLetztesElement;
  }

  /**
   * Entfernt das Element an der gegebenen Position. Wenn die Position im Array
   * nicht vorhanden ist, passiert nichts.
   * 
   * @param i
   */
  public void entferneElementAnIndex(int i) {
    if (i >= 0 && i < elemente.length) {
      elemente[i] = null;
    }
    
    //raeume das Array zum schluss auf
    schiebeArrayAuf();

  }

  /**
   * Diese Funktion schiebt alle Objekte im Array nach vorne
   */
  private void schiebeArrayAuf() {
    // check ob Array geordnet ist
    int objektCounter = 0;
    boolean geordnet = true;

    for (int i = 0; i < elemente.length; i++) {
      if (elemente[i] != null) {
        objektCounter++;
      } else if (objektCounter < anzahlElemente) {
        geordnet = false;
      }
    }

    if (!geordnet) {
      while (getLetztesObjekt() != getFreierPlatz()) {
        int letztesObjekt = getLetztesObjekt();
        elemente[getFreierPlatz()] = elemente[letztesObjekt];
        elemente[letztesObjekt] = null;
      }
    }

  }

  /**
   * Gibt einen freien Platz im Array zurueck. Falls das Array voll ist, wird
   * automatisch die Funktion erhoeheArrayGroesse() aufgerufen.
   * 
   * @return ein freier Platz im Array.
   */
  private int getFreierPlatz() {
    int freierPlatz = -1;
    for (int i = 0; i < elemente.length; i++) {
      if (elemente[i] == null) {
        freierPlatz = i;
        break;
      }
    }
    if (freierPlatz == -1) {
      erhoeheArrayGroesse();
      freierPlatz = getFreierPlatz();
    }

    return freierPlatz;
  }

  /**
   * Gibt die Anzahl der Elemente zurueck.
   * 
   * @return
   */
  public int getAnzahlElemente() {
    return anzahlElemente;

  }

  /**
   * 
   * @return
   */
  @Override
  public String toString() {
    String ausgabeString = "";
    for (int i = 0; i < elemente.length; i++) {
      if (elemente[i] != null) {
        ausgabeString += " " + elemente[i].toString();
      }
    }
    return ausgabeString;
  }

  // /**
  // * Wenn die Klasse T comparable ist, wird das kleine Objekt ausgegeben. Wenn
  // * kein Objekt im Array vorhanden ist oder die Klasse nicht comparable ist,
  // * wird null zurueck gegeben. Wenn mehrere Objekte gleich klein sind, wird
  // ein
  // * zufaelliges kleinstes Objekt zurueck gegeben.
  // *
  // * @return Das kleinste Objekt im Array
  // */
  // public T getKleinstesElement() {
  // T kleinstes = null;
  // for (int i = 0; i < elemente.length; i++)
  // {
  // for (int j = 0; j < elemente.length; j++)
  // {
  // if(elemente[i] instanceof Comparable<?> && elemente[j] instanceof
  // Comparable<?>)
  // {
  // if(elemente[i] != null)
  // {
  // elemente[i].compare(elemente[j]);
  // }
  // }
  // }
  // }
}
