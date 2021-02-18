package download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class EarthObservDownload {

    public EarthObservDownload(boolean resize) throws IOException {
        String img_url = get_url();
        String author = "Earth Observatory";
        String site = "Earth Observatory";

        new DownloadImg(img_url, author, site, resize);
    }


    public static String get_url() {
        String URL = "https://earthobservatory.nasa.gov/topic/image-of-the-day";
        System.out.println(URL);
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
            if (el.absUrl("href").contains("images/")) {
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

        try {
            assert doc2 != null;
            Elements els2 = doc2.select("a[href]");

            int ImgNum = 0;
            for (Element el2 : els2) {
                if ((el2.absUrl("href").contains("jpg")) || (el2.absUrl("href").contains("gif")) || (el2.absUrl("href").contains("png"))) {
                    System.out.println(el2.absUrl("href"));
                    ImgNum++;
                    if (ImgNum == 1) {
                        img_url = el2.absUrl("href");
                        System.out.println("url img: " + img_url);
                    }
                }
            }
        } finally {
            assert doc2 != null;
            Elements els2 = doc2.select("img[src]");

            int ImgNum = 0;
            for (Element el2 : els2) {
                if ((el2.absUrl("src").contains("jpg")) ||
                        (el2.absUrl("src").contains("gif")) ||
                        (el2.absUrl("src").contains("png")) &&
                                (!el2.absUrl("src").contains("logo")) &&
                                (!el2.absUrl("src").contains("svg"))) {
                    ImgNum++;
                    if (ImgNum == 1) {
                        img_url = el2.absUrl("src");
                        System.out.println("url img: " + img_url);
                    }
                }
            }
        }

        return img_url;
    }
}


