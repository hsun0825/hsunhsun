import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPFileFilter;
import org.apache.commons.net.ftp.FTPReply;

public class tryftp {

	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		String dirToSearch = "D:/";
		String server = "192.168.17.51";
		int port = 21;
		String name = "jess";
		String password = "123456";
		FTPClient ftpClient = new FTPClient();
		String filePath = "C:\\ABC"; //傳到的位子

		FileOutputStream output = null;//用來輸出下載檔案
		ftpClient.setControlEncoding("UTF-8");
		try {

			ftpClient.connect(server, port);
			showServerReply(ftpClient);
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Operation failed. Server reply code: " + replyCode);
				return;
			}
			boolean success = ftpClient.login(name, password);
			showServerReply(ftpClient);
			if (!success) {
				System.out.println("Could not login to the server");
				return;
			} else {
				System.out.println("LOGGED IN SERVER");
			}
		} catch (IOException ex) {
			System.out.println("Oops! Something wrong happened");
			ex.printStackTrace();
		}
		/*
		// 列出文件和目錄
		FTPFile[] files = ftpClient.listFiles();

		for (FTPFile file : files) {
			String details = file.getName();
			if (file.isDirectory()) {
				details = "[" + details + "]";

			}
			System.out.println(details);
		}
		*/
		
		//下載檔案
		
		FTPFile[] files = ftpClient.listFiles();
		
		for (FTPFile a : files) {
			String fileName = a.getName();
			OutputStream os = new FileOutputStream(filePath);
			
			File localFile = new File(filePath + File.separatorChar + fileName);
			
			ftpClient.retrieveFile(fileName, os);

			os.close();
		}
		
		//ftpClient.retrieveFileStream(filePath);

	}
}
