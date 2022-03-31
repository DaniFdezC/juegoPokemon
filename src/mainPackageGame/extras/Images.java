package mainPackageGame.extras;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Images {

    public static ImageIcon getBasicBackground(int widthFrame, int heightFrame){
        ImageIcon icon = null;

        try {
            BufferedImage bufferedImage = ImageIO.read(new File("src\\mainPackageGame\\images\\pokemonBackground.jpg"));
            Image image = bufferedImage.getScaledInstance(widthFrame, heightFrame, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return icon;
    }
}
