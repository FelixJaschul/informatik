package src.Q2.Sortieralgorithmen;

import java.util.ArrayList;
import java.util.List;

/*
 * Start des Programmes.
 * Nutzt die Hilfsklasse SortierHilfe zum Generieren des Arrays und Ausgabe in die Kommandozeile sowie zum Zählen der Operationen und zur Zeitmessung.
 */
public class Start {

    // Initialisiert die Liste States
    private static List<SaveStates> states = new ArrayList<>();

    /*
     * Getter
     */
    public static List<SaveStates> getStates() {
        return states;
    }
    /*
     * Main-Methode
     * Implementiert die Methode um den SortierAlgo. zu testen und seine Performance zu analysieren.
     */
    public static void main(String[] args) {
        System.out.println("\n=== Test-Sorting Demonstration ===");

        // Setzt Beispiele für ein Sortiertes Array anhand einer gegebenen Sortier-Methode
        // Zusätzlicher Performance-Test
        Test.sort(new BubbleSort());
        // Test.performance(new BubbleSort());
        Test.sort(new InsertionSort());
        // Test.performance(new InsertionSort());
        Test.sort(new QuickSort());
        // Test.performance(new QuickSort());
        Test.sort(new RadixSort());
        // Test.performance(new RadixSort());
        SaveStates.print();
    }
}