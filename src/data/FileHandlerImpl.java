package data;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandlerImpl implements FileHandler {

    // reading file and returning as arrayList
    public List<String> loadFile(File file) {

        List<String> collectedData = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader reader = new BufferedReader(fileReader);

            String nextInput;

            while ((nextInput = reader.readLine()) != null) {
                collectedData.add(nextInput);
            }

            fileReader.close();
            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Hej du, Yoodle Doodle Dandy Yankee");
        }

        return collectedData;
    }


    public void saveFile(List<String> saveData, File file) {
        try {

            PrintWriter writer = new PrintWriter(new FileWriter(file, true));

            //Print savaData to file, except last element of Array. Last element is printed separately
            for (int i = 0; i < saveData.size() - 1; i++) {
                writer.println(saveData.get(i));
            }

            //Prints the last element of saveData without exiting with a /n
            writer.print(saveData.get(saveData.size() - 1));

            writer.close();

        } catch (NullPointerException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void saveFileOverwrite(@NotNull List<String> saveData, File file) {
        try {

            PrintWriter writer = new PrintWriter(file);

            //Print savaData to file, except last element of Array. Last element is printed separately
            for (int i = 0; i < saveData.size() - 1; i++) {
                writer.println(saveData.get(i));
            }

            //Prints the last element of saveData without exiting with a /n
            writer.print(saveData.get(saveData.size() - 1));

            writer.close();

        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println(e.getMessage());
        }
    }

    public Image getImage(String title, String mediaType) {
        //TODO Write proper getImage function, that actually returns an image
        return new BufferedImage(100, 100, 2);
    }
}
