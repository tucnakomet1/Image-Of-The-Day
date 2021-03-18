package sample;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public WriteFile(File path, String text, boolean append){
        try {
            FileWriter writer = new FileWriter(path, append);
            writer.write(text);
            writer.close();
        }
        catch (IOException ioex) {
            ioex.printStackTrace();
        }
    }
}
