package Settings;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SetWallpaper {
    public SetWallpaper() throws IOException {
        new ShowAlert("Downloaded", "The image is downloaded and will be set as your wallpaper");

        String ImgPath = null;
        String OS = System.getProperty("os.name");

        Scanner sc = new Scanner(new File("/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/WallpaperPath.txt"));
        int num = 0;
        while (sc.hasNextLine()) {
            num++;
            if (num == 1) {
                ImgPath = sc.nextLine();
                System.out.println(ImgPath);
            }
        }

        assert ImgPath != null;
        if (ImgPath != null) {
            if (OS.contains("Windows")) {
                System.out.println(OS);
            } else if (OS.equals("Darwin")) {
                System.out.println(OS);
            } else if (OS.equals("Linux")) {
                String envir = GetEnviroment();
                String[] ChangeWall;
                try {
                    ChangeWall = switch (envir) {
                        case "XFCE4" -> new String[]{"bash", "-c", "xfconf-query -c xfce4-desktop -l | grep last-image | while read path; do xfconf-query -c xfce4-desktop -p $path -s " + ImgPath + "; done"};
                        case "MATE" -> new String[]{"bash", "-c", "gsettings", "set", "org.mate.background", "picture-filename " + ImgPath};
                        case "CINNAMON" -> new String[]{"bash", "-c", "gsettings", "set", "org.cinnamon.desktop.background", "picture-uri", "file://" + ImgPath};
                        case "Gnome" -> new String[]{"bash", "-c", "gconftool-2", "-t", "string", "-s", "/desktop/gnome/background/picture_filename " + ImgPath};
                        case "Gnome3" -> new String[]{"bash", "-c", "gsettings", "set", "org.gnome.desktop.background", "picture-uri", "file://" + ImgPath};
                        default -> new String[0];
                    };
                    ProcessBuilder builder = new ProcessBuilder(ChangeWall);
                    builder.redirectErrorStream(true);
                    builder.start();
                }catch(Exception e){
                    e.printStackTrace();
                }
            } else {
                System.out.println("WTF");
            }
        }
    }

    public String GetEnviroment() throws IOException {
        String[] IdCommand = {"xprop", "-root", "_NET_SUPPORTING_WM_CHECK"};
        String ID = GetRes(IdCommand);

        String enviroment = null;

        if (ID != null) {
            String[] EnvCommand = {"xprop", "-id", ID, "_NET_WM_NAME"};
            String ENV = GetRes(EnvCommand);
            if (ENV != null) {
                ENV = ENV.replaceAll("\"", "");

                if (ENV.equals("Xfwm4")) {
                    enviroment = "XFCE4";
                }
                else if (ENV.contains("Marco")) {
                    enviroment = "MATE";
                }
                else if (ENV.contains("Muffin")) {
                    enviroment = "CINNAMON";
                }
                else if (ENV.equals("Budgie")) {
                    enviroment = "Gnome3";
                }
                else {
                    enviroment = "Gnome";
                }
            }
        }
        return enviroment;
    }

    public String GetRes(String[] command) throws IOException {
        ProcessBuilder builder = new ProcessBuilder(command);
        builder.redirectErrorStream(true);
        ArrayList<String> ar = new ArrayList<>();

        Process process = builder.start();
        BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        try {
            while ((line = input.readLine()) != null) {
                ar.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String[] PreID = ar.get(0).split(" ");
        return PreID[PreID.length - 1];
    }
}
