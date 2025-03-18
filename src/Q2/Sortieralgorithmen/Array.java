package src.Q2.Sortieralgorithmen;

import java.util.HashMap;
import java.util.Map;

class Array {
    private final Map<String, int[]> arrays = new HashMap<>();

    // Constructor
    public Array(int testSize) {
        // Generate arrays with different characteristics
        arrays.put("RandomArray", SortierUtils.generateRandomArray(testSize));
        arrays.put("SortedArray", SortierUtils.generateSortedArray(testSize));
        arrays.put("ReverseSortedArray", SortierUtils.generateReverseSortedArray(testSize));
        arrays.put("ArrayWithDuplicates", SortierUtils.generateArrayWithDuplicates(testSize));
        arrays.put("ArrayPartiallySorted", SortierUtils.generateArrayPartiallySorted(testSize, 50));
    }

    // Getter
    public Map<String, int[]> getArrays() {
        return arrays;
    }
}
