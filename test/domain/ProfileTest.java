package domain;

import data.FileHandler;
import data.FileHandlerImpl;
import exceptions.MediaAlreadyInArrayException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {

    private DataHandler dataHandler;
    private FileHandler fileHandler;
    private File testProfileFile;
    private

    @BeforeEach
    void setUp() {
        dataHandler = new DataHandler();
        fileHandler = new FileHandlerImpl();
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

    //TODO Refactor test to accommodate persistence;
    /*@Test
    void removeFromFavoriteList() {
        String mediaName = "Spider-Man";
        List<String> list = new ArrayList<>();
        Profile profile = new Profile(1, "bob", list);

        try{
            profile.addToFavorite(mediaName);
        } catch (IOException e) {
            fail("Could not save to favorite");
        } catch (MediaAlreadyInArrayException e) {
            fail(e.getMessage());
        }

        assertTrue(list.size() == 1 && list.contains(mediaName));

        profile.removeFromFavorite(mediaName);
        assertEquals(0, list.size());
    }*/

    @Test
    void setName() {
        Profile profile = new Profile(1, "Bob", new ArrayList<>());
        profile.setName("Jan");
        assertEquals("Jan", profile.getName());
    }

    /*@Test
    void profileInfoFormatterTest() {
        Profile profile = new Profile(1, "Bob", new ArrayList<>());
        profile.addToFavorite("Spider-Man");
        profile.addToFavorite("Back to the future");

        profile.profileInfoFormatter();

        assertEquals(profile.profileInfoFormatter().get(0), String.valueOf(1));
        assertEquals(profile.profileInfoFormatter().get(1), "Bob");
        assertEquals(profile.profileInfoFormatter().get(2), "Spider-Man");
        assertEquals(profile.profileInfoFormatter().get(3), "Back to the future");
    }*/

    //TODO Test with fixed separator
   /* @Test
    void testToString() {
        Profile profile = new Profile(1, "Bob", new ArrayList<>());
        profile.addToFavorite("Spider-Man");
        profile.addToFavorite("Back to the future");

        assertEquals(profile.toString(), "Id: 1 Name: Bob Favorites: Spider-Man, Back to the future, ");
    }*/
    @Test
    void getPath() {
    }
    @Test
    void getName() {
    }

    @Test
    void getId() {
    }

    @Test
    void getFavorites() {
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
