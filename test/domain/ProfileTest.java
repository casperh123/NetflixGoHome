package domain;

import data.FileHandler;
import data.FileHandlerImpl;
import exceptions.MediaAlreadyInArrayException;
import exceptions.MediaNotInArrayException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

public class ProfileTest {

    private DataHandler dataHandler;
    private FileHandler fileHandler;
    private File testProfileFile;
    private ProfileCollection profileCollection;
    private

    @BeforeEach
    void setUp() {
        dataHandler = new DataHandler();
        fileHandler = new FileHandlerImpl();
        profileCollection = new ProfileCollection();
        testProfileFile = new File("lib/profiles/1026245.txt");
    }

    @AfterEach
    void tearDown() {
        dataHandler = null;
        testProfileFile = null;
    }

    @Test
    void addToFavoriteList() {

        List<String> loadedProfile = null;
        List<String> favorites = new ArrayList<>();
        List<String> loadedFavorites = new ArrayList<>();
        Profile profile;

        try {
            loadedProfile = fileHandler.loadFile(testProfileFile);
        } catch (IOException e) {
            fail("testProfile could not be loaded");
        }

        for (int i = 0; i < loadedProfile.size(); i++) {
            if(i > 1) {
                favorites.add(loadedProfile.get(i));
            }
        }

        profile = new Profile(1026245, "GENERIC", favorites);

        favorites = new ArrayList<>(favorites);

        for (int i = 0; i < 5; i++) {

            String randomMedia = stringGenerator(25);

            favorites.add(randomMedia);

            try {
                profile.addToFavorite(randomMedia);
            } catch (MediaAlreadyInArrayException | IOException e) {
                System.out.println(e.getMessage());
                fail("Could not save to favorite");
            }
        }

        try {
            loadedProfile = fileHandler.loadFile(testProfileFile);
        } catch (IOException e) {
            fail("Could not load profile for the second time");
        }

        for (int i = 0; i < loadedProfile.size(); i++) {
            if(i > 1) {
                loadedFavorites.add(loadedProfile.get(i));
            }
        }

        for(String favorite : favorites) {
            assert(loadedFavorites.contains(favorite));
        }
    }

    @Test
    void removeFromFavoriteList() {

        Profile testProfile = profileCollection.getProfile(10123761);
        List<String> loadedData;

        try{
            testProfile.addToFavorite("Spider-Man");
            loadedData = fileHandler.loadFile(new File("lib/profiles/10123761.txt"));
            assert(testProfile.getFavorites().contains("Spider-Man"));
            assert(loadedData.contains("Spider-Man"));
        } catch (IOException e) {
            fail("Could not save to favorite");
        } catch (MediaAlreadyInArrayException e) {
            fail(e.getMessage());
        }

        try {
            testProfile.removeFromFavorite("Spider-Man");
            loadedData = fileHandler.loadFile(new File("lib/profiles/10123761.txt"));
            assert(!testProfile.getFavorites().contains("Spider-Man"));
            assert(!loadedData.contains("Spider-Man"));
        } catch (MediaNotInArrayException e) {
            fail(e.getMessage());
        } catch (IOException e) {
            fail("Could not load profile file");
        }
    }

    @Test
    void setName() {

        Profile testProfile = profileCollection.getProfile(10123761);
        String randomName = stringGenerator(40);

        testProfile.setName(randomName);

        testProfile = new ProfileCollection().getProfile(10123761);

        assert(testProfile.getName().equals(randomName));
    }

    private String stringGenerator(int size) {

        String randomString = "";
        String lowercaseAlphabet = "abcdefghijklmn";

        for (int i = 0; i < size; i++) {
            int index = (int)(lowercaseAlphabet.length() * Math.random());
            randomString += lowercaseAlphabet.charAt(index);
        }

        return randomString;

    }
}