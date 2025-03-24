package Sortieralgorithmen.MyProject;

import Sortieralgorithmen.MyProject.Sort.*;

import java.util.Scanner;

/**
 * Startklasse für den Testlauf der Sortieralgorithmen.
 * Bietet Funktionen zum Testen der Performance verschiedener Sortieralgorithmen.
 */
class Start {
    private static final Scanner scanner = new Scanner(System.in);
    private static int testSize;

    /**
     * Hauptmethode zum Starten des Benchmarks.
     */
    public static void main(String[] args) {
        System.out.println("\n--------- Sortieralgorithmen Benchmark --------- ");
        System.out.print("\nGib die Größe des Test-Arrays ein (Standard = 100): ");
        testSize = scanner.nextInt();
        scanner.close();

        getPerformanceOfSortingalgorithms();
    }

    /**
     * Führt Performance-Tests für alle implementierten Sortieralgorithmen durch.
     */
    private static void getPerformanceOfSortingalgorithms() {
        Test.initializeSortingAlgorithm(testSize);
        Test.runTest(new RadixSort());
        Test.runTest(new BubbleSort());
        Test.runTest(new InsertionSort());
        Test.runTest(new QuickSort());
        Test.runTest(new CountingSort());
        Test.displayResults();
    }
}
