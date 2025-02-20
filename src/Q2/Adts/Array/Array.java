package src.Q2.Adts.Array;

public class Array {

	private int[] data;
	private int aktIndex, capacity;

	public Array(int capacity) {

		data = new int[capacity];
		aktIndex = 0;
		this.capacity = capacity;
	}

	public static void main(String[] args) {

		Array array = new Array(1);

		array.add(1);array.add(8);array.add(7);array.add(1);array.add(8);array.add(7);array.add(1);array.add(8);array.add(7);array.add(1);array.add(8);array.add(7);array.add(1);array.add(8);array.add(7);

		// array.remove(1, false);

		array.print();

	}

	public void add(int value) {

		data[aktIndex] = value;
		aktIndex++;

		this.resize();
	}

	public void insert(int value, int index) {

		for (int i = aktIndex; i >= index; i-- ) {

			data[i] = data[i - 1];	
		}

		data[index] = value;
		aktIndex++;

		this.resize();
	}

	public int get(int index) {

		return data[index];
	}

	public void set(int value, int index) {

		data[index] = value;
	}

	public void remove(int value, boolean isYourValueAnIndex) {

		if (!isYourValueAnIndex) {

			int writeIndex = 0;

			for (int readIndex = 0; readIndex < aktIndex; readIndex++) {

				if (data[readIndex] != value) {

					data[writeIndex] = data[readIndex];
					writeIndex++;
				}
			}

			aktIndex = writeIndex;
		}

		if (isYourValueAnIndex) {

			for (int i = value; i < aktIndex - 1; i++) {

				data[i] = data[i + 1];
			}

			aktIndex--;
		}

		this.shrink();
	}

	public void print() {

		for (int i = 0; i < aktIndex; i++) {

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

		this.shrink();
	}

	public boolean isEmpty() {

		if (aktIndex == 0 || data[aktIndex] == 0) return true;
		return false;
	}

	public void indexOf(int value) {

		for (int i = 0; i < aktIndex; i++) {
		
			if (data[i] == value) System.out.println("Der Index von: " + value + " ist: " + i);
		}

		System.out.println("Der Wert: " + value + " Exestiert nicht im Array.");
	}

	public void resize() {

		if (aktIndex == capacity) {
			
			capacity += capacity;
			this.update();

			System.out.println("Der Array wurde ums doppelte verlängert. Von: " + capacity / 2 + " --> " + capacity);
		}
	}
	
	public void shrink() {

		if (aktIndex == capacity / 4) {
		
			capacity = capacity / 2;
			this.update();
			System.out.println("Der Array wurde um die Hälfte verkürzt. Von: " + capacity * 2 + " --> " + capacity);
		}
	}

	public void update() {
	
		int[] dataNew = new int[capacity];

		for (int i = 0; i < aktIndex; i++) {

			dataNew[i] = data[i];
			// System.out.println("Stelle: " + i + " wurde übergeben.");
		}

		data = dataNew;
	}

	public void reverse() {
 
	}
}
