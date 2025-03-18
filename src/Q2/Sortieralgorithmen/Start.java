package src.Q2.Sortieralgorithmen;

import java.util.Scanner;

// Startklasse für den Testlauf
class Start {
    // Scanner für Benutzereingabe
    private static final Scanner scanner = new Scanner(System.in);
    private static int testSize;
	private static int anzahlDerAbschnitte;

    // Main-Methode
    public static void main(String[] args) {
        System.out.println("\n--------- Sortieralgorithmen Benchmark --------- ");
        System.out.print("\nGib die Größe des Test-Arrays ein (Standard = 100): ");
        testSize = scanner.nextInt();
		System.out.print("\nGib die Anzahl der Abschnitte an (Standard = 50): ");
		anzahlDerAbschnitte = scanner.nextInt();
		scanner.close()
        getPerformanceOfSortingalgorithms();
        getDiagramOfSortingalgorithm(testSize);
    }
    // Initialisiert das Performance-Programm
    private static void getPerformanceOfSortingalgorithms() {
        // Initialisiere die Testumgebung
        Test.initializeSortingAlgorithm(testSize);
        // Test.runTest(new BubbleSort());
        // Test.runTest(new InsertionSort());
        // Test.runTest(new QuickSort());
        // Test.runTest(new CountingSort());
        Test.runTest(new RadixSort());
        Test.displayResults();
    }
    // Initialisiert das Diagramm
    private static void getDiagramOfSortingalgorithm(int testSize) {
        Sort algorithm = new RadixSort(); // Change the Algorithm to whatever Algorithm you like
        DisplayAlgorithm diagram = new DisplayAlgorithm(SortierUtils.generateRandomArray(testSize), algorithm, anzahlDerAbschnitte);
        int[] summeDerAbschnitte = diagram.getSummeDerAbschnitte();
        for (int i = 0; i < summeDerAbschnitte.length; i++) System.out.print(summeDerAbschnitte[i] + " ");
    }
}
