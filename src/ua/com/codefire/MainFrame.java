package ua.com.codefire;

import ua.com.codefire.component.JImageView;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by human on 3/26/17.
 */
public class MainFrame extends JFrame implements ActionListener {

    private JImageView imageView;

    public MainFrame() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Image loader");

        JPanel panel = new JPanel();

        imageView = new JImageView();
        imageView.setPreferredSize(new Dimension(800, 600));
        panel.add(imageView);

        JButton browseImage = new JButton("Browse...");
        browseImage.addActionListener(this);
        panel.add(browseImage);

        setContentPane(panel);

        pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Images", "jpg", "jpeg", "png", "gif", "bmp"));

        if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedImage bufferedImage = ImageIO.read(fileChooser.getSelectedFile());
                imageView.setImage(bufferedImage);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> new MainFrame().setVisible(true));
    }
}
