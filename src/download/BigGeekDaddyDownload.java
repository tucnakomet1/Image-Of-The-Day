package download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class BigGeekDaddyDownload {

    public BigGeekDaddyDownload(boolean resize, String path) throws IOException {
        String img_url = get_url();
        String author = get_author();
        String site = "Big Geek Daddy";

        new DownloadImg(img_url, author, site, resize, path);
    }

    public static String get_url() {
        String URL = "https://biggeekdad.com/photo-of-the-day/";
        Document doc = null;
        String img_url = null;

        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert doc != null;
        Elements els = doc.select("img[src]");

        for (Element el : els ) {
            String NotImg_url = el.absUrl("src");
            String[] newIMG = NotImg_url.replaceAll("-[0-9]{3}", "::").split("::");
            String[] ImgFormat = newIMG[1].replace(".", ":").split(":");
            img_url = newIMG[0] + "." + ImgFormat[1];
            System.out.println("\nurl img: " + img_url);
        }
        return img_url;
    }

    public static String get_author() {
        ArrayList <String> fucking_article = new ArrayList();
        String author_name = null;
        Document doc = null;
        String URL = "https://biggeekdad.com/photo-of-the-day/";

        System.out.println(URL);

        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert doc != null;
        Elements els = doc.select("figcaption");
        for (Element el : els ) {
            String[] toSplit = el.toString().replace("\n", "").replace(".", " ").replaceAll("</figcaption>", "").split(" ");
            fucking_article.addAll(Arrays.asList(toSplit));
        }

        try {
            int author_indx = fucking_article.indexOf("Photo");
            author_name = fucking_article.get(author_indx + 2) + " " + fucking_article.get(author_indx + 3);

            System.out.println(author_name);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return author_name;
    }
}