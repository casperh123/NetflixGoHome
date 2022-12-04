package domain;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
<<<<<<< HEAD
    public MediaCollection sortByGenre(String genre) throws IOException {
        MediaCollection newCollection = new MediaCollection();
=======
    public MediaCollection(String genre) throws IOException {
        mediaListManager = new DataHandler();
        media = mediaListManager.assembleMediaList();
        this.genre = genre;
    }
    public MediaCollection sortByGenre(String genre) throws IOException{
        MediaCollection sortedCollection = new MediaCollection(genre);
        // For the object "media" of type Media in the list "media", where the list is a field for MediaCollection
>>>>>>> Mag's-Branch
        for (Media media : media) {
            if (media.getGenres().contains(genre)) {
                sortedCollection.media.add(media);
            }
        }
        return sortedCollection;
    }
    //TODO Check if handles everything
    public MediaCollection sortByName(List<String> chosenMedia) throws IOException{
        MediaCollection sortedCollection = new MediaCollection();
        for (Media media : media) {
            for (String title : chosenMedia) {
                if (media.getTitle().equals(title)) {
                    sortedCollection.media.add(media);
                }
            }
        }
        return sortedCollection;
    }
    public void sortByRating() {
        throw new UnsupportedOperationException();
    }
    public void sortByReleaseYear() {
        throw new UnsupportedOperationException();
    }
<<<<<<< HEAD
    public MediaCollection sortByAlphabetical() throws IOException {
        throw new UnsupportedOperationException();
=======

    public DataHandler getMediaListManager() {
        return mediaListManager;
    }

    public List<Media> getMedia() {
        return media;
    }

    public String getGenre() {
        return genre;
    }

    //TODO Look at this beauty! Maybe also improve before final version
    public void sortByAlphabetical() throws IOException{
        List<String> titleList = new ArrayList<>();
        for (Media media : media) {
            titleList.add(media.getTitle());
        }
        Collections.sort(titleList);
         media = sortByName(titleList).media;
>>>>>>> Mag's-Branch
    }

}
