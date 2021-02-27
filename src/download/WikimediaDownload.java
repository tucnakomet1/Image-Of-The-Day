package download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WikimediaDownload {
    public WikimediaDownload(boolean resize, String path) throws IOException {
        String[] splitted_urls = get_url().split(" /// ");

        String img_url = splitted_urls[0];
        String http_url = splitted_urls[1];
        String author = get_author(http_url);
        String site = "Wikimedia Common";

        System.out.println("img: " + img_url + "\nurl: " + site +  "author: " + author);

        new DownloadImg(img_url, author, site, resize, path);
    }

    public static String get_url() {
        String URL = "https://commons.wikimedia.org/wiki/Main_Page";
        Document doc = null;
        Document doc2 = null;
        String http_url = null;
        String img_url = null;

        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert doc != null;
        Elements els = doc.select("a[href]");
        int httpNum = 0;
        for (Element el : els ) {
            if ((el.absUrl("href").contains("jpg")) ||
                    (el.absUrl("href").contains("jpeg")) ||
                    (el.absUrl("href").contains("png")) ||
                    (el.absUrl("href").contains("webp"))) {

                httpNum++;

                if (httpNum == 1) {
                    http_url = el.absUrl("href");
                }
            }
        }

        try {
            doc2 = Jsoup.connect(http_url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert doc2 != null;
        Elements els2 = doc2.select("a[href]");

        int ImgNum = 0;
        for (Element el2 : els2 ) {
            if (el2.absUrl("href").contains("upload")){

                ImgNum++;
                if (ImgNum == 1) {
                    img_url = el2.absUrl("href");
                }
            }
        }

        return img_url + " /// " + http_url;
    }

    public static String get_author(String URL) {
        String author_name = null;
        Document doc = null;

        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert doc != null;
        Elements els = doc.select("a[title]");

        int AuthNum = 0;
        for (Element el : els ) {
            if (el.toString().contains("User:")) {
                AuthNum++;
                if (AuthNum == 1) {
                    author_name = el.text();
                }
            }
        }

        return author_name;
    }
}