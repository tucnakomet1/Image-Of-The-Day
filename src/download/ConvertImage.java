package download;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ConvertImage {
    public ConvertImage(String name, String author, String site) {
        try {
            File input = new File(name);
            File output = new File(name + ".png");

            BufferedImage image = ImageIO.read(input);
            BufferedImage result = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
            result.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
            ImageIO.write(result, "png", output);

            Files.delete(input.toPath());

            String Name_To_Return = name.replace(".jpg", ".png");

            String resolution = image.getWidth() + "x" + image.getHeight();

            new AddJson(Name_To_Return, author, site, resolution);


        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
