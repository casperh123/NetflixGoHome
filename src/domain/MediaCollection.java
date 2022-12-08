package domain;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MediaCollection {

    private List<Media> media;
    private String genre;

    public MediaCollection() throws IOException {
        media = new DataHandler().assembleMediaList();
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


    public MediaCollection getCollectionByType(String mediaType) throws IOException {
        List<Media> listOfMedia;
        switch (mediaType) {
            case "Movies" -> listOfMedia = new DataHandler().assembleMovieList();
            case "Series" -> listOfMedia = new DataHandler().assembleSeriesList();
            default -> {
                listOfMedia = new DataHandler().assembleMediaList();
                throw new IllegalArgumentException();
            }
        }
        return new MediaCollection(listOfMedia);
    }
    public void sortByRating() {
        media.sort(Comparator.comparing(Media::getRating).reversed());
    }
    public void sortByReverseRating() {
        media.sort(Comparator.comparing(Media::getRating));
    }
    public void sortByReleaseYear() {
        media.sort(Comparator.comparing(Media::getReleaseYear));
    }
    public void sortByReverseReleaseYear() {
        media.sort(Comparator.comparing(Media::getReleaseYear).reversed());
    }
    public void sortByAlphabetical() throws IOException{
        media.sort(Comparator.comparing(Media::getTitle));
    }
    public void sortByReverseAlphabetical() throws IOException{
        media.sort(Comparator.comparing(Media::getTitle).reversed());
    }
    public List<Media> getMedia() {
        return media;
    }
    public String getGenre() {
        return genre;
    }

}
