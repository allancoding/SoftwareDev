package Projects;

import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;
import java.net.URL;
import java.util.Date;
import java.io.File;

public class Windoww extends JFrame{
    private static final String DEFAULT_IMAGE_PATH = "./cat.gif";
    public Windoww() {
        super("Windowwwww!");
        int width = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        int x = (int) (Math.random() * (width - 300));
        int y = (int) (Math.random() * (height - 150));
        setLocation(x, y);
        setSize(300, 300);
        setVisible(true);
        long timestamp = new Date().getTime();
        JLabel label = new JLabel();
        loadImageIconFromURLAsync("https://cataas.com/cat?" + timestamp, label);
        label.setHorizontalAlignment(JLabel.CENTER);
        getContentPane().add(label);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                new Windoww();
                new Windoww();
            }
        });
    }

    private void loadImageIconFromURLAsync(String imageUrl, JLabel label) {
        SwingWorker<ImageIcon, Void> worker = new SwingWorker<ImageIcon, Void>() {
            @Override
            protected ImageIcon doInBackground() throws Exception {
                try {
                    URL url = new URL(imageUrl);
                    return new ImageIcon(ImageIO.read(url));
                } catch (IOException e) {
                    // If there is an error loading the image, return the default image
                    return new ImageIcon(ImageIO.read(new File(DEFAULT_IMAGE_PATH)));
                }
            }

            @Override
            protected void done() {
                try {
                    ImageIcon imageIcon = get();
                    label.setIcon(imageIcon);
                    revalidate();
                    repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        worker.execute();
    }
    public static void main(String[] args) throws IOException {
        JavaW.run("Projects.Windoww");
        new Windoww();
    }
}
