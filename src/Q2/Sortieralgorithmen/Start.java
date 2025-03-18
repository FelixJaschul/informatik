package src.Q2.Sortieralgorithmen;
/*
 * Startklasse für den Testlauf
 */
public class Start {
    // Main-Methode
    public static void main(String[] args) {
        printTabellenkopf();

        Test.runTest(new BubbleSort());
        Test.runTest(new InsertionSort());
        Test.runTest(new QuickSort());
        Test.runTest(new RadixSort());
    }
    // Erstellt den Tabellenkopf im Terminal
    private static void printTabellenkopf() {
        System.out.println("\n=== Sortieralgorithmen Benchmark ===");
        System.out.printf("\n%-15s %-10s %-10s %-10s\n", "Algorithmus", "Dauer(ms)", "Swaps", "Vergleiche");
        System.out.println("---------------------------------------------------");
    }
}

