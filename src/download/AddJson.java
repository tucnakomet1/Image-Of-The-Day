package download;

import sample.WriteFile;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class AddJson {
    public static String MyPath = System.getProperty("user.dir");

    public AddJson(String name, String author, String site, String resolution) throws IOException {
        File fileAu = new File(new URL("file:" + MyPath + "/out/production/ImageOfTheDay/JSON_data/author.json").getPath());
        File fileIMG = new File(new URL("file:" + MyPath + "/out/production/ImageOfTheDay/JSON_data/img.json").getPath());
        File fileRes = new File(new URL("file:" + MyPath + "/out/production/ImageOfTheDay/JSON_data/resolution.json").getPath());
        
        if (resolution.equals("100x300")){
            author = "unknown";
            URL ErrprPath = new URL("file:" + MyPath + "/out/production/ImageOfTheDay/images/MainPage/error.png");
            name = (ErrprPath).getPath();
        }

        if (site.equals("Unsplash")) {
            new WriteFile(fileAu, "{\n\t\"" + site + "\":\"" + author + "\",\n", false);
            new WriteFile(fileIMG, "{\n\t\"" + site + "\":\"" + name + "\",\n", false);
            new WriteFile(fileRes, "{\n\t\"" + site + "\":\"" + resolution + "\",\n", false);
        }
        else if (site.equals("Earth Observatory")) {
            new WriteFile(fileAu, "\t\"" + site + "\":\"" + author + "\"\n}", true);
            new WriteFile(fileIMG, "\t\"" + site + "\":\"" + name + "\"\n}", true);
            new WriteFile(fileRes, "\t\"" + site + "\":\"" + resolution + "\"\n}", true);
        }
        else {
            new WriteFile(fileAu, "\t\"" + site + "\":\"" + author + "\",\n", true);
            new WriteFile(fileIMG, "\t\"" + site + "\":\"" + name + "\",\n", true);
            new WriteFile(fileRes, "\t\"" + site + "\":\"" + resolution + "\",\n", true);
        }
    }
}
