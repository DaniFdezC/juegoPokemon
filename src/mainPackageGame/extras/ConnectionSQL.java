package mainPackageGame.extras;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionSQL {
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
