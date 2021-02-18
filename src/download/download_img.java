package download;

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
    public download_img(String img_urls, String author) {
        try{
            Format myFormatObj = new SimpleDateFormat("yyyy-mm-dd-hh-mm-s");
            String formattedDate = myFormatObj.format(new Date());

            InputStream in = new URL(img_urls).openStream();
            String name_of_img = "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Splash/"+author+"-"+formattedDate+".jpg";

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

            copy_img(name.replace(".jpg", ".png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void copy_img(String name){
        File old_path = new File(name);
        File new_path = new File(name.replace("/Splash", ""));

        try {
            Files.copy(old_path.toPath(), new_path.toPath());
        } catch (Exception ex ) {
            ex.printStackTrace();
        }

    }
}
