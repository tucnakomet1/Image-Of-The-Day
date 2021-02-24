package Settings;

import java.awt.*;
import java.net.URI;

public class OpenUrl {
    public OpenUrl(String url) {
        System.out.println(url);
        try {
            String OS = System.getProperty("os.name");
            Runtime run = Runtime.getRuntime();
            try {
                if (OS.contains("Windows")) {
                    if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                        System.out.println("wtf");
                        Desktop.getDesktop().browse(new URI(url));
                    } else {
                        run.exec("rundll32 url.dll,FileProtocolHandler " + url).waitFor();
                    }
                } else if (OS.equals("Darwin")) {
                    String[] cmd = {"open", url};
                    run.exec(cmd).waitFor();
                } else if (OS.equals("Linux")) {
                    try {
                        String[] cmd = {"x-www-browser", url};
                        System.out.println("1");
                        run.exec(cmd).waitFor();
                    } catch (Exception e0) {
                        try {
                            String[] cmd = {"xdg-open", url};
                            System.out.println("2");
                            run.exec(cmd).waitFor();
                        } catch (Exception e) {
                            try {
                                String[] cmd = {"gnome-open", url};
                                System.out.println("3");
                                run.exec(cmd).waitFor();
                            } catch (Exception e1) {
                                try {
                                    String[] cmd = {"kde-open", url};
                                    System.out.println("3");
                                    run.exec(cmd).waitFor();
                                } catch (Exception e2) {
                                    System.out.println("Failed to open " + url);
                                    e0.printStackTrace();
                                    e.printStackTrace();
                                    e1.printStackTrace();
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                } else {
                    try {
                        throw new IllegalStateException();
                    } catch (IllegalStateException e1) {
                        e1.printStackTrace();
                    }
                }
            }catch (Exception exx) {
                exx.printStackTrace();
            }
        } catch (Exception exxx) {
            exxx.printStackTrace();
        }
    }
}
