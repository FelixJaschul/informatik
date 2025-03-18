package src.Q2.Sortieralgorithmen;

/*
 * Pseudocode für RadixSort
 *
 * Funktion radixSort(arr[], n)
 *     Bestimme das maximale Element max im Array
 *
 *     Setze exp = 1
 *     Solange max / exp > 0
 *         Führe countSort(arr, n, exp) aus
 *         exp = exp * 10
 *
 * Funktion countSort(arr[], n, exp)
 *     Erstelle ein output-Array der Größe n
 *     Erstelle ein count-Array mit 10 Elementen, initialisiert auf 0
 *
 *     // Zähle die Häufigkeit der Ziffern in der exp-ten Stelle
 *     Für i von 0 bis n-1
 *         index = (arr[i] / exp) % 10
 *         count[index] erhöhen
 *
 *     // Verändere count[i], damit es die Position des Elements im Output-Array enthält
 *     Für i von 1 bis 9
 *         count[i] = count[i] + count[i-1]
 *
 *     // Fülle das output-Array
 *     Für i von n-1 bis 0 (rückwärts)
 *         index = (arr[i] / exp) % 10
 *         output[count[index] - 1] = arr[i]
 *         count[index] verringern
 *
 *     // Kopiere das output-Array zurück ins ursprüngliche Array
 *     Für i von 0 bis n-1
 *         arr[i] = output[i]
 */

// RadixSort Implementation
class RadixSort implements Sort {
    // Gibt den höchsten Wert des zu sortierenden Arrays zurück
    private static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) if (SortierUtils.compare(arr[i], max)) max = arr[i];
        return max;
    }
    // Der Counting-Sort ist ein wichtiger Bestandteil des RadixSort
    private static void countingSort(int[] arr, int exp) {
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
    }
    // Sortiert schlussendlich das Array
    public int[] sort(int[] arr) {
        int max = getMax(arr);
        // Wende Counting Sort auf jede Stelle an (1er, 10er, 100er, ...)
        for (int exp = 1; max / exp > 0; exp *= 10) {
            SortierUtils.incComparisonCount();
            countingSort(arr, exp);
        }
        return arr;
    }
}