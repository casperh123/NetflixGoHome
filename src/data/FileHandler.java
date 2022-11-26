package data;
import java.io.File;
import java.util.ArrayList;

public interface FileHandler {

    ArrayList<String> loadFile();
    void saveFile();
    void saveFileOverwrite();
    void openNewFile(File file);
}
