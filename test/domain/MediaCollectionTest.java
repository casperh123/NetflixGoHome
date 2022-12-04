package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

class MediaCollectionTest {

    MediaCollection testCollection = null;

    @BeforeEach
    void setUp() {
        try {
            testCollection = new MediaCollection();
        } catch (IOException e) {
            fail("testCollection could not be instantiated");
        }
    }

    @AfterEach
    void tearDown() {
        testCollection = null;
    }

    @Test
    void sortByGenre() {
    }

    @Test
    void sortByName() {
    }

    @Test
    void sortByRating() {
    }

    @Test
    void sortByReleaseYear() {
    }

    @Test
    void sortByAlphabetical() {
        try {
            MediaCollection baseCollection = new MediaCollection();
            System.out.println(testCollection.getMedia().get(0));
            testCollection.sortByAlphabetical();
            System.out.println(testCollection.getMedia().get(0));
            //TODO better assertion
            assert (testCollection.getMedia().get(0) != baseCollection.getMedia().get(0));
        } catch (IOException e) {
            fail("baseCollection could not be instantiated");
        }
    }
}