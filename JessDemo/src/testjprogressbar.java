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
                //設定進度條資料值
                jProgressBar.setValue(progressValues[i]);
            }
            jProgressBar.setIndeterminate(false);
            jProgressBar.setString("載入完成");
            isFinish = true;
            jButton.setText("關閉程式");
        }
    }

    public void addComponentsToPane(Container pane) {

        JProgressBar jProgressBar = new JProgressBar();
        pane.add(jProgressBar, BorderLayout.CENTER);
        jProgressBar.setStringPainted(true);
        jProgressBar.setString("資料載入中...");
        //progressBar.setIndeterminate(true);

        JButton jButton = new JButton("開始");
        pane.add(jButton, BorderLayout.SOUTH);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isFinish) {
                    System.exit(0);
                } else {
                    Thread myThread = new ProgressThread(jProgressBar, jButton);   // 建一個新的 Thread t1
                    myThread.start();
                }
            }
        });
    }


    public testjprogressbar() {
        JFrame frame = new JFrame("HKT線上教室");
        // 獲取螢幕解析度
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        // 設定視窗大小佔螢幕四分之一
        frame.setSize(dimension.width / 2, dimension.height / 2);

        //設定視窗顯示在螢幕畫面中間位置
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//設定關閉可以關掉程式
        //在 Pane 畫面中加入元件
        addComponentsToPane(frame.getContentPane());
//        frame.pack();
        frame.setVisible(true);
    }

    //最一開始程式進入點
    public static void main(String[] args) {
        //使用 invokeLater 確保 UI 在排程執行緒內
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new testjprogressbar();
            }
        });
    }
}
