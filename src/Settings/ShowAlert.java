package Settings;

import sample.Main;

import java.awt.*;
import java.io.IOException;
import java.awt.TrayIcon.MessageType;

public class ShowAlert {
    static Main mn = new Main();
    static Class cls = mn.getClass();

    public ShowAlert(String title, String send) {
        String imgPath = (cls.getResource("/images/Logo/logo.png")).getPath();
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
