package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MediaCollection {

    private List<Media> media;
    private String genre;

    public MediaCollection() throws IOException {
        media = DataHandler.getInstance().assembleMediaList();
        genre = null;
    }

    private MediaCollection(String genre, List<Media> media) {
        this.media = media;
        this.genre = genre;
    }

    private MediaCollection(List<Media> media) {
        this.media = media;
        this.genre = null;
    }

    public MediaCollection getCollectionByGenre(String genre){

        List<Media> listOfMedia = new ArrayList<>();
        // For the object "media" of type Media in the list "media", where the list is a field for MediaCollection
        for (Media media : media) {
            if (media.getGenres().contains(genre)) {
                listOfMedia.add(media);
            }
        }
        return new MediaCollection(genre, listOfMedia);
    }
    //TODO Check if handles everything
    public MediaCollection getCollectionByName(List<String> chosenMedia) {
        List<Media> listOfMedia = new ArrayList<>();

        for (Media media : media) {
            for (String title : chosenMedia) {
                if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                    listOfMedia.add(media);
                }
            }
        }
        return new MediaCollection(listOfMedia);
    }
    public MediaCollection getCollectionByName(String chosenMedia) {
        List<Media> listOfMedia = new ArrayList<>();

        for (Media media : media) {
            if (media.getTitle().toLowerCase().contains(chosenMedia.toLowerCase())) {
                    listOfMedia.add(media);
            }
        }
        return new MediaCollection(listOfMedia);
    }
    public MediaCollection getCollectionByType(String mediaType) throws IOException {
        List<Media> listOfMedia;
        switch (mediaType) {
            case "Movies" -> listOfMedia = DataHandler.getInstance().assembleMovieList();
            case "Series" -> listOfMedia = DataHandler.getInstance().assembleSeriesList();
            default -> {
                listOfMedia = DataHandler.getInstance().assembleMediaList();
                throw new IllegalArgumentException();
            }
        }
        return new MediaCollection(listOfMedia);
    }
    public void sortByRating() {
        media.sort(Comparator.comparing(Media::getRating).reversed());
    }
    public void sortByRatingReverse() {
        media.sort(Comparator.comparing(Media::getRating));
    }
    public void sortByReleaseYear() {
        media.sort(Comparator.comparing(Media::getReleaseYear));
    }
    public void sortByReleaseYearReverse() {
        media.sort(Comparator.comparing(Media::getReleaseYear).reversed());
    }
    public void sortByAlphabetical() throws IOException{
        media.sort(Comparator.comparing(Media::getTitle));
    }
    public void sortByAlphabeticalReverse() throws IOException{
        media.sort(Comparator.comparing(Media::getTitle).reversed());
    }
    public List<Media> getMedia() {
        return media;
    }
    public String getGenre() {
        return genre;
    }
}
