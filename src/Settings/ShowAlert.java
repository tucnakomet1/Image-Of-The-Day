package Settings;

import java.awt.*;
import java.io.IOException;
import java.awt.TrayIcon.MessageType;
import java.net.MalformedURLException;
import java.net.URL;

public class ShowAlert {
    public static String MyPath = System.getProperty("user.dir");

    public ShowAlert(String title, String send) throws MalformedURLException {
        String imgPath = (new URL("file:" + MyPath + "/out/production/ImageOfTheDay/images/Logo/logo.png")).getPath();
        String[] LinuxNotifyCmd = {"notify-send", "'Image-Of-The-Day - " + title + "'", "'" + send + "'", "-u", "normal", "-t", "6000", "-i", imgPath};
        String[] MacNotifyCmd = {"osascript", "-e", "'display notification \"Image-Of-The-Day - " + send + "\"  with title \"" + title + "\"'"};

        String OS = System.getProperty("os.name");
        Runtime runtime = Runtime.getRuntime();

        try {
            if (OS.contains("Windows")) {
                if (SystemTray.isSupported()) {
                    SystemTray tray = SystemTray.getSystemTray();

                    Image img = Toolkit.getDefaultToolkit().createImage(imgPath);
                    TrayIcon trayIcon = new TrayIcon(img, "Image-Of-The-Day");
                    trayIcon.setImageAutoSize(true);
                    trayIcon.setToolTip("System Image-Of-The-Day");
                    tray.add(trayIcon);

                    trayIcon.displayMessage(title, send, MessageType.INFO);
                } else {
                    System.err.println("System tray not supported!");
                }
                System.out.println(OS);
            } else if (OS.equals("Darwin")) {
                System.out.println(OS);
                runtime.exec(MacNotifyCmd).waitFor();
            } else if (OS.equals("Linux")) {
                System.out.println(OS);
                RunAlert(LinuxNotifyCmd);
                System.out.println(send + "\t" + title);
            }
            else {
                try {
                    throw new IllegalStateException();
                } catch (IllegalStateException e1) {
                    e1.printStackTrace();
                }
            }
        }catch (Exception ex){
            System.out.println("wtf");
            ex.printStackTrace();
        }
    }

    public void RunAlert(String[] NotifString) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(NotifString);
        builder.redirectErrorStream(true);
        builder.start();
    }

}
