package Sortieralgorithmen.MyProject;

import Sortieralgorithmen.MyProject.Sort.Sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Klasse für das Testen von Sortieralgorithmen.
 * Verwaltet die Testumgebung und führt Tests mit verschiedenen Algorithmen durch.
 */
class Test {
    private static final Map<String, List<SortierErgebnis>> statisticalResults = new HashMap<>();
    private static SortableArrays arraysToBeSorted;

    /**
     * Initialisiert die Testumgebung mit Arrays der angegebenen Größe.
     *
     * @param testSize Größe der zu testenden Arrays
     */
    public static void initializeSortingAlgorithm(int testSize) {
        arraysToBeSorted = new SortableArrays(testSize);
        for (String arrayType : arraysToBeSorted.getHashMap().keySet()) {
            statisticalResults.put(arrayType, new ArrayList<>());
        }
    }

    /**
     * Führt einen Test mit dem angegebenen Sortieralgorithmus durch.
     *
     * @param algorithm Der zu testende Sortieralgorithmus
     */
    public static void runTest(Sort algorithm) {
        for (Map.Entry<String, int[]> entry : arraysToBeSorted.getHashMap().entrySet()) {
            String arrayType = entry.getKey();
            int[] originalArray = entry.getValue();
            int[] arrayCopy = java.util.Arrays.copyOf(originalArray, originalArray.length);

            SortierErgebnis result = executeSortingalgorithmAndMetrics(algorithm, arrayCopy);
            statisticalResults.get(arrayType).add(result);
        }
    }

    /**
     * Zeigt die Ergebnisse aller durchgeführten Tests an.
     */
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

    /**
     * Gibt die Kopfzeile der Ergebnistabelle aus.
     */
    private static void printTableHeader() {
        System.out.println("Algorithm      Time (ms)   Swaps      Comparisons");
        System.out.println("-------------------------------------------------");
    }

    /**
     * Führt einen Sortieralgorithmus aus und misst die Performance-Metriken.
     *
     * @param algorithm Der auszuführende Sortieralgorithmus
     * @param array Das zu sortierende Array
     * @return Ein SortierErgebnis-Objekt mit den Messergebnissen
     */
    private static SortierErgebnis executeSortingalgorithmAndMetrics(Sort algorithm, int[] array) {
        SortierHilfe.resetMetrics();
        SortierHilfe.startTimer();
        algorithm.sort(array);
        SortierHilfe.endTimer();

        return new SortierErgebnis(
                algorithm.getClass().getSimpleName(),
                SortierHilfe.getDurationTime(),
                SortierHilfe.getSwapCount(),
                SortierHilfe.getComparisonCount()
        );
    }
}