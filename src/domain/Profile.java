package domain;

import java.util.ArrayList;
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

    // Add mediaName to favoriteList if not already added
    void addToFavorite(String mediaName) {

        if (favorites.contains(mediaName)) {
            //TODO Create exception
            throw new UnsupportedOperationException();
        } else {
            favorites.add(mediaName);
        }
    }

    // If favoriteList contains mediaName, it removes it.
    void removeFromFavorite(String mediaName) {

        if (favorites.contains(mediaName)) {
            favorites.remove(mediaName);
        } else {
            //TODO Create exception
            throw new UnsupportedOperationException();
        }

    }

    //TODO Sanitize input
    public void setName(String name) throws IllegalArgumentException {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public List<String> getFavorites() {
        return favorites;
    }

    // Puts profile info into arrayList
    public ArrayList<String> profileInfoFormatter() {

        ArrayList<String> profileInfo = new ArrayList<>();

        profileInfo.add(String.valueOf(getId()));
        profileInfo.add(getName());
        profileInfo.addAll(favorites);

        return profileInfo;
    }

    public String getPath() {
        //String path =
        return null;
    }

    @Override
    public String toString() {

        String outputString = "Id: " + id + " Name: " + name + " Favorites: ";

        //TODO Do something about separator
        for(String favourite : favorites) {
            outputString += favourite + ", ";
        }

        return outputString;
    }


}