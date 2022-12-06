package data;

import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandlerImpl implements FileHandler {

    // reading file and returning as arrayList
    public List<String> loadFile(File file) throws IOException {

        List<String> loadedData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String nextInput;

            while ((nextInput = reader.readLine()) != null) {
                loadedData.add(nextInput);
            }
        }

        return loadedData;
    }

    public void saveFile(@NotNull List<String> saveData, File file) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true))) {

            if(file.length() > 0) {
                writer.println();
            }
            //Print savaData to file, except last element of Array. Last element is printed separately
            for (int i = 0; i < saveData.size() - 1; i++) {
                writer.println(saveData.get(i));
            }

            //Prints the last element of saveData without /n
            writer.print(saveData.get(saveData.size() - 1));

        }
    }

    public void saveFileOverwrite(@NotNull List<String> saveData, File file) throws IOException {
        try (PrintWriter writer = new PrintWriter(file)) {

            //Print savaData to file, except last element of Array. Last element is printed separately
            for (int i = 0; i < saveData.size() - 1; i++) {
                writer.println(saveData.get(i));
            }

            //Prints the last element of saveData without exiting with a /n
            writer.print(saveData.get(saveData.size() - 1));

        }
    }

    public boolean deleteFile(File file) {
        if(file.delete()) {
            return true;
        }

        return false;
    }

    public Image getImage(String title, String mediaType) throws IOException {
        if(mediaType.equals("film")) {
            try {
                return ImageIO.read(new File("lib/media/" + mediaType + "plakater/" + title + ".jpg"));
            } catch (IOException | IllegalArgumentException e) {
                return ImageIO.read(new File("lib/media/" + mediaType + "plakater/Placeholder.jpg"));
            }
        } else if (mediaType.equals("serie")) {
            try {
                return ImageIO.read(new File("lib/media/" + mediaType + "forsider/" + title + ".jpg"));
            } catch (IOException | IllegalArgumentException e) {
                return ImageIO.read(new File("lib/media/" + mediaType + "forsider/Placeholder.jpg"));
            }
        }
        return null;
    }
}
