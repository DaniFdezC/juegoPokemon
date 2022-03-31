package mainPackageGame.pages;

import mainPackageGame.objects.Pokemon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;
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
    private LinkedList<Pokemon> listForPokemonRelation = new LinkedList<>();

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

        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(getColumnsNames());

        JTable jTable = new JTable();
        jTable.setFont(getFontBySize(16));
        jTable.setModel(model);
        jTable.setBounds(300, 300, 600, 40);
        contentPane.add(jTable);


        JButton buttonSearch = new JButton("Search");
        buttonSearch.addActionListener(e -> {

            try {
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
                    
                    listForPokemonRelation.add(new Pokemon(id,userPoke,pokeName,level));

                }


                System.out.println("YA HE DADO AL BOTON");
                //contentPane.repaint();
                System.out.println("DEBERIA HABER REPINTADO");

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

                HomePage hpage = new HomePage(connection,user);

                hpage.show();

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

    public String[] getColumnsNames(){
        return new String[]{"id", "user", "pokemon", "level"};
    }

    public String[][] getDataOfPokemons(){
        int sizeListPokemon = listForPokemonRelation.size();
        String[][] arrayData = new String[sizeListPokemon][4];

        for (int i = 0 ; i < sizeListPokemon; i++){
            arrayData[i][0] = String.valueOf(listForPokemonRelation.get(i).getId());
            arrayData[i][1] = listForPokemonRelation.get(i).getUser();
            arrayData[i][2] = listForPokemonRelation.get(i).getPokeName();
            arrayData[i][3] = String.valueOf(listForPokemonRelation.get(i).getLevel());
        }

        return arrayData;
    }

}
