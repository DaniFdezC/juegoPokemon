package paquetepruebas;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ResizeImageExample {
    public static void main(String[] args) throws IOException {

        new ResizeImageExample();
    }

    public ResizeImageExample() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File("D:\\OneDrive\\Clase-Estudios\\PruebasProgramacion\\NuevoIntento\\src\\mainPackageGame\\images\\pokemonBackground.jpg"));
        Image image = bufferedImage.getScaledInstance(800, 600, Image.SCALE_DEFAULT);

        ImageIcon icon = new ImageIcon(image);
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(800, 600);

        JLabel jLabel = new JLabel();
        jLabel.setIcon(icon);
        frame.add(jLabel);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}