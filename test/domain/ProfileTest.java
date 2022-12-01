package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProfileTest {

    @BeforeEach

    @AfterEach

    @Test
    void addToFavoriteList() {
        String mediaName = "Spider-Man";
        List<String> list = new ArrayList<>();
        Profile profile = new Profile(1, "bob", list);

        profile.addToFavorite(mediaName);

        assert(list.size() == 1 && list.contains(mediaName));
    }

    @Test
    void removeFromFavoriteList() {
        String mediaName = "Spider-Man";
        List<String> list = new ArrayList<>();
        Profile profile = new Profile(1, "bob", list);

        profile.addToFavorite(mediaName);
        assertTrue(list.size() == 1 && list.contains(mediaName));

        profile.removeFromFavorite(mediaName);
        assertEquals(0, list.size());
    }

    @Test
    void setName() {
        Profile profile = new Profile(1, "Bob", new ArrayList<>());
        profile.setName("Jan");
        assertEquals("Jan", profile.getName());
    }

    @Test
    void profileInfoFormatterTest() {
        Profile profile = new Profile(1, "Bob", new ArrayList<>());
        profile.addToFavorite("Spider-Man");
        profile.addToFavorite("Back to the future");

        profile.profileInfoFormatter();

        assertEquals(profile.profileInfoFormatter().get(0), String.valueOf(1));
        assertEquals(profile.profileInfoFormatter().get(1), "Bob");
        assertEquals(profile.profileInfoFormatter().get(2), "Spider-Man");
        assertEquals(profile.profileInfoFormatter().get(3), "Back to the future");
    }

    //TODO Test with fixed separator
    @Test
    void testToString() {
        Profile profile = new Profile(1, "Bob", new ArrayList<>());
        profile.addToFavorite("Spider-Man");
        profile.addToFavorite("Back to the future");

        assertEquals(profile.toString(), "Id: 1 Name: Bob Favorites: Spider-Man, Back to the future, ");
    }
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
}
