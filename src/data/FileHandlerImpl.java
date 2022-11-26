package data;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileHandlerImpl implements FileHandler{

    private FileReader fileReader;
    private BufferedReader reader;
    private PrintWriter writer;

    public FileHandlerImpl() {
    }

    public ArrayList<String> loadFile() {
        throw new UnsupportedOperationException();
    }

    public void saveFile() {
        throw new UnsupportedOperationException();
    }

    public void saveFileOverwrite() {
        throw new UnsupportedOperationException();
    }

    public void openNewFile(File file) {
        throw new UnsupportedOperationException();
    }
}
