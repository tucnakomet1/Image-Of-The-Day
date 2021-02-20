package download;

import Settings.SendNotif;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DownloadImg {
    public DownloadImg(String img_url, String author, String site, boolean resize, String path) throws IOException {
        try {
            int WIDTH, HEIGHT;

            Format myFormatObj = new SimpleDateFormat("yyyy-MM-dd-hh-mm-s");
            String formattedDate = myFormatObj.format(new Date());
            String output = path + site.replace(" ", "") + "-" + formattedDate + ".png";

            BufferedImage image = ImageIO.read(new URL(img_url));

            if (resize) {

                int PrefferedWidth = 580;
                int MaxHeight = 386;

                String[] BOTH = (GetImgResolution.get_img_resolution(img_url, PrefferedWidth, MaxHeight, false)).split(":");
                int width = Integer.parseInt(BOTH[0]);
                int height = Integer.parseInt(BOTH[1]);
                Dimension size = new Dimension(width, height);
                WIDTH = size.width;
                HEIGHT = size.height;

            }
            else{
                WIDTH = image.getWidth();
                HEIGHT = image.getHeight();
            }

            String resolution = WIDTH + "x" + HEIGHT;
            System.out.println();

            BufferedImage resized = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gd = resized.createGraphics();
            gd.drawImage(image, 0, 0, WIDTH, HEIGHT, null);
            gd.dispose();

            ImageIO.write(resized, "png", new File(output));

            System.out.println(resolution);

            if (resize) {
                System.out.println("Adding JSON");
                new AddJson(output, author, site, resolution);
            }
            System.out.println("DONE");
            System.out.println("Downloaded in: " + output);
        } catch (IOException e) {
            System.out.println("Ahoj, to se nepovedlo");
            System.out.println(String.valueOf(e));
            e.printStackTrace();
            if (resize) {
                new AddJson("/home/tucna/Dokumenty/Java/ImageOfTheDay/images/MainPage/error.png", "unknown", site, "100x300");
            }
            else {
                System.out.println("Ahoj, to se nepovedlo");
                System.out.println(String.valueOf(e));
                new SendNotif().SendDownloadErrorAlert(e);
            }
        }
    }
}
