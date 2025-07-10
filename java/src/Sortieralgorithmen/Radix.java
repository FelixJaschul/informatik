package Sortieralgorithmen;

import Sortieralgorithmen.MyProject.SortierHilfe;

public class Radix {

    public static int[] sort(int[] array) {
        if (array == null || array.length <= 1) return array; // Already sorted or empty
        int max = SortierHilfe.getMaximunDesArrays(array);
        for (int exp = 1; max / exp > 0; exp *= 10) countingSortByDigit(array, exp);
        return array;
    }

    private static void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }
        for (int i = 1; i < 10; i++) count[i] += count[i - 1];
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }
        System.arraycopy(output, 0, array, 0, n);
    }

}
