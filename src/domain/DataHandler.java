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
    private File profileIds;

    public DataHandler() {
        movieList = new File("lib/mediaMetaData/movies.txt");
        seriesList = new File("lib/mediaMetaData/series.txt");
        profileIds = new File("lib/profiles/profileIds.txt");
        fileHandler = new FileHandlerImpl();
    }

    public List<Media> assembleMediaList() throws IllegalArgumentException, IOException {

        List<Media> assembledMediaList = assembleMovieList();

        assembledMediaList.addAll(assembleSeriesList());

        return assembledMediaList;
    }

    public List<Media> assembleMovieList() throws IllegalArgumentException, IOException {

        List<String> moviesMetaData = fileHandler.loadFile(movieList);
        List<Media> mediaList = new ArrayList<>();

        for(String movieData : moviesMetaData) {
            mediaList.add(movieCreator(movieData));
        }

        return mediaList;
    }

    public List<Media> assembleSeriesList() throws IllegalArgumentException, IOException {
        List<String> seriesMetaData = fileHandler.loadFile(seriesList);
        List<Media> mediaList = new ArrayList<>();

        for(String seriesData : seriesMetaData) {
            mediaList.add(seriesCreator(seriesData));
        }

        return mediaList;
    }

    public Map<Integer, Profile> assembleProfileMap() throws IllegalArgumentException, IOException {

        Map<Integer, Profile> profileMap = new HashMap<>();
        //Fetch saved ids from profileIds.txt
        List<String> idsToLoad = fileHandler.loadFile(profileIds);

        //Fetch data from each individual profile file based on id.
        for (String profileId : idsToLoad) {

            List<String> profileData = fileHandler.loadFile(new File("lib/profiles/" + profileId + ".txt"));

            String title = null;
            int id = -1;
            List<String> favourites = new ArrayList<>();


            for (int i = 0; i < profileData.size(); i++) {

                if(i == 0) {
                    id = Integer.parseInt(profileData.get(i));
                } else if(i == 1) {
                    title = profileData.get(i);
                } else {
                    favourites.add(profileData.get(i));
                }
            }
            profileMap.merge(id, new Profile(id, title, favourites), (a,b) -> a = b);
        }
        return profileMap;
    }

    public void saveProfile(Profile profile) {

        List<String> saveData = new ArrayList<>();
        
    }

    public void saveProfileMap() {
        throw new UnsupportedOperationException();
    }

    public void saveFavoritesToProfile(int id) {
        throw new UnsupportedOperationException();
    }

    private Media movieCreator(String data) {

        //TODO refactor method to be more readable and clean...

        String[] dataEntries = inputSanitizer(data);
        String title = dataEntries[0];
        int releaseYear = Integer.parseInt(dataEntries[1]);
        // Splits the genre entry into a new array, and saves this in an arrayList called genres
        ArrayList<String> genres = new ArrayList<>(Arrays.asList(dataEntries[2].split(",")));
        double rating = Double.parseDouble(dataEntries[3]);
        Image poster;
        int seasons;

            try {
                poster = fileHandler.getImage(title, "movie");
            } catch (IllegalArgumentException | IOException e) {
                //TODO Proper exception handling
                poster = null;
                System.out.println("Critical Error: " + e.getMessage());
            }
            return new Movie(title, releaseYear, genres, rating, poster);


    }

    private Media seriesCreator(String data) {

        //TODO refactor method to be more readable and clean...

        String[] dataEntries = inputSanitizer(data);
        String title = dataEntries[0];
        String[] releasePeriod = dataEntries[1].split("-");
        int releaseYear = Integer.parseInt(releasePeriod[0]);
        // Splits the genre entry into a new array, and saves this in an arrayList called genres
        ArrayList<String> genres = new ArrayList<>(Arrays.asList(dataEntries[2].split(",")));
        double rating = Double.parseDouble(dataEntries[3]);
        Image poster;
        int seasons = dataEntries[4].split(",").length;
        Map<Integer, Integer> seasonsEpisodes = seasonEpisodeMapAssembler(dataEntries[4].split(","));

        //TODO clean up map and seasons
            try {
                poster = fileHandler.getImage(title, "series");
            } catch(IllegalArgumentException | IOException e) {
                //TODO Proper exception handling
                poster = null;
                System.out.println("Critical Error: " + e.getMessage());
            }

            //TODO Constructor contains placeholder variables to make tests executable. Replace Seasons and episodes with proper values. Same goes for Image.
            return new Series(title, releaseYear, genres, rating, poster, seasons, seasonsEpisodes);

    }

    private String[] inputSanitizer(String input) {

        String[] dataEntries = input.split(";");
        String[] sanitizedArray = new String[dataEntries.length];

        //TODO write an implementation that doesn't is more extensible.
        for(int i = 0; i < dataEntries.length; i++) {
            if (i == 0) {
                sanitizedArray[i] = dataEntries[i];
            } else if (i == 3) {
                sanitizedArray[i] = inputSpaceSanitizer(dataEntries[i].replace(',', '.'));
            } else {
                sanitizedArray[i] = inputSpaceSanitizer(dataEntries[i]);
            }
        }


        return sanitizedArray;
    }

    private String inputSpaceSanitizer(String input) {

        StringBuilder outputString = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) != ' ') {
                outputString.append(input.charAt(i));
            }
        }

        return outputString.toString();
    }

    private Map<Integer, Integer> seasonEpisodeMapAssembler(String[] input) {

        Map<Integer, Integer> seasonEpisodeMap = new HashMap<>();

        for(String index : input) {

            String[] newArray = index.split("-");

            if(newArray.length >= 2) {
                seasonEpisodeMap.merge(Integer.parseInt(newArray[0]), Integer.parseInt(newArray[1]), (a, b) -> a = b);
            }
        }

        return seasonEpisodeMap;
    }
}
