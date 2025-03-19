package src.Q2.Sortieralgorithmen;

// Implementierung des QuickSort-Algorithmus in Java.
class QuickSort implements Sort {
    // Sortiert ein Array aufsteigend mit dem QuickSort-Algorithmus.
    public int[] sort(int[] arrayToBeSorted) {
        // QuickSort-Aufruf
        return quickSort(arrayToBeSorted, 0, arrayToBeSorted.length - 1);
    }
    // Rekursive QuickSort-Funktion, die das Array in kleinere Teile zerlegt.
    private int[] quickSort(int[] arrayToBeSorted, int lowestValueOfArray, int highestValueOfArray) {
        if (lowestValueOfArray < highestValueOfArray) {
            // Partitioniere das Array und erhalte den Pivot-Index
            int piviotIndexOfArray = partition(arrayToBeSorted, lowestValueOfArray, highestValueOfArray);
            // Rekursiver Aufruf für die linke Hälfte (kleinere Werte)
            quickSort(arrayToBeSorted, lowestValueOfArray, piviotIndexOfArray - 1);
            // Rekursiver Aufruf für die rechte Hälfte (größere Werte)
            quickSort(arrayToBeSorted, piviotIndexOfArray + 1, highestValueOfArray);
        }
        return arrayToBeSorted;
    }
    // Partitioniert das Array anhand eines Pivot-Elements.
    // Alle kleineren Werte kommen links vom Pivot, größere Werte rechts.
    private int partition(int[] arrayToBeSorted, int lowestValueOfArray, int highestValueOfArray) {
        // Das letzte Element als Pivot wählen
        int pivot = arrayToBeSorted[highestValueOfArray];
        // Index für kleinere Elemente (Startwert: low - 1)
        int i = lowestValueOfArray - 1;
        // Durchlaufe das Array von 'low' bis 'high - 1'
        for (int j = lowestValueOfArray; j < highestValueOfArray; j++) {
            // Falls das aktuelle Element kleiner oder gleich dem Pivot ist, tausche es nach links
            if (!SortierUtils.compare(arrayToBeSorted[j], pivot)) { // Vergleich: array[j] <= pivot
                i += 1;
                SortierUtils.swap(arrayToBeSorted, i, j);
            }
        }
        // Tausche das Pivot-Element an die richtige Position
        SortierUtils.swap(arrayToBeSorted, i + 1, highestValueOfArray);
        // Gib den Index des Pivot-Elements zurück
        return i + 1;
    }
}
