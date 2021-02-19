package download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class BingDownload {

    public BingDownload(boolean resize, String path) throws IOException {
        String[] splitted_urls = get_url().split(" /// ");

        String img_url = splitted_urls[0];
        String http_url = splitted_urls[1];
        String author = get_author(http_url);

        String site = "Bing";

        new DownloadImg(img_url, author, site, resize, path);
    }

    public static String get_url() {
        String URL = "https://bing.gifposter.com/";
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
            if (el.absUrl("href").contains("wallpaper")) {
                httpNum++;

                if (httpNum == 1) {
                    http_url = el.absUrl("href");
                    System.out.println(http_url);
                }
            }
        }

        try {
            doc2 = Jsoup.connect(http_url).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert doc2 != null;
        Elements els2 = doc2.select("img[src]");

        int ImgNum = 0;
        for (Element el2 : els2 ) {
            if (el2.absUrl("src").contains("jpg")){
                ImgNum++;
                if (ImgNum == 2) {
                    img_url = el2.absUrl("src");
                    System.out.println("url img: " + img_url);
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
        Elements els = doc.select("div.title");

        int AuthNum = 0;
        for (Element el : els ) {
            AuthNum++;
            if (AuthNum <= 30) {
                String[] almostDone = el.text().replace(" © ", "/").split("/");
                author_name = almostDone[1];
                System.out.println(author_name);
            }
        }

        return author_name;
    }
}