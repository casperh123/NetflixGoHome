package domain;

import java.awt.*;
import java.util.List;
import java.util.Map;

public class Series extends Media{

    private int seasons;
    private Map<Integer, Integer> episodesInSeason;

    public Series(String title, int releaseYear, List<String> genres, double rating,
                  Image poster, int seasons, Map<Integer, Integer> episodesInSeason) {

        super(title, releaseYear, genres, rating, poster);
        this.seasons = seasons;
        this.episodesInSeason = episodesInSeason;
    }

    public int getSeasons() {
        return seasons;
    }

    public Map<Integer, Integer> getEpisodesInSeason() {
        return episodesInSeason;
    }

    @Override
    public String toString() {

        String outputString = "Series - "+ super.toString();
        //TODO Proper implementation

        for(int i = 0; i < episodesInSeason.size(); i ++) {
            if(episodesInSeason.containsKey(i)) {
                outputString += "Season " + i + ": " + episodesInSeason.get(i) + " episodes. ";
            }
        }
        return outputString;
    }
}
