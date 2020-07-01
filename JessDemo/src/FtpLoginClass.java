import java.io.IOException;
import java.net.SocketException;
import java.io.File;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;



public class FtpLoginClass {

	private String serverName;
	private String userName;
	private String password;
	private FTPClient thisFtpconnect;

	public FtpLoginClass(String serverName, String userName, String password) {
		this.serverName = serverName;
		this.userName = userName;
		this.password = password;

		// create FTP client from apache commons
		this.thisFtpconnect = new FTPClient();
	}
	
	public void connect() throws IOException, LoginException, SocketException {
		this.thisFtpconnect.connect(serverName);

		// login
		this.thisFtpconnect.login(userName, password);

		String logincode = thisFtpconnect.getReplyString();
		if (!logincode.equalsIgnoreCase("230")&&logincode.equalsIgnoreCase("250")) {
			throw new LoginException("Not Logged in");
		}
	}
	public class LoginException extends Exception{
		LoginException(String msg){
			super(msg);
		}
		
	}
	public void showProcess() throws IOException{
		
		FTPFile[] files = this.thisFtpconnect.listFiles();
		
		for (FTPFile file : files) {
			
		
			if (file.isDirectory()) {
				String name = file.getName();
				System.out.println("");
				System.out.println("Entering Directory: " + name);
				this.thisFtpconnect.changeWorkingDirectory(name);
				System.out.println("In Directory: " + this.thisFtpconnect.printWorkingDirectory());
				this.showProcess();

				// after that recursive call returns, all directories/files in
				// the current directory have been listed.
				// move to the parent directory
				this.thisFtpconnect.changeToParentDirectory();
				name = file.getName();
				System.out.println("Moving out of directory: " + name);
			}
 
			// if the file is a file, print its name
			if (file.isFile()) {
				System.out.println("File: " + file.getName() + " found");
			
		}
	}
	
}
	public void listContents(int depth) throws IOException {

		this.thisFtpconnect.sendNoOp();

		// this stores the contents
		FTPFile[] files = this.thisFtpconnect.listFiles();

		// for every file in the directory
		for (FTPFile file : files) {

			// if the file is a directory
			if (file.isDirectory()) {
				String name = file.getName();

				// change to that directory
				this.thisFtpconnect.changeWorkingDirectory(name);

				// print that directory name
				System.out.println("Path: " + this.thisFtpconnect.printWorkingDirectory());


			}

			
			}
		}
	
	public boolean checkConnection() {
		try {
			return this.thisFtpconnect.sendNoOp();
		} catch (IOException e) {
			// if an exception is thrown, the connection is deemed not to exist
			return false;
		}
	}
	
	}
	
	
