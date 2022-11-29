package domain;

import data.FileHandler;
import data.FileHandlerImpl;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.*;

public class DataHandler {
    private FileHandler fileHandler;
    private File movieList;
    private File seriesList;

    public DataHandler() {
        movieList = new File("lib/mediaMetaData/movies.txt");
        seriesList = new File("lib/mediaMetaData/movies.txt");
        fileHandler = new FileHandlerImpl();
    }
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
        Image poster;

        try {
            poster = fileHandler.getImage(title, "movies");
        } catch(IllegalArgumentException | IOException e) {
            poster = null;
            System.out.println("Critical Error: " + e.getMessage());
        }


        if(mediaType.equals("movies")) {
            return new Movie(title, releaseYear, genres, rating, poster);
        } else {
            //TODO Constructor contains placeholder variables to make tests executable. Replace Seasons and episodes with proper values. Same goes for Image.
            return new Series(title, releaseYear, genres, rating, poster, 10, new HashMap<Integer, Integer>());
        }
    }
}
