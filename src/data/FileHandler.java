package data;

import java.awt.*;
import java.io.File;
import java.util.List;

public interface FileHandler {

    List<String> loadFile(File file);
    Image getImage(String title, String mediaType);
    void saveFile(List<String> saveData, File file);
    void saveFileOverwrite(List<String> saveData, File file);
}
