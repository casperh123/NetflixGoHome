package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ProfileCollection {

    private DataHandler profileListManager;
    private Map<Integer, Profile> profileMap;

    public ProfileCollection(Map<Integer, Profile> profiles) {
        this.profileMap = profiles;
    }

    public void createProfile(int id, String name, ArrayList<String> favorites) {

        Profile newProfile = new Profile(id, name, favorites);

        //push new profile to the Map.
        profileMap.merge(newProfile.getId(), newProfile, (a, b) -> a = b);

        //save the profile and newly modified profileMap to disc.
        try {
            profileListManager.saveProfile(newProfile);
            profileListManager.saveProfileMap(profileMap);
        } catch(IOException e) {
            //TODO Proper exception handling
            System.out.println("Fuck");
        }
    }
    public void createProfile(String name) {
        throw new UnsupportedOperationException();
    }

    public void deleteProfile(int id) {
        throw new UnsupportedOperationException();
    }

}
