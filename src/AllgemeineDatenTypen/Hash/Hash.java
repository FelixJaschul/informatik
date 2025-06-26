package AllgemeineDatenTypen.Hash;

public class Hash {
    private final int size;
    private final String[] table;

    public Hash(int size) {
        this.size = size;
        this.table = new String[size];
    }

    private int hash(String value) {
        int sum = 0;
        for (int i = 0; i < value.length(); i++) {
            char c = Character.toLowerCase(value.charAt(i));
            if (c >= 'a' && c <= 'z') {
                sum = sum + (c-'a'+1);
            }
        }
        return sum % size;
    }

    public void put(String value) {
        put(hash(value), value);
    }

    private void put(int hash, String value) {
        if (contains_anything_at(hash)) {
            if (hash == size - 1) hash = -1;
            put(hash + 1, value);
        } else {
            table[hash] = value;
        }
    }

    public boolean contains(String value) {
        return table[hash(value)] != null
                && table[hash(value)].equals(value);
    }

    private boolean contains_anything_at(int hash) {
        return table[hash] != null;
    }

    public void show_table() {
        for (int i = 0; i < size; i++) {
            System.out.print(table[i] + " ");
        }
    }

    public static void main(String[] args) {
        Hash hash = new Hash(11);
        hash.put("Lea");
        hash.put("aLe");
        hash.put("eaL");
        hash.put("Lae");
        hash.put("eLa");
        hash.put("aeL");
        hash.put("Jan");
        hash.put("nJa");
        hash.put("anJ");
        hash.put("Jna");
        hash.put("Max");

        System.out.println(hash.contains("Hallo"));

        hash.show_table();
    }
}
