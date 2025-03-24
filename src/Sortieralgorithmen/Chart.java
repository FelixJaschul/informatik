package Sortieralgorithmen;

import Sortieralgorithmen.MyProject.SortierHilfe;

// Chart visualization for sorted arrays
class Chart {

    // Func to call outside of Chart
    public static int[] getPercentages(int[] inputArr) {
        return calculatePercentages(inputArr);
    }
    public static int[] getSums(int[] inputArr) {
        // Determine number of sections
        int sections = adjustSections(inputArr);
        return sumSections(inputArr, sections);
    }

    // Helper method to adjust number of sections based on array length
    private static int adjustSections(int[] arr) {
        int maxLen = 17;
        int len = arr.length;
        if (len < maxLen) return (len % 2 == 0) ? len : len - 1;
        return maxLen;
    }

    // Helper method to calculate sum for each section
    private static int[] sumSections(int[] arr, int sections) {
        int[] sectionSums = new int[sections];
        // Calculate elements per section
        int elementsPerSection = (int) Math.ceil((double) arr.length / sections);

        // Sum elements in each section
        for (int i = 0; i < arr.length; i++) {
            sectionSums[Math.min(i / elementsPerSection, sections - 1)] += arr[i];
        }
        return sectionSums;
    }

    // Calculate percentage values for display
    private static int[] calculatePercentages(int[] sumsArr) {
        // Find min and max values
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : sumsArr) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        // Convert to percentage scale (10-100)
        int[] percentages = new int[sumsArr.length];
        for (int i = 0; i < sumsArr.length; i++) {
            if (max == min) percentages[i] = 100;
            else percentages[i] = 10 + (sumsArr[i] - min) * 90 / (max - min);
        }
        return percentages;
    }
}

// Main-Klasse
class Main {

    // Main-Methode
    public static void main(String[] args) {
        int[] arr = SortierHilfe.generateRandomArray(1000);
        int[] sums = Chart.getSums(arr);
        int[] percentages = Chart.getPercentages(sums); // oder 'arr' für die percentages des normalen Arrays

        for (int i : sums) System.out.print(i + " ");
        System.out.println();
        for (int j : percentages) System.out.print(j + " ");
    }
}
