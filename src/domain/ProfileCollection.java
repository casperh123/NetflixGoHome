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
    //TODO Check CurrentID works as intended
    private int currentID;

    //TODO Throw FileNotLoadedException?
    public ProfileCollection() throws FileNotLoadedException {
        this.dataHandler = new DataHandler();
        this.profileMap = dataHandler.assembleProfileMap();
        this.currentID = getMaxID() + 1;
    }

    //TODO FileNotSavedException?
    public void createProfile(String name, List<String> favorites) throws FileNotSavedException {

        Profile newProfile = new Profile(this.currentID ,name, favorites);

        //Iterate CurrentID
        currentID++;

        //push new profile to the Map.
        profileMap.merge(newProfile.getId(), newProfile, (a, b) -> a = b);

        //save the profile and newly modified profileMap to disc.
        dataHandler.saveProfile(newProfile);
        dataHandler.saveProfileMap(profileMap);
    }

    public void createProfile(String name, List<String> favorites, boolean testMethod) throws FileNotSavedException {

        Profile newProfile = new Profile(this.currentID ,name, favorites);

        //Iterate CurrentID
        currentID++;

        //push new profile to the Map.
        profileMap.merge(newProfile.getId(), newProfile, (a, b) -> a = b);

        //save the profile and newly modified profileMap to disc.
        if(!testMethod)
        {
            dataHandler.saveProfile(newProfile);
            dataHandler.saveProfileMap(profileMap);
        }
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

    private int getMaxID() {
        int highestID = Integer.MIN_VALUE;
        for (int ID : profileMap.keySet()) {
            if (ID >= highestID) {
                highestID = ID;
            }
        }
        return highestID;
    }

}
