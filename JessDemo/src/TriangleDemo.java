
public class TriangleDemo {

	public static void main(String[] args) {
		for (int j = 1; j<=5;j++) {
			for (int i = 5 ;i > 0 ; i--) {
				if (i>j) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.print("\n");
	
		}
		for (int j = 1; j<=5;j++) {
			for (int i=1;i<=5;i++) {
				if (i<j) {
					System.out.print(" ");
				}
				else {
					System.out.print("*");
				}
			}
			System.out.print("\n");
			}
		}
	}				

	
	

