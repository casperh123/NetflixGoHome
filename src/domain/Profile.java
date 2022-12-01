package domain;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name;
    private List<String> favorites;
    private int id;
    private static int idCounter = 1;
    private File profile;

    public Profile(String name) {
        id = idCounter;
        this.name = name;
        favorites = new ArrayList<String>();
        idCounter++;
        profile = new File("NetflixGoHome/lib/profiles" + File.separator + id + ".txt");
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
