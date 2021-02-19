package Settings;

import java.io.IOException;

public class SetWallpaper {
    public SetWallpaper() throws IOException, InterruptedException {
        //String[] LinuxCommand = {"xfconf-query", "-c", "xfce4-desktop", "-l", "|", "grep", "last-image", "|", "while", "read path;", "do", "xfconf-query", "-c", "xfce4-desktop", "-p", "$path", "-s", "/home/tucna/Desktop/Images/Unsplash-2021-02-19-08-46-19.png;", "done;"};
        //String LinuxCommand = "bash -c xfconf-query -c xfce4-desktop -l | grep last-image | while read path; do xfconf-query -c xfce4-desktop -p $path -s \"/home/tucna/Desktop/Images/Unsplash-2021-02-19-08-46-19.png\"; done";
        String LinuxCommand = "sl";
        Runtime runtime = Runtime.getRuntime();
        runtime.exec(LinuxCommand);
    }
}
