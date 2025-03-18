package src.Q2.Sortieralgorithmen;

class DisplayAlgorithm {
    // Fields und Variables
    private static int[] arrayToBeDisplayed = SortierUtils.generateRandomArray(3500);
    private static Sort algorithmToSortTheArray;
    private static final int anzahlDerAbschnitte = berechneAnzahlDerAbschnitte();
    private static final int maximalerWertDesArrays = SortierUtils.getMaximunDesArrays(arrayToBeDisplayed);
    // Konstruktor
    public DisplayAlgorithm(int[] arrayToBeDisplayed, Sort algorithmToSortTheArray) {
        DisplayAlgorithm.arrayToBeDisplayed = arrayToBeDisplayed;
        DisplayAlgorithm.algorithmToSortTheArray = algorithmToSortTheArray;
    }
    // Ausgabe
    public int[] getSummeDerAbschnitte() {
        algorithmToSortTheArray.sort(arrayToBeDisplayed);
        return berechneSummeDesArraysNachDerAnzahlDerAbschnitten();
    }
    // Math
    private static int berechneAnzahlDerAbschnitte() {
        int length = arrayToBeDisplayed.length;
        if (length > 50) return 50;
        else return length % 2 == 0 ? length : length - 1; // Wenn ungerade, eine Ziffer (in der Mitte) abziehen
    }
    private static int[] berechneSummeDesArraysNachDerAnzahlDerAbschnitten() {
        int[] summeDerAbschnitte = new int[anzahlDerAbschnitte];
        int[] anzahlProAbschnitt = new int[anzahlDerAbschnitte];
        // Berechne die Länge eines Abschnitts basierend auf der Array-Länge
        int elementeProAbschnitt = (int) Math.ceil((double) arrayToBeDisplayed.length / anzahlDerAbschnitte);
        // Verteile die Elemente auf die Abschnitte basierend auf ihrer Position im Array
        for (int i = 0; i < arrayToBeDisplayed.length; i++) {
            int abschnittIndex = Math.min(i / elementeProAbschnitt, anzahlDerAbschnitte - 1);
            summeDerAbschnitte[abschnittIndex] += arrayToBeDisplayed[i];
            anzahlProAbschnitt[abschnittIndex]++;
        }
        // debugOutput(anzahlProAbschnitt, summeDerAbschnitte, elementeProAbschnitt);
        return summeDerAbschnitte;
    }
    // Debug
    private static void debugOutput(int[] anzahlProAbschnitt, int[] summeDerAbschnitte, int elementeProAbschnitt) {
        // Debug-Ausgabe in die Konsole, um die Verteilung zu sehen
        System.out.println();
        System.out.println("Anzahl der Abschnitte: " + anzahlDerAbschnitte);
        System.out.println("Länge eines Abschnitts: " + elementeProAbschnitt);
        System.out.println("Maximaler Wert im Array: " + maximalerWertDesArrays);
        System.out.println();
        System.out.println("Verteilung der Werte auf die Abschnitte:");
        System.out.println("     Index |    Bereich    |       Anzahl | Summe");
        for (int i = 0; i < anzahlDerAbschnitte; i++) {
            int start = i * elementeProAbschnitt;
            int end = Math.min((i + 1) * elementeProAbschnitt - 1, arrayToBeDisplayed.length - 1);
            System.out.printf("%10d | %6d-%-6d | %12d | %d%n", i+1, start, end, anzahlProAbschnitt[i], summeDerAbschnitte[i]);
        }
    }
}