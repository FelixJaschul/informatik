package AllgemeineDatenTypen.Hash;

public class Hash2<T> {
    private static final Object DELETED = new Object();
    private final Object[] table;

    public Hash2(int size) {
        table = new Object[size];
    }

    public int hash(T value) {
        return Math.abs(value.hashCode()) % table.length;
    }

    public void put(T value) {
        put(value, hash(value));
    }

    private void put(T value, int index) {
        int i = (index + 1) % table.length;
        if (i == hash(value)) {
            System.out.printf("Array ist voll. Element %s konnte nicht eingefügt werden.%n", value);
        } else if (table[index] == null || table[index] == DELETED) {
            table[index] = value;
        } else {
            put(value, i);
        }
    }

    public void remove(T value) {
        remove(value, hash(value), 0);
    }

    private void remove(T value, int index, int count) {
        if (count >= table.length || table[index] == null) return;
        if (table[index] == DELETED) {
            remove(value, (index + 1) % table.length, count + 1);
        } else if (value.equals(table[index])) {
            table[index] = DELETED;
        } else {
            remove(value, (index + 1) % table.length, count + 1);
        }
    }

    public T get(int index) {
        Object value = table[index];
        return value != null && value != DELETED ? (T) value : null;
    }

    public boolean contains(T value) {
        return contains(value, hash(value), 0);
    }

    private boolean contains(T value, int index, int count) {
        if (count >= table.length || table[index] == null) return false;
        if (table[index] == DELETED) {
            return contains(value, (index + 1) % table.length, count + 1);
        }
        if (value.equals(table[index])) return true;
        return contains(value, (index + 1) % table.length, count + 1);
    }

    public void show_table() {
        show_table(0);
        System.out.println();
    }

    private void show_table(int index) {
        if (index >= table.length) return;
        if (table[index] == null || table[index] == DELETED) {
            System.out.print("null\t");
        } else {
            System.out.print(table[index] + "\t");
        }
        show_table(index + 1);
    }

    public static void main(String[] args) {
        Hash2<Person> hash_users = new Hash2<>(11);
        Person[] users = {
                new Person(1001, "felix", 39),
                new Person(2001, "Max", 12),
                new Person(3001, "Titus", 90),
        };

        for (Person person : users) {
            hash_users.put(person);
        }

        hash_users.show_table();
        hash_users.remove(users[0]);
        hash_users.show_table();
    }
}
