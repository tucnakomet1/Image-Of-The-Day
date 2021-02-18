package download;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddJson {
    public AddJson(String name, String author, String site, String resolution) throws IOException {
        File fileAu = new File("/home/tucna/Dokumenty/Java/ImageOfTheDay/JSON_data/author.json");
        File fileIMG = new File("/home/tucna/Dokumenty/Java/ImageOfTheDay/JSON_data/img.json");
        File fileRes = new File("/home/tucna/Dokumenty/Java/ImageOfTheDay/JSON_data/resolution.json");
        
        if (resolution.equals("100x300")){
            author = "unknown";
            name = "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/error.png";
        }

        if (site.equals("Unsplash")) {
            FileWriter FWAu = new FileWriter(fileAu, false);
            String toWriteAu = "{\n\t\"" + site + "\":\"" + author + "\",\n";
            FWAu.write(toWriteAu);

            FileWriter FWImg = new FileWriter(fileIMG, false);
            String toWriteImg = "{\n\t\"" + site + "\":\"" + name + "\",\n";
            FWImg.write(toWriteImg);

            FileWriter FWRes = new FileWriter(fileRes, false);
            String toWriteRes = "{\n\t\"" + site + "\":\"" + resolution + "\",\n";
            FWRes.write(toWriteRes);

            FWRes.close();
            FWAu.close();
            FWImg.close();
        }
        else if (site.equals("Earth Observatory")) {
            FileWriter FWAu = new FileWriter(fileAu, true);
            String toWriteAu = "\t\"" + site + "\":\"" + author + "\"\n}";
            FWAu.write(toWriteAu);

            FileWriter FWImg = new FileWriter(fileIMG, true);
            String toWriteImg = "\t\"" + site + "\":\"" + name + "\"\n}";
            FWImg.write(toWriteImg);

            FileWriter FWRes = new FileWriter(fileRes, true);
            String toWriteRes = "\t\"" + site + "\":\"" + resolution + "\"\n}";
            FWRes.write(toWriteRes);

            FWRes.close();
            FWAu.close();
            FWImg.close();
        }
        else {
            FileWriter FWAu = new FileWriter(fileAu, true);
            String toWriteAu = "\t\"" + site + "\":\"" + author + "\",\n";
            FWAu.write(toWriteAu);

            FileWriter FWImg = new FileWriter(fileIMG, true);
            String toWriteImg = "\t\"" + site + "\":\"" + name + "\",\n";
            FWImg.write(toWriteImg);

            FileWriter FWRes = new FileWriter(fileRes, true);
            String toWriteRes = "\t\"" + site + "\":\"" + resolution + "\",\n";
            FWRes.write(toWriteRes);

            FWRes.close();
            FWAu.close();
            FWImg.close();
        }
    }
}
