package data;

import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandlerImpl implements FileHandler {

    // reading file and returning as arrayList
    public List<String> loadFile(File file) throws IllegalArgumentException, IOException {

        List<String> loadedData = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String nextInput;

            while ((nextInput = reader.readLine()) != null) {
                loadedData.add(nextInput);
            }
        }

        return loadedData;
    }

    public void saveFile(List<String> saveData, File file) throws IOException, NullPointerException {
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

    public void saveFileOverwrite(@NotNull List<String> saveData, File file) throws IllegalArgumentException, IOException {
        try (PrintWriter writer = new PrintWriter(file)) {

            //Print savaData to file, except last element of Array. Last element is printed separately
            for (int i = 0; i < saveData.size() - 1; i++) {
                writer.println(saveData.get(i));
            }

            //Prints the last element of saveData without exiting with a /n
            writer.print(saveData.get(saveData.size() - 1));

        }
    }

    public Image getImage(String title, String mediaType) throws IllegalArgumentException, IOException {
        try {
            return ImageIO.read(new File("NetflixGoHome/lib/media/" + mediaType + "posters/" + title + ".jpg"));
        } catch (IOException | IllegalArgumentException e) {
            return ImageIO.read(new File("NetflixGoHome/lib/media/" + mediaType + "posters/Placeholder.jpg"));
        }
    }
}
