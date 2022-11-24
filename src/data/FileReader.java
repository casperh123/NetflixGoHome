package data;
import java.io.File;
import java.util.ArrayList;

public interface FileReader {

    ArrayList<String> loadFile();
    void saveFile();
    void saveFileOverwrite();
    void newFilePath(File file);
}
