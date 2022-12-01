package domain;
import java.util.ArrayList;

public class MediaCollection {

    private DataHandler mediaListManager;
    private List<Media> media;
    private String genre;

    public MediaCollection() throws IOException {
        mediaListManager = new DataHandler();
        media = mediaListManager.assembleMediaList();
        genre = null;
    }
    public MediaCollection sortByGenre(String genre) throws IOException{
        MediaCollection newCollection = new MediaCollection();
        for (Media media : media) {
            if (media.genres.contains(genre)) {
                newCollection.media.add(media);
            }
        }
        return newCollection;
    }

    public void sortByRating() {
        throw new UnsupportedOperationException();
    }
    public void sortByReleaseYear() {
        throw new UnsupportedOperationException();
    }
    public void sortByAlphabetical() {
        throw new UnsupportedOperationException();
    }
}
