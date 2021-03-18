package sample;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
    public ReadFile() {
    }

    public String ReadTheStringFile(String path) {
        String data = null;
        File myObj = new File(path);
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
        }
        myReader.close();
        return data;
    }

    public Integer ReadTheIntFile(String path) {
        String data = null;
        File myObj = new File(path);
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
        }
        myReader.close();
        return Integer.valueOf(data);
    }
}
