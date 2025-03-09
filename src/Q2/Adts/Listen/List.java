public class List {
    
    private Knoten head;        
    private Knoten tail;        
    private Knoten current;     
    private int groesse;        

    private class Knoten {

        private Knoten naechster;   
        private Knoten vorheriger;  
        private int wert;           

        public Knoten(int wert) {

            this.naechster = null;
            this.vorheriger = null;
            this.wert = wert;
        }
    }

    public List() {

        this.head = null;
        this.tail = null;
        this.current = null;
        this.groesse = 0;
    }

    public boolean isEmpty() {

        return groesse == 0;
    }

    public void addFirst(int value) {

        Knoten knoten = new Knoten(value);

        groesse++;

        if (isEmpty()) {

            this.head = knoten;
            this.tail = knoten;
            this.current = knoten;
        } else {

            knoten.naechster = this.head;
            this.head.vorheriger = knoten;
            this.head = knoten;
        }
    }

    public void addLast(int value) {

        Knoten knoten = new Knoten(value);
        groesse++;

        if (isEmpty()) {

            this.head = knoten;
            this.tail = knoten;
            this.current = knoten;
        } else {

            knoten.vorheriger = this.tail;
            this.tail.naechster = knoten;
            this.tail = knoten;
        }
    }

    public void addAt(int index, int value) {

        if (index < 0 || index > groesse) {
            System.out.println("Index außerhalb des gültigen Bereichs.");
            return;
        }

        if (index == 0) {

            addFirst(value);
            return;
        }

        if (index == groesse) {

            addLast(value);
            return;
        }

        Knoten knoten = new Knoten(value);
        Knoten current = head;

        for (int i = 0; i < index; i++) {

            current = current.naechster;
        }

        knoten.vorheriger = current.vorheriger;
        knoten.naechster = current;

        if (current.vorheriger != null) {

            current.vorheriger.naechster = knoten;
        }

        current.vorheriger = knoten;

        groesse++;
    }

    public void addAtCurrent(int wert) {

        Knoten knoten = new Knoten(wert);

        groesse++;

        if (current == null || current == head) {

            addFirst(wert);
        } else {

            knoten.vorheriger = current.vorheriger;
            knoten.naechster = current;

            if (current.vorheriger != null) {

                current.vorheriger.naechster = knoten;
            }

            current.vorheriger = knoten;
        }
    }

    public void print() {

        if (isEmpty()) {

            System.out.println("Die Liste ist leer.");
            return;
        }

        Knoten temp = head;
        System.out.print("Liste: [");

        while (temp != null) {

            System.out.print(temp.wert);
            
            if (temp == current) System.out.print(" (current)");

            if (temp.naechster != null) System.out.print(" -> ");

            temp = temp.naechster;
        }

        System.out.println("]");
    }

    public static void main(String[] args) {
        
        List list = new List();

        list.addFirst(10);
        list.addLast(20);
        list.addAt(1, 15);
        list.print();
    }
}