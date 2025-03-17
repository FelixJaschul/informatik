package src.Q2.Sortieralgorithmen;

import java.util.ArrayList;
import java.util.List;

/*
 * Testet alle SortierAlgorithmen.
 */
class Test {

    /*
     * Beispielhafte Nutzung der Sortierungs-Algorithmen mit verschiedenen Arrays.
     * Nutzt die Hilfsklasse SortierHilfe zum Generieren des Arrays und Ausgabe in die Kommandozeile
     */
    public static void sort(Sort algorithm) {
        // System.out.println("\n=== Test mit " + algorithm.getClass().getSimpleName() + " ===");
        // Beispiel 1: Zufälliges Array
        int[] array = SortierHilfe.generateRandomArray(100);
        // Beispiel 2: reversed Zufälliges Array
        int[] reversedArray = SortierHilfe.generateReverseSortedArray(100);
        // Beispiele Ausgeben
        printAlgorithmus(algorithm, array);
        // SaveStates.printList();
        printAlgorithmus(algorithm, reversedArray);
        // SaveStates.printList();
    }

    /*
     * Führt einen Performance-Test mit Arrays verschiedener Größe durch
     */
    public static void performance(Sort algorithm) {
        System.out.println("\n=== Performance-Test mit " + algorithm.getClass().getSimpleName() + " ===");
        int[] testSizes = {10, 50, 100};
        // Durchgeht den TestSizes-Array und schreibt jeweils die Ergebnisse ins Terminal
        for (int size : testSizes) {
            System.out.println("\nTest mit Array der Größe " + size + ":");
            // Zufälliges Array generieren
            int[] array = SortierHilfe.generateRandomArray(size);
            // Zurücksetzten der Zähler und Timer
            System.out.println("Sortiere...");
            SortierHilfe.startTimer();
            // Array sortieren (zum gewünschtem SortierAlgo ändern)
            algorithm.sort(array);
            // Ende
            SortierHilfe.endTimer();
            // Statistik ausgeben
            SortierHilfe.printStatistics(array);
        }
    }

    /*
     * Hilf Funktionen
     */
    private static void printAlgorithmus(Sort algorithm, int[] array) {
        // System.out.println("\nArray vor der Sortierung: ");
        // SortierHilfe.printArray(array, 10);
        // Zähler und Timer zurücksetzen
        SortierHilfe.resetCounters();
        SortierHilfe.resetTimer();
        // Timer starten
        SortierHilfe.startTimer();
        // Array sortieren
        algorithm.sort(array);
        // Timer beenden
        SortierHilfe.endTimer();
        // Ergebnisse ausgeben
        // System.out.println("\nArray nach Sortierung:");
        // SortierHilfe.printArray(array, 10);
        // SortierHilfe.printStatistics(array);
        SaveStates save = new SaveStates(algorithm.getClass().getSimpleName(), SortierHilfe.durationTimer(), SortierHilfe.getSwapCount(), SortierHilfe.getComparisonCount());
        Start.getStates().add(save);
    }
}