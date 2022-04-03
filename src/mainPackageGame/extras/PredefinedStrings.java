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

    public static String getStringToSearchPokemonUserAndType (String user, String type){
        String sql = "" +
                "CALL searchPokemonsOfATypeAndUser\t(" +
                '"'+user+'"'+","+
                '"'+type+'"'+
                ")";
        return sql;
    }

    public static String[] getStringNamesOfColumns(){
        return new String[]{"id", "user", "pokemon", "level"};
    }
}
