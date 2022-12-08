package domain;

import exceptions.FileNotLoadedException;
import exceptions.FileNotSavedException;

import java.io.File;
import java.util.List;
import java.util.Map;

public class ProfileCollection {

    private DataHandler dataHandler;
    private Map<Integer, Profile> profileMap;
    private Profile activeProfile;

    //TODO Throw FileNotLoadedException?
    public ProfileCollection() throws FileNotLoadedException {
        this.dataHandler = new DataHandler();
        this.profileMap = dataHandler.assembleProfileMap();
    }

    //TODO FileNotSavedException?
    public void createProfile(int id, String name, List<String> favorites) throws FileNotSavedException {

        Profile newProfile = new Profile(id, name, favorites);

        //push new profile to the Map.
        profileMap.merge(newProfile.getId(), newProfile, (a, b) -> a = b);

        //save the profile and newly modified profileMap to disc.
        dataHandler.saveProfile(newProfile);
        dataHandler.saveProfileMap(profileMap);
    }

    public boolean deleteProfile(int id) throws FileNotSavedException {

        File profileFile = new File("lib/profiles/" + id + ".txt");
        //TODO ?Que pasa Exeptioooon?
        if(profileFile.delete()) {
            profileMap.remove(id);
            dataHandler.saveProfileMap(profileMap);
            return true;
        }
        return false;
    }

    public void setActiveProfile(int id) {
        activeProfile = profileMap.get(id);
    }

    public Profile getActiveProfile() {
        return activeProfile;
    }

    public Profile getProfile(int id) {
        return profileMap.get(id);
    }

}
