package Q2.Sortieralgorithmen.MyProject;

import java.util.Scanner;

// Startklasse für den Testlauf
class Start {

    // Scanner für Benutzereingabe
    private static final Scanner scanner = new Scanner(System.in);
    private static int testSize;
	private static int anzahlDerAbschnitte;
    // Main-Methode
    public static void main(String[] args) throws InterruptedException {
        // waitAndClearScreen(1000);
        System.out.println("\n--------- Sortieralgorithmen Benchmark --------- ");
        System.out.print("\nGib die Größe des Test-Arrays ein (Standard = 100): "); testSize = scanner.nextInt();
		// System.out.print("\nGib die Anzahl der Abschnitte an (Standard = 50): "); anzahlDerAbschnitte = scanner.nextInt();
		scanner.close();
        // Initialisiere Sortieralgorithmen
        getPerformanceOfSortingalgorithms();
        // getDiagramOfSortingalgorithm(testSize);
    }

    // Gibt einen PerformanceTest aller Sortieralgorithmen zurück
    private static void getPerformanceOfSortingalgorithms() {
        // Initialisiere die Testumgebung
        Test.initializeSortingAlgorithm(testSize);
        Test.runTest(new BubbleSort());
        Test.runTest(new InsertionSort());
        Test.runTest(new QuickSort());
        Test.runTest(new CountingSort());
        Test.runTest(new RadixSort());
        Test.displayResults();
    }

    // Gibt das Diagramm eines zu sortiertenden Arrays in der Konsole aus
    private static void getDiagramOfSortingalgorithm(int testSize) throws InterruptedException {
        // Fields und Variables
        int timeInMilliSeconds = 1000;
        // Array der als Diagramm gezeigt werden soll
        int[] arrayToBeDisplayed = SortierUtils.generateRandomArray(testSize);
        // Change the Algorithm to whatever Algorithm you like
        Sort algorithmToSortTheArray = new RadixSort();
        DisplayAlgorithm diagramToBeDisplayed = new DisplayAlgorithm(arrayToBeDisplayed, anzahlDerAbschnitte);

        // Clear
        waitAndClearScreen(timeInMilliSeconds);

        // Display unsorted array
        diagramToBeDisplayed.drawDiagramToBeDisplayed();

        // Sort the array
        algorithmToSortTheArray.sort(arrayToBeDisplayed);

        // Clear
        waitAndClearScreen(timeInMilliSeconds);

        // Display sorted array
        diagramToBeDisplayed.setArrayToBeDisplayed(arrayToBeDisplayed);
        diagramToBeDisplayed.drawDiagramToBeDisplayed();
    }
    // Clear
    private static void waitAndClearScreen(int timeInMilliseconds) throws InterruptedException {
        Thread.sleep(timeInMilliseconds);
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
