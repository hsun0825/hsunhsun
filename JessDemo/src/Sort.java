import java.util.Arrays;

public class Sort {

	// class level: global
	public static int N = 10; // repeat N times for each size
	public static String[] algo_names = { "Bubble sort", "Selection sort", "Insertion sort", "Arrays.sort" };
	public static int[] set_size = { 1000, 2000, 4000, 8000, 16000, 32000 };
	public static double[][] records = new double[algo_names.length][set_size.length];

	public static void selectionSort(int[] A) {

		for (int i = 0; i < A.length - 1; i++) {
			int m = i;// 找最小值
			for (int j = i + 1; j < A.length; j++) {
				if (A[j] > A[m])
					m = j;
			}
			if (i != m) {
				int temp = A[i];
				A[i] = A[m];
				A[m] = temp;

			}

		}
	}

	public static void insertionSort(int[] A) {

		for (int i = 0; i < A.length; i++) {
			int temp = A[i];

			int j = i - 1;

			while (j >= 0 && temp < A[j]) {
				A[j + 1] = A[j--];
			}

			A[j + 1] = temp;
		}

	}

	public static void bubbleSort(int[] A) {

		for (int i = 0; i < A.length - 1; i++) {// 外層做幾次
			for (int j = 0; j < A.length - 1 - i; j++) {// 內層裡面排幾次
				if (A[j] > A[j + 1]) {
					int temp = A[j];
					A[j] = A[j + 1];
					A[j + 1] = temp;

				}
			}
		}
	}

	public static void main(String[] args) {

		for (int i = algo_names.length - 1; i >= 0; i--) {
			simulate(i);
		}
		showStat();

		// testing(); // you could use this to check correctness of algorithms
	}

	public static void testing() {

		int[] A = arrayGen(10);
		display(A);

		double t0 = System.nanoTime() / 1e6;
		selectionSort(A); // test on selectionSort(); you could change it
		double t1 = System.nanoTime() / 1e6;

		display(A);
		System.out.println(t1 - t0);
	}

	public static void simulate(int algo_no) {

		System.out.printf("Simulating %s: ", algo_names[algo_no]);

		for (int i = 0; i < set_size.length; i++) {

			for (int j = 0; j < N; j++) {

				int[] A = arrayGen(set_size[i]);
				double t0 = System.nanoTime() / 1e6;

				switch (algo_no) {
				case 0:
					bubbleSort(A);
				case 1:
					selectionSort(A);
				case 2:
					insertionSort(A);
				case 3:
					Arrays.sort(A);
				}

				double t1 = System.nanoTime() / 1e6;
				records[algo_no][i] += t1 - t0;
			}

			System.out.printf(".");
			records[algo_no][i] /= N;
		}
		System.out.println("done");

	}

	public static void showStat() {

		System.out.println("Benchmark (time unit: ms)");
		System.out.printf("%7s", "Size");
		for (int i = 0; i < algo_names.length; i++) {
			System.out.printf("%17s", algo_names[i]);
		}
		System.out.println();

		for (int i = 0; i < set_size.length; i++) {
			System.out.printf("%7d", set_size[i]);
			for (int j = 0; j < records.length; j++) {
				System.out.printf("%17.3f", records[j][i]);
			}
			System.out.println();
		}
	}

	public static int[] arrayGen(int N) {

		int[] A = new int[N];
		for (int i = 0; i < A.length; i++)
			A[i] = (int) (Math.random() * N * 10);
		return A;

	}

	public static void display(int[] A) {

		for (int item : A)
			System.out.printf("%d ", item);
		System.out.println();

	}

}
