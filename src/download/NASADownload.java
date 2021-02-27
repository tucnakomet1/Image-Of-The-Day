package download;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NASADownload {

    public NASADownload(boolean resize, String path) throws IOException {
        String img_url = get_url();
        String author = "NASA";
        String site = "NASA";

        System.out.println("img: " + img_url + "\nurl: " + site +  "author: " + author);

        new DownloadImg(img_url, author, site, resize, path);
    }

    public static String get_url() throws IOException {
        String fuckingRssUrl = "https://www.nasa.gov/rss/dyn/lg_image_of_the_day.rss";
        String img_url = null;

        try{
            URL RssURL = new URL(fuckingRssUrl);
            InputStreamReader streamReader = new InputStreamReader(RssURL.openStream());
            BufferedReader BuffRead = new BufferedReader(streamReader);

            String line;
            int someNumber = 0;

            while (( line = BuffRead.readLine() ) != null ){
                if( line.contains("<enclosure") ){
                    someNumber++;
                    String[] splittedLine = line.split("\"");
                    if (someNumber == 1 ) img_url = splittedLine[1];
                }
            }
            BuffRead.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        boolean redirect = false;

        assert img_url != null;
        URL newURL =  new URL(img_url);
        HttpURLConnection conn = (HttpURLConnection) newURL.openConnection();
        int status = conn.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            if (status == HttpURLConnection.HTTP_MOVED_TEMP
                    || status == HttpURLConnection.HTTP_MOVED_PERM
                    || status == HttpURLConnection.HTTP_SEE_OTHER)
                redirect = true;
        }

        if (redirect) {
            String RealUrlOfImg = conn.getHeaderField("Location");
            String biscuits = conn.getHeaderField("Set-Cookie");
            conn = (HttpURLConnection) new URL(RealUrlOfImg).openConnection();
            conn.setRequestProperty("Cookie", biscuits);

            img_url = RealUrlOfImg;
        }

        return img_url;
    }
}