package ua.com.codefire.component;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by human on 3/26/17.
 */
public class JImageView extends JComponent {

    private BufferedImage image;

    public JImageView() {
        super();
    }

    public BufferedImage getImage() {
        return image;
    }

    public void setImage(BufferedImage image) {
        this.image = image;

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);


        if (image != null) {
            g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        }
    }
}
