package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class DataHandlerTest {

    private DataHandler dataHandler;

    @BeforeEach
    void setUp() {
        dataHandler = new DataHandler();
    }

    @AfterEach
    void tearDown() {
        dataHandler = null;
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
            assert(allMediaList.size() == 100);
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