package src.Q2.Sortieralgorithmen;

import java.util.Scanner;

// Startklasse für den Testlauf
class Start {
    // Scanner für Benutzereingabe
    private static final Scanner scanner = new Scanner(System.in);

    // Main-Methode
    public static void main(String[] args) {
        // getPerformanceOfSortingalgorithms();

        // Führe Tests für jeden Algorithmus aus
        // Test.runTest(new BubbleSort());
        // Test.runTest(new InsertionSort());
        // Test.runTest(new QuickSort());
        // Test.runTest(new RadixSort());

        // Zeige die Ergebnisse
        // Test.displayResults();

        // Zeige das Original-Array und die Summen der Abschnitte
        getDiagramOfSortingalgorithm();
    }
    // Initialisiert das Performance-Programm
    private static void getPerformanceOfSortingalgorithms() {
        System.out.println("\n--------- Sortieralgorithmen Benchmark --------- ");
        System.out.print("\nGib die Größe des Test-Arrays ein (Standard = 100): ");
        int testSize = scanner.nextInt();
        // Initialisiere die Testumgebung
        Test.initializeSortingAlgorithm(testSize);
    }
    // Initialisiert das Diagramm
    private static void getDiagramOfSortingalgorithm() {
        Sort algorithm = new RadixSort(); // Change the Algorithm to whatever Algorithm you like
        DisplayAlgorithm diagram = new DisplayAlgorithm(SortierUtils.generateRandomArray(150), algorithm);
        int[] summeDerAbschnitte = diagram.getSummeDerAbschnitte();
        for (int i = 0; i < summeDerAbschnitte.length; i++) System.out.print(summeDerAbschnitte[i] + " ");
    }
}
