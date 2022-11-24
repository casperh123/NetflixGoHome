package domain;
import java.awt.image.VolatileImage;
import java.util.List;

abstract class Media {

    protected String title;
    protected int releaseYear;
    protected List<String> genres;
    protected double rating;
    protected VolatileImage poster;

    public String getTitle() {
        return title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public List<String> getGenres() {
        return genres;
    }

    public double getRating() {
        return rating;
    }

    public VolatileImage getPoster() {
        return poster;
    }

    public void display() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException();
    }
}
