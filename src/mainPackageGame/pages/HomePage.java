package mainPackageGame.pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import static mainPackageGame.extras.Fonts.*;
import static mainPackageGame.extras.Images.*;
import static mainPackageGame.extras.SQLInteractions.*;
import static mainPackageGame.extras.PredefinedStrings.*;
import static mainPackageGame.extras.ConnectionSQL.*;


public class HomePage extends JFrame {

    private JPanel contentPane;

    public HomePage(Connection connection, String user) {
        int widthFrame = 1200;
        int heightFrame = 900;
        double doubleWidthFrameThird = widthFrame/3;
        int widthFrameThird = (int) doubleWidthFrameThird;

        //Frame
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, widthFrame, heightFrame);
        setLocation(350,80);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        //Buttons
        JButton buttonCollection = new JButton("View Collection");
        buttonCollection.addActionListener(e -> {
            dispose();
            CollectionPage collPage = new CollectionPage(connection,user);
            collPage.show();
        });
        buttonCollection.setFont(getFontBySize(23));
        buttonCollection.setBounds(widthFrameThird, 140, 400, 60);
        contentPane.add(buttonCollection);

        JButton buttonCatch = new JButton("Catch");
        buttonCatch.addActionListener(e -> {
            try {
                dispose(); //cerrar homepage

                ChooseCatchingPage catchingPage = new ChooseCatchingPage(connection);

                catchingPage.show();


            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonCatch.setFont(getFontBySize(23));
        buttonCatch.setBounds(widthFrameThird, 220, 400, 60);
        contentPane.add(buttonCatch);

        JButton buttonItems = new JButton("Items");
        buttonItems.setFont(getFontBySize(23));
        buttonItems.setBounds(widthFrameThird, 300, 400, 60);
        contentPane.add(buttonItems);

        JButton buttonLogout = new JButton("Logout");
        buttonLogout.addActionListener(e -> {
            try {
                dispose(); //cerrar homepage

                LoginPage lpage = new LoginPage();

                lpage.show();

                connection.close();

            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonLogout.setFont(getFontBySize(16));
        buttonLogout.setBounds(1040, 820, 150, 40);
        contentPane.add(buttonLogout);

        //Images
        JLabel imageBackground = new JLabel("");
        imageBackground.setIcon(getBasicBackground(widthFrame,heightFrame));
        imageBackground.setBounds(0, 0, widthFrame, heightFrame);
        contentPane.add(imageBackground);
    }

}
