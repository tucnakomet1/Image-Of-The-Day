package download;

import sample.Main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class download_img {
    public static String MyPath = System.getProperty("user.dir");

    public download_img(String img_urls, String author) {
        try{
            Format myFormatObj = new SimpleDateFormat("yyyy-MM-dd-hh-mm-s");
            String formattedDate = myFormatObj.format(new Date());

            InputStream in = new URL(img_urls).openStream();
            String name_of_img = (new URL("file:" + MyPath + "/out/production/ImageOfTheDay/images/Splash/").getPath() +author+"-"+formattedDate+".jpg");

            Files.copy(in, Paths.get(name_of_img));

            convert_img(name_of_img);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void convert_img(String name){
        try {
            File input = new File(name);
            File output = new File(name.replace(".jpg", ".png"));

            BufferedImage image = ImageIO.read(input);
            BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            result.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
            ImageIO.write(result, "png", output);

            Files.delete(input.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
