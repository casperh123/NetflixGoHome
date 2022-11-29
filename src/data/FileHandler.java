package data;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileHandler {

    List<String> loadFile(File file);
    Image getImage (String title, String mediaType) throws IllegalArgumentException, IOException;
    void saveFile(List<String> saveData, File file);
    void saveFileOverwrite(List<String> saveData, File file);
}
