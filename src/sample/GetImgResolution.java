package sample;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GetImgResolution {
    public GetImgResolution() {
    }
    public static double get_img_resolution(String ImgPath, int inputWIDTH) throws IOException {
        String[] pathnames;

        File files = new File(ImgPath);
        pathnames = files.list();

        int width = 0;
        int height = 0;

        assert pathnames != null;
        for (String file_name : pathnames) {
            String my_imp = ImgPath + file_name;
            System.out.println(my_imp);
            if (my_imp.contains(".png")) {
                BufferedImage bimg = ImageIO.read(new File(my_imp));
                width = bimg.getWidth();
                height = bimg.getHeight();
            }
        }

        double HIGHT = Math.round((inputWIDTH/((double) width / (height))* 10.0) / 10.0);
        System.out.println(HIGHT);

        return HIGHT;
    }
}
