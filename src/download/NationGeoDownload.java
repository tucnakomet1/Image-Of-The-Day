package download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class NationGeoDownload {

    public NationGeoDownload(boolean resize, String path) throws IOException {
        String img_url = get_url();
        String author = get_author();
        String site = "National Geographic";

        System.out.println("img: " + img_url + "\nurl: " + site +  "author: " + author);

        new DownloadImg(img_url, author, site, resize, path);
    }

    public static String get_url() {
        String URL = "https://www.nationalgeographic.co.uk/photo-of-day";
        Document doc = null;
        String img_url = null;

        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert doc != null;
        Elements els = doc.select("img[src]");
        int ImgNum = 0;
        for (Element el : els ) {
            ImgNum++;
            if (ImgNum == 1) {
                String NotImg_url = el.absUrl("src");
                String[] newIMG = NotImg_url.replace("?w=", "llll").split("llll");
                img_url = newIMG[0];
            }
        }
        return img_url;
    }

    public static String get_author() {
        String author_name = null;
        Document doc = null;
        String URL = "https://www.nationalgeographic.co.uk/photo-of-day";

        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert doc != null;
        Elements els = doc.select("div.ngart-img__cont__author");

        int AuthNum = 0;
        for (Element el : els ) {
            AuthNum++;
            if (AuthNum == 1) {
                String[] toSplit = el.text().replace("Photograph by ", "").split(",");
                author_name = toSplit[0];
            }
        }
        return author_name;
    }
}