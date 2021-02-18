package Settings;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CheckVersion {
    public CheckVersion() throws IOException, AWTException, InterruptedException {
    }

    public static void Version() throws IOException, InterruptedException {
        String VersionFile = "/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/version.txt";
        String VersionURL = "https://raw.githubusercontent.com/tucnakomet1/Image-Of-The-Day/master/controllers/version.txt";

        String ReadFile = ReadFileVersion(VersionFile);
        String ReadURL =  ReadUrlVersion(VersionURL);

        System.out.println("\n" + ReadFile + "\n" + ReadURL);

        if (ReadFile.equals(ReadURL)){
            String sent = "Your version '" + ReadFile + "' is actual.";
            new ShowNotice(sent, "Upgrade");
            System.out.println(sent);
        }
        else{
            String sent = "Your version '" + ReadFile + "' is old and can be upgraded with the version '" + ReadURL + "'.";
            new ShowNotice(sent, "Image-Of-The-Day");
            new OpenUrl("https://github.com/tucnakomet1/Image-Of-The-Day/releases");
            System.out.println(sent);
        }
    }

    public static String ReadFileVersion(String version) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File(version));

        while (scanner.hasNextLine()){
            String res = scanner.nextLine();
            if (res.contains("version")){
                version = res.replace("version ", "");
            }
        }
        return version;
    }

    public static String ReadUrlVersion(String version){
        Document doc;

        try {
            doc = Jsoup.connect(version).get();
            String preversion = doc.text();
            System.out.println(version);

            if (preversion.contains("version")){
                version = preversion.replace("version ", "");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return version;
    }
}
