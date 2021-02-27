package download;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class GetImgResolution {
    public GetImgResolution() {
    }

    public static String get_img_resolution(String Img, int WIDTH, int MaxHeight, boolean online) throws IOException {
        String RESULT = "100:300";
        try {
            String[] pathnames;

            File files = new File(Img);
            pathnames = files.list();

            int width = 0;
            int height = 0;

            if (online) {
                assert pathnames != null;
                for (String file_name : pathnames) {
                    String my_imp = Img + file_name;
                    if (my_imp.contains(".png")) {
                        BufferedImage bimg = ImageIO.read(new File(my_imp));
                        width = bimg.getWidth();
                        height = bimg.getHeight();
                    }
                }
            } else {
                URL url = new URL(Img);
                BufferedImage bimg = ImageIO.read(url);

                width = bimg.getWidth();
                height = bimg.getHeight();
            }

            int HEIGHT = (int) Math.round((WIDTH / ((double) width / (height)) * 10.0) / 10.0);

            if (HEIGHT > MaxHeight) {
                HEIGHT = MaxHeight;
                WIDTH = (int) Math.round((HEIGHT * ((double) width / (height)) * 10.0) / 10.0);
            }
            RESULT = WIDTH + ":" + HEIGHT;
            return RESULT;
        }catch (Exception e){
            e.printStackTrace();
        }
        return RESULT;
    }
}
