package src.Q2.Adts.Array;

public class Array {

	private int[] data;
	public int aktIndex, capacity;

	public Array(int capacity) {

		data = new int[capacity];
		aktIndex = 0;
		this.capacity = capacity;
	}

	public static void main(String[] args) {

			Array array = new Array(8);
			array.add(1);
			array.add(8);
			array.add(7);
	}

	public void add(int value) {

		if (aktIndex == capacity) return;

		data[aktIndex] = value;
		aktIndex++;
	}

	public void insert(int value, int index) {

		if (aktIndex == capacity) return;

		for (int i = aktIndex; i >= index; i-- ) {

			data[i] = data[i - 1];	
		}

		data[index] = value;
		aktIndex++;
	}

	public int get(int index) {

		return data[index];
	}

	public void set(int value, int index) {

		data[index] = value;
	}

	public void remove(int index) {
		
		for (int i = index; i < aktIndex -1; i++) {

			data[i] = data[i + 1];
		}

		aktIndex--;
	}

	public void print() {

		for (int i = 0; i <= aktIndex; i++) {

			System.out.print(data[i]);
			if (i < aktIndex - 1) System.out.print(" / ");
		}

		System.out.println();
	}

	public int size() {
	
		return aktIndex;
	}

	public int capacity() {

		return capacity;
	}

	public boolean contains(int value) {
	
		for (int i = 0; i < aktIndex; i++) {
		
			if (data[i] == value) return true;	
		}

		return false;
	}

	public void clear() {

		aktIndex = 0;
		data[aktIndex] = 0;
	}

	public boolean isEmpty() {

		if (aktIndex == 0 || data[aktIndex] == 0) return true;
		return false;
	}

	public void indexOf(int value) {

		for (int i = 0; i < aktIndex; i++) {
		
			if (data[i] == value) System.out.println("Der Index von: " + value + " ist: " + i);
		}
		System.out.prinln("Der Wert: " + value + " Exestiert nicht im Array.");
	}

	public void resize() {

		if (aktIndex == capacity) capacity += capacity;
		System.out.println("Der Array wurde ums doppelte verlängert. Von: " + aktIndex + " --> " + capacity);
	}
	
	public void shrink() {

		if (aktIndex == capacity / 4) capacity = capacity / 2;
		System.out.println("Der Array wurde um die Hälfte verkürzt. Von: " + aktIndex + " --> " + capacity);
	}

	public void reverse() {
 
	}
}
