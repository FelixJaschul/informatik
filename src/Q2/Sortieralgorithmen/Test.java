package src.Q2.Sortieralgorithmen;

import java.util.*;

// Klasse für das Testen von Algorithmen
class Test {
    // Fields und Variables
    private static final Map<String, List<SortierErgebnis>> statisticalResults = new HashMap<>();
    private static SortableArrays arraysToBeSorted;
    // Initialisiere Testumgebung
    public static void initializeSortingAlgorithm(int testSize) {
        arraysToBeSorted = new SortableArrays(testSize);
        // Initialisiere results map
        for (String arrayType : arraysToBeSorted.getHashMap().keySet()) statisticalResults.put(arrayType, new ArrayList<>());
    }
    // Fügt einen Algorithmus hinzu und wenn es der letzte ist, zeigt er alle Ergebnisse an
    public static void runTest(Sort algorithm) {
        // Test each sorting method on each array type
        for (Map.Entry<String, int[]> entry : arraysToBeSorted.getHashMap().entrySet()) {
            String arrayType = entry.getKey();
            int[] originalArray = entry.getValue();
            int[] arrayCopy = java.util.Arrays.copyOf(originalArray, originalArray.length);
            // Führe die Sortier-Operation aus und speichere das Ergebnis in einem Array
            SortierErgebnis result = executeSortingalgorithmAndMetrics(algorithm, arrayCopy);
            statisticalResults.get(arrayType).add(result);
        }
    }
    // Zeige alle Werte im gespeicherten Array "results"
    public static void displayResults() {
        System.out.println("\n--------- Sortieralgorithmen Performance ---------");
        for (String arrayType : arraysToBeSorted.getHashMap().keySet()) {
            System.out.println("\n--------- " + arrayType + " ---------");
            printTableHeader();
            for (SortierErgebnis result : statisticalResults.get(arrayType)) {
                result.print();
            }
        }
    }
    // Display the table header
    private static void printTableHeader() {
        System.out.println("Algorithm      Time (ms)   Swaps      Comparisons");
        System.out.println("-------------------------------------------------");
    }
    // Execute sorting algorithm and return results
    private static SortierErgebnis executeSortingalgorithmAndMetrics(Sort algorithm, int[] array) {
        SortierUtils.resetMetrics();
        SortierUtils.startTimer();
        algorithm.sort(array);
        SortierUtils.endTimer();
        // Return sorting result
        return new SortierErgebnis(
                algorithm.getClass().getSimpleName(),
                SortierUtils.getDurationTime(),
                SortierUtils.getSwapCount(),
                SortierUtils.getComparisonCount()
        );
    }
}