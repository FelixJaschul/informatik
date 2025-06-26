package AllgemeineDatenTypen.Hash;

import java.util.ArrayList;

public class HashTable<K, V> {
    private final ArrayList<Entry<K, V>>[] entries;
    private final int capacity;

    private static class Entry<K, V> {
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return this.key + "=" + this.value;
        }
    }

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.entries = new ArrayList[capacity];

        for (int i = 0; i < this.capacity; i++) {
            this.entries[i] = new ArrayList<>();
        }
    }

    public void put(K key, V value) {
        int hash = key.hashCode() % this.capacity;
        this.entries[hash].add(new Entry<>(key, value));
    }

    public V get(K key) {
        int hash = key.hashCode() % this.capacity;
        for (Entry<K, V> entry : this.entries[hash]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    public void remove(K key) {
        int hash = key.hashCode() % this.capacity;
        this.entries[hash].removeIf(entry -> entry.key.equals(key)); // this...
        // is the same as -> for (Entry<K, V> entry : this.entries[hash]) {
        //                      if (entry.key.equals(key)) {
        //                          this.entries[hash].remove(entry);
        //                      }
        //                   }
    }

    public V contains(K key) {
        int hash = key.hashCode() % this.capacity;
        for (Entry<K, V> entry : this.entries[hash]) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    private void printChain(int index) {
        for (Entry<K, V> entry : this.entries[index]) {
            System.out.println(entry);
        }
    }

    public void printTable() {
        for (int i = 0; i < this.capacity; i++) {
            this.printChain(i);
        }
    }

    public static void main(String[] args) {
        HashTable<Integer, Person> hashTable = new HashTable<>(10);

        hashTable.put(1, new Person(1001, "felix", 39));
        hashTable.put(1, new Person(1002, "felix", 15));
        hashTable.put(1, new Person(1003, "felix", 78));
        hashTable.put(2, new Person(2001, "Max", 12));
        hashTable.put(3, new Person(3001, "Titus", 90));
        hashTable.put(3, new Person(3002, "Titus", 7));

        hashTable.printTable();
    }
}

