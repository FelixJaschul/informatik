package Q2.Sortieralgorithmen.GroupProject;

// RadixSort Implementation
class RadixSort implements Sort {

    // Sortiert ein Array mit dem Radix-Algorithmus.
    public int[] sort(int[] arrayToBeSorted) {
        int groessterWertDesZuSortierendenArrays = SortierUtils.getMaximunDesArrays(arrayToBeSorted);
        // Apply counting sort to each digit position
        for (int exp = 1; groessterWertDesZuSortierendenArrays / exp > 0; exp *= 10) {
            SortierUtils.incComparisonCount();
            CountingSort.sortByDigit(arrayToBeSorted, exp);
        }
        return arrayToBeSorted;
    }
}
