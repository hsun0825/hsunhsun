import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

public class Download {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Download window = new Download();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Download() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(false);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("姓名");
		label.setBounds(22,30,39,25);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(65, 65, 96, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	
		JButton button = new JButton("确定");
		button.setBounds(306,206,87,35);
		frame.getContentPane().add(button);
		
		
		button.addActionListener((e) -> {
			onButtonOk();
		});
	
	}
	
	public void onButtonOk() {
		
		String str = textField.getText();//取得內容
		
		//判斷是否輸入
		if(str.equals(""))
		{
			Object[] options = { "OK ", "CANCEL " }; 
			JOptionPane.showOptionDialog(null, "尚未輸入 ", "提示", JOptionPane.DEFAULT_OPTION, 
			JOptionPane.WARNING_MESSAGE,null, options, options[0]);
		}
		else
			JOptionPane.showInputDialog(this,"你輸入了：" + str);

		

}
}