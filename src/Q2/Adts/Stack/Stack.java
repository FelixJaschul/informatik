public class Stack {

    int groesse;
    Knoten top;

    private class Knoten {
        
        int value;
        Knoten naechster;

        public Knoten(int value) {

            this.value = value;
            this.naechster = null;
        } 
    }

    public Stack() {
        
        this.top = null;
        this.groesse = 0;
    }

    public static void main(String[] args) {

        Stack stack = new Stack();

        stack.push(7); stack.push(3); stack.push(3); stack.push(1);

        stack.printStack();

        System.out.println(stack.contains(1));
    }

    public boolean isEmpty() {

        return groesse == 0;
    }

    public void push(int value) {

        Knoten knoten = new Knoten(value);
        knoten.naechster = top;
        top = knoten;

        groesse++;
    }

    public int pop() {

        if (isEmpty()) throw new RuntimeException("Der Stack ist leer");

        int tempValue = top.value;
        top = top.naechster;

        groesse--;
        return tempValue;
    }

    public int peek() {

        return top.value;
    }

    public int size() {

        return groesse;
    }

    public void printStack() {
        
        while (top != null) {

            System.out.print(top.value + " ");
            top = top.naechster;
        }

        System.out.println();
    }

    public void clear() {
        
        top = null;
        groesse = 0;
    }

    public boolean contains(int value) {

        while (top != null) {

            if (top.value == value) return true;
            top = top.naechster;
        }

        return false;
    } 

    public int[] toArray() {
        int[] array = new int[groesse];
        
        for (int i = 0; i < groesse; i++) {
            array[i] = current.wert;
            current = current.naechster;
        }
        return array;
    }

    public MyStackPlus copyStack() {
        MyStackPlus newStack = new MyStackPlus();
        for (int i = tempArray.length - 1; i >= 0; i--) {
            newStack.push(tempArray[i]);
        }
        return newStack;
    }

    public void merge(MyStackPlus other) {
        int[] otherArray = other.toArray();
        for (int i = otherArray.length - 1; i >= 0; i--) {
            this.push(otherArray[i]);
        }
    }
}