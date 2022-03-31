package mainPackageGame.pages;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

import static mainPackageGame.extras.Fonts.*;
import static mainPackageGame.extras.Images.*;
import static mainPackageGame.extras.SQLInteractions.*;
import static mainPackageGame.extras.PredefinedStrings.*;
import static mainPackageGame.extras.ConnectionSQL.*;

public class CreateUserPage extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldUser;
    private JPasswordField textFieldPassword;


    public CreateUserPage(Connection connection) {
        int widthFrame = 1200;
        double doubleWidthFrameThird = widthFrame/3;
        int widthFrameThird = (int) doubleWidthFrameThird;
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

        // User
        JLabel labelUser = new JLabel("User");
        labelUser.setForeground(Color.BLACK);
        labelUser.setFont(getFontBySize(20));
        labelUser.setBounds(widthFrameThird, 160, 80, 40);
        contentPane.add(labelUser);

        textFieldUser = new JTextField();
        textFieldUser.setFont(getFontBySize(17));
        textFieldUser.setBounds(widthFrameThird, 200, 400, 70);
        contentPane.add(textFieldUser);
        textFieldUser.setColumns(10);

        // Password
        JLabel labelPassword = new JLabel("Password");
        labelPassword.setForeground(Color.BLACK);
        labelPassword.setFont(getFontBySize(20));
        labelPassword.setBounds(widthFrameThird, 310, 100, 40);
        contentPane.add(labelPassword);


        textFieldPassword = new JPasswordField();
        textFieldPassword.setFont(getFontBySize(17));
        textFieldPassword.setBounds(widthFrameThird, 350, 400, 70);
        contentPane.add(textFieldPassword);


        JButton buttonCreateUser = new JButton("CreateUser");
        buttonCreateUser.addActionListener(e -> {
            try {
                String user = textFieldUser.getText();
                String pass = textFieldPassword.getText();

                String sql = getStringForSearchUserAndPassword(user,pass);
                ResultSet rs = getResultSetFromStatement(sql, connection);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Username already existing");

                    textFieldPassword.setText("");
                    textFieldUser.setText("");

                } else {
                    String createUser = getStringToCreateNewUser(user,pass);
                    insertStatement(createUser, connection);

                    JOptionPane.showMessageDialog(null, "Username created");

                    dispose();

                    LoginPage loginPage = new LoginPage();
                    loginPage.show();
                }


            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonCreateUser.setFont(getFontBySize(20));
        buttonCreateUser.setBounds(300, 600, 200, 60);
        contentPane.add(buttonCreateUser);

        JButton buttonResetData = new JButton("Reset data");
        buttonResetData.addActionListener(e -> {
            textFieldPassword.setText("");
            textFieldUser.setText("");
        });
        buttonResetData.setFont(getFontBySize(20));
        buttonResetData.setBounds(700, 600, 200, 60);
        contentPane.add(buttonResetData);

        //Images
        JLabel imageBackground = new JLabel("");
        imageBackground.setIcon(getBasicBackground(widthFrame,heightFrame));
        imageBackground.setBounds(0, 0, widthFrame, heightFrame);
        contentPane.add(imageBackground);
    }

}