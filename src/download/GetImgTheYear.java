package download;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class GetImgTheYear {
    public GetImgTheYear(){
    }

    public static ArrayList<String> get_img_of_the_year(String URL) throws IOException {
        Document doc = null;
        try {
            doc = Jsoup.connect(URL).get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements els = doc.select("img[src]");
        ArrayList<String> img_urls = new ArrayList<String>();
        ArrayList<String> author_name = new ArrayList<String>();
        ArrayList<String> url_author = new ArrayList<String>();

        for (Element el : els ) {
            String img_url = el.absUrl("src");
            if (img_url.contains(".jpg")) {
                String get_author = img_url.replace("https://api.time.com/wp-content/uploads/", "")
                        .replace("-top-100-photos-", "")
                        .replace(".jpg", "")
                        .replace("-", " ")
                        .replaceAll("[0-9]{4}\\/[0-9]{2}\\/", "")
                        .replaceAll("[0-9]", "");

                String capit_author = capitalize_author(get_author);
                author_name.add(capit_author);
                img_urls.add(img_url);
            }
        }

        int rand = (int)(Math.random() * img_urls.size());

        String author = author_name.get(rand);
        url_author.add(img_urls.get(rand)+"?quality=10");
        url_author.add(author);

        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Splash/author.txt"));
        writer.write(author);
        writer.close();

        new download_img(url_author.get(0), url_author.get(1).replace(" ", "-"));

        return url_author;
    }

    public static String capitalize_author(String author){
        char[] charArray = author.toCharArray();
        boolean foundSpace = true;

        for(int i = 0; i < charArray.length; i++) {
            if(Character.isLetter(charArray[i])) {
                if(foundSpace) {
                    charArray[i] = Character.toUpperCase(charArray[i]);
                    foundSpace = false;
                }
            }
            else {
                foundSpace = true;
            }
        }

        author = String.valueOf(charArray);
        return author;
    }
}
