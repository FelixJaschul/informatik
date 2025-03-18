package src.Q2.Sortieralgorithmen;

class CountingSort implements Sort {
    // Standalone counting sort implementation
    public int[] sort(int[] arr) {
        if (arr.length == 0) return arr;
        // Find the maximum value to determine the count array size
        int max = SortierUtils.getMaximunDesArrays(arr);
        return countingSort(arr, max + 1);
    }
    // Helper method that can be used by RadixSort
    public static int[] countingSort(int[] arr, int range) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[range];
        // Count occurrences
        for (int i = 0; i < n; i++) count[arr[i]]++;

        // Calculate cumulative count
        for (int i = 1; i < range; i++) count[i] += count[i - 1];
        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
            SortierUtils.incSwapCount();
        }
        // Copy back to original array
        for (int i = 0; i < n; i++) {
            if (arr[i] != output[i]) {
                arr[i] = output[i];
                SortierUtils.incSwapCount();
            }
        }
        return arr;
    }

    // Method specifically for RadixSort (digit-based counting sort)
    public static int[] sortByDigit(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10]; // 0-9 digits
        // Count occurrences of the current digit
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        // Calculate cumulative count
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        // Build the output array (stable sort)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
            SortierUtils.incSwapCount();
        }
        // Copy back to original array
        for (int i = 0; i < n; i++) {
            if (arr[i] != output[i]) {
                arr[i] = output[i];
                SortierUtils.incSwapCount();
            }
        }
        return arr;
    }
}

