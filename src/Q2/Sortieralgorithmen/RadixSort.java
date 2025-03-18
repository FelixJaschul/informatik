package src.Q2.Sortieralgorithmen;

// RadixSort Implementation
class RadixSort implements Sort {
    // Sortiert schlussendlich das Array
    public int[] sort(int[] arr) {
        int max = SortierUtils.getMaximunDesArrays(arr);
        // Wende Counting Sort auf jede Stelle an (1er, 10er, 100er, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            SortierUtils.incComparisonCount();
            CountingSort.sort(arr, exp);
        }
        return arr;
    }
}