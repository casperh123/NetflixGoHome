package domain;

import java.io.IOException;
import java.util.Comparator;
import java.util.List;

public class MediaCollection {

    private DataHandler mediaListManager;
    private List<Media> media;
    private String genre;

    public MediaCollection() throws IOException {
        mediaListManager = new DataHandler();
        media = mediaListManager.assembleMediaList();
        genre = null;
    }

    public MediaCollection(String genre) throws IOException {
        mediaListManager = new DataHandler();
        media = mediaListManager.assembleMediaList();
        this.genre = genre;
    }
    public MediaCollection getCollectionByGenre(String genre) throws IOException{
        MediaCollection sortedCollection = new MediaCollection(genre);
        // For the object "media" of type Media in the list "media", where the list is a field for MediaCollection
        for (Media media : media) {
            if (media.getGenres().contains(genre)) {
                sortedCollection.media.add(media);
            }
        }
        return sortedCollection;
    }
    //TODO Check if handles everything
    public MediaCollection getCollectionByName(List<String> chosenMedia) throws IOException{
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
        media.sort(Comparator.comparing(Media::getRating));
    }
    public void sortByReverseRating() {
        media.sort(Comparator.comparing(Media::getRating).reversed());
    }
    public void sortByReleaseYear() {
        media.sort(Comparator.comparing(Media::getReleaseYear));
    }
    public void sortByReverseReleaseYear() {
        media.sort(Comparator.comparing(Media::getReleaseYear).reversed());
    }
    public DataHandler getMediaListManager() {
        return mediaListManager;
    }
    public List<Media> getMedia() {
        return media;
    }

    public String getGenre() {
        return genre;
    }

    public void sortByAlphabetical() throws IOException{
        media.sort(Comparator.comparing(Media::getTitle));
    }

    public void sortByReverseAlphabetical() throws IOException{
        media.sort(Comparator.comparing(Media::getTitle).reversed());
    }

}
