package Sortieralgorithmen.MyProject;

/**
 * Klasse zur Speicherung der Ergebnisse eines Sortierdurchlaufs.
 * Enthält Informationen über den Algorithmus und seine Performance-Metriken.
 */
class SortierErgebnis {
    private final String algorithm;
    private final double duration;
    private final int swaps;
    private final int comparisons;

    /**
     * Erstellt ein neues SortierErgebnis mit den angegebenen Metriken.
     *
     * @param algorithm Name des Sortieralgorithmus
     * @param duration Dauer der Sortierung in Millisekunden
     * @param swaps Anzahl der Tauschoperationen
     * @param comparisons Anzahl der Vergleichsoperationen
     */
    public SortierErgebnis(String algorithm, double duration, int swaps, int comparisons) {
        this.algorithm = algorithm;
        this.duration = duration;
        this.swaps = swaps;
        this.comparisons = comparisons;
    }

    /**
     * Gibt die Ergebnisse formatiert in der Konsole aus.
     */
    public void print() {
        System.out.printf("%-15s %-10.3f %-10d %-10d\n", algorithm, duration, swaps, comparisons);
    }
}

