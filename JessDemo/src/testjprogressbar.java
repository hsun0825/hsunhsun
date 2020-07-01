import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;



public class testjprogressbar {

	private boolean isFinish = false;
   class ProgressThread extends Thread {

        JProgressBar jProgressBar;
        JButton jButton;
        int[] progressValues = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        ProgressThread(JProgressBar progressBar, JButton button) {
            this.jProgressBar = progressBar;
            this.jButton = button;
        }

        public void run() {
            for (int i = 0; i < progressValues.length; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //�]�w�i�ױ���ƭ�
                jProgressBar.setValue(progressValues[i]);
            }
            jProgressBar.setIndeterminate(false);
            jProgressBar.setString("���J����");
            isFinish = true;
            jButton.setText("�����{��");
        }
    }

    public void addComponentsToPane(Container pane) {

        JProgressBar jProgressBar = new JProgressBar();
        pane.add(jProgressBar, BorderLayout.CENTER);
        jProgressBar.setStringPainted(true);
        jProgressBar.setString("��Ƹ��J��...");
        //progressBar.setIndeterminate(true);

        JButton jButton = new JButton("�}�l");
        pane.add(jButton, BorderLayout.SOUTH);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isFinish) {
                    System.exit(0);
                } else {
                    Thread myThread = new ProgressThread(jProgressBar, jButton);   // �ؤ@�ӷs�� Thread t1
                    myThread.start();
                }
            }
        });
    }


    public testjprogressbar() {
        JFrame frame = new JFrame("HKT�u�W�Ы�");
        // ����ù��ѪR��
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        // �]�w�����j�p���ù��|�����@
        frame.setSize(dimension.width / 2, dimension.height / 2);

        //�]�w������ܦb�ù��e��������m
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�]�w�����i�H�����{��
        //�b Pane �e�����[�J����
        addComponentsToPane(frame.getContentPane());
//        frame.pack();
        frame.setVisible(true);
    }

    //�̤@�}�l�{���i�J�I
    public static void main(String[] args) {
        //�ϥ� invokeLater �T�O UI �b�Ƶ{�������
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new testjprogressbar();
            }
        });
    }
}
