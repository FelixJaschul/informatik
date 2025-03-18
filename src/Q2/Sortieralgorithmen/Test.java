package src.Q2.Sortieralgorithmen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Klasse für das Testen von Algorithmen
class Test {
    // Fields und Variables
    private static final List<Sort> algorithms = new ArrayList<>();
    private static final Map<String, List<SortierErgebnis>> results = new HashMap<>();
    private static Array array;
    // Initialisiere Testumgebung
    public static void initialize(int testSize) {
        array = new Array(testSize);
        // Initialisiere results map
        for (String arrayType : array.getArrays().keySet()) results.put(arrayType, new ArrayList<>());
    }
    // Fügt einen Algorithmus hinzu und wenn es der letzte ist, zeigt er alle Ergebnisse an
    public static void runTest(Sort algorithm, int testSize) {
        // Gebe den Algorithmus and die Liste weiter
        algorithms.add(algorithm);
        // Test each sorting method on each array type
        for (Map.Entry<String, int[]> entry : array.getArrays().entrySet()) {
            String arrayType = entry.getKey();
            int[] originalArray = entry.getValue();
            int[] arrayCopy = java.util.Arrays.copyOf(originalArray, originalArray.length);
            // Führe die Sortier-Operation aus und speichere das Ergebnis in einem Array
            SortierErgebnis result = execute(algorithm, arrayCopy);
            results.get(arrayType).add(result);
        }
    }
    // Zeige alle Werte im gespeicherten Array "results"
    public static void displayResults() {
        System.out.println("\n--------- Sortieralgorithmen Performance ---------");
        for (String arrayType : array.getArrays().keySet()) {
            System.out.println("\n--------- " + arrayType + " ---------");
            printTableHeader();
            for (SortierErgebnis result : results.get(arrayType)) {
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
    private static SortierErgebnis execute(Sort algorithm, int[] array) {
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