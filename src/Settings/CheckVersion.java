package Settings;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import sample.Main;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CheckVersion {
    static Main mn = new Main();
    static Class cls = mn.getClass();

    public CheckVersion() throws IOException, AWTException, InterruptedException {
    }

    public static void Version() throws IOException {
        String VersionFile = (cls.getResource("/controllers/version.txt")).getPath();
        String VersionURL = "https://raw.githubusercontent.com/tucnakomet1/Image-Of-The-Day/master/controllers/version.txt";

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

            if (preversion.contains("version")){
                version = preversion.replace("version ", "");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return version;
    }
}
