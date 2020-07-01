import java.util.Scanner;

public class HomeWork {

	public static void main(String[] args) {
		int s = (int) (Math.random()*43);
		
		int max = 42 , min = 0 , i ;
		int count = 1;

		
		while (true){
			System.out.println("Input a Number");
			Scanner input = new Scanner(System.in);
			i = input.nextInt();
			System.out.println("Input : " + i);
			System.out.println("Count : " + count);
			System.out.println("*****************");
			count++;
			if (max-min == 2 ) { 
				System.out.println("Loses the game");
				break;
				
			}
				
			else if (count > 4 ) {
				System.out.println("Over three times");
				System.out.println("Game Over");
				
			}
			else if (i > max ) {
				System.out.println("The number between 0 and 42");
				System.out.println("*****************");
				
			
			}else if (i == s) {
				System.out.println("Win");
				System.out.println("*****************");
				break;
				
			}else if(i < s) {
				System.out.println("Too small");
				System.out.println(i + "~" + max );
				System.out.println("*****************");
				min = i;
				
				
			}else if (i > s) {
				System.out.println("Too large");
				System.out.println(min + "~" + i );
				System.out.println("*****************");
				max = i;

				}
		}
	}
}