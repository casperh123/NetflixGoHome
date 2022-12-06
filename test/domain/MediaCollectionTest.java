package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;

class MediaCollectionTest {

    private MediaCollection testCollection;

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
        List<String> nameList = new ArrayList<>();
        nameList.add("Family Ties");
        System.out.println(testCollection.getCollectionByName(nameList).getMedia().get(0));
    }

    @Test
    void sortByRating() {
        System.out.println(testCollection.getMedia().get(0) + " rating: " + testCollection.getMedia().get(0).getRating());
        testCollection.sortByRating();
        System.out.println(testCollection.getMedia().get(0) + " rating: " + testCollection.getMedia().get(0).getRating());
        testCollection.sortByReverseRating();
        System.out.println(testCollection.getMedia().get(0) + " rating: " + testCollection.getMedia().get(0).getRating());
    }

    @Test
    void sortByReleaseYear() {
        System.out.println(testCollection.getMedia().get(0));
        testCollection.sortByReleaseYear();
        System.out.println(testCollection.getMedia().get(0));
        testCollection.sortByReverseReleaseYear();
        System.out.println(testCollection.getMedia().get(0));
    }

    @Test
    void sortByAlphabetical() {
        try {
            MediaCollection baseCollection = new MediaCollection();
            System.out.println(testCollection.getMedia().get(0));
            testCollection.sortByAlphabetical();
            System.out.println(testCollection.getMedia().get(0));
            testCollection.sortByReverseAlphabetical();
            System.out.println(testCollection.getMedia().get(0));
            //TODO better assertion
            assert (testCollection.getMedia().get(0) != baseCollection.getMedia().get(0));
        } catch (IOException e) {
            fail("baseCollection could not be instantiated");
        }
    }
}