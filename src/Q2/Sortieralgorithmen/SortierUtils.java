package src.Q2.Sortieralgorithmen;

import java.util.Arrays;
import java.util.Random;

// Klasse mit hilfreichen Methoden zur Verwendung bei Sortieralgorithmen.
// Bietet Funktionen zum Generieren von Testdaten, Messen der Performance
// und Analysieren von Sortieralgorithmen.
public class SortierUtils {
    // --- Statische Variablen für die Zählung der Operationen ---
    private static int swapCount = 0;
    private static int comparisonCount = 0;

    // --- Statische Variablen für den Timer ---
    private static long startTime = 0;
    private static long endTime = 0;
    private static boolean timerRunning = false;

    // --- Methoden für das Erstellen, Überprüfen und Kopieren von Arrays mit Zahlen ---

    // Generiert ein zufälliges Array mit entsprechend gewünschter Größe.
    // Die Werte liegen zwischen 0 und 999.
    public static int[] generateRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) array[i] = random.nextInt(1000); // Zufallszahlen von 0 bis 999
        return array;
    }
    // Generiert ein bereits sortiertes Array von klein nach groß mit entsprechend gewünschter Größe.
    // Die Werte beginnen bei 0 und erhöhen sich sequentiell.
    public static int[] generateSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) array[i] = i;
        return array;
    }
    // Generiert ein bereits sortiertes Array von groß nach klein mit entsprechend gewünschter Größe.
    // Die Werte beginnen bei size-1 und verringern sich sequentiell.
    public static int[] generateReverseSortedArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) array[i] = size - i - 1;
        return array;
    }
    // Generiert ein Array nur mit Werten zwischen 0 - 9 bei entsprechend gewünschter Größe.
    // Durch die begrenzte Wertemenge enthält das Array zahlreiche Duplikate, was zum
    // Testen von Algorithmen genutzt werden kann.
    public static int[] generateArrayWithDuplicates(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) array[i] = random.nextInt(10); // Nur 10 verschiedene Wert
        return array;
    }
    // Generiert ein teilweise sortiertes Array mit entsprechend gewünschter Größe.
    // Der prozentuale Anteil der sortierten Elemente kann angegeben werden.
    public static int[] generateArrayPartiallySorted(int size, int sortedPercentage) {
        if (sortedPercentage < 0 || sortedPercentage > 100) throw new IllegalArgumentException("Der Prozentsatz muss zwischen 0 und 100 liegen");
        // Zunächst ein vollständig sortiertes Array erstellen
        int[] array = generateSortedArray(size);
        // Berechnen, wie viele Elemente wir vertauschen müssen
        int elementsToSwap = size * (100 - sortedPercentage) / 100;
        // Zufällige Elemente vertauschen
        Random random = new Random();
        for (int i = 0; i < elementsToSwap; i++) {
            int index1 = random.nextInt(size);
            int index2 = random.nextInt(size);
            // Nur tauschen, wenn die Indizes unterschiedlich sind
            if (index1 != index2) swap(array, index1, index2);
        }
        return array;
    }
    // Setzt alle Werte des zurück.
    public static void resetMetrics() {
        swapCount = comparisonCount = 0;
        startTime = endTime = 0;
    }
    // Prüft, ob ein Array nach der Größe sortiert ist
    public static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) if (array[i] > array[i + 1]) return false;
        return true;
    }
    // Kopiert den Array
    public static int[] copyArray(int[] array) { return Arrays.copyOf(array, array.length); }
    // Gibt ein Array in der Konsole aus. Bei großen Arrays werden nur die
    // ersten maxElements Elemente angezeigt, um die Ausgabe übersichtlich zu halten.
    public static void printArray(int[] array, int maxElements) {
        if (array.length <= maxElements) System.out.println(Arrays.toString(array));
        else {
            int[] shortened = Arrays.copyOf(array, maxElements);
            System.out.print(Arrays.toString(shortened));
            System.out.println(" ... [" + (array.length - maxElements) + " weitere Elemente]");
        }
    }

    // --- Methoden für den Timer ---

    // Startet einen Timer für die Zeitmessung.
    // Wenn der Timer bereits läuft, passiert nichts.
    public static void startTimer() {
        if (!timerRunning) {
            startTime = System.nanoTime();
            timerRunning = true;
        }
    }
    // Beendet den Timer, sofern zuvor ein Timer gestartet wurde.
    // Wenn kein Timer läuft, passiert nichts.
    public static void endTimer() {
        if (timerRunning) {
            endTime = System.nanoTime();
            timerRunning = false;
        }
    }
    // Setzt alle Werte des Timers zurück.
    public static void resetTimer() {
        startTime = 0;
        endTime = 0;
        timerRunning = false;
    }

    // --- Methoden für die Anzahl an Vergleichs- und Tauschoperationen ---

    // Gibt die aktuelle Anzahl an Tauschoperationen zurück.
    public static int getSwapCount() { return swapCount; }
    // Erhöht die Anzahl der Tauschvorgänge um 1.
    // Diese Methode kann in Algorithmen verwendet werden, die nicht die swap-Methode nutzen.
    public static void incSwapCount() { swapCount++; }
    // Gibt die Dauer des Timers in Millisekunden zurück.
    public static double getDurationTime() { return (endTime - startTime) / 1_000_000.0; }
    // Erhöht die Anzahl der Vergleichsoperationen um 1.
    // Diese Methode kann in Algorithmen verwendet werden, die nicht die compare-Methode nutzen.
    public static void incComparisonCount() { comparisonCount++; }
    //  Gibt die aktuelle Anzahl an Vergleichsoperationen zurück.
    public static int getComparisonCount() { return comparisonCount; }
    // Setzt die Zähler für Tausch- und Vergleichsoperationen zurück.
    public static void resetCounters() {
        swapCount = 0;
        comparisonCount = 0;
    }
    // Vergleicht zwei Werte miteinander und erhöht den Counter für die Vergleiche um 1.
    // Diese Methode sollte in Sortieralgorithmen anstelle direkter Vergleiche verwendet werden.
    public static boolean compare(int a, int b) {
        comparisonCount++;
        return a > b;
    }
    // Tauscht zwei Elemente in einem Array miteinander und erhöht den Counter für die Tauschoperationen um 1.
    // Diese Methode sollte in Sortieralgorithmen anstelle direkter Tauschoperationen verwendet werden.
    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        swapCount++;
    }

    // --- Methode für Statistiken ---

    // Gibt eine Zusammenfassung der wichtigsten Statistiken aus.
    // Zeigt Laufzeit, Vergleiche, Tauschoperationen und ob das Array sortiert ist.
    public static void printStatistics(int[] data) {
        System.out.println("\n--- Sortierstatistik ---");
        System.out.println("Dauer der Sortierung: " + getDurationTime() + " ms.");
        System.out.println("Anzahl Vergleiche: " + getComparisonCount());
        System.out.println("Anzahl Tauschoperationen: " + getSwapCount());
        System.out.print("Ist das Array richtig sortiert worden: ");
        if (isSorted(data)) System.out.println("Ja!");
        else System.out.println("Nein!");
    }
}