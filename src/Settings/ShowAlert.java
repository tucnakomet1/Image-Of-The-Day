package Settings;

import java.io.IOException;

public class ShowAlert {

    public ShowAlert(String title, String send) {
        String[] LinuxNotifyCmd = {"notify-send", "'Image-Of-The-Day - " + title + "'", "'" + send + "'", "-u", "normal", "-t", "6000", "-i", "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Logo/logo.png"};
        String[] WinNotifyCmd = {"notify-send", "'Image-Of-The-Day - " + title + "'", "'" + send + "'", "-u", "normal", "-t", "6000", "-i", "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Logo/logo.png"};

        String OS = System.getProperty("os.name");
        Runtime runtime = Runtime.getRuntime();

        try {
            if (OS.contains("Windows")) {
                System.out.println(OS);
                RunAlert(WinNotifyCmd);
            } else if (OS.equals("Darwin")) {
                System.out.println(OS);
                String[] cmd = {"open"};
                runtime.exec(cmd).waitFor();
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
