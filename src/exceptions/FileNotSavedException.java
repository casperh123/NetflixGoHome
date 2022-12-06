package exceptions;

import java.io.IOException;

public class FileNotSavedException extends IOException {

    public FileNotSavedException() {
        super("Could not save to file");
    }

}
