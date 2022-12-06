package domain;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ProfileCollection {

    private DataHandler dataHandler;
    private Map<Integer, Profile> profileMap;

    public ProfileCollection() {
        this.dataHandler = new DataHandler();
        try {
            this.profileMap = dataHandler.assembleProfileMap();
        } catch (IOException e) {
            profileMap = null;
            System.out.println("Profiles could not be loaded");
        }
    }

    public void createProfile(int id, String name, List<String> favorites) throws IOException {

        Profile newProfile = new Profile(id, name, favorites);

        //push new profile to the Map.
        profileMap.merge(newProfile.getId(), newProfile, (a, b) -> a = b);

        //save the profile and newly modified profileMap to disc.
        dataHandler.saveProfile(newProfile);
        dataHandler.saveProfileMap(profileMap);
    }

    public void deleteProfile(int id) throws IOException {

        profileMap.remove(id);
        dataHandler.saveProfileMap(profileMap);

    }

    public Profile getProfile(int id) {
        return profileMap.get(id);
    }

}
