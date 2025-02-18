public class myArray {

	private int[] data;
	private int aktIndex;

	public myArray(int capacity) {
		
		data = new int[capacity];
		aktIndex = 0;

	}

	public void add(int value) {

		// if (data.length = capacity) return;

		data[aktIndex] = value;
		aktIndex++;

	}

	public void instert(int value, int index) {

		// if (data.length = capacity) return;

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
		
		for (int i = index; i < aktIndex -1; i++;) {

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
}
