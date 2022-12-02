package domain;

import data.FileHandler;
import data.FileHandlerImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DataHandlerTest {

    private DataHandler dataHandler;
    private FileHandler fileHandler;
    private File profileIds;

    @BeforeEach
    void setUp() {
        dataHandler = new DataHandler();
        fileHandler = new FileHandlerImpl();
        profileIds = new File("lib/profiles/profileIds.txt");
    }

    @AfterEach
    void tearDown() {
        dataHandler = null;
        fileHandler = null;
        profileIds = null;
    }

    @Test
    void assembleMediaList() {

        List<Media> mediaList;

        try {
            mediaList = dataHandler.assembleMediaList();
        } catch(IOException | IllegalArgumentException e) {
            mediaList = null;
        }

        if (mediaList == null) {
            assert(false);
        } else {
            assert(mediaList.size() == 200);
        }
    }

    //Done
    @Test
    void assembleMovieList() {

        List<Media> movieList;

        try {
            movieList = dataHandler.assembleMovieList();
        } catch(IOException | IllegalArgumentException e) {
            movieList = null;
        }

        for(Media media : movieList) {
            System.out.println(media.toString());
        }
        if (movieList == null) {
            assert(false);
        } else {
            assert(movieList.size() == 100);
        }
    }

    //Done
    @Test
    void assembleSeriesList() {

        List<Media> seriesList;

        try {
            seriesList = dataHandler.assembleSeriesList();
        } catch(IOException | IllegalArgumentException e) {
            seriesList = null;
        }

        for(Media media : seriesList) {
            System.out.println(media.toString());
        }

        if (seriesList == null) {
            assert(false);
        } else {
            assert(seriesList.size() == 100);
        }
    }

    @Test
    void assembleProfileMap() {

        Map<Integer, Profile> profileMap;
        int profilesAmount;

        try {
            profilesAmount = fileHandler.loadFile(new File("lib/profiles/profileIds.txt")).size();
            profileMap = dataHandler.assembleProfileMap();
        } catch (IOException e) {
            profileMap = null;
            profilesAmount = 0;
        }

        if (profileMap == null) {
            assert(false);
        } else {
            assert(profileMap.keySet().size() == profilesAmount );
        }
    }

    @Test
    void saveProfile() {

        int testId = 1026245;
        String profileName = stringGenerator(10);
        List<String> testFavorites = new ArrayList<>();
        List<String> loadedProfileData;

        for (int i = 0; i < 50; i++) {
            testFavorites.add(stringGenerator(15));
        }

        Profile testProfile = new Profile(testId, profileName, testFavorites);

        try {
            dataHandler.saveProfile(testProfile);
            loadedProfileData = fileHandler.loadFile(new File("lib/profiles/1026245.txt"));
        } catch (IOException e) {
            loadedProfileData = null;
        }

        if(loadedProfileData == null) {
            assert(false);
        } else {
            for (int i = 0; i < loadedProfileData.size(); i++) {
                if(i == 0) {
                    assertEquals(Integer.parseInt(loadedProfileData.get(i)), testId);
                } else if (i == 1) {
                    assertEquals(loadedProfileData.get(i), profileName);
                } else {
                    assertEquals(loadedProfileData.get(i), testFavorites.get(i - 2));
                }
            }
        }
    }

    @Test
    void saveProfileMap() {
    }

    @Test
    void saveFavoritesToProfile() {
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