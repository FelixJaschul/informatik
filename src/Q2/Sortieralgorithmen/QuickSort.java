package src.Q2.Sortieralgorithmen;

// Implementierung des QuickSort-Algorithmus in Java.
// Nutzt die Hilfsklasse SortierHilfe zum Zählen der Operationen und zur Zeitmessung.
class QuickSort implements Sort {
    // Sortiert ein Array aufsteigend mit dem QuickSort-Algorithmus.
    //  Nutzt die SortierHilfe-Klasse zum Zählen von Vergleichen und Tauschoperationen.
    public int[] sort(int[] array) {
        // QuickSort-Aufruf
        return quickSort(array, 0, array.length - 1);
    }
    // Rekursive QuickSort-Funktion, die das Array in kleinere Teile zerlegt.
    private int[] quickSort(int[] array, int low, int high) {
        if (low < high) {
            // Partitioniere das Array und erhalte den Pivot-Index
            int pi = partition(array, low, high);
            // Rekursiver Aufruf für die linke Hälfte (kleinere Werte)
            quickSort(array, low, pi - 1);
            // Rekursiver Aufruf für die rechte Hälfte (größere Werte)
            quickSort(array, pi + 1, high);
        }
        return array;
    }
    // Partitioniert das Array anhand eines Pivot-Elements.
    // Alle kleineren Werte kommen links vom Pivot, größere Werte rechts.
    private int partition(int[] array, int low, int high) {
        // Das letzte Element als Pivot wählen
        int pivot = array[high];
        // Index für kleinere Elemente (Startwert: low - 1)
        int i = low - 1;
        // Durchlaufe das Array von 'low' bis 'high - 1'
        for (int j = low; j < high; j++) {
            // Falls das aktuelle Element kleiner oder gleich dem Pivot ist, tausche es nach links
            if (!SortierUtils.compare(array[j], pivot)) { // Vergleich: array[j] <= pivot
                i += 1;
                SortierUtils.swap(array, i, j);
            }
        }
        // Tausche das Pivot-Element an die richtige Position
        SortierUtils.swap(array, i + 1, high);
        // Gib den Index des Pivot-Elements zurück
        return i + 1;
    }
}
