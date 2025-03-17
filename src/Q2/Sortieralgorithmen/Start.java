package src.Q2.Sortieralgorithmen;

/*
 * Start des Programmes.
 * Nutzt die Hilfsklasse SortierHilfe zum Generieren des Arrays und Ausgabe in die Kommandozeile sowie zum Zählen der Operationen und zur Zeitmessung.
 */
class Start {
    // Initialisiert die Liste States
    private static SaveStatesList saveStates = new SaveStatesList();

    public static SaveStatesList getSaveStates() {
        return saveStates;
    }
    /*
     * Main-Methode
     * implementiert die Methode um den SortierAlgo. zu testen und seine Performance zu analysieren.
     */
    public static void main(String[] args) {
        System.out.println("\n=== Test-Sorting Demonstration ===");
        // Setzt Beispiele für ein Sortiertes Array anhand einer gegebenen Sortier-Methode
        // zusätzlicher Performance-Test
        Test.sort(new BubbleSort());
        // Test.performance(new BubbleSort());
        Test.sort(new InsertionSort());
        // Test.performance(new InsertionSort());
        Test.sort(new QuickSort());
        // Test.performance(new QuickSort());
        Test.sort(new RadixSort());
        // Test.performance(new RadixSort());
        saveStates.print();
    }
}