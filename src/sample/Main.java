package sample;

import Settings.*;
import download.GetImgTheYear;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.Notifications;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        if (RunSplash()) {
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

    public static boolean RunSplash() {
        boolean RunSplash = true;
        try {
            File myObj = new File("/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/SplashScreen.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("splash screen" + data);
                if (data.contains("0")) {
                    RunSplash = false;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return RunSplash;
    }

    public static boolean RunAutoUpdate() {
        boolean RunSplash = true;
        try {
            File myObj = new File("/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/AutoUpdates.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println("auto updates: " + data);
                if (data.contains("0")) {
                    RunSplash = false;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
        }
        return RunSplash;
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

    public static Integer date_time(){
        Format myFormatObj = new SimpleDateFormat("yyyy");
        String formattedDate = myFormatObj.format(new Date());
        return Integer.valueOf(formattedDate);
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

            int year = date_time();
            int old_year = year - 1;

            String img_of_year_url = "https://time.com/" + old_year + "-photos/";
            ArrayList pic_of_year = new GetImgTheYear().get_img_of_the_year(img_of_year_url);

            String SplashScreenImg = (String) pic_of_year.get(0);
            String SplashScreenAuthor = (String) pic_of_year.get(1);

            System.out.println("URL: " + SplashScreenImg);
            System.out.println("Author: " + SplashScreenAuthor);
        }


        launch(args);
    }
}
