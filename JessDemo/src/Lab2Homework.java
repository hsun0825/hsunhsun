
public class Lab2Homework {


	public static int[] arr() {

		int[] arr = new int[8];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 8);
			for (int j = 0; j < i;) {
				if (arr[j] == arr[i]) {

					arr[i] = (int) (Math.random() * 8);

					j = 0;// 從頭開始做
				}

				else
					j++;

			}
			// System.out.printf("%3d", arr[i]);
		}
		return arr;
	}

	public static void main(String[] args) {

		int[] check = arr();
		for (int i : check) {
			System.out.printf("%d ", i);
		}
		System.out.println();

		boolean[] confirm = new boolean[check.length];

		int Group = 0;
		System.out.print(confirm[0]);
		for (int i = 0; i < check.length; i++) {

			if (confirm[i])
				
				continue;

			System.out.printf("Group %d: ", Group);
			
			while (!confirm[i]) {
				
				confirm[i] = true;
				
				System.out.printf("%d ", i);
				
				i = check[i];
			}
			
			System.out.println();
			Group++;

		}

		System.out.println("Groups :" + Group);

	}

}
