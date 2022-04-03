package mainPackageGame.pages;

import mainPackageGame.objects.Pokemon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.util.LinkedList;

import static mainPackageGame.extras.Fonts.*;
import static mainPackageGame.extras.Images.*;
import static mainPackageGame.extras.SQLInteractions.*;
import static mainPackageGame.extras.PredefinedStrings.*;
import static mainPackageGame.extras.ConnectionSQL.*;

public class CollectionPage extends JFrame {

    private JPanel contentPane;

    public CollectionPage(Connection connection, String user) {
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
        JLabel labelUserName = new JLabel("Hello "+user + " !");
        labelUserName.setFont(getFontBySize(60));
        labelUserName.setBounds(500, 28, 400, 47);
        contentPane.add(labelUserName);


        //Choose types
        String[] typesOfPokemon = {"Fire","Water","Earth","Electric","Grass"};
        JComboBox<String> chooseList = new JComboBox<>(typesOfPokemon);
        chooseList.setBounds(400, 130, 70, 30);
        System.out.println(chooseList.getItemAt(chooseList.getSelectedIndex()));
        contentPane.add(chooseList);


        //Table
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(getStringNamesOfColumns());
        JTable jTable = new JTable();
        jTable.setFont(getFontBySize(16));
        jTable.setModel(model);
        jTable.setBounds(300, 300, 600, 40);
        contentPane.add(jTable);


        // ------------------- Buttons ------------------- //
        JButton buttonSearch = new JButton("Search");
        buttonSearch.addActionListener(e -> {
            try {
                model.setRowCount(0); //reset the data before adding new
                String[] header = new String[]{"ID", "User", "Pokemon", "Level"};
                model.addRow(header);

                String typeToSearch = (String) chooseList.getSelectedItem();
                String sql = getStringToSearchPokemonUserAndType(user,typeToSearch);
                ResultSet rs = getResultSetFromStatement(sql, connection);

                while (rs.next()){
                    int id = rs.getInt("id");
                    String userPoke = rs.getString("user");
                    String pokeName = rs.getString("pokemon");
                    int level = rs.getInt("level");

                    String[] data = new String[]{String.valueOf(id), userPoke, pokeName, String.valueOf(level)};
                    model.addRow(data);

                }

            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonSearch.setFont(getFontBySize(20));
        buttonSearch.setBounds(500, 120, 120, 50);
        contentPane.add(buttonSearch);


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
        imageBackground.setIcon(getBasicBackground(widthFrame,heightFrame));
        imageBackground.setBounds(0, 0, widthFrame, heightFrame);
        contentPane.add(imageBackground);

    }
}
