package Q2.Sortieralgorithmen;

import java.util.HashMap;
import java.util.Map;

class SortableArrays {
    // Fields und Variables
    private final Map<String, int[]> arraysToBeSorted = new HashMap<>();

    // Konstruktor
    public SortableArrays(int testSize) {
        // Generate arrays with different characteristics
        arraysToBeSorted.put("RandomArray", SortierUtils.generateRandomArray(testSize));
        arraysToBeSorted.put("SortedArray", SortierUtils.generateSortedArray(testSize));
        arraysToBeSorted.put("ReverseSortedArray", SortierUtils.generateReverseSortedArray(testSize));
        arraysToBeSorted.put("ArrayWithDuplicates", SortierUtils.generateArrayWithDuplicates(testSize));
        arraysToBeSorted.put("ArrayPartiallySorted", SortierUtils.generateArrayPartiallySorted(testSize, 50));
    }

    // Getter
    public Map<String, int[]> getHashMap() {
        return arraysToBeSorted;
    }
}
