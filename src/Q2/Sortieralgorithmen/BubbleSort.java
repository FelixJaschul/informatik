package src.Q2.Sortieralgorithmen;

/*
 * Implementierung des Bubble-Sort-Algorithmus in Java.
 * Nutzt die Hilfsklasse SortierHilfe zum Zählen der Operationen und zur Zeitmessung.
 */
class BubbleSort implements Sort {

    /*
     * Sortiert ein Array aufsteigend mit dem Bubble-Sort-Algorithmus.
     * Nutzt die SortierHilfe-Klasse zum Zählen von Vergleichen und Tauschoperationen.
     */
    public int[] sort(int[] array) {
        // Bubble-Sort Implementierung
        for (int i = 0; i < array.length; i++) {
            boolean swapped = false;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (SortierUtils.compare(array[j], array[j + 1])) {
                    SortierUtils.swap(array, j, j + 1);
                    swapped = true;
                }
            }
            // Wenn keine Tauschoperationen vorgenommen wurden, ist das Array bereits sortiert
            if (!swapped) break;
        }
        return array;
    }
}