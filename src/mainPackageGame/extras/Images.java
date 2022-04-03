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

    public static ImageIcon getImageLocation(String location, boolean isJPG, int widthFrame, int heightFrame){
        ImageIcon icon = null;
        String direction = null;
        if (isJPG) direction = "src\\mainPackageGame\\images\\locations\\"+location+".jpg";
        else direction = "src\\mainPackageGame\\images\\locations\\"+location+".png";

        try {
            BufferedImage bufferedImage = ImageIO.read(new File(direction));
            Image image = bufferedImage.getScaledInstance(widthFrame, heightFrame, Image.SCALE_DEFAULT);
            icon = new ImageIcon(image);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return icon;
    }
}
