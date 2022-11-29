package data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class FileHandlerImplTest {
    private FileHandler fileHandler;
    private File moviesFile;
    private File seriesFile;

    @BeforeEach
    void setUp() {
        this.moviesFile = new File("lib/mediaMetaData/movies.txt");
        this.seriesFile = new File("lib/mediaMetaData/series.txt");
        this.fileHandler = new FileHandlerImpl();
    }

    @AfterEach
    void tearDown() {
        moviesFile = null;
        seriesFile = null;
        fileHandler = null;
    }

    @Test
    void loadFileContainsAllMedia() {
        assert(fileHandler.loadFile(moviesFile).size() == 100);
        assert(fileHandler.loadFile(seriesFile).size() == 100);
    }

    @Test
    void saveFile() {
        File writeTestFile = new File("test/testLib/WriteTest.txt");
        List<String> saveData = fileHandler.loadFile(writeTestFile);
        Random random = new Random();

        //Generate checksum to validate difference between new and old file
        for(int i = 0; i < 5; i++) {
            String randomNumber = Integer.toString(random.nextInt(100));
            saveData.add(randomNumber);
        }

        fileHandler.saveFileOverwrite(saveData, writeTestFile);

        assert(fileHandler.loadFile(writeTestFile).equals(saveData));

    }


    @Test
    void saveFileOverwrite() {

        File overwriteTestFile = new File("test/testLib/overWriteTest.txt");
        List<String> saveData = new ArrayList<>();
        Random random = new Random();

        //Generate checksum to validate difference between new and old file
        for(int i = 0; i < 200; i++) {
            String randomNumber = Integer.toString(random.nextInt(100));
            saveData.add(randomNumber);
        }

        fileHandler.saveFileOverwrite(saveData, overwriteTestFile);

        assert(fileHandler.loadFile(overwriteTestFile).equals(saveData));
    }

    @Test
    void getImageNotNullMovies() {

        List<String> movieList = fileHandler.loadFile(moviesFile);

        for(String movieEntry : movieList) {

            String[] metaData = movieEntry.split(";");
            Image poster;

            try {
                poster = fileHandler.getImage(metaData[0], "movie");
            } catch (IllegalArgumentException | IOException e) {
                //Uncorrectable Error. No Image will be displayed.
                poster = null;
            }

            assert(poster != null);

        }
    }

    @Test
    void getImageNotNullSeries() {

        List<String> seriesList = fileHandler.loadFile(seriesFile);

        for(String seriesEntry : seriesList) {

            String[] metaData = seriesEntry.split(";");
            Image poster;

            try {
                poster = fileHandler.getImage(metaData[0], "series");
            } catch (IllegalArgumentException | IOException e) {
                //Uncorrectable Error. No Image will be instantiated.
                poster = null;
            }

            assert(poster != null);

        }
    }

    @Test
    void getImageNotPlaceholderMovies() {

        List<String> movieList = fileHandler.loadFile(moviesFile);
        BufferedImage placeholder;

        try {
            placeholder = ImageIO.read(new File("lib/media/movieposters/Placeholder.jpg"));
        } catch(IllegalArgumentException | IOException e) {
            //Uncorrectable error. Placeholder Image is missing.
            placeholder = null;
        }

        for(String movieEntry : movieList) {

            String[] metaData = movieEntry.split(";");
            BufferedImage poster;

            try {
                poster = (BufferedImage) fileHandler.getImage(metaData[0], "movie");
            } catch (IllegalArgumentException | IOException e) {
                //Uncorrectable Error. No Image will be displayed.
                poster = null;
            }

            assert(poster != null);
            assert(placeholder != null);
            assert(!imageEquality(poster, placeholder));
        }
    }

    @Test
    void getImageNotPlaceholderSeries() {

        List<String> seriesList = fileHandler.loadFile(seriesFile);
        BufferedImage placeholder;

        try {
            placeholder = ImageIO.read(new File("lib/media/seriesposters/Placeholder.jpg"));
        } catch(IllegalArgumentException | IOException e) {
            //Uncorrectable error. Placeholder Image is missing.
            placeholder = null;
        }

        for(String seriesEntry : seriesList) {

            String[] metaData = seriesEntry.split(";");
            BufferedImage poster;

            try {
                poster = (BufferedImage) fileHandler.getImage(metaData[0], "series");
            } catch (IllegalArgumentException | IOException e) {
                //Uncorrectable Error. No Image will be displayed.
                poster = null;
            }

            assert(poster != null);
            assert(placeholder != null);
            assert(!imageEquality(poster, placeholder));
        }
    }

    @Test
    void getImagePlaceholderFallbackMovies() {

        BufferedImage placeholder;
        BufferedImage poster;

        try {
            placeholder = ImageIO.read(new File("lib/media/movieposters/Placeholder.jpg"));
            poster = (BufferedImage) fileHandler.getImage("INVALID_FILE_NAME", "movie");
        } catch(IllegalArgumentException | IOException e) {
            //Uncorrectable error. Placeholder Image is missing.
            placeholder = null;
            poster = null;
        }
        assert(poster != null);
        assert(placeholder != null);
        assert(imageEquality(poster, placeholder));
    }

    @Test
    void getImagePlaceholderFallbackSeries() {

        BufferedImage placeholder;
        BufferedImage poster;

        try {
            placeholder = ImageIO.read(new File("lib/media/seriesposters/Placeholder.jpg"));
            poster = (BufferedImage) fileHandler.getImage("INVALID_FILE_NAME", "series");
        } catch(IllegalArgumentException | IOException e) {
            //Uncorrectable error. Placeholder Image is missing.
            placeholder = null;
            poster = null;
        }
        assert(poster != null);
        assert(placeholder != null);
        assert(imageEquality(poster, placeholder));
    }

    private boolean imageEquality(BufferedImage first, BufferedImage second) {

        int testWidth = first.getWidth();
        int testHeight = first.getHeight();

        for(int x = 0; x < testWidth; x++) {
            for(int y = 0; y < testHeight; y++) {
                if(first.getRGB(x, y) != second.getRGB(x, y)) {
                    return false;
                }
            }
        }

        return true;

    }
}