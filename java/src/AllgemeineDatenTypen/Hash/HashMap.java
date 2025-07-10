package AllgemeineDatenTypen.Hash;

import java.util.Objects;

public class HashMap<K, V> {
    private class Node<K, V> {
        final int hash;
        final K key;
        V value;
        Node<K,V> next;

        public Node(int hash, K key, V value, Node<K,V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public final int hashCode() {
            return Objects.hashCode(key) ^ Objects.hashCode(value);
        }
    }

    private Node<K, V>[] table;
    private int capacity;
    private int size;
    private static final float LOAD_FACTOR = 0.75f; // HashMap should only be loaded up to 75%

    @SuppressWarnings("unchecked")
    public HashMap(int capacity) {
        this.capacity = capacity;
        this.table = new Node[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        if (key == null) return 0;
        return Math.abs(key.hashCode()) % capacity;
    }

    public void put(K key, V value) {
        if (size >= capacity * LOAD_FACTOR) {
            resize();
        }

        int hash = hash(key);
        int index = hash % capacity;

        if (table[index] == null) {
            table[index] = new Node<>(hash, key, value, null);
            size++;
            return;
        }

        Node<K,V> current = table[index];
        Node<K,V> prev = null;

        // Check if key already exists
        while (current != null) {
            if (Objects.equals(current.key, key)) {
                current.value = value; // Update value if key exists
                return;
            }
            prev = current;
            current = current.next;
        }

        // Add new node at the end of the list
        prev.next = new Node<>(hash, key, value, null);
        size++;
    }

    public V get(K key) {
        int index = hash(key) % capacity;
        Node<K,V> current = table[index];

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value;
            }
            current = current.next;
        }

        return null;
    }

    public void remove(K key) {
        int index = hash(key) % capacity;
        Node<K,V> current = table[index];
        Node<K,V> prev = null;

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                if (prev == null) {
                    table[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    public boolean contains(K key) {
        return get(key) != null;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCapacity = capacity * 2;
        Node<K,V>[] oldTable = table;
        table = new Node[newCapacity];
        capacity = newCapacity;
        size = 0;

        // Rehash all existing entries
        for (Node<K,V> node : oldTable) {
            while (node != null) {
                put(node.key, node.value);
                node = node.next;
            }
        }
    }

    public void printMap() {
        System.out.println();
        for (int i = 0; i < capacity; i++) {
            Node<K,V> current = table[i];
            if (current != null) {
                System.out.print("Bucket " + i + ": ");
                while (current != null) {
                    System.out.print(current.key + "=" + current.value);
                    if (current.next != null) {
                        System.out.print(" -> ");
                    }
                    current = current.next;
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        HashMap<Integer, String> hashMap = new HashMap<>(10);

        hashMap.put(1, "One");
        hashMap.put(2, "Two");
        hashMap.put(11, "Eleven"); // Should be in the same bucket as 1
        hashMap.put(3, "Three");
        hashMap.put(4, "Four");

        System.out.println("Map size: " + hashMap.size());
        System.out.println("Value for key 2: " + hashMap.get(2));
        System.out.println("Value for key 11: " + hashMap.get(11));

        hashMap.printMap();

        System.out.println("\nRemoving key 1");
        hashMap.remove(1);
        System.out.println("Updating key 4");
        hashMap.put(4, "Updated Four"); // This will update the value for key 4
        hashMap.printMap();
    }
}
