package mainPackageGame.objects;

public class Pokemon {
    int id;
    String user;
    String pokeName;
    int level;


    public Pokemon(int id, String user, String pokeName, int level){
        this.id = id;
        this.user=user;
        this.pokeName=pokeName;
        this.level=level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPokeName() {
        return pokeName;
    }

    public void setPokeName(String pokeName) {
        this.pokeName = pokeName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

}
