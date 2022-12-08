package domain;

import exceptions.FileNotLoadedException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

class ProfileCollectionTest {

    private ProfileCollection profileCollection;

    @BeforeEach
    void setUp() {
        try {
            profileCollection = new ProfileCollection();
        } catch (FileNotLoadedException e) {
            fail(e.getMessage());
        }
    }

    @AfterEach
    void tearDown() {
        profileCollection = null;
    }

    @Test
    void createProfile() {
    }

    @Test
    void deleteProfile() {
    }
}