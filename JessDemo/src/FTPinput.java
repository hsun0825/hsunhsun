import java.util.Scanner;

public class FTPinput {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter the name/IP of the FTP server you want to search: ");
		String serverName = input.nextLine();
		System.out.println("");
		
		// prompt for username
		System.out.print("Please enter your username: ");
		String userName = input.nextLine();
		System.out.println("");

		// prompt for password
		System.out.print("Please enter your password: ");
		String password = input.nextLine();
		System.out.println("");
		
		System.out.println("Creating ftp connection using following credentials:");
		System.out.println("Server name: " + serverName);
		System.out.println("Username:    " + userName);
		System.out.println("Password:    " + password);
		System.out.println("");
	}

}
