package data;
import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileReaderImpl implements FileReader{

    private File file;
    private BufferedReader reader;
    private PrintWriter writer;


    public ArrayList<String> loadFile() {
        throw new UnsupportedOperationException();
    }

    public void saveFile() {
        throw new UnsupportedOperationException();
    }

    public void saveFileOverwrite() {
        throw new UnsupportedOperationException();
    }

    public void newFilePath(File file) {
        throw new UnsupportedOperationException();
    }
}
