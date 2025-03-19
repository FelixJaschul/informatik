package src.Q2.Sortieralgorithmen;

// Implementierung des Bubble-Sort-Algorithmus in Java.
class BubbleSort implements Sort {
    // Sortiert ein Array aufsteigend mit dem Bubble-Sort-Algorithmus.
    public int[] sort(int[] arrayToBeSorted) {
        // Bubble-Sort Implementierung
        for (int i = 0; i < arrayToBeSorted.length; i++) {
            boolean wasPositionSwapped = false;
            for (int j = 0; j < arrayToBeSorted.length - i - 1; j++) {
                if (SortierUtils.compare(arrayToBeSorted[j], arrayToBeSorted[j + 1])) {
                    SortierUtils.swap(arrayToBeSorted, j, j + 1);
                    wasPositionSwapped = true;
                }
            }
            // Wenn keine Tauschoperationen vorgenommen wurden, ist das Array bereits sortiert
            if (!wasPositionSwapped) break;
        }
        return arrayToBeSorted;
    }
}