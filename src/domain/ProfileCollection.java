package domain;
import java.io.File;
import java.util.ArrayList;
import java.util.Map;

public class ProfileCollection {

    private DataHandler profileListManager;
    private Map<Integer, Profile> profileMap;

    public void createProfile(int id, String name, ArrayList<String> favorites) {
        Profile profile = new Profile(id, name, favorites);
        File profileFile = new File("lib/profiles" + File.separator + id + ".txt");
    }

    public void deleteProfile(int id) {
        throw new UnsupportedOperationException();
    }

    public void editProfileName(String name) {
        throw new UnsupportedOperationException();
    }
}
