package download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class USRA {

    public USRA(boolean resize, String path) throws IOException {
        String img_url = get_url();
        String author = get_author(img_url);
        String site = "EPOD-USRA";

        new DownloadImg(img_url, author, site, resize, path);
    }

    public static String get_url() {
        String URL = "https://epod.usra.edu/blog/";
        Document doc = null;
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
            if (el.absUrl("href").contains("-pi")) {
                httpNum++;
                if (httpNum == 1) {
                    img_url = el.absUrl("href");
                    System.out.println(img_url);
                }
            }
        }
        return img_url;
    }

    public static String get_author(String img_url) {
        String author_name = null;
        Document doc = null;
        String URL = "https://epod.usra.edu/blog/";

        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        assert doc != null;
        Elements els = doc.select("p");

        int AuthNum = 0;
        for (Element el : els ) {
            try {
                AuthNum++;
                if (AuthNum == 3) {
                    String[] author_names = el.text().split(" Summary");

                    author_name = author_names[0].replace("Photographer: ", "");
                    if (CheckLett(author_name) > 40) {
                        System.out.println(CheckLett(author_name));
                        throw new Exception("An Error Occurred!\nFailed to download " + img_url);
                    } else {
                        System.out.println(author_name);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
                System.out.println("Failed to download " + img_url);
                author_name = "unknown";
                System.out.println(author_name);
            }
        }
        return author_name;
    }

    public static Integer CheckLett(String name){
        int count = 0;
        for (int i = 0; i < name.length(); i++) {
            if (Character.isLetter(name.charAt(i)))
                count++;
        }
        return count;
    }
}
