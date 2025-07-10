package AllgemeineDatenTypen.Hash;

import java.util.ArrayList;

public class HashTable2<K, V> {
    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key + "=" + value;
        }
    }

    private final ArrayList<Entry<K, V>>[] entries;
    private final int capacity;
    private int size;

    @SuppressWarnings("unchecked")
    public HashTable2(int capacity) {
        this.capacity = capacity;
        this.entries = new ArrayList[capacity];
        this.size = 0;

        // Initialize all ArrayLists
        for (int i = 0; i < this.capacity; i++) {
            this.entries[i] = new ArrayList<>();
        }
    }

    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        int index = hash(key);

        // Check if key already exists
        for (int i = 0; i < entries[index].size(); i++) {
            Entry<K, V> entry = entries[index].get(i);
            if (entry.key.equals(key)) {
                entry.value = value; // Update value if key exists
                return;
            }
        }

        // Add new entry
        entries[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);

        for (Entry<K, V> entry : entries[index]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key);

        for (int i = 0; i < entries[index].size(); i++) {
            if (entries[index].get(i).key.equals(key)) {
                entries[index].remove(i);
                size--;
                return;
            }
        }
    }

    public V contains(K key) {
        return get(key);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printTable() {
        System.out.println();
        for (int i = 0; i < capacity; i++) {
            if (!entries[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (int j = 0; j < entries[i].size(); j++) {
                    System.out.print(entries[i].get(j));
                    if (j < entries[i].size() - 1) {
                        System.out.print(" -> ");
                    }
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        HashTable2<Integer, String> hashTable = new HashTable2<>(10);

        hashTable.put(1, "One");
        hashTable.put(2, "Two");
        hashTable.put(11, "Eleven"); // Should be in the same bucket as 1
        hashTable.put(3, "Three");
        hashTable.put(4, "Four");

        System.out.println("HashTable size: " + hashTable.size());
        System.out.println("Value for key 2: " + hashTable.get(2));
        System.out.println("Value for key 11: " + hashTable.get(11));

        hashTable.printTable();

        System.out.println("\nRemoving key 1");
        hashTable.remove(1);
        System.out.println("Updating key 4");
        hashTable.put(4, "Updated Four"); // This will update the value for key 4
        hashTable.printTable();
    }
}
