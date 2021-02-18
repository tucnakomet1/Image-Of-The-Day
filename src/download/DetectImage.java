package download;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Iterator;

public class DetectImage {

    public DetectImage(String imgPath, String author, String site) {
        try {
            System.out.println(imgPath);
            ImageInputStream imageInputStream = ImageIO.createImageInputStream(new File(imgPath));
            Iterator<ImageReader> imageReadersList = ImageIO.getImageReaders(imageInputStream);

            if (!imageReadersList.hasNext()){
                System.out.println("this fucking problem");
                new convert_webp(imgPath, author, site);
            }
            else {
                ImageReader reader = imageReadersList.next();
                String img_format = reader.getFormatName();
                System.out.println(img_format);

                if ((img_format.equals("JPEG")) || (img_format.equals("GIF"))){
                    try {
                        new ConvertImage(imgPath, author, site);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else if (img_format.equals("WebP")){
                    try {
                        new convert_webp(imgPath, author, site);
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                else{
                    try {
                        String newImgName = imgPath + ".png";
                        boolean renameBool = new File(imgPath).renameTo(new File(newImgName));
                        BufferedImage image = ImageIO.read(new URL(newImgName));
                        String resolution = image.getWidth() + "x" + image.getHeight();

                        if (renameBool) {
                            new AddJson(newImgName, author, site, resolution);
                        }
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }
                }
                imageInputStream.close();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
