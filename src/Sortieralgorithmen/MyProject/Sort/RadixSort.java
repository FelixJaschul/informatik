package Sortieralgorithmen.MyProject.Sort;

import Sortieralgorithmen.MyProject.SortierHilfe;

// RadixSort Implementation
public class RadixSort implements Sort {

    // Sortiert ein Array mit dem Radix-Algorithmus.
    public int[] sort(int[] arrayToBeSorted) {
        int groessterWertDesZuSortierendenArrays = SortierHilfe.getMaximunDesArrays(arrayToBeSorted);
        // Apply counting sort to each digit position
        for (int exp = 1; groessterWertDesZuSortierendenArrays / exp > 0; exp *= 10) {
            SortierHilfe.incComparisonCount();
            CountingSort.sortByDigit(arrayToBeSorted, exp);
        }
        return arrayToBeSorted;
    }
}
