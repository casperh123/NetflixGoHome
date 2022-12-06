package exceptions;

import java.io.IOException;

public class FileNotLoadedException extends IOException{

    private String fileName;

    public FileNotLoadedException(String fileName) {
        this.fileName = fileName;
    }

    public String getMessage() {
        return fileName + " could not be loaded";
    }
}
