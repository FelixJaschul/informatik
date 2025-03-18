package src.Q2.Sortieralgorithmen;

// RadixSort Implementation
class RadixSort implements Sort {
    @Override
    public int[] sort(int[] arr) {
        int max = SortierUtils.getMaximunDesArrays(arr);
        // Apply counting sort to each digit position
        for (int exp = 1; max / exp > 0; exp *= 10) {
            SortierUtils.incComparisonCount();
            CountingSort.sortByDigit(arr, exp);
        }
        return arr;
    }
}
