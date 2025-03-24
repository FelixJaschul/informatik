package Sortieralgorithmen.MyProject;

import java.util.Arrays;
import java.util.Random;

/**
 * Utility-Klasse mit hilfreichen Methoden zur Verwendung bei Sortieralgorithmen.
 * Bietet Funktionen zum Generieren von Testdaten, Messen der Performance
 * und Analysieren von Sortieralgorithmen.
 */
public class SortierHilfe {
    // Zähler für Operationen
    private static int swapCount = 0;
    private static int comparisonCount = 0;

    // Timer-Variablen
    private static long startTime = 0;
    private static long endTime = 0;
    private static boolean timerRunning = false;

    /**
     * Generiert ein zufälliges Array mit der angegebenen Größe.
     * Die Werte liegen zwischen 1 und 999.
     *
     * @param size Größe des Arrays
     * @return Ein Array mit Zufallszahlen
     */
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1, 1000);
        }
        return array;
    }

    /**
     * Generiert ein bereits sortiertes Array von klein nach groß.
     *
     * @param size Größe des Arrays
     * @return Ein aufsteigend sortiertes Array
     */
    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * Generiert ein bereits sortiertes Array von groß nach klein.
     *
     * @param size Größe des Arrays
     * @return Ein absteigend sortiertes Array
     */
    public static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i - 1;
        }
        return array;
    }

    /**
     * Generiert ein Array mit vielen Duplikaten (Werte zwischen 1 und 9).
     *
     * @param size Größe des Arrays
     * @return Ein Array mit vielen Duplikaten
     */
    public static int[] generateArrayWithDuplicates(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(1, 10);
        }
        return array;
    }

    /**
     * Generiert ein teilweise sortiertes Array.
     *
     * @param size Größe des Arrays
     * @param sortedPercentage Prozentsatz der sortierten Elemente (0-100)
     * @return Ein teilweise sortiertes Array
     * @throws IllegalArgumentException wenn sortedPercentage nicht zwischen 0 und 100 liegt
     */
    public static int[] generateArrayPartiallySorted(int size, int sortedPercentage) {
        if (sortedPercentage < 0 || sortedPercentage > 100) {
            throw new IllegalArgumentException("Der Prozentsatz muss zwischen 0 und 100 liegen");
        }

        int[] array = generateSortedArray(size);
        int elementsToSwap = size * (100 - sortedPercentage) / 100;

        Random random = new Random();
        for (int i = 0; i < elementsToSwap; i++) {
            int index1 = random.nextInt(1, size);
            int index2 = random.nextInt(1, size);

            if (index1 != index2) {
                swap(array, index1, index2);
            }
        }
        return array;
    }

    /**
     * Setzt alle Metriken zurück (Zähler und Timer).
     */
    public static void resetMetrics() {
        swapCount = 0;
        comparisonCount = 0;
        startTime = 0;
        endTime = 0;
    }

    /**
     * Prüft, ob ein Array aufsteigend sortiert ist.
     *
     * @param array Das zu prüfende Array
     * @return true wenn das Array sortiert ist, sonst false
     */
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * Erstellt eine Kopie eines Arrays.
     *
     * @param array Das zu kopierende Array
     * @return Eine Kopie des Arrays
     */
    public static int[] copyArray(int[] array) {
        return Arrays.copyOf(array, array.length);
    }

    /**
     * Gibt ein Array in der Konsole aus, bei großen Arrays nur die ersten maxElements.
     *
     * @param array Das auszugebende Array
     * @param maxElements Maximale Anzahl der anzuzeigenden Elemente
     */
    public static void printArray(int[] array, int maxElements) {
        if (array.length <= maxElements) {
            System.out.println(Arrays.toString(array));
        } else {
            int[] shortened = Arrays.copyOf(array, maxElements);
            System.out.print(Arrays.toString(shortened));
            System.out.println(" ... [" + (array.length - maxElements) + " weitere Elemente]");
        }
    }

    /**
     * Startet den Timer für die Zeitmessung.
     */
    public static void startTimer() {
        if (!timerRunning) {
            startTime = System.nanoTime();
            timerRunning = true;
        }
    }

    /**
     * Beendet den Timer für die Zeitmessung.
     */
    public static void endTimer() {
        if (timerRunning) {
            endTime = System.nanoTime();
            timerRunning = false;
        }
    }

    /**
     * Setzt den Timer zurück.
     */
    public static void resetTimer() {
        startTime = 0;
        endTime = 0;
        timerRunning = false;
    }

    /**
     * Gibt die aktuelle Anzahl an Tauschoperationen zurück.
     *
     * @return Anzahl der Tauschoperationen
     */
    public static int getSwapCount() {
        return swapCount;
    }

    /**
     * Erhöht die Anzahl der Tauschvorgänge um 1.
     */
    public static void incSwapCount() {
        swapCount++;
    }

    /**
     * Gibt die Dauer des Timers in Millisekunden zurück.
     *
     * @return Dauer in Millisekunden
     */
    public static double getDurationTime() {
        return (endTime - startTime) / 1_000_000.0;
    }

    /**
     * Erhöht die Anzahl der Vergleichsoperationen um 1.
     */
    public static void incComparisonCount() {
        comparisonCount++;
    }

    /**
     * Gibt die aktuelle Anzahl an Vergleichsoperationen zurück.
     *
     * @return Anzahl der Vergleichsoperationen
     */
    public static int getComparisonCount() {
        return comparisonCount;
    }

    /**
     * Setzt die Zähler für Tausch- und Vergleichsoperationen zurück.
     */
    public static void resetCounters() {
        swapCount = 0;
        comparisonCount = 0;
    }

    /**
     * Vergleicht zwei Werte und zählt den Vergleich.
     *
     * @param a Erster Wert
     * @param b Zweiter Wert
     * @return true wenn a > b, sonst false
     */
    public static boolean compare(int a, int b) {
        comparisonCount++;
        return a > b;
    }

    /**
     * Tauscht zwei Elemente in einem Array und zählt den Tausch.
     *
     * @param array Das Array
     * @param i Index des ersten Elements
     * @param j Index des zweiten Elements
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        swapCount++;
    }

    /**
     * Gibt den höchsten Wert des Arrays zurück.
     *
     * @param array Das zu durchsuchende Array
     * @return Der höchste Wert im Array
     */
    public static int getMaximunDesArrays(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (SortierHilfe.compare(array[i], max)) {
                max = array[i];
            }
        }
        return max;
    }

    /**
     * Gibt eine Zusammenfassung der wichtigsten Statistiken aus.
     *
     * @param data Das sortierte Array
     */
    public static void printStatistics(int[] data) {
        System.out.println("\n--- Sortierstatistik ---");
        System.out.println("Dauer der Sortierung: " + getDurationTime() + " ms.");
        System.out.println("Anzahl Vergleiche: " + getComparisonCount());
        System.out.println("Anzahl Tauschoperationen: " + getSwapCount());
        System.out.print("Ist das Array richtig sortiert worden: ");
        System.out.println(isSorted(data) ? "Ja!" : "Nein!");
    }
}