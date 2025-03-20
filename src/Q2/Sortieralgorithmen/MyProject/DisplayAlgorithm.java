package Q2.Sortieralgorithmen.MyProject;

// DrawDiagram Implementation
class DisplayAlgorithm {

    // Fields und Variables
    private static int[] arrayToBeDisplayed;
    private static int anzahlDerAbschnitte;
    private static int[] summeDerAbschnitte;

    // Konstruktor
    public DisplayAlgorithm(int[] unsortierterArrayToBeDisplayed, int anzahlDerAbschnitte) {
        DisplayAlgorithm.arrayToBeDisplayed = unsortierterArrayToBeDisplayed;
        DisplayAlgorithm.anzahlDerAbschnitte = anzahlDerAbschnitte;
        DisplayAlgorithm.summeDerAbschnitte = berechneSummeDerAbschnitte();
    }

    // Setter
    public void setArrayToBeDisplayed(int[] arrayToBeDisplayed) {
        DisplayAlgorithm.arrayToBeDisplayed = arrayToBeDisplayed;
    }

    // Ausgabe
    public void drawDiagramToBeDisplayed() {
        int[] summeDerAbschnitteInProzenten = berechneSummeDerAbschnitteInProzentUm();
        System.out.println();
        for (int stelle : summeDerAbschnitteInProzenten) {
            System.out.print("|");
            for (int j = 0; j < stelle; j++) {
                System.out.print("#");
            }
            System.out.println("|");
        }
    }

    // Math
    private static int[] berechneSummeDerAbschnitteInProzentUm() {
        int largestValueOfSummeDerAbschnitte = Integer.MIN_VALUE;
        int smallestValueOfSummeDerAbschnitte = Integer.MAX_VALUE;
        for (int value : summeDerAbschnitte) {
            if (value > largestValueOfSummeDerAbschnitte) largestValueOfSummeDerAbschnitte = value;
            if (value < smallestValueOfSummeDerAbschnitte) smallestValueOfSummeDerAbschnitte = value;
        }
        int[] summeDerAbschnitteInProzenten = new int[summeDerAbschnitte.length];
        for (int i = 0; i < summeDerAbschnitte.length; i++) {
            if (largestValueOfSummeDerAbschnitte == smallestValueOfSummeDerAbschnitte) summeDerAbschnitteInProzenten[i] = 100;
            else summeDerAbschnitteInProzenten[i] = 10 + (summeDerAbschnitte[i] - smallestValueOfSummeDerAbschnitte) * 90 / (largestValueOfSummeDerAbschnitte - smallestValueOfSummeDerAbschnitte);
        }
        // debugTurnSummeDerAbschnitteInProzent(summeDerAbschnitteInProzenten);
        return summeDerAbschnitteInProzenten;
    }
    private static int[] berechneSummeDerAbschnitte() {
        berechneAnzahlDerAbschnitte();
        return berechneAbschnittsSummen();
    }
    private static void berechneAnzahlDerAbschnitte() {
        int lengthDesArrayToBeDisplayed = arrayToBeDisplayed.length;
        // Wenn Array Gerade ist und Array länger als maximalAnzahlDerAbschnitte, behalten wir die Größe bei maximalAnzahlDerAbschnitte
        if (lengthDesArrayToBeDisplayed % 2 == 0 && lengthDesArrayToBeDisplayed > anzahlDerAbschnitte) return;
        if (lengthDesArrayToBeDisplayed % 2 == 1 && lengthDesArrayToBeDisplayed > anzahlDerAbschnitte) anzahlDerAbschnitte--;
        // Wenn Array Ungerade ist und Array kleiner als maximalAnzahlDerAbschnitte, ändern wir die größe zu der Größe des Arrays
        if (lengthDesArrayToBeDisplayed % 2 == 0 && lengthDesArrayToBeDisplayed < anzahlDerAbschnitte) anzahlDerAbschnitte = lengthDesArrayToBeDisplayed;
        if (lengthDesArrayToBeDisplayed % 2 == 1 && lengthDesArrayToBeDisplayed < anzahlDerAbschnitte) anzahlDerAbschnitte = lengthDesArrayToBeDisplayed - 1;
    }
    private static int[] berechneAbschnittsSummen() {
        int[] summeDerAbschnitte = new int[anzahlDerAbschnitte];
        // int[] anzahlProAbschnitt = new int[anzahlDerAbschnitte]; // Nur wichtig für Debug
        // Berechne die Länge eines Abschnitts basierend auf der Array-Länge
        int elementeProAbschnitt = (int) Math.ceil((double) arrayToBeDisplayed.length / anzahlDerAbschnitte);
        // Verteile die Elemente auf die Abschnitte basierend auf ihrer Position im Array
        for (int i = 0; i < arrayToBeDisplayed.length; i++) {
            int abschnittIndex = Math.min(i / elementeProAbschnitt, anzahlDerAbschnitte - 1);
            summeDerAbschnitte[abschnittIndex] += arrayToBeDisplayed[i];
            // anzahlProAbschnitt[abschnittIndex]++; // Nur wichtig für Debug
        }
        // debugBerechneAbschnittsSummen(anzahlProAbschnitt, summeDerAbschnitte, elementeProAbschnitt);
        return summeDerAbschnitte;
    }

    // Debug
    private static void debugBerechneAbschnittsSummen(int[] anzahlProAbschnitt, int[] summeDerAbschnitte, int elementeProAbschnitt) {
        // Debug-Ausgabe in die Konsole, um die Verteilung zu sehen
        System.out.println();
        System.out.println("Anzahl der Abschnitte: " + anzahlDerAbschnitte);
        System.out.println("Länge eines Abschnitts: " + elementeProAbschnitt);
        System.out.println("Maximaler Wert im Array: " + SortierUtils.getMaximunDesArrays(arrayToBeDisplayed));
        System.out.println();
        System.out.println("Verteilung der Werte auf die Abschnitte:");
        System.out.println("     Index |    Bereich    |       Anzahl | Summe");
        for (int i = 0; i < anzahlDerAbschnitte; i++) {
            int start = i * elementeProAbschnitt;
            int end = Math.min((i + 1) * elementeProAbschnitt - 1, arrayToBeDisplayed.length - 1);
            System.out.printf("%10d | %6d-%-6d | %12d | %d%n", i+1, start, end, anzahlProAbschnitt[i], summeDerAbschnitte[i]);
        }
    }
    private static void debugTurnSummeDerAbschnitteInProzent(int[] summeDerAbschnitteInProzenten) {
        // Debug-Ausgabe in die Konsole, um die Prozente zu sehen
        for (int i = 0; i < summeDerAbschnitte.length; i++) {
            System.out.print(summeDerAbschnitte[i] + " = ");
            System.out.print(summeDerAbschnitteInProzenten[i] + " | ");
        }
    }
}