package mainPackageGame.pages;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.sql.ResultSet;

import static mainPackageGame.extras.Fonts.*;
import static mainPackageGame.extras.Images.*;
import static mainPackageGame.extras.SQLInteractions.*;
import static mainPackageGame.extras.PredefinedStrings.*;
import static mainPackageGame.extras.ConnectionSQL.*;

public class CollectionPage extends JFrame {

    private JPanel contentPane;

    public CollectionPage(Connection connection, String username) {
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

        //Greetings
        JLabel labelUserName = new JLabel("Hello "+username + " !");
        labelUserName.setFont(getFontBySize(60));
        labelUserName.setBounds(500, 28, 400, 47);
        contentPane.add(labelUserName);


        //Choose types
        String[] typesOfPokemon = {"Fire","Water","Earth","Electric","Grass"};
        JComboBox<String> chooseList = new JComboBox<>(typesOfPokemon);
        chooseList.setBounds(400, 130, 70, 30);
        System.out.println(chooseList.getItemAt(chooseList.getSelectedIndex()));
        contentPane.add(chooseList);

        JButton buttonSearch = new JButton("Search");
        buttonSearch.addActionListener(e -> {
            try {
                String typeToSearch = (String) chooseList.getSelectedItem();



            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonSearch.setFont(getFontBySize(20));
        buttonSearch.setBounds(500, 120, 120, 50);
        contentPane.add(buttonSearch);


        JButton buttonLogout = new JButton("Homepage");
        buttonLogout.addActionListener(e -> {
            try {
                dispose(); //cerrar homepage

                HomePage hpage = new HomePage(connection,username);

                hpage.show();

            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonLogout.setFont(getFontBySize(16));
        buttonLogout.setBounds(1040, 820, 150, 40);
        contentPane.add(buttonLogout);

        //JTable table = new JTable(String[][] rowData, String[] columnNames);

        //Images
        JLabel imageBackground = new JLabel("");
        imageBackground.setIcon(getBasicBackground(widthFrame,heightFrame));
        imageBackground.setBounds(0, 0, widthFrame, heightFrame);
        contentPane.add(imageBackground);

    }

}
