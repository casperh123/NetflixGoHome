package domain;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class MediaCollection {

    private DataHandler mediaListManager;
    private List<Media> media;
    private String genre;

    public MediaCollection() throws IOException {
        mediaListManager = new DataHandler();
        media = mediaListManager.assembleMediaList();
        genre = null;
    }
    public MediaCollection sortByGenre(String genre) throws IOException {
        MediaCollection newCollection = new MediaCollection();
        for (Media media : media) {
            if (media.genres.contains(genre)) {
                newCollection.media.add(media);
            }
        }
        return newCollection;
    }
    public MediaCollection sortByName(List<String> chosenMedia) {
        throw new UnsupportedOperationException();
    }
    public void sortByRating() {
        throw new UnsupportedOperationException();
    }
    public void sortByReleaseYear() {
        throw new UnsupportedOperationException();
    }
    public MediaCollection sortByAlphabetical() throws IOException {
        throw new UnsupportedOperationException();
    }

}
