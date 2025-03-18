package src.Q2.Sortieralgorithmen;

import java.util.Scanner;

// Startklasse für den Testlauf
public class Start {
    // Fields und Variables
    private static final Scanner scanner = new Scanner(System.in);
    private static int testSize = 100;
    // Main-Methode
    public static void main(String[] args) {
        //
        initialize(testSize);
        // Führe Tests für jeden Algorithmus aus
        Test.runTest(new BubbleSort(), testSize);
        Test.runTest(new InsertionSort(), testSize);
        Test.runTest(new QuickSort(), testSize);
        Test.runTest(new RadixSort(), testSize);
        // Zeige die Ausgabe im Terminal
        Test.displayResults();
    }
    // Erstellt das erstmalige Interface und den Test-Array (aus Test.java)
    private static void initialize(int testSize) {
        System.out.println("\n--------- Sortieralgorithmen Benchmark --------- ");
        System.out.print("\nWas soll die größe sein auf die die Sortieralgorithmen getestet werden (Standardgroesse von 100)? ");
        testSize = scanner.nextInt();
        // Initialisiere die Test Umgebung
        Test.initialize(testSize);
    }
}

