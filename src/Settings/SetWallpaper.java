package Settings;

import java.awt.*;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class SetWallpaper {
    public SetWallpaper() throws IOException, InterruptedException {
        //String[] LinuxCommand = {"xfconf-query", "-c", "xfce4-desktop", "-l", "|", "grep", "last-image", "|", "while", "read path;", "do", "xfconf-query", "-c", "xfce4-desktop", "-p", "$path", "-s", "/home/tucna/Desktop/Images/Unsplash-2021-02-19-08-46-19.png;", "done;"};
        //String LinuxCommand = "bash -c xfconf-query -c xfce4-desktop -l | grep last-image | while read path; do xfconf-query -c xfce4-desktop -p $path -s \"/home/tucna/Desktop/Images/Unsplash-2021-02-19-08-46-19.png\"; done";
        /*String LinuxCommand = "sl";
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(LinuxCommand);*/

        //Runtime.getRuntime().exec("xdg-open /home/tucna/Desktop/Images");
        //Runtime.getRuntime().exec("bash -c xfconf-query -c xfce4-desktop -l | grep last-image | while read path; do xfconf-query -c xfce4-desktop -p $path -s \"/home/tucna/Desktop/Images/Unsplash-2021-02-19-08-46-19.png\"; done");
        String[] comm = {"bash", "-c", "notify-send", "ahoj"};
        Runtime.getRuntime().exec(comm);

        Desktop desktop = Desktop.getDesktop();
        System.out.println("ok");
        File dirToOpen = null;
        try {
            System.out.println("okok");
            dirToOpen = new File("/home/tucna/Desktop/Images/");
            System.out.println("okokokok");
            desktop.open(dirToOpen);
            System.out.println("wtf");
        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        }
        /*Desktop desktop = Desktop.getDesktop();
        File dirToOpen = null;
        try {
            dirToOpen = new File("/home/tucna/Desktop/Images");
            desktop.open(dirToOpen);
        } catch (IllegalArgumentException iae) {
            System.out.println("File Not Found");
        }*/
    }
}
