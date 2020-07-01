//import java.io.*;
//import java.util.*;
//
//public class Ftp2 {
//	public static void main(String[] args) {
//
//		File a = new File("D:\\");
//
//		String[] filenames;
//		String fullpath = a.getAbsolutePath();
//		
//		
//		if (a.isDirectory()) {
//			filenames = a.list();
//			for (int i = 0; i < filenames.length; i++) {
//				File tempFile = new File(fullpath + "\\" + filenames[i]);
//				if (tempFile.isDirectory()) {
//					System.out.println("�ؿ�:" + filenames[i]);
//				} else
//					System.out.println("�ɮ�:" + filenames[i]);
//			}
//		} else
//			System.out.println("[" + a + "]���O�ؿ�");
//
//	}
//}

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

public class Ftp2 {
	private static void showServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies != null && replies.length > 0) {
			for (String aReply : replies) {
				System.out.println("SERVER: " + aReply);
			}
		}
	}

	public static void main(String[] args) {
		String server = "192.168.17.79";
		int port = 21;
		String user = "jess";
		String pass = "1234567";
		FTPClient ftpClient = new FTPClient();
		try {
			ftpClient.connect(server, port);
			showServerReply(ftpClient);
			int replyCode = ftpClient.getReplyCode();
			if (!FTPReply.isPositiveCompletion(replyCode)) {
				System.out.println("Operation failed. Server reply code: " + replyCode);
				return;
			}
			boolean success = ftpClient.login(user, pass);
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
	}
}