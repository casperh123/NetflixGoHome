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
        List<String> movieList;
        List<String> seriesList;

        try {
            movieList = fileHandler.loadFile(moviesFile);
            seriesList = fileHandler.loadFile(seriesFile);
        } catch (IOException | IllegalArgumentException e) {
            movieList = null;
            seriesList = null;
        }


        assert(movieList != null && movieList.size() == 100);
        assert(seriesList != null && seriesList.size() == 100);
    }

    @Test
    void saveFile() {

        File writeTestFile = new File("test/testLib/WriteTest.txt");
        List<String> saveData = new ArrayList<>();
        List<String> comparisonData;
        List<String> fileContentAfterWrite;
        Random random = new Random();

        try {
            comparisonData = fileHandler.loadFile(writeTestFile);
        } catch (IOException | IllegalArgumentException e) {
            comparisonData = null;
        }

        if(comparisonData != null) {

            //Generate checksum to validate difference between new and old file
            for(int i = 0; i < 5; i++) {
                String randomNumber = Integer.toString(random.nextInt(100));
                saveData.add(randomNumber);
                comparisonData.add(randomNumber);
            }

            try {
                fileHandler.saveFile(saveData, writeTestFile);
                fileContentAfterWrite = fileHandler.loadFile(writeTestFile);
            } catch (IOException | IllegalArgumentException e) {
                fileContentAfterWrite = null;
            }

            assert(fileContentAfterWrite != null);
            assert(comparisonData.equals(fileContentAfterWrite));

        } else {
            assert(false);
        }


    }


    @Test
    void saveFileOverwrite() {

        File overwriteTestFile = new File("test/testLib/overWriteTest.txt");
        List<String> saveData = new ArrayList<>();
        List<String> comparisonData;
        Random random = new Random();

        //Generate checksum to validate difference between new and old file
        for(int i = 0; i < 200; i++) {
            String randomNumber = Integer.toString(random.nextInt(100));
            saveData.add(randomNumber);
        }

        try {
            fileHandler.saveFileOverwrite(saveData, overwriteTestFile);
        } catch(IOException | IllegalArgumentException e) {
            //TODO proper exception handling.
            System.out.println("Error");
        }


        try {
            comparisonData = fileHandler.loadFile(overwriteTestFile);
        } catch (IOException | IllegalArgumentException e) {
            comparisonData = null;
        }

        assert(comparisonData != null);
        assert(comparisonData.equals(saveData));
    }

    @Test
    void getImageReturnsImageMovies() {

        Image poster;

        try {
            poster = fileHandler.getImage("12 Angry Men", "movie");
        } catch (IllegalArgumentException | IOException e) {
            //Uncorrectable Error. No Image will be displayed.
            poster = null;
        }

        assert(poster != null);

    }

    @Test
    void getImageReturnsImageSeries() {

        Image poster;

        try {
            poster = fileHandler.getImage("24", "series");
        } catch (IllegalArgumentException | IOException e) {
            //Uncorrectable Error. No Image will be instantiated.
            poster = null;
        }

        assert(poster != null);

    }

    @Test
    void getImageNotPlaceholderMovies() {

        BufferedImage placeholder;
        BufferedImage poster;

        try {
            placeholder = ImageIO.read(new File("lib/media/movieposters/Placeholder.jpg"));
            poster = (BufferedImage) fileHandler.getImage("12 Angry Men", "movie");
        } catch(IllegalArgumentException | IOException e) {
            //Uncorrectable error. Placeholder Image is missing.
            placeholder = null;
            poster = null;
        }

        assert(poster != null);
        assert(placeholder != null);
        assert(!imageEquality(poster, placeholder));

    }

    @Test
    void getImageNotPlaceholderSeries() {

        BufferedImage placeholder;
        BufferedImage poster;

        try {
            placeholder = ImageIO.read(new File("lib/media/seriesposters/Placeholder.jpg"));
            poster = (BufferedImage) fileHandler.getImage("24", "series");
        } catch(IllegalArgumentException | IOException e) {
            //Uncorrectable error. Placeholder Image is missing.
            placeholder = null;
            poster = null;
        }

        assert(poster != null);
        assert(placeholder != null);
        assert(!imageEquality(poster, placeholder));

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

        if(testWidth != second.getWidth() && testHeight != second.getHeight()) {
            return false;
        }

        for(int y = 0; y < testHeight; y++) {
            for(int x = 0; x < testWidth; x++) {
                if(first.getRGB(x, y) != second.getRGB(x, y)) {
                    return false;
                }
            }
        }

        return true;

    }
}