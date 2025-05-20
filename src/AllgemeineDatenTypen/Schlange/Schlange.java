package AllgemeineDatenTypen.Schlange;

public class Schlange {

    int groesse;
    Knoten head;
    Knoten tail;

    private class Knoten {

        int value;
        Knoten next;

        public Knoten(int value) {

            this.value = value;
            this.next = null;
        }
    }

    public Schlange() {

        this.head = null;
        this.tail = null;
        this.groesse = 0;
    }

    public static void main(String[] args) {

        Schlange schlange = new Schlange();
        
        schlange.enqueue(0);
        schlange.enqueue(1);
        schlange.enqueue(8);
        schlange.enqueue(7);

        Schlange otherSchlange = schlange.copy();

        schlange.print();
        otherSchlange.print();

        schlange.dequeue(); 
        otherSchlange.dequeue();

        schlange.print();
        otherSchlange.print();

        schlange.merge(otherSchlange);

        schlange.print();
    }

    public boolean isEmpty() {

        return groesse == 0;
    }

    public void enqueue(int value) {

        Knoten knoten = new Knoten(value);

        if (this.isEmpty()) {

            head = knoten;
            tail = knoten;
        } else {

            tail.next = knoten;
            tail = knoten;
        }

        groesse++;
    }

    public int dequeue() {

        if (isEmpty()) throw new RuntimeException("Schlange is empty."); 
        
        int value = head.value;
        head = head.next;

        if (head == null) tail = null;

        groesse--;
        return value;
    }

    public int front() {

        if (isEmpty()) throw new RuntimeException("Schlange is empty."); 

        return head.value;
    }

    public int size() {

        return groesse;
    }

    public void print() {

        Knoten current = head;
        System.out.print("head -> ");

        while (current != null) {

            System.out.print(current.value + " -> ");
            current = current.next;
        }

        System.out.println("tail");
    }

    public void clear() {

        this.groesse = 0;
        this.head = null;
        this.tail = null;
    }

    public boolean contains(int value) {

        Knoten current = head;

        while (current != null) {

            if (current.value == value) return true;
            current = current.next;
        }

        return false;
    }

    public int[] toArray() {

        Knoten current = head;
        int[] array = new int[groesse];

        for (int i = 0; i < groesse; i++) {
            array[i] = current.value;
            current = current.next;
        }

        return array;
    }

    public int rear() {

        return tail.value;
    }

    public Schlange copy() {

        Schlange newSchlange = new Schlange();
        Knoten current = this.head;

        while (current != null) {

            newSchlange.enqueue(current.value);
            current = current.next;
        }

        return newSchlange;
    }

    public void merge(Schlange other) {
        
        Knoten current = other.head;

        while (current != null) {

            this.enqueue(current.value);
            current = current.next;
        }
    }
}