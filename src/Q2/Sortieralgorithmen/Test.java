package src.Q2.Sortieralgorithmen;

/*
 * Testet alle SortierAlgorithmen.
 */
class Test {
    /*
     * Beispielhafte Nutzung der Sortierungs-Algorithmen mit verschiedenen Arrays.
     * Nutzt die Hilfsklasse SortierHilfe zum Generieren des Arrays und Ausgabe in die Kommandozeile
     */
    public static void sort(Sort algorithm) {
        int[] array = SortierHilfe.generateRandomArray(100);
        int[] reversedArray = SortierHilfe.generateReverseSortedArray(100);
        generateStates(algorithm, array);
        generateStates(algorithm, reversedArray);
    }
    /*
     * Führt einen Performance-Test mit Arrays verschiedener Größe durch
     */
    public static void performance(Sort algorithm) {
        System.out.println("\n=== Performance-Test mit " + algorithm.getClass().getSimpleName() + " ===");
        int[] testSizes = {10, 50, 100};
        // Durchgeht den TestSizes-Array und schreibt jeweils die Ergebnisse ins Terminal
        for (int size : testSizes) {
            // System.out.println("\nTest mit Array der Größe " + size + ":");
            int[] array = SortierHilfe.generateRandomArray(size);
            // Zurücksetzten der Zähler und Timer
            SortierHilfe.resetCounters();
            SortierHilfe.resetTimer();
            // Timer starten
            SortierHilfe.startTimer();
            // Array sortieren (zum gewünschtem SortierAlgo ändern)
            algorithm.sort(array);
            // Ende
            SortierHilfe.endTimer();
            // Statistik ausgeben
            SaveStates save = new SaveStates(algorithm.getClass().getSimpleName(), SortierHilfe.durationTimer(), SortierHilfe.getSwapCount(), SortierHilfe.getComparisonCount());
            Start.getSaveStates().add(save);
        }
    }
    /*
     * Hilf Funktionen
     */
    private static void generateStates(Sort algorithm, int[] array) {;
        // Zähler und Timer zurücksetzen
        SortierHilfe.resetCounters();
        SortierHilfe.resetTimer();
        // Timer starten
        SortierHilfe.startTimer();
        // Array sortieren
        algorithm.sort(array);
        // Timer beenden
        SortierHilfe.endTimer();
        // Statistik ausgeben
        SaveStates save = new SaveStates(algorithm.getClass().getSimpleName(), SortierHilfe.durationTimer(), SortierHilfe.getSwapCount(), SortierHilfe.getComparisonCount());
        Start.getSaveStates().add(save);
    }
}