package Settings;

import java.awt.*;
import java.net.URI;

public class OpenUrl {
    public OpenUrl(String url) {
        try {
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            }
            else{
                String OS = System.getProperty("os.name");
                Runtime run = Runtime.getRuntime();
                try {
                    if (OS.contains("Windows")) {
                        run.exec("rundll32 url.dll,FileProtocolHandler " + url).waitFor();
                    } else if (OS.equals("Darwin")) {
                        String[] cmd = {"open", url};
                        run.exec(cmd).waitFor();
                    } else if (OS.equals("Linux")) {
                        String[] cmd = {"xdg-open", url};
                        run.exec(cmd).waitFor();
                    } else {
                        try {
                            throw new IllegalStateException();
                        } catch (IllegalStateException e1) {
                            e1.printStackTrace();
                        }
                    }
                }catch(Exception ex){
                    ex.printStackTrace();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
