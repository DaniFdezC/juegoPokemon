package mainPackageGame.pages;

import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.sql.*;

import static mainPackageGame.extras.Fonts.*;
import static mainPackageGame.extras.Images.*;
import static mainPackageGame.extras.SQLInteractions.*;
import static mainPackageGame.extras.PredefinedStrings.*;
import static mainPackageGame.extras.ConnectionSQL.*;

public class LoginPage extends JFrame {

    private final JPanel contentPane;
    private final JTextField textFieldUser;
    private final JPasswordField textFieldPassword;
    private String user;
    private String password;


    public LoginPage() {
        int widthFrame = 1200;
        double doubleWidthFrameThird = widthFrame/3;
        int widthFrameThird = (int) doubleWidthFrameThird;

        int heightFrame = 900;
        Connection connection = getConnection("pruebasprogramacion_pokemon","root","");

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


        //Buttons
        JButton buttonLogin = new JButton("Login");
        buttonLogin.addActionListener(e -> {
            try {
                user = textFieldUser.getText();
                password = textFieldPassword.getText();

                String sql = getStringForSearchUserAndPassword(user, password);
                ResultSet rs = getResultSetFromStatement(sql,connection);

                if (rs.next()) {
                    System.out.println("Se ha hecho login el usuario "+user);
                    dispose();

                    HomePage hpage = new HomePage(connection,user);
                    hpage.show();

                } else {
                    JOptionPane.showMessageDialog(null, "Username or password wrong");

                    textFieldPassword.setText("");
                    textFieldUser.setText("");

                }


            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonLogin.setFont(getFontBySize(20));
        buttonLogin.setBounds(299, 600, 200, 60);
        contentPane.add(buttonLogin);

        JButton buttonCreateUser = new JButton("Create user");
        buttonCreateUser.addActionListener(e -> {
            CreateUserPage createUserPage = new CreateUserPage(connection);
            createUserPage.show();
            dispose();

        });
        buttonCreateUser.setFont(getFontBySize(20));
        buttonCreateUser.setBounds(500, 600, 200, 60);
        contentPane.add(buttonCreateUser);

        JButton buttonResetData = new JButton("Reset data");
        buttonResetData.addActionListener(e -> {
            textFieldPassword.setText("");
            textFieldUser.setText("");
        });
        buttonResetData.setFont(getFontBySize(20));
        buttonResetData.setBounds(701, 600, 200, 60);
        contentPane.add(buttonResetData);


        //Images
        JLabel imageBackground = new JLabel("");
        imageBackground.setIcon(getBasicBackground(widthFrame,heightFrame));
        imageBackground.setBounds(0, 0, widthFrame, heightFrame);
        contentPane.add(imageBackground);


    }

    public static Connection getConnection(String database, String usernameDatabase, String passwordUsernameDatabase){
        Connection con = null;

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+database+"?useSSL=false",usernameDatabase,passwordUsernameDatabase);

        }  catch (Exception e1){
            System.out.println(e1.getMessage());
        }

        return con;
    }
}