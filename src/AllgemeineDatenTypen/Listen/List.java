package AllgemeineDatenTypen.Listen;

public class List {
    private Knoten head, tail, current;
    private int groesse;

    // Interne Knotenstruktur
    private class Knoten {
        private Knoten next, previous;
        private int value;

        public Knoten(int value) {
            this.value = value;
        }
    }

    public List() {
        this.groesse = 0;
    }

    public static void main(String[] args) {
        List list = new List();
        list.addFirst(100);
        list.addFirst(200);
        list.addFirst(300);
        list.print();
        list.printReverse();
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addFirst(int wert) {
        Knoten knoten = new Knoten(wert);

        if (isEmpty())
            head = tail = knoten;
        else {
            knoten.next = head;
            head.previous = knoten;
            head = knoten;
        }

        if (current == null) current = knoten;
        groesse++;
    }

    public void addLast(int wert) {
        Knoten knoten = new Knoten(wert);

        if (isEmpty())
            head = tail = knoten;
        else {
            knoten.previous = tail;
            tail.next = knoten;
            tail = knoten;
        }

        if (current == null) current = knoten;
        groesse++;
    }

    public void addAt(int index, int wert) {
        if (index < 0 || index > groesse) throw new IndexOutOfBoundsException("Index: " + index + ", Größe: " + groesse);

        if (index == 0) {
            addFirst(wert);
            return;
        }

        if (index == groesse) {
            addLast(wert);
            return;
        }

        Knoten knoten = new Knoten(wert);
        Knoten aktuell = head;

        for (int i = 0; i < index; i++) aktuell = aktuell.next;

        knoten.previous = aktuell.previous;
        knoten.next = aktuell;
        aktuell.previous.next = knoten;
        aktuell.previous = knoten;

        groesse++;
    }

    public void addAtCurrent(int wert) {
        if (current == null || current == head) {
            addFirst(wert);
            return;
        }

        Knoten knoten = new Knoten(wert);
        knoten.previous = current.previous;
        knoten.next = current;
        current.previous.next = knoten;
        current.previous = knoten;

        groesse++;
    }

    public int removeFirst() {
        if (isEmpty()) throw new RuntimeException("Die Liste ist leer");

        int wert = head.value;

        if (head == tail)
            head = tail = current = null;
        else {
            head = head.next;
            head.previous = null;

            if (current != null && current.previous == null && current != head) current = head;
        }

        groesse--;
        return wert;
    }

    public int removeLast() {
        if (isEmpty()) throw new RuntimeException("Die Liste ist leer");

        int wert = tail.value;

        if (head == tail)
            head = tail = current = null;
        else {
            tail = tail.previous;
            tail.next = null;

            if (current != null && current.next == null && current != tail) current = tail;
        }

        groesse--;
        return wert;
    }

    public int removeAt(int index) {
        if (index < 0 || index >= groesse) throw new IndexOutOfBoundsException("Index: " + index + ", Größe: " + groesse);

        if (index == 0) return removeFirst();
        if (index == groesse - 1) return removeLast();

        Knoten aktuell = head;
        for (int i = 0; i < index; i++) aktuell = aktuell.next;

        int wert = aktuell.value;
        aktuell.previous.next = aktuell.next;
        aktuell.next.previous = aktuell.previous;

        if (current == aktuell) current = aktuell.next;

        groesse--;
        return wert;
    }

    public int removeAtCurrent() {
        if (current == null) throw new IllegalStateException("Keine aktuelle Position gesetzt");

        if (current == head) return removeFirst();
        if (current == tail) return removeLast();

        int wert = current.value;
        current.previous.next = current.next;
        current.next.previous = current.previous;

        Knoten naechster = current.next;
        current = naechster;

        groesse--;
        return wert;
    }

    public int get(int index) {
        if (index < 0 || index >= groesse) throw new IndexOutOfBoundsException("Index: " + index + ", Größe: " + groesse);

        Knoten aktuell = head;
        for (int i = 0; i < index; i++) aktuell = aktuell.next;

        return aktuell.value;
    }

    public int getCurrent() {
        if (current == null) throw new IllegalStateException("Keine aktuelle Position gesetzt");
        return current.value;
    }

    public void setCurrent(int index) {
        if (index < 0 || index >= groesse) throw new IndexOutOfBoundsException("Index: " + index + ", Größe: " + groesse);

        Knoten aktuell = head;
        for (int i = 0; i < index; i++) aktuell = aktuell.next;

        current = aktuell;
    }

    public void next() {
        if (current == null) throw new IllegalStateException("Keine aktuelle Position gesetzt");
        if (current.next == null) throw new RuntimeException("Kein nächstes Element vorhanden");

        current = current.next;
    }

    public void previous() {
        if (current == null) throw new IllegalStateException("Keine aktuelle Position gesetzt");
        if (current.previous == null) throw new RuntimeException("Kein vorheriges Element vorhanden");

        current = current.previous;
    }

    public boolean hasNext() {
        return current != null && current.next != null;
    }

    public boolean hasPrevious() {
        return current != null && current.previous != null;
    }

    public int size() {
        return groesse;
    }

    public void print() {
        if (isEmpty()) {
            System.out.println("Die Liste ist leer.");
            return;
        }

        StringBuilder sb = new StringBuilder("Liste: [");
        Knoten temp = head;

        while (temp != null) {
            sb.append(temp.value);
            if (temp == current) sb.append(" (current)");
            if (temp.next != null) sb.append(" -> ");
            temp = temp.next;
        }

        this.stats(sb);
    }

    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Die Liste ist leer.");
            return;
        }

        StringBuilder sb = new StringBuilder("Liste (umgekehrt): [");
        Knoten temp = tail;

        while (temp != null) {
            sb.append(temp.value);
            if (temp == current) sb.append(" (current)");
            if (temp.previous != null) sb.append(" <- ");
            temp = temp.previous;
        }

        this.stats(sb);
    }

    private void stats(StringBuilder sb) {
        sb.append("]\n[Größe: ").append(groesse);
        if (head != null) sb.append(" | Head: ").append(head.value);
        if (tail != null) sb.append(" | Tail: ").append(tail.value);
        if (current != null) sb.append(" | Current: ").append(current.value);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public void clear() {
        head = tail = current = null;
        groesse = 0;
        System.out.println("Liste wurde geleert.");
    }

    public boolean contains(int wert) {
        if (isEmpty()) return false;

        Knoten temp = head;
        while (temp != null) {
            if (temp.value == wert) return true;
            temp = temp.next;
        }

        return false;
    }

    public int[] toArray() {
        int[] array = new int[groesse];

        if (isEmpty()) return array;

        Knoten temp = head;
        for (int i = 0; i < groesse; i++) {
            array[i] = temp.value;
            temp = temp.next;
        }

        return array;
    }

    public int getFirst() {
        if (isEmpty()) throw new RuntimeException("Die Liste ist leer");
        return head.value;
    }

    public int getLast() {
        if (isEmpty()) throw new RuntimeException("Die Liste ist leer");
        return tail.value;
    }

    public List copyList() {
        List kopie = new List();

        if (isEmpty()) return kopie;

        Knoten temp = head;
        while (temp != null) {
            kopie.addLast(temp.value);
            if (temp == current) kopie.setCurrent(kopie.size() - 1);
            temp = temp.next;
        }

        return kopie;
    }

    public void set(int index, int wert) {
        if (index < 0 || index >= groesse) throw new IndexOutOfBoundsException("Index: " + index + ", Größe: " + groesse);

        Knoten aktuell = head;
        for (int i = 0; i < index; i++) aktuell = aktuell.next;

        aktuell.value = wert;
    }
}