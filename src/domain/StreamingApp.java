package domain;

import java.io.IOException;

public class StreamingApp {

    private MediaCollection media;
    private ProfileCollection profiles;
    private Profile activeProfile;
    public StreamingApp() throws IOException {
        media = new MediaCollection();
        profiles = new ProfileCollection();
    }

    public MediaCollection getMedia() {
        return media;
    }

    public ProfileCollection getProfiles() {
        return profiles;
    }

    public void setActiveProfile(Profile activeProfile) {
        this.activeProfile = activeProfile;
    }

    public void playPauseMedia() {
        throw new UnsupportedOperationException();
    }
}
