package Q2.Sortieralgorithmen;

// Implementierung des Instertion-Sort-Algorithmus in Java.
class InsertionSort implements Sort {

    // Sortiert ein Array aufsteigend mit dem Insertion-Sort-Algorithmus.
    public int[] sort(int[] array) {
        // Insertion-Sort Implementierung
        for (int i = 0; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && SortierUtils.compare(array[j], key)) {
                SortierUtils.incSwapCount();
                array[j + 1] = array[j];
                j -= 1;
            }
            array[j + 1] = key;
        }
        return array;
    }
}
