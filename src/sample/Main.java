package sample;

import Settings.*;
import download.GetImgTheYear;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main extends Application {
    private static boolean RunSplashScreen;

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("-----------------------");
        System.out.println(RunSplashScreen);
        if (InternetConnection() && RunSplashScreen) {
            System.out.println("fuckfuckfuckfuck");
            double WEIGHT = 700;
            double HIGHT = new GetImgResolution().get_img_resolution("/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Splash/", 700);

            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("SplashScreen.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setTitle("Image Of The Day");

            assert root != null;
            Scene scene = new Scene(root, WEIGHT, HIGHT);
            primaryStage.setScene(scene);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();
        }
        else {
            Parent root = null;
            primaryStage = new Stage();
            try {
                root = FXMLLoader.load(getClass().getResource("MainIoTdPage.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            primaryStage.setTitle("Image Of The Day");

            assert root != null;
            Scene scene = new Scene(root);
            double maxW = 1282;
            primaryStage.setMaxWidth(maxW);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
    }

    public static boolean RunSplash() throws IOException {
        boolean RunSplash = false;
        boolean CheckedDate = CheckDate();

        if (CheckedDate){
            System.out.println("Checked");
            Format myFormatObj = new SimpleDateFormat("yyyy/MM/dd");
            String RealDate = myFormatObj.format(new Date());

            File path = new File("/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/CheckDate.txt");
            FileWriter writer = new FileWriter(path, false);
            System.out.println("Checked");
            writer.write(RealDate);
            writer.close();
            RunSplash = true;
        }
        System.out.println(RunSplash);
        return RunSplash;
    }

    public static boolean RunAutoUpdate() {
        boolean RunAuto = true;
        try {
            File myObj = new File("/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/AutoUpdates.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("auto updates: " + data);
                if (data.contains("0")) {
                    RunAuto = false;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return RunAuto;
    }

    public static void CheckDownloadPath() throws FileNotFoundException {
        String path = null;
        String dir = "/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/DownloadPath.txt";
        Scanner myReader = new Scanner(new File(dir));
        int num = 0;
        while (myReader.hasNextLine()) {
            num++;
            if (num == 1) {
                path = myReader.nextLine();
                System.out.println(path);
            }
        }
        myReader.close();
        File REAL_PATH = new File(path);
        System.out.println(REAL_PATH + "\t" + path);
        if (!Files.exists(REAL_PATH.toPath())) {
            REAL_PATH.mkdir();
        }
    }

    public static void check_free() throws IOException {
        String[] pathname;
        String directory = "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Splash/";
        File path = new File(directory);
        pathname = path.list();

        assert pathname != null;
        for (String fileName : pathname){
            File file_to_remove = new File(directory + fileName);
            Files.delete(file_to_remove.toPath());
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

    public static Boolean CheckDate() throws FileNotFoundException {
        boolean run = true;
        String OldDate = null;

        Format myFormatObj = new SimpleDateFormat("yyyy/MM/dd");
        String RealDate = myFormatObj.format(new Date());
        System.out.println(RealDate);

        String path = "/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/CheckDate.txt";
        File myObj = new File(path);
        Scanner reader = new Scanner(myObj);

        int num = 0;
        while (reader.hasNextLine()) {
            String data = reader.nextLine();
            if (num == 0) {
                OldDate = data;
            }
            num++;
        }

        System.out.println(OldDate);

        if (RealDate.equals(OldDate)) {
            run = false;
            System.out.println("No splash screen!");
        }
        System.out.println("Boolean run is: " + run);
        return run;
    }


    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        if (RunAutoUpdate()){
            new CheckVersion().Version();
        }
        if (RunSplash()) {
            File path = new File("/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Day/");
            for (File dir: path.listFiles())
                if (!dir.isDirectory())
                    dir.delete();

            check_free();
            System.out.println("Checked free");

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
