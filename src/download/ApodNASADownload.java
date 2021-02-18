package download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class ApodNASADownload {

    public ApodNASADownload(boolean resize) throws IOException {
        String img_url = get_url();
        String author = get_author();
        String site = "APOD NASA";

        new DownloadImg(img_url, author, site, resize);
    }

    public static String get_url() {
        String URL = "https://apod.nasa.gov/apod/astropix.html";
        System.out.println(URL);
        Document doc = null;
        String img_url = null;

        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert doc != null;
        Elements els = doc.select("a[href]");
        int ImgNum = 0;
        for (Element el : els ) {
            ImgNum++;
            if (ImgNum == 2) {
                img_url = el.absUrl("href");

                System.out.println("url img: " + img_url);
            }
        }
        return img_url;
    }

    public static String get_author() {
        String author_name = "Error";
        try {
            Document doc = null;
            String URL = "https://apod.nasa.gov/apod/astropix.html";

            try {
                doc = Jsoup.connect(URL).get();
            } catch (IOException e) {
                e.printStackTrace();
            }

            assert doc != null;
            Elements els = doc.select("center");

            int AuthNum = 0;
            for (Element el : els) {
                AuthNum++;
                if (AuthNum == 2) {
                    String[] toSplit = el.text().split(",");
                    if (toSplit[0].contains(";")) {
                        String[] toSplit2 = toSplit[0].split(";");
                        author_name = (toSplit2[0].split(": ")[1]).replace(" /", ",");
                    } else {
                        author_name = (toSplit[0].split(": ")[1]).replace(" /", ",");
                    }
                }
            }


            try {
                System.out.println(author_name);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        return author_name;
    }
}