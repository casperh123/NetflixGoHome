package data;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileHandler {

    List<String> loadFile(File file) throws IllegalArgumentException, IOException;
    Image getImage (String title, String mediaType) throws IllegalArgumentException, IOException;
    void saveFile(List<String> saveData, File file) throws IOException, NullPointerException;
    void saveFileOverwrite(@NotNull List<String> saveData, File file) throws IllegalArgumentException, IOException;
}
