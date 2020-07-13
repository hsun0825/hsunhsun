
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class FtpGuiA extends JFrame {

	public static final boolean ActionListener = false;
	private static final InputStream in = null;
	public static final int d = 0;
	private JPanel contentPane;
	private static JTextField textField_1;
	private JTextField textField_2;
	private static JTextField textField;

	private JLabel lblNewLabel_2;
	private static JTextField textField_5;
	private JButton btnRun;

	public static String oldpath;
	public static String newpath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					FtpGuiA frame = new FtpGuiA();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});

	}

	/**
	 * Create the frame.
	 */
	public FtpGuiA() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5)); // 組件呈現邊框
		contentPane.setLayout(null);// 1.setLayout(null) 不使用版面配置管理者 2.setLayout(null) 不使用版面配置管理者
		setTitle("自動更新");
		setContentPane(contentPane);

		textField = new JTextField();
		textField.setBounds(23, 34, 384, 21);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("檔案更新資料夾:");
		lblNewLabel.setBounds(23, 10, 96, 26);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("前台資料夾:");
		lblNewLabel_1.setBounds(23, 65, 96, 21);
		contentPane.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setBounds(23, 83, 384, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		lblNewLabel_2 = new JLabel("後台資料夾:");
		lblNewLabel_2.setBounds(23, 114, 82, 26);
		contentPane.add(lblNewLabel_2);

		textField_5 = new JTextField();
		textField_5.setBounds(23, 138, 384, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(23, 231, 384, 21);
		contentPane.add(progressBar);
		progressBar.setVisible(true);
		progressBar.setStringPainted(true);

		btnRun = new JButton("RUN");
		btnRun.setBounds(308, 169, 87, 53);
		contentPane.add(btnRun);
		btnRun.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				TestFile testfile = new TestFile(progressBar,btnRun);
				testfile.path();

			}
		});

	}

	/*
	 * JFrame f = new JFrame("test JProgressBar");
	 * f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Container content =
	 * f.getContentPane(); JProgressBar progressBar = new JProgressBar();
	 * progressBar.setValue(0); progressBar.setStringPainted(true); Border border =
	 * BorderFactory.createTitledBorder("Loading...");
	 * progressBar.setBorder(border); content.add(progressBar, BorderLayout.NORTH);
	 * f.setSize(300, 100); f.setVisible(true); UpdateWorker updateWorker = new
	 * UpdateWorker(f, progressBar); updateWorker.execute(); }
	 * 
	 * public static class UpdateWorker extends SwingWorker {
	 * 
	 * JProgressBar bar = null; JFrame f=null; public UpdateWorker(JFrame f,
	 * JProgressBar bar) { this.bar = bar; this.f = f; }
	 * 
	 * @Override protected Object doInBackground() throws Exception {
	 * 
	 * Random rdm = new Random(); int pv = 0; while(pv<100) {
	 * Thread.sleep(rdm.nextInt(500)+500); pv+=rdm.nextInt(5); bar.setValue(pv); }
	 * return null; }
	 * 
	 * @Override protected void done() { f.setVisible(false); f.dispose(); }
	 * 
	 * 
	 * }
	 */

	public  class TestFile extends Thread{

		private final String substring = null;
		private final boolean True = false;
		private final char[] filesall = null;

		private final PrintStream FileName = null;
		private PrintStream out;

		JProgressBar jProgressBar;
        JButton jButton;
        
		public TestFile(JProgressBar progressBar, JButton button) {
			this.jProgressBar = progressBar;
            this.jButton = button;
		}
		
		/**
		 * @param oldpath 要複製的資料夾
		 * @param newpath 複製到新的路徑
		 */
		public void copy(File oldpath, File newpath) {

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
		public void copyFile(File filepath, String path) {

			
					try {

						InputStream is = new FileInputStream(filepath);
						OutputStream os = new FileOutputStream(path);

						BufferedInputStream bis = new BufferedInputStream(is);
						BufferedOutputStream bos = new BufferedOutputStream(os);

						byte[] bs = new byte[1024];// 定義byte陣列

						int len = -1;// 得到實際讀取到的字節數 最後返回-1

						long length =filepath.length(); // 資料夾容量製做百分比

						double temp = 0;// 複製容量用來製作百分比

						//DecimalFormat decimalFormat = new DecimalFormat("##.00%");// 格式化百分比

						// 循環讀取
						while ((len = bis.read(bs)) != -1) {// 把字節轉換String 從0到len變成String

							bos.write(bs, 0, len);// 通過流寫資料

							temp += len;
							double d = temp / length;
							
							System.out.println((int)(d * 100) + "%");
							jProgressBar.setValue((int)(d * 100));
						}
						bos.close();
						bis.close();
					} catch (IOException e) {

						e.printStackTrace();
					}
				}
		//	}; 
		//}

		public void path() {

			// 找出目錄下的資料夾路徑
//			Scanner input = new Scanner(System.in);
			//
//			String oldpathName = input.nextLine();
			//
//			File[] oldpath = new File(oldpathName).listFiles();

			File[] oldpath = new File(textField.getText()).listFiles();

			for (File filesall : oldpath) {

				java.util.List<File> list = Arrays.asList(oldpath);// Arrays.asList將一個變長引數或者陣列轉換成List

				if (filesall.getPath().contains("Front") | filesall.getPath().contains("Report")) {

//					String newFrontName = input.nextLine();
					//
//					File newpath = new File(newFrontName);

					File newpath = new File(textField_1.getText());

					copy(filesall, newpath);

				}
				if (filesall.getPath().contains("Back") | filesall.getPath().contains("Report")) {

//					String newBackName = input.nextLine();
					//
//					File newpath = new File(newBackName);

					File newpath = new File(textField_5.getText());

					copy(filesall, newpath);

				}
			}

			// System.out.println(filesall);

			// copy(filesall, newpath);

		}

		/**
		 * @return
		 * @return
		 * @output 輸出console到txt
		 * @throws IOException 錯誤訊息*
		 * @throws IOException
		 * @FileName 資料夾名稱
		 */

//		public static void FileName() throws IOException {
//
//			File file = new File("D:\\testFile1\\新增資料夾\\");
//
//			PrintStream out = new PrintStream(new FileOutputStream("output.txt"));
//
//			System.setOut(out);
//
//			String[] filenames;
//
//			String fullpath = file.getAbsolutePath();// 取得路徑
//			{
//
//				if (file.isDirectory())
//
//				{
//					filenames = file.list();
//
//					for (int i = 0; i < filenames.length; i++) {
//
//						System.out.println(filenames[i]);
//
//					}
//
//				}
//			}
//		}	 

	}

}
