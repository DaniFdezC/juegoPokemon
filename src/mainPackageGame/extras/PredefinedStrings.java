package mainPackageGame.extras;

public class PredefinedStrings {

    public static String getStringForSearchUserAndPassword (String user, String password){
        String sql = "" +
                "CALL searchUserAndPassword(" +
                '"'+user+'"'+","+
                '"'+password+'"'+
                ")";
        return sql;
    }

    public static String getStringToCreateNewUser (String user, String password){
        String sql = "" +
                "CALL createUser(" +
                '"'+user+'"'+","+
                '"'+password+'"'+
                ")";
        return sql;
    }
}
