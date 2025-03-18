package src.Q2.Sortieralgorithmen;

class CountingSort {
    // Der Counting-Sort ist ein wichtiger Bestandteil des RadixSort
    public static int[] sort(int[] arr, int exp) {
        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        // Baue das sortierte Array von hinten nach vorne (stabil)
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
            SortierUtils.incSwapCount();
        }
        // Kopiere das sortierte Array zurück ins Original-Array
        // Ich benutze hier nicht copyArray aus SortierUtils, da ich sonst den SwapCount nicht zählen könnte
        for (int i = 0; i < n; i++) {
            if (arr[i] != output[i]) {
                arr[i] = output[i];
                SortierUtils.incSwapCount();
            }
        }
        return output;
    }
}
