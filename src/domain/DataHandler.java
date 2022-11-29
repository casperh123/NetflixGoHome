package domain;

import data.FileHandler;

import java.util.List;
import java.util.Map;

public class DataHandler {
    private FileHandler fileHandler;

    public List<Media> assembleMovieList() {

        List<String> moviesMetaData = fileHandler.loadFile(movieList);
        List<Media> movieList = new ArrayList<>();

        for(String movieData : moviesMetaData) {
            movieList.add(mediaCreator(movieData, "movie"));
        }

        return movieList;
    }
    
    public List<Media> assembleSeriesList() {
        throw new UnsupportedOperationException();
    }

    public Map<Integer, Profile> assembleProfileMap() {
        throw new UnsupportedOperationException();
    }

    public void saveProfile() {
        throw new UnsupportedOperationException();
    }

    public void saveProfileMap() {
        throw new UnsupportedOperationException();
    }

    public void saveFavoritesToProfile(int id) {
        throw new UnsupportedOperationException();
    }

    private Media mediaCreator(String data, String mediaType) {

        String[] dataEntries = data.split(";");

        String title = dataEntries[0];
        int releaseYear = Integer.parseInt(dataEntries[1]);
        // Splits the genre entry into a new array, and saves this in an arrayList called genres
        ArrayList<String> genres = new ArrayList<>(Arrays.asList(dataEntries[2].split(",")));
        double rating = Double.parseDouble(dataEntries[3]);
        //TODO Write proper implementation of getImage, so that it is not static.
        //Image poster = FileHandler.getImage(title, "movie");


        if(mediaType.equals("movie")) {
            //TODO Constructor contains placeholder Values. Replace Image with proper method call on FileHandler once implemented.
           return new Movie(title, releaseYear, genres, rating, new BufferedImage(100, 100, 1));
        } else {
            //TODO Constructor contains placeholder variables to make tests executable. Replace Seasons and episodes with proper values. Same goes for Image.
            return new Series(title, releaseYear, genres, rating, new BufferedImage(100, 100, 1), 10, new HashMap<Integer, Integer>());
        }
    }
}
