package Q2.Sortieralgorithmen;

// CountingSort Implementation
class CountingSort implements Sort {

    // Helper method that can be used by RadixSort
    public static int[] countingSort(int[] arrayToBeSorted, int range) {
        int lengthOfArrayToBeSorted = arrayToBeSorted.length;
        int[] outputArray = new int[lengthOfArrayToBeSorted];
        int[] countingArray = new int[range];
        // Count occurrences
        for (int i = 0; i < lengthOfArrayToBeSorted; i++) countingArray[arrayToBeSorted[i]]++;

        // Calculate cumulative count
        for (int i = 1; i < range; i++) countingArray[i] += countingArray[i - 1];
        // Build the outputArray
        for (int i = lengthOfArrayToBeSorted - 1; i >= 0; i--) {
            outputArray[countingArray[arrayToBeSorted[i]] - 1] = arrayToBeSorted[i];
            countingArray[arrayToBeSorted[i]]--;
            SortierUtils.incSwapCount();
        }
        // Copy back to original array
        for (int i = 0; i < lengthOfArrayToBeSorted; i++) {
            if (arrayToBeSorted[i] != outputArray[i]) {
                arrayToBeSorted[i] = outputArray[i];
                SortierUtils.incSwapCount();
            }
        }
        return arrayToBeSorted;
    }

    // Method specifically for RadixSort (digit-based counting sort)
    public static int[] sortByDigit(int[] arrayToBeSorted, int exp) {
        int lengthOfArrayToBeSorted = arrayToBeSorted.length;
        int[] outputArray = new int[lengthOfArrayToBeSorted];
        int[] countingArray = new int[10]; // 0-9 digits
        // Count occurrences of the current digit
        for (int i = 0; i < lengthOfArrayToBeSorted; i++) {
            int digit = (arrayToBeSorted[i] / exp) % 10;
            countingArray[digit]++;
        }
        // Calculate cumulative count
        for (int i = 1; i < 10; i++) countingArray[i] += countingArray[i - 1];
        // Build the output array (stable sort)
        for (int i = lengthOfArrayToBeSorted - 1; i >= 0; i--) {
            int resultForOutputArray = (arrayToBeSorted[i] / exp) % 10;
            outputArray[countingArray[resultForOutputArray] - 1] = arrayToBeSorted[i];
            countingArray[resultForOutputArray]--;
            SortierUtils.incSwapCount();
        }
        // Copy back to original array
        for (int i = 0; i < lengthOfArrayToBeSorted; i++) {
            if (arrayToBeSorted[i] != outputArray[i]) {
                arrayToBeSorted[i] = outputArray[i];
                SortierUtils.incSwapCount();
            }
        }
        return arrayToBeSorted;
    }

    // Standalone counting sort implementation
    public int[] sort(int[] arrayToBeSorted) {
        if (arrayToBeSorted.length == 0) return arrayToBeSorted;
        // Find the maximum value to determine the count array size
        int groessterWertDesZuSortierendenArrays = SortierUtils.getMaximunDesArrays(arrayToBeSorted);
        return countingSort(arrayToBeSorted, groessterWertDesZuSortierendenArrays + 1);
    }
}

