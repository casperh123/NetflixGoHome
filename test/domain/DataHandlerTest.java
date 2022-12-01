package domain;

import data.FileHandler;
import data.FileHandlerImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

class DataHandlerTest {

    private DataHandler dataHandler;
    private FileHandler fileReader;
    private File profileIds;

    @BeforeEach
    void setUp() {
        dataHandler = new DataHandler();
        fileReader = new FileHandlerImpl();
        profileIds = new File("lib/profiles/profileIds.txt");
    }

    @AfterEach
    void tearDown() {
        dataHandler = null;
        fileReader = null;
        profileIds = null;
    }

    @Test
    void assembleMediaList() {

        List<Media> allMediaList;

        try {
            allMediaList = dataHandler.assembleMediaList();
        } catch(IOException | IllegalArgumentException e) {
            //TODO appropriate
            System.out.println("Fuck");
            allMediaList = null;
        }

        if (allMediaList == null) {
            assert(false);
        } else {
            //TODO Sys.out.println
            for(Media movie : allMediaList) {
                System.out.println(movie);
            }
            assert(allMediaList.size() == 200);
        }
    }

    @Test
    void assembleMovieList() {

        List<Media> movieList;

        try {
            movieList = dataHandler.assembleMovieList();
        } catch(IOException | IllegalArgumentException e) {
            //TODO appropriate
            System.out.println("Fuck");
            movieList = null;
        }

        if (movieList == null) {
            assert(false);
        } else {
            //TODO Sys.out.println
            for(Media movie : movieList) {
                System.out.println(movie);
            }
            assert(movieList.size() == 100);
        }
    }

    @Test
    void assembleSeriesList() {

        List<Media> seriesList;

        try {
            seriesList = dataHandler.assembleSeriesList();
        } catch(IOException | IllegalArgumentException e) {
            //TODO appropriate
            System.out.println("Fuck");
            seriesList = null;
        }

        if (seriesList == null) {
            assert(false);
        } else {
            //TODO Sys.out.println
            for(Media movie : seriesList) {
                System.out.println(movie);
            }
            assert(seriesList.size() == 100);
        }
    }

    @Test
    void assembleProfileMap() {

        Map<Integer, Profile> profileMap;
        int profilesAmount;

        try {
            profilesAmount = fileReader.loadFile(new File("lib/profiles/profileIds.txt")).size();
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
    }

    @Test
    void saveProfileMap() {
    }

    @Test
    void saveFavoritesToProfile() {
    }
}