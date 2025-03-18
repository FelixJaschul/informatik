package src.Q2.Sortieralgorithmen;

import java.util.Scanner;

// Startklasse für den Testlauf
public class Start {
    // Fields und Variables
    private static final Scanner scanner = new Scanner(System.in);
    private static int testSize = 100;
    // Main-Methode
    public static void main(String[] args) {
        printTabellenkopf();

        Test.runTest(new BubbleSort(), testSize);
        Test.runTest(new InsertionSort(), testSize);
        Test.runTest(new QuickSort(), testSize);
        Test.runTest(new RadixSort(), testSize);
    }
    // Erstellt das erstmalige Interface im Terminal
    private static void printTabellenkopf() {
        System.out.println("\n=== Sortieralgorithmen Benchmark ===");
        System.out.print("\nWas soll die größe sein auf die die Sortieralgorithmen getestet werden (Standardgroesse von 100)? ");
        testSize = scanner.nextInt();
        System.out.printf("\n%-15s %-10s %-10s %-10s\n", "Algorithmus", "Dauer(ms)", "Swaps", "Vergleiche");
        System.out.println("---------------------------------------------------");
    }
}

