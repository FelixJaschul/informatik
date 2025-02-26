public class Stack {

    int groesse;
    Knoten top;

    private class Knoten {
        
        int value;
        Knoten next;

        public Knoten(int value) {

            this.value = value;
            this.next = null;
        } 
    }

    public Stack() {
        
        this.top = null;
        this.groesse = 0;
    }

    public static void main(String[] args) {

        Stack stack = new Stack();
        Stack otherStack = stack.copyStack();

        stack.push(7); 
        stack.push(3); 
        stack.push(3); 
        stack.push(1);

        stack.print();

        stack.swap();

        stack.print();

        stack.duplicateTopAndPush();

        stack.print();

    }

    public boolean isEmpty() {

        return groesse == 0;
    }

    public void push(int value) {

        Knoten knoten = new Knoten(value);
        knoten.next = top;
        top = knoten;

        groesse++;
    }

    public int pop() {

        if (isEmpty()) throw new RuntimeException("Der Stack ist leer");

        int tempValue = top.value;
        top = top.next;

        groesse--;
        return tempValue;
    }

    public int peek() {

        if (isEmpty()) throw new RuntimeException("Der Stack ist leer");

        return top.value;
    }

    public int size() {

        return groesse;
    }

    public void print() {

        Knoten current = top;
        
        while (current != null) {

            System.out.print(current.value + " ");
            current = current.next;
        }

        System.out.println();
    }

    public void clear() {
        
        top = null;
        groesse = 0;
    }

    public boolean contains(int value) {

        Knoten current = top;

        while (current != null) {

            if (current.value == value) return true;
            current = current.next;
        }

        return false;
    } 

    public int[] toArray() {

        Knoten current = top;
        int[] array = new int[groesse];
        
        for (int i = 0; i < groesse; i++) {

            array[i] = current.value;
            current = current.next;
        }

        return array;
    }

    public Stack copyStack() {

        Stack newStack = new Stack();
        int[] tempArray = this.toArray();

        for (int i = tempArray.length - 1; i >= 0; i--) {

            newStack.push(tempArray[i]);
        }

        return newStack;
    }

    public void merge(Stack other) {

        int[] otherArray = other.toArray();

        for (int i = otherArray.length - 1; i >= 0; i--) {

            this.push(otherArray[i]);
        }
    }

    public void swap() {

        int tempTop = top.value;
        int tempTopNext = top.next.value;

        this.pop();
        this.pop();

        this.push(tempTop);
        this.push(tempTopNext);
    }

    public void duplicateTopAndPush() {

        this.push(top.value);
    }
}