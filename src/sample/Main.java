package sample;

import Settings.CheckVersion;
import Settings.SendNotif;
import download.GetImgTheYear;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.awt.*;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main extends Application {
    private static boolean RunSplashScreen;
    static Main mn = new Main();
    static Class cls = mn.getClass();

    @Override
    public void start(Stage primaryStage) throws Exception {
        if (InternetConnection() && RunSplashScreen) {
            System.out.println(">>>>>>>> Splash Screen <<<<<<<<<");
            URL hght = cls.getResource("/images/Splash/");
            double WEIGHT = 700;
            double HIGHT = new GetImgResolution().get_img_resolution(hght.getPath(), 700);

            Parent root = null;
            try {
                root = FXMLLoader.load(cls.getResource("SplashScreen.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setTitle("Image Of The Day");

            assert root != null;
            Scene scene = new Scene(root, WEIGHT, HIGHT);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UNDECORATED);
        }
        else {
            System.out.println(">>>>>>>> Main Page <<<<<<<<<");
            Parent root = null;
            primaryStage = new Stage();
            try {
                root = FXMLLoader.load(cls.getResource("MainIoTdPage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setTitle("Image Of The Day");

            assert root != null;
            Scene scene = new Scene(root);
            double maxW = 1282;
            primaryStage.setMaxWidth(maxW);
            primaryStage.setScene(scene);
            URL icn = cls.getResource("/images/Logo/logo.png");
            Image icon = new Image("file://"+icn.getPath());
            primaryStage.getIcons().add(icon);
        }
        primaryStage.show();
    }

    public static boolean RunSplash() throws IOException {
        boolean RunSplash = false;
        boolean CheckedDate = CheckDate();

        if (CheckedDate){
            Format myFormatObj = new SimpleDateFormat("yyyy/MM/dd");
            String RealDate = myFormatObj.format(new Date());

            URL pth = cls.getResource("/controllers/CheckDate.txt");
            File path = new File(pth.getPath());
            FileWriter writer = new FileWriter(path, false);
            writer.write(RealDate);
            writer.close();
            RunSplash = true;
        }
        System.out.println(RunSplash);
        return RunSplash;
    }

    public static boolean RunAutoUpdate() {
        boolean RunAuto = true;
        String data = null;

        try {
            InputStream in = Main.class.getResourceAsStream("/controllers/AutoUpdates.txt");
            Scanner reader = new Scanner(in, StandardCharsets.UTF_8);

            while (reader.hasNextLine()) {
                data = reader.nextLine();
            }
        } catch(Exception e) { System.out.println(e); }

        if (data.contains("0")) {
            RunAuto = false;
        }
        return RunAuto;
    }

    public static void check_free() throws IOException {
        String[] pathname;
        URL directory = cls.getResource("/images/Splash/");
        File path = new File(directory.getPath());
        pathname = path.list();

        assert pathname != null;
        for (String fileName : pathname){
            if (!fileName.equals("author.txt")) {
                File file_to_remove = new File(directory.getPath() + fileName);
                Files.delete(file_to_remove.toPath());
            }
        }
    }

    private static boolean InternetConnection() {
        try {
            URL url = new URL("http://www.google.com");
            URLConnection connection = url.openConnection();
            connection.connect();
            connection.getInputStream().close();
            return true;
        } catch (IOException e) {
            new SendNotif().SendErrorAlert();
            return false;
        }
    }

    public static Integer date_time(){
        Format myFormatObj = new SimpleDateFormat("yyyy");
        String formattedDate = myFormatObj.format(new Date());
        return Integer.valueOf(formattedDate);
    }

    public static Boolean CheckDate() {
        boolean run = true;
        String OldDate = "";

        Format myFormatObj = new SimpleDateFormat("yyyy/MM/dd");
        String RealDate = myFormatObj.format(new Date());
        System.out.println(RealDate);

        try {
            InputStream in = Main.class.getResourceAsStream("/controllers/CheckDate.txt");
            Scanner reader = new Scanner(in, StandardCharsets.UTF_8);
            while (reader.hasNextLine()) {
                OldDate = reader.nextLine();
            }
        } catch(Exception e) { System.out.println(e); }

        System.out.println(OldDate);

        if (RealDate.equals(OldDate)) {
            run = false;
        }
        System.out.println("Splash screen: " + run);
        return run;
    }


    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        if (RunAutoUpdate()){
            new CheckVersion().Version();
        }
        if (RunSplash()) {
            try {
                URL url = cls.getResource("/images/Day/");
                File path = new File(url.getPath());
                for (File dir : path.listFiles())
                    if (!dir.isDirectory())
                        dir.delete();
            }catch (Exception e) {
                e.printStackTrace();
            }

            check_free();

            int year = date_time();
            int old_year = year - 1;

            String img_of_year_url = "https://time.com/" + old_year + "-photos/";
            ArrayList pic_of_year = new GetImgTheYear().get_img_of_the_year(img_of_year_url);

            String SplashScreenImg = (String) pic_of_year.get(0);
            String SplashScreenAuthor = (String) pic_of_year.get(1);

            System.out.println("URL: " + SplashScreenImg);
            System.out.println("Author: " + SplashScreenAuthor);

            RunSplashScreen = true;

        }
        launch(args);
    }
}