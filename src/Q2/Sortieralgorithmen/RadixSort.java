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

/*
 * RedixSort Implementation
 */
class RadixSort implements Sort {

    /*
     * Returns the value of the bit at index 'bit' in 'number'
     */
    private static int bitValue(int number, int bit) {
        int mask = 1 << bit;
        if ((number & mask) != 0) {
            return 1;
        }
        return 0;
    }

    /*
     * Arrange the items in array based on the value of
     * a specific bit. This doesn't fully sort the array (it
     * just sorts by a specific bit), but we'll use it for radix
     * sort.
     *
     * counts[0] stores the number of items with a 0 in this bit
     * counts[1] stores the number of items with a 1 in this bit
     *
     * indices[0] stores the index where we should put the next item with a 0 in this bit.
     * indices[1] stores the index where we should put the next item with a 1 in this bit.
     *
     * the items with a 0 in this bit come at the beginning (index 0).
     * the items with a 1 in this bit come after all the items with a 0.
     */
    private static int[] countingSort(int[] array, int bit) {
        int[] counts = new int[]{0, 0};
        for (int item : array) counts[bitValue(item, bit)] += 1;
        int[] indices = new int[]{0, counts[0]};
        // output array to be filled in
        int[] sortedArray = new int[array.length];
        for (int item : array) {
            int itemBitValue = bitValue(item, bit);
            // place the item at the next open index for its bit value
            sortedArray[indices[itemBitValue]] = item;
            // the next item with the same bit value goes after this item
            indices[itemBitValue] += 1;
        }
        return sortedArray;
    }

    /*
     * Use counting sort to arrange the numbers, from least significant
     * bit to most significant bit.
     */
    public int[] sort(int[] array) {
        for (int bitIndex = 0; bitIndex < 64; bitIndex++) {
            array = countingSort(array, bitIndex);
        }
        return array;
    }
}