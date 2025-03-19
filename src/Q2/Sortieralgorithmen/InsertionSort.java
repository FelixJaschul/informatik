package src.Q2.Sortieralgorithmen;

// Implementierung des Instertion-Sort-Algorithmus in Java.
class InsertionSort implements Sort {
    // Sortiert ein Array aufsteigend mit dem Insertion-Sort-Algorithmus.
    public int[] sort(int[] arrayToBeSorted) {
        // Insertion-Sort Implementierung
        for (int i = 0; i < arrayToBeSorted.length; i++) {
            int aktuellesElement = arrayToBeSorted[i];
            int j = i - 1;
            while (j >= 0 && SortierUtils.compare(arrayToBeSorted[j], aktuellesElement)) {
                SortierUtils.incSwapCount();
                arrayToBeSorted[j + 1] = arrayToBeSorted[j];
                j -= 1;
            }
            arrayToBeSorted[j + 1] = aktuellesElement;
        }
        return arrayToBeSorted;
    }
}
