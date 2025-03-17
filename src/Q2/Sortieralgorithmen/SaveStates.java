package src.Q2.Sortieralgorithmen;

import java.util.ArrayList;
import java.util.List;
/*
 * Sortierung, Einordnung und Darstellung der Ergebnisse
 *
 * System.out.println("\nAlgorithm: " + state.getAlgorithm());
 * System.out.println("Duration: " + state.getDurationTime());
 * System.out.println("Swap Count: " + state.getSwapCount());
 * System.out.println("Comparison Count: " + state.getComparisonCount());
 */
class SaveStates {
    private double durationTime;
    private int swapCount;
    private int comparisonCount;
    private String algorithm;
    // Konstruktor
    public SaveStates(String algorithm, double durationTime, int swapCount, int comparisonCount) {
        this.algorithm = algorithm;
        this.durationTime = durationTime;
        this.swapCount = swapCount;
        this.comparisonCount = comparisonCount;
    }
    public double getDurationTime() {
        return durationTime;
    }
    public int getSwapCount() {
        return swapCount;
    }
    public int getComparisonCount() {
        return comparisonCount;
    }
    public String getAlgorithm() {
        return algorithm;
    }
    // Print Statistik
    public static void print() {
        // Listen
        List<String> sortieralgorithmen = new ArrayList<>();
        List<Double> durationtime = new ArrayList<>();
        List<Integer> swapCount = new ArrayList<>();
        List<Integer> comparisonCount = new ArrayList<>();
        // For-Schleife
        for (SaveStates state : Start.getStates()) {
            sortieralgorithmen.add(state.getAlgorithm());
            durationtime.add(state.getDurationTime());
            swapCount.add(state.getSwapCount());
            comparisonCount.add(state.getComparisonCount());
        }
        // Tabellenkopf
        System.out.printf("\n%-20s %-15s %-15s %-15s\n", "Algorithmus", "Dauer (ms)", "Swaps", "Vergleiche");
        System.out.println("---------------------------------------------------------------");
        // Tabelleninhalt
        for (int i = 0; i < sortieralgorithmen.size(); i++) System.out.printf("%-20s %-15.3f %-15d %-15d\n", sortieralgorithmen.get(i), durationtime.get(i), swapCount.get(i), comparisonCount.get(i));
    }
}
