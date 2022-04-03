package mainPackageGame.pages;

import mainPackageGame.pages.locations.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.sql.Connection;

import static mainPackageGame.extras.Fonts.getFontBySize;
import static mainPackageGame.extras.Images.*;

public class ChooseCatchingPage extends JFrame {

    private JPanel contentPane;

    public ChooseCatchingPage(Connection connection, String user) {
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

        //homepage
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
        buttonHomepage.setBounds(0, 0, 1200, 50);
        contentPane.add(buttonHomepage);

        JButton buttonSea = new JButton("Sea");
        buttonSea.setIcon(getImageLocation("sea",true,600,400));
        buttonSea.addActionListener(e -> {
            try {
                dispose(); //cerrar homepage

                SeaPage seaPage = new SeaPage(connection,user);

                seaPage.show();

            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonSea.setBounds(0, 50, 600, 400);
        buttonSea.setBorderPainted(false);
        contentPane.add(buttonSea);

        JButton buttonVolcano = new JButton("Volcano");
        buttonVolcano.setIcon(getImageLocation("volcano",true,600,400));
        buttonVolcano.addActionListener(e -> {
            try {
                dispose(); //cerrar homepage

                VolcanoPage volcanoPage = new VolcanoPage(connection,user);

                volcanoPage.show();

            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonVolcano.setBounds(600, 50, 600, 400);
        buttonVolcano.setBorderPainted(false);
        contentPane.add(buttonVolcano);

        JButton buttonPlains = new JButton("Plains");
        buttonPlains.setIcon(getImageLocation("plains",true,400,450));
        buttonPlains.addActionListener(e -> {
            try {
                dispose(); //cerrar homepage

                PlainsPage plainsPage = new PlainsPage(connection,user);

                plainsPage.show();

            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonPlains.setBounds(0, 450, 400, 450);
        buttonPlains.setBorderPainted(false);
        contentPane.add(buttonPlains);

        JButton buttonPowerPlant = new JButton("PowerPlant");
        buttonPowerPlant.setIcon(getImageLocation("powerplant",false,400,450));
        buttonPowerPlant.addActionListener(e -> {
            try {
                dispose(); //cerrar homepage

                PowerplantPage powerplantPage = new PowerplantPage(connection,user);

                powerplantPage.show();

            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonPowerPlant.setBounds(400, 450, 400, 450);
        buttonPowerPlant.setBorderPainted(false);
        contentPane.add(buttonPowerPlant);

        JButton buttonDesert = new JButton("Desert");
        buttonDesert.setIcon(getImageLocation("desert",true,400,450));
        buttonDesert.addActionListener(e -> {
            try {
                dispose(); //cerrar homepage

                DesertPage desertPage = new DesertPage(connection,user);

                desertPage.show();

            } catch (Exception e1){
                System.out.println(e1.getMessage());
            }
        });
        buttonDesert.setBounds(800, 450, 400, 450);
        buttonDesert.setBorderPainted(false);
        contentPane.add(buttonDesert);


    }
}
