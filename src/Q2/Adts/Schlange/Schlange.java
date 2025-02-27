package src.Q2.Adts.Schlange;

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

    private static void main(String[] args) {

        Schlange schlange = new Schlange();
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

    public void dequeue() {

        if (this.isEmpty()) {


        }
    }
