package mainPackageGame.pages.locations;

import mainPackageGame.pages.HomePage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.Connection;

import static mainPackageGame.extras.Fonts.getFontBySize;
import static mainPackageGame.extras.Images.*;

public class SeaPage extends JFrame {

    private JPanel contentPane;

    public SeaPage(Connection connection, String user) {
        int widthFrame = 1200;
        int heightFrame = 900;

        //Frame
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, widthFrame, heightFrame);
        setLocation(350,80);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton buttonHomepage = new JButton("Homepage");
        buttonHomepage.addActionListener(e -> {
            try {
                dispose(); //cerrar homepage

                HomePage hpage = new HomePage(connection,user);

                hpage.show();

            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonHomepage.setFont(getFontBySize(16));
        buttonHomepage.setBounds(1040, 820, 150, 40);
        contentPane.add(buttonHomepage);

        //Images
        JLabel imageBackground = new JLabel("");
        imageBackground.setIcon(getImageLocation("sea",true,widthFrame,heightFrame));
        imageBackground.setBounds(0, 0, widthFrame, heightFrame);
        contentPane.add(imageBackground);

    }

}
