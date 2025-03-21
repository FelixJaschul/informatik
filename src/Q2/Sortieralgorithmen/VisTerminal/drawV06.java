package Q2.Sortieralgorithmen.VisSwing;

interface Sort {
    int[] tempArray = null;
    boolean anim = false;
    // change 'return status' in Sort-Method for: return anim = status;
    default boolean setAnim(boolean status) {
        return status;
    }
    // Default implementation
    default int getFac() {
        return 2;
    }
    // Complete sorting algorithm
    default void sort(int[] sortableArr) {
        for (int step = 0; step < 4; step++) sortStep(sortableArr, step);
    }
    // Single step of radix sort (for animation) // Look at Radix class for help
    void sortStep(int[] sortableArr, int step);
    // shows if an array is sorted or not
    default boolean sorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) if (arr[i] < arr[i - 1]) return false;
        return true;
    }
}

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

class Main {

    // Main method
    public static void main(String[] args) {
        Sort sorter = new Radix();
        // Create unsorted array
        int[] array = new int[1_000];
        for (int i = 0; i < array.length; i++) array[i] = (int) ((Math.random() * 1_000) + 1); // Fill with random values

        // Sort and visualize process
        if (sorter.setAnim(true)) visualizeSort(array, sorter, 0);
    }

    // Sort recursively with chart updates
    private static void visualizeSort(int[] array, Sort sorter, int step) {
        char blockChar = '█';
        if (sorter.sorted(array)) {
            System.out.println("Sorting complete!");
            return;
        }
        // Perform one step of radix sort (8 bits)
        sorter.sortStep(array, step);
        // Update chart with current state
        int[] current = array.clone();
        int[] sums = Chart.getSums(current);
        int[] percentages = Chart.getPercentages(sums);
        System.out.println("After step " + (step + 1) + " of sorting:");
        // Draw Chart // Draw each bar horizontally
        for (int i = 0; i < percentages.length; i++) {
            for (int j = 0; j < percentages[i]; j++) System.out.print(blockChar);
            // Print the sum value under the bar
            System.out.println(" (" + sums[i] + ")");
        }
        // Pause for visualization (can be adjusted)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Recursive call for next step
        visualizeSort(array, sorter, step + 1);
    }
}

class Radix implements Sort {

    // Fields
    private static int[] tempArray;
    private static boolean anim = false;

    // Single step of radix sort (for animation)
    public void sortStep(int[] sortableArr, int step) {
        // Each step processes 8 bits
        int shift = step / getFac();
        int[] sortedArr = new int[sortableArr.length];

        // Initialize tempArray for animation
        if (tempArray == null) tempArray = sortableArr.clone();
        int[] count = new int[256]; // Count sort for current digit
        for (int num : sortableArr) count[(num >>> shift) & 0xFF]++;
        for (int i = 1; i < 256; i++) count[i] += count[i - 1]; // Calculate positions
        for (int i = sortableArr.length - 1; i >= 0; i--) sortedArr[--count[(sortableArr[i] >>> shift) & 0xFF]] = sortableArr[i]; // Place elements in sorted order
        System.arraycopy(sortedArr, 0, sortableArr, 0, sortableArr.length);
        if (anim) tempArray = sortedArr.clone();
    }

    @Override
    public boolean setAnim(boolean status) {
        return anim = status;
    }
}
