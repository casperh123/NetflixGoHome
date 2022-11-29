package data;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;

class FileHandlerImplTest {
    private FileHandler fileHandler;
    private File moviesFile;
    private File seriesFile;

    @BeforeEach
    void setUp() {
        this.moviesFile = new File("lib/mediaMetaData/film.txt");
        this.seriesFile = new File("lib/mediaMetaData/serier.txt");
        this.fileHandler = new FileHandlerImpl();
    }

    @AfterEach
    void tearDown() {
        moviesFile = null;
        seriesFile = null;
        fileHandler = null;
    }

    @Test
    void loadFile() {
        assert(fileHandler.loadFile(moviesFile).size() > 0);
        assert(fileHandler.loadFile(seriesFile).size() > 0);
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
}