package Settings;

import fr.jcgay.notification.Notifier;
import fr.jcgay.notification.SendNotification;

import java.awt.*;
import java.io.IOException;

public class ShowNotice {

    public ShowNotice(String send, String title) throws IOException, InterruptedException {
        String OS = System.getProperty("os.name");
        System.out.println("I'm here!");
        Runtime runtime = Runtime.getRuntime();

        try {
            if (OS.contains("Windows")) {
                runtime.exec(" ").waitFor();
            } else if (OS.equals("Darwin")) {
                String[] cmd = {"open"};
                runtime.exec(cmd).waitFor();
            } else if (OS.equals("Linux")) {
                System.out.println(OS);
                //String[] command = {"notify-send", "'Image-Of-The-Day - " + title + "'", "'" + send + "'", "-u", "normal", "-t", "6000", "-i", "'/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Logo/logo.png'"};
                String[] command = {"/usr/bin/notify-send",
                        "-t",
                        "10000",
                        "Hello OSD This is my first programmatic OSD notification"};// - " + title + "'", "'" + send + "'", "-u", "normal", "-t", "6000", "-i", "'/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Logo/logo.png'"};
                System.out.println(send + "\t" + title);
                runtime.exec(command).waitFor();
                System.out.println("Done?");
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

}
