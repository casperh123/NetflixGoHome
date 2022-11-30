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
    void assembleMovieList() {

        List<Media> movieList;

        try {
            movieList = dataHandler.assembleMovieList();
        } catch(IOException | IllegalArgumentException e) {
            //TODO appropriate
            System.out.println("Fuck");
            movieList = new ArrayList<>();
        }

        for(Media movie : movieList) {
            System.out.println(movie);
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
            seriesList = new ArrayList<>();
        }

        for(Media series : seriesList) {
            System.out.println(series);
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