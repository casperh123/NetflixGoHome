package domain;

import java.util.Map;

public class Series extends Media{

    private int seasons;
    private Map<Integer, Integer> episodesInSeason;

    public int getSeasons() {
        return seasons;
    }

    public Map<Integer, Integer> getEpisodesInSeason() {
        return episodesInSeason;
    }
}
