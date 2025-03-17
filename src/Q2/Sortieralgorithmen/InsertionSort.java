package src.Q2.Sortieralgorithmen;

/*
 * Implementierung des Instertion-Sort-Algorithmus in Java.
 * Nutzt die Hilfsklasse SortierHilfe zum Zählen der Operationen und zur Zeitmessung.
 */
public class InsertionSort implements Sort {

    /*
     * Sortiert ein Array aufsteigend mit dem Insertion-Sort-Algorithmus.
     * Nutzt die SortierHilfe-Klasse zum Zählen von Vergleichen und Tauschoperationen.
     */
    public int[] sort(int[] array) {
        // Insertion-Sort Implementierung
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && SortierHilfe.compare(array[j], key)) {
                SortierHilfe.incSwapCount();
                array[j + 1] = array[j];
                j -= 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
}
