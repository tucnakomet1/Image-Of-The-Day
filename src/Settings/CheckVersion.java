package Settings;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import sample.Main;
import sample.ReadFile;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Scanner;

public class CheckVersion {
    public static String MyPath = System.getProperty("user.dir");

    public CheckVersion() throws IOException, AWTException, InterruptedException {
    }

    public static void Version() throws IOException {
        String VersionFile = new URL("file:" + MyPath + "/out/production/ImageOfTheDay/controllers/version.txt").getPath();
        String VersionURL = "https://raw.githubusercontent.com/tucnakomet1/Image-Of-The-Day/master/src/controllers/version.txt";

        String ReadFile = ReadFileVersion(VersionFile);
        String ReadURL =  ReadUrlVersion(VersionURL);

        String send;
        if (ReadFile.equals(ReadURL)){
            send = "Your version '" + ReadFile + "' is actual.";
            new ShowAlert("Upgrade", send);
        }
        else{
            send = "Your version '" + ReadFile + "' is outdated and can be upgraded with the version '" + ReadURL + "'.";
            new ShowAlert("Upgrade", send);
            new OpenUrl("https://github.com/tucnakomet1/Image-Of-The-Day/releases");
        }
        System.out.println(send);
    }

    public static String ReadFileVersion(String version) throws FileNotFoundException {
        String res = new ReadFile().ReadTheStringFile(version);

        if (res.contains("version")){
            version = res.replace("version ", "");
        }
        return version;
    }

    public static String ReadUrlVersion(String version){
        Document doc;

        try {
            doc = Jsoup.connect(version).get();
            String preversion = doc.text();

            if (preversion.contains("version")){
                version = preversion.replace("version ", "");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return version;
    }
}
