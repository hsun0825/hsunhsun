
import java.awt.Font;
import java.awt.List;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTPFile;

/*
public class TestFile {
	public static void main(String arg[]) throws IOException {
		String path = "D:\\testFile1";
		String newPath = "D:\\testFile2";
		copy(path,newPath);
		 
	}
	public static void copy(String path, String copyPath) throws IOException{
		File filePath = new File(path);
		DataInputStream read ;
		DataOutputStream write;
		if(filePath.isDirectory()) {
			File[] list = filePath.listFiles();
			for(int i=0; i<list.length;i++) {
				
			String newPath = path + File.separator + list[i].getName();
					
			String newCopyPath = copyPath + File.separator + list[i].getName();
			
			File newfile = new File(copyPath);
			 if(!newfile.exists()){
				 newfile.mkdir();
			    }
				
			
			copy(newPath, newCopyPath);
		}
	}else if(filePath.isFile()) {
		 read = new DataInputStream(
			     new BufferedInputStream(new FileInputStream(path)));
		 write = new DataOutputStream(
			     new BufferedOutputStream(new FileOutputStream(copyPath)));
			   byte [] buf = new byte[1024];
			   while(read.read(buf) != -1){
			    write.write(buf);
	}
	read.close();
	write.close();
	}else {
		System.out.println("chack again");
		
	}
		
	
	}

	
}
*/
/*
public class TestFile {
	public void copyDir(File sour, File tar) {
		File[] sourFiles = sour.listFiles();
		byte[] tmp = new byte[1];//把一個整形該為1位的byte陣列
		
		if (!tar.exists()) {
			tar.mkdirs();
		}
		for (int i = 0; i < sourFiles.length; i++) {
			if (sourFiles[i].isFile()) {
				String tarpath = tar.getPath() + File.separator + sourFiles[i].getName();
				try {
					BufferedInputStream in = new BufferedInputStream(new FileInputStream(sourFiles[i]));
					BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(tarpath));
					while (in.read(tmp) != -1) {
						out.write(tmp);
					}
					in.close();
					out.close();
				} catch (FileNotFoundException e) {
					System.out.println("Dir FileNotFoundException！");
				} catch (SecurityException e) {
					System.out.println("Dir SecurityException！");
				} catch (IOException e) {
					System.out.print("Dir IOException！");
				}
			} else {
				copyDir(new File(sourFiles[i].getPath()),
						new File(tar.getPath() + File.separator + sourFiles[i].getName()));
			}
		}
	}

	public static void main(String[] args) {
		TestFile tf = new TestFile();
		File src = new File("D:\\testFile1");
		File tar = new File("D:\\testFile2");
		tf.copyDir(src, tar);
	}
}
*/
public class TestFile {

	private static final String substring = null;
	private static final boolean True = false;
	private static final char[] filesall = null;

	private static final PrintStream FileName = null;
	private static PrintStream out;

	/**
	 * 複製整個目錄到指定目錄
	 * 
	 * @throws IOException
	 * @throws IOException
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {

		FileName();
		path();

//		File oldpath = new File("D:\\testFile1\\新增資料夾\\Front1\\");
//		File newpath = new File("D:\\testFile2\\here");
//		
//		
//		//File dirall = new File("D:\\testFile1\\新增資料夾");
//		//dirAll(dirall,0);
//		
//		copy(oldpath, newpath);

		System.out.println("資料夾複製成功");

	}

	/**
	 * @param oldpath 要複製的資料夾
	 * @param newpath 複製到新的路徑
	 */
	public static void copy(File oldpath, File newpath) {

		// String str = "Front"; boolean status = str.contains("Front"); if (status) {

		if (oldpath.isDirectory()) {// 複製資料夾

			newpath.mkdir();// 新建一個資料夾
			File[] oldList = oldpath.listFiles();

			if (oldList != null) {
				for (File file : oldList) {
					copy(file, new File(newpath, file.getName()));
				}
			}
			// }
		} else if (oldpath.isFile()) {// 複製檔案
			File f = new File(newpath.getAbsolutePath());
			try {
				f.createNewFile();
				copyFile(oldpath, f.getAbsolutePath());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * @param filepath 要複製的檔案
	 * @param path     複製到哪去
	 */
	public static void copyFile(File filepath, String path) {
		try {

			InputStream is = new FileInputStream(filepath);
			OutputStream os = new FileOutputStream(path);

			BufferedInputStream bis = new BufferedInputStream(is);
			BufferedOutputStream bos = new BufferedOutputStream(os);

			byte[] bs = new byte[1024];

			int len = -1;

			while ((len = bis.read(bs)) != -1) {

				bos.write(bs, 0, len);
			}

			bos.close();
			bis.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static void path() {

		// File newpath = new File("D:\\testFile2\\Front");

		// List list = (List) Arrays.asList(oldpath);

		// for (File filesall : new File("D:\\testFile1\\新增資料夾\\").listFiles())//

		// 找出目錄下的資料夾路徑
//		Scanner input = new Scanner(System.in);
//
//		String oldpathName = input.nextLine();
//
//		File[] oldpath = new File(oldpathName).listFiles();
		File[] oldpath = new File("D:\\testFile1\\新增資料夾\\").listFiles();

		for (File filesall : oldpath) {

			java.util.List<File> list = Arrays.asList(oldpath);// Arrays.asList將一個變長引數或者陣列轉換成List

			if (filesall.getPath().contains("Front") | filesall.getPath().contains("Report")) {

//				String newFrontName = input.nextLine();
//
//				File newpath = new File(newFrontName);

				 File newpath = new File("D:\\testFile2\\Front");

				copy(filesall, newpath);

			}
			if (filesall.getPath().contains("Back") | filesall.getPath().contains("Report")) {

//				String newBackName = input.nextLine();
//
//				File newpath = new File(newBackName);
				
				File newpath = new File("D:\\testFile2\\Back");

				copy(filesall, newpath);
			}
		}

		// System.out.println(filesall);

		// copy(filesall, newpath);
	}

	/**
	 * @output 輸出console到txt
	 * @throws IOException 錯誤訊息*
	 * @throws IOException
	 * @FileName 資料夾名稱
	 */
	public static void FileName() throws IOException {

		File file = new File("D:\\testFile1\\新增資料夾\\");

		PrintStream out = new PrintStream(new FileOutputStream("output.txt"));

		System.setOut(out);

		String[] filenames;

		String fullpath = file.getAbsolutePath();// 取得路徑
		{

			if (file.isDirectory())

			{
				filenames = file.list();

				for (int i = 0; i < filenames.length; i++) {

					System.out.println(filenames[i]);

				}

			}
		}
	}

}
