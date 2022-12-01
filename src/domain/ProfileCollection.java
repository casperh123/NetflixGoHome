package domain;
import java.util.Map;

public class ProfileCollection {

    private DataHandler profileListManager;
    private Map<Integer, Profile> profileMap;

    public void createProfile(String name) {
        Profile profile = new Profile(name);
    }

    public void deleteProfile(int id) {
        throw new UnsupportedOperationException();
    }

    public void editProfileName(String name) {
        throw new UnsupportedOperationException();
    }
}
