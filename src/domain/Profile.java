package domain;
import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name;
    private List<String> favorites;
    private int id;
    private static int idCounter = 1;

    public Profile(String name) {
        id = idCounter;
        this.name = name;
        favorites = new ArrayList<String>();
        idCounter++;
    }

    void addToFavorite(String mediaName) {
        favorites.add(mediaName);
    }

    void deleteFromFavorite(String mediaName) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
