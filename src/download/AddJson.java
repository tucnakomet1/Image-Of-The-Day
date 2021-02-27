package download;

import sample.Main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AddJson {
    static Main mn = new Main();
    static Class cls = mn.getClass();

    public AddJson(String name, String author, String site, String resolution) throws IOException {
        File fileAu = new File((cls.getResource("/JSON_data/author.json")).getPath());
        File fileIMG = new File((cls.getResource("/JSON_data/img.json")).getPath());
        File fileRes = new File((cls.getResource("/JSON_data/resolution.json")).getPath());
        
        if (resolution.equals("100x300")){
            author = "unknown";
            name = (cls.getResource("/images/MainPage/error.png")).getPath();
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
