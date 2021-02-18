package download;

import com.luciad.imageio.webp.WebPReadParam;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.FileImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class convert_webp {
    public convert_webp(String name, String author, String site) throws IOException {
        String imgPath = name;
        String imgOutput = name + ".png";

        ImageReader reader = ImageIO.getImageReadersByMIMEType("image/webp").next();

        WebPReadParam readParam = new WebPReadParam();
        readParam.setBypassFiltering(true);

        reader.setInput(new FileImageInputStream(new File(imgPath)));

        BufferedImage image = reader.read(0, readParam);
        ImageIO.write(image, "png", new File(imgOutput));

        String resolution = image.getWidth() + "x" + image.getHeight();

        Files.delete(new File(imgPath).toPath());

        new AddJson(imgOutput, author, site, resolution);


    }
}
