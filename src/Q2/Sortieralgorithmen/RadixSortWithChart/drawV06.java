package Q2.Sortieralgorithmen.RadixSortWithChart;

interface Sort {
    static void sort(int[] sortableArr) {
        for (int step = 0; step < 4; step++) sortStep(sortableArr, step);
    } // Complete sorting algorithm
    static void sortStep(int[] sortableArr, int step) {} // Single step of radix sort (for animation)
    static boolean sorted(int[] arr) {
        for (int i = 1; i < arr.length; i++)
            if (arr[i] < arr[i - 1]) return false;
        return true;
    } // shows if an array is sorted or not
}

// Chart visualization for sorted arrays
class Chart {

    // Fields
    private int[] array;
    private final int sections;
    private final int[] sumsArray;

    // Constructor
    public Chart(int[] inputArray) {
        this.array = inputArray;
        this.sections = adjustSections();
        this.sumsArray = sumSections();
    }

    // Setter
    public void setArray(int[] newArray) {
        this.array = newArray;
        // Recalculate the sums when the array changes
        System.arraycopy(sumSections(), 0, this.sumsArray, 0, this.sections);
    }

    // Display chart - Improved horizontal display with ASCII blocks
    public void drawChart() {
        int[] percentages = calculatePercentages();
        char blockChar = '█'; // ASCII block character

        // Draw each bar horizontally
        for (int i = 0; i < percentages.length; i++) {
            for (int j = 0; j < percentages[i]; j++) {
                System.out.print(blockChar);
            }
            // Print the sum value under the bar
            System.out.println(" (" + sumsArray[i] + ")");
        }
    }

    // Calculate percentage values for display
    private int[] calculatePercentages() {
        // Find min and max values
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : sumsArray) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        // Convert to percentage scale (10-100)
        int[] percentages = new int[sumsArray.length];
        for (int i = 0; i < sumsArray.length; i++) {
            if (max == min) percentages[i] = 100;
            else percentages[i] = 10 + (sumsArray[i] - min) * 90 / (max - min);
        }
        return percentages;
    }

    // Adjust number of sections based on array length
    private int adjustSections() {
        int maxLen = 17;
        int len = array.length;
        if (len < maxLen) return (len % 2 == 0) ? len : len - 1;
        return maxLen;
    }

    // Calculate sum for each section
    private int[] sumSections() {
        int[] sectionSums = new int[sections];
        // Calculate elements per section
        int elementsPerSection = (int) Math.ceil((double) array.length / sections);

        // Sum elements in each section
        for (int i = 0; i < array.length; i++) {
            int sectionIndex = Math.min(i / elementsPerSection, sections - 1);
            sectionSums[sectionIndex] += array[i];
        }
        return sectionSums;
    }
}

class Main implements Sort {

    // How many steps are needed for sorting
    public static int getFac() {return 8;}

    // Main method
    public static void main(String[] args) {
        // Create unsorted array
        int[] array = new int[1_000];
        // Fill with random values
        for (int i = 0; i < array.length; i++) array[i] = (int) ((Math.random() * 1_000) + 1);

        // Display and measure time (no sorting)
        int[] time = new int[array.length];
        System.arraycopy(array, 0, time, 0, array.length);
        getTime(time);

        // Sort with animations // Create chart and display
        if (Radix.anim(true)) {
            sort_(array, new Chart(array), 0);
        } // Repeat if sorting animation is active
    }

    private static void sort_(int[] array, Chart chart, int step) {
        // Base case: if sorting is complete  // Radix sort with 32 bits (4 steps of 8 bits each)
        // if (step >= getFac() + getFac() + 1) { System.out.println("Sorting complete!"); return; }
        if (Sort.sorted(array)) { System.out.println("Sorting complete!"); return; }
        // Perform one step of radix sort (8 bits)
        Radix.sortStep(array, step);
        // Update chart with current state
        int[] current = array.clone();
        chart.setArray(current);
        System.out.println("After step " + (step + 1) + " of sorting:");
        chart.drawChart();
        // Pause for visualization (can be adjusted)
        try { Thread.sleep(1000); } catch (InterruptedException e) { e.printStackTrace(); }
        // Recursive call for next step
        sort_(array, chart, step + 1);
    }

    // Sort and measure time
    private static void getTime(int[] array) {
        // Sort and measure time
        long start = System.nanoTime();
        Sort.sort(array);
        long end = System.nanoTime();
        // Display sorting time and Array
        // for (int i = 0; i < array.length; i++) System.out.print(array[i] + " ");
        System.out.println("\nSorted in " + (end - start) / 1e6 + " ms\n");
    }
}

class Radix implements Sort {
    // Fields
    private static int[] tempArray;
    private static boolean anim = false;
    public static boolean anim(boolean status) {return anim = status;}
    public static int getFac() {return Main.getFac();} // Get Factor for steps

    // Single step of radix sort (for animation)
    public static void sortStep(int[] sortableArr, int step) {
        int shift = step / getFac(); // Each step processes 8 bits
        int[] sortedArr = new int[sortableArr.length];
        if (tempArray == null) tempArray = sortableArr.clone(); // Initialize tempArray for animation
        int[] count = new int[256]; // Count sort for current digit
        for (int num : sortableArr) count[(num >>> shift) & 0xFF]++;
        for (int i = 1; i < 256; i++) count[i] += count[i - 1]; // Calculate positions
        for (int i = sortableArr.length - 1; i >= 0; i--) sortedArr[--count[(sortableArr[i] >>> shift) & 0xFF]] = sortableArr[i]; // Place elements in sorted order
        System.arraycopy(sortedArr, 0, sortableArr, 0, sortableArr.length);
        if (anim) tempArray = sortedArr.clone();
    }
}
