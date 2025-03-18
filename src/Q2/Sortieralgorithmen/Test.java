package src.Q2.Sortieralgorithmen;

/*
 * Klasse für das Testen von Algorithmen
 */
class Test {
    // Startet Alles
    public static void runTest(Sort algorithm) {
        int[] array = SortierUtils.generateRandomArray(100);
        execute(algorithm, array);
    }
    // Startet die Sortierung der Algorithmen und sortiert sie in der Tabelle ein
    private static void execute(Sort algorithm, int[] array) {
        SortierUtils.resetMetrics();
        SortierUtils.startTimer();
        algorithm.sort(array);
        SortierUtils.endTimer();

        new SortierErgebnis(
                algorithm.getClass().getSimpleName(),
                SortierUtils.getDurationTime(),
                SortierUtils.getSwapCount(),
                SortierUtils.getComparisonCount()
        ).print();
    }
}