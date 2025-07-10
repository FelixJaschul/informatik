package Sortieralgorithmen.MyProject;

import java.util.HashMap;
import java.util.Map;

/**
 * Klasse zur Verwaltung verschiedener Arten von Arrays für Sortiertests.
 * Erzeugt und speichert Arrays mit unterschiedlichen Eigenschaften.
 */
class SortableArrays {
    private final Map<String, int[]> arraysToBeSorted = new HashMap<>();

    /**
     * Erstellt verschiedene Arten von Arrays für Sortiertests.
     *
     * @param testSize Größe der zu erstellenden Arrays
     */
    public SortableArrays(int testSize) {
        arraysToBeSorted.put("RandomArray", SortierHilfe.generateRandomArray(testSize));
        arraysToBeSorted.put("SortedArray", SortierHilfe.generateSortedArray(testSize));
        arraysToBeSorted.put("ReverseSortedArray", SortierHilfe.generateReverseSortedArray(testSize));
        arraysToBeSorted.put("ArrayWithDuplicates", SortierHilfe.generateArrayWithDuplicates(testSize));
        arraysToBeSorted.put("ArrayPartiallySorted", SortierHilfe.generateArrayPartiallySorted(testSize, 50));
    }

    /**
     * Gibt die Map mit allen Arrays zurück.
     *
     * @return Map mit Arrays verschiedener Eigenschaften
     */
    public Map<String, int[]> getHashMap() {
        return arraysToBeSorted;
    }
}
