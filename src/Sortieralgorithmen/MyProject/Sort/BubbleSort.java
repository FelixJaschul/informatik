package Sortieralgorithmen.MyProject.Sort;

import Sortieralgorithmen.MyProject.SortierHilfe;

/**
 * Implementierung des Bubble-Sort-Algorithmus in Java.
 */
public class BubbleSort implements Sort {

    /**
     * Sortiert ein Array aufsteigend mit dem Bubble-Sort-Algorithmus.
     *
     * @param array Das zu sortierende Array
     * @return Das sortierte Array
     */
    public int[] sort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (SortierHilfe.compare(array[j], array[j + 1])) {
                    // Swap elements
                    SortierHilfe.swap(array, j, j + 1);
                    swapped = true;
                }
            }
            // If no swapping occurred in this pass, array is sorted
            if (!swapped) break;
        }
        return array;
    }
}