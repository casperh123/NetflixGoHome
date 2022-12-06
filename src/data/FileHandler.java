package data;

import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

public interface FileHandler {

    Image getImage (String title, String mediaType) throws IOException;
    List<String> loadFile(File file) throws IOException;
    void saveFile(List<String> saveData, File file) throws IOException;
    boolean deleteFile(File file);

    void saveFileOverwrite(@NotNull List<String> saveData, File file) throws IOException;
}
