package src.Q2.Sortieralgorithmen;

// Klasse zur Speicherung der Ergebnisse
class SortierErgebnis {

    // Fields und Variables
    private final String algorithm;
    private final double duration;
    private final int swaps, comparisons;

    // Konstruktor
    public SortierErgebnis(String algorithm, double duration, int swaps, int comparisons) {
        this.algorithm = algorithm;
        this.duration = duration;
        this.swaps = swaps;
        this.comparisons = comparisons;
    }

    // Erstellt den Tabellen Inhalt im Terminal
    public void print() {
        System.out.printf("%-15s %-10.3f %-10d %-10d\n", algorithm, duration, swaps, comparisons);
    }
}

