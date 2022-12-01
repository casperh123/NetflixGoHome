package domain;

import java.util.List;

public class Profile {
    private String name;
    private List<String> favorites;
    private int id;

    public Profile(int id, String name, List<String> favorites) {
        this.id = id;
        this.name = name;
        this.favorites = favorites;
    }

    void addToFavorite(String mediaName) {
        favorites.add(mediaName);

    }

    void deleteFromFavorite(String mediaName) {
        favorites.remove(mediaName);
        //TODO save in profile data
    }

    public void setName(String name) {
        this.name = name;
        //TODO save in profile data
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPath() {
        //String path =
        return null;
    }

    @Override
    public String toString() {

        String outputString = "Id: " + id + " Name: " + name + " Favorites: ";

        for(String favourite : favorites) {
            outputString += favourite + " ";
        }

        return outputString;
    }


}