import java.io.*;
import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class DemoFtp {
	
	private static void ShowServerReply(FTPClient ftpClient) {
		String[] replies = ftpClient.getReplyStrings();
		if (replies !=null && replies.length> 0 ) {
			for (String aReply : replies) {
				System.out.println("Server: " + aReply);
			}
		}
	}
//	private static void printFileDetails(FTPFile[] files) {
//      
//        for (FTPFile file : files) {
//            String details = file.getName();
//            if (file.isDirectory()) {
//                details = "[" + details + "]";
//            }
////           details += "\t\t" + file.getSize();//  "\t"前面的書出內容空8格
//            
//            System.out.println(details);
//        }
//    }
// 
//    private static void printNames(String files[]) {
//        if (files != null && files.length > 0) {
//            for (String aFile: files) {
//                System.out.println(aFile);
//            }
//        }
//    }
 
	
	
	static void listDirectory(FTPClient ftpClinet ,String parentDir, String currentDir, int level) throws IOException {
		String dirTolist = parentDir;
		if (!currentDir.equals("")) {
			dirTolist += "/" + currentDir;
		}
		//輸出console到txt
		 PrintStream out = new PrintStream(new
			      BufferedOutputStream(new
			        FileOutputStream("output.txt", true)));
			    System.setOut(out); // 轉換書出

	//確認資料夾還是文件
		FTPFile[] subFiles = ftpClinet.listFiles(dirTolist);
		if (subFiles !=null && subFiles.length > 0) {
			for (FTPFile aFile : subFiles) {
				String currentFileName = aFile.getName();
				if (currentFileName.equals(".")
					|| currentFileName.equals("..")) {
//						skip parent directory and the directory itself
					continue;
				}
				for (int i = 0; i < level;i++) {
					System.out.print("\t");
				}
				if (aFile.isDirectory()) {
					System.out.println("[" + currentFileName + "]");
					listDirectory(ftpClinet, dirTolist, currentFileName, level + 1 );
				} else {
					System.out.println(currentFileName);
					   
				}
			}
		}
	}
	
	
	
 
	public static void main(String[] arg) {
		String server = "192.168.17.51";
		int port = 21;
		String user = "jess";
		String password = "123456";
		FTPClient ftpClient = new FTPClient();
		ftpClient.setControlEncoding("UTF-8");
		 try {
	            ftpClient.connect(server, port);
	            ShowServerReply(ftpClient);
	            int replyCode = ftpClient.getReplyCode();
	            if (!FTPReply.isPositiveCompletion(replyCode)) {
	                System.out.println("Operation failed. Server reply code: " + replyCode);
	                return;
	            }
	            boolean success = ftpClient.login(user, password);
	            ShowServerReply(ftpClient);
	            if (!success) {
	                System.out.println("Could not login to the server");
	                return;
	            } else {
	                System.out.println("LOGGED IN SERVER");
	            }
	            
//	            FTPFile[] files1 = ftpClient.listFiles();
//	            
//	            printFileDetails(files1);
			
	            String dirToList = "D:\\..";
	            listDirectory(ftpClient, dirToList, "", 0);
	            
	            
	            
	        } catch (IOException ex) {
	            System.out.println("Oops! Something wrong happened");
	            ex.printStackTrace();
	        }
		 
		
         

	}

}
