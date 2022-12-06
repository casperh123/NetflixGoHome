package domain;

import exceptions.MediaAlreadyInArrayException;
import exceptions.MediaNotInArrayException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Profile {
    private String name;
    private List<String> favorites;
    private int id;

    private DataHandler dataHandler;

    public Profile(int id, String name, List<String> favorites) {
        this.id = id;
        this.name = name;
        this.favorites = favorites;
        this.dataHandler = new DataHandler();
    }

    //TODO implement saving functionality, so favourites are saved to disc.
    //TODO Add mediaName to favoriteList if not already added

    void addToFavorite(String mediaName) throws IOException, MediaAlreadyInArrayException {

        if (favorites.contains(mediaName)) {
            throw new MediaAlreadyInArrayException(mediaName);
        } else {
            favorites.add(mediaName);
            dataHandler.saveToProfileFavourites(mediaName, id);
        }
    }

    void removeFromFavorite(String mediaName) throws MediaNotInArrayException, IOException {
        if (favorites.contains(mediaName)) {
            favorites.remove(mediaName);
            dataHandler.saveProfile(new Profile(id, name, favorites));
        } else {
            throw new MediaNotInArrayException(mediaName);
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