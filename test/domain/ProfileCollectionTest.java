package domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ProfileCollectionTest {

    private ProfileCollection profileCollection;

    @BeforeEach
    void setUp() {
        profileCollection = new ProfileCollection();
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