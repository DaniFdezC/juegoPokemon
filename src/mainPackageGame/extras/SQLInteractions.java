package mainPackageGame.extras;

import java.sql.*;

public class SQLInteractions {


    public static ResultSet getResultSetFromStatement(String sql, Connection connection){
        ResultSet rs = null;
        try {
            Statement stm = connection.createStatement();
            rs = stm.executeQuery(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return rs;
    }

    public static void insertStatement(String sql, Connection connection){
        try {
            PreparedStatement preparedStmt = connection.prepareStatement(sql);
            preparedStmt.execute();
        } catch (Exception e) {
            System.err.println("EXCEPTION insert "+e.getMessage());
        }
    }


}
