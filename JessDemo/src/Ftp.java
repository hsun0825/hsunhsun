import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.SocketException;
import java.util.Scanner;

import org.apache.commons.net.PrintCommandListener;
import org.apache.commons.net.ProtocolCommandListener;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

/**
 * addProtocolCommandListener�i�N�L�{���ҨϥΨ쪺�R�O��ܦbconsole�C connect���O�a�JFTP
 * server��IP��ƨӳs��FTP�C login���O�a�J�b���K�X�n�JFTP�C getReplyCode���o�^���X�C
 * isPositiveCompletion�ΨӧP�_�^���X�O�_���\�PFTP�s�u
 * 
 * @author jess_lin
 *
 */

public class Ftp {
	

	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter the name/IP of the FTP server you want to search: ");
		String server = input.nextLine();
		System.out.print("Please enter the localfolder add : ");
		String filePath = input.nextLine();
//		String server = "192.168.17.79";
//		String filePath = "C:\\ABC"; //�U������w��Ƨ�
		System.out.print("Please enter port: ");
		int port = input.nextInt();
//		int port = 21;
		FTPClient ftp = new FTPClient();
		ftp.addProtocolCommandListener(new PrintCommandListener(new PrintWriter(System.out)));
		ftp.connect(server, port);
		System.out.print("Please enter the name: ");
		String name = input.next();
		System.out.print("Please enter the password: ");
		String password = input.next();
//		
//		String name = "jess";
//		String password = "123456";
		
		ftp.login(name,password);
		
		int reply = ftp.getReplyCode();
		ftp.setControlEncoding("UTF-8");
		ftp.setFileType(ftp.BINARY_FILE_TYPE);//�ڭ̦b�n�JFTP Server��]�i�H�]�w���ɪ��Ҧ�
//		ftp.setFileType(FTP.ASCII_FILE_TYPE);
//		ftp.setFileType(FTP.EBCDIC_FILE_TYPE);
//		ftp.setFileType(FTP.LOCAL_FILE_TYPE);
		
		ftp.enterLocalPassiveMode();//���ɪ��Ҧ��A�����D�ʤγQ�ʨ��
//      ftp.enterLocalActiveMode();
		
		
		
		System.out.println(FTPReply.isPositiveCompletion(reply));

//		String charsetName = "";

//		if (FTPReply.isPositiveCompletion(ftp.sendCommand("OPTS UTF8", "ON"))) {
//			charsetName = "UTF-8";
//		}
/************�U��**************/
		FTPFile[] files = ftp.listFiles();
		
		ftp.retrieveFileStream(filePath); 
		
		FileOutputStream output = null;
		
		for (int i = 0; i < files.length; i++) {

			String fileName = files[i].getName();
			

//			ftp.retrieveFile(fileName, output);
			File localFile = new File(filePath + File.separatorChar + fileName);
			{
//			if (fileName.startsWith("test2")) {
//startWith �U���S�w��Ƨ�				
				
		
			OutputStream os = new FileOutputStream(localFile);
			
			ftp.retrieveFile(fileName, os);

			os.close();
//			String printName = new String(files[i].getName().getBytes("ISO-8859-1"), charsetName);// �ק�]����K�ýX
//			System.out.println(printName);
			
		
			
		}
		
	}

}

		
}

/*
// �C�X���M�ؿ�
FTPFile[] files = ftpClient.listFiles();

for (FTPFile file : files) {
	String details = file.getName();
	if (file.isDirectory()) {
		details = "[" + details + "]";

	}
	System.out.println(details);
}
*/
