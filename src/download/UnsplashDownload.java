package download;

import java.io.IOException;

public class UnsplashDownload {

    public UnsplashDownload(boolean resize, String path) throws IOException {
        String img_url = "https://source.unsplash.com/collection/%1/3840x2160/daily";
        String author = "Unsplash";
        String site = "Unsplash";

        System.out.println("\nimg: " + img_url + "\nurl: " + site +  "\nauthor: " + author);

        new DownloadImg(img_url, author, site, resize, path);
    }
}