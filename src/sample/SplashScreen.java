package sample;

import download.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class SplashScreen implements Initializable {

    @FXML
    private AnchorPane splash_pane;

    @FXML
    private ImageView SplashImgView;

    @FXML
    private Text SplashAuthorView;

    public static String getAuthor() {
        String AuthorName = null;
        try{
            String basic_path = "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Splash/author.txt";
            File folder = new File(basic_path);
            Scanner sc = new Scanner(folder);
            while (sc.hasNextLine()) {
                AuthorName = sc.nextLine();
                return AuthorName;
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return AuthorName;

    }

    public void initialize(URL location, ResourceBundle resources) {

        new splashscreen().start();

        String[] pathnames;

        String basic_path = "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Splash/";
        File file = new File(basic_path);
        pathnames = file.list();

        assert pathnames != null;
        for (String file_name : pathnames) {
            if (file_name.contains(".png")){
                String SplashScreenImg = "file:" + basic_path + file_name;
                String SplashScreenAuthor = getAuthor();

                System.out.println("URL: " + SplashScreenImg);
                System.out.println("Author: " + SplashScreenAuthor);

                run_again(SplashScreenImg, SplashScreenAuthor);
            }
        }
    }

    public void run_again(String imageUrl, String Author) {
        SplashImgView.setImage(new Image(imageUrl));
        SplashImgView.setFitWidth(700);
        SplashAuthorView.setText(Author);
    }

    class splashscreen extends Thread {
        @Override
        public void run() {
            try {
                new UnsplashDownload(true);
                new BigGeekDaddyDownload(true);
                new NationGeoDownload(true);
                new ApodNASADownload(true);
                new WikimediaDownload(true);
                new USRA(true);
                new NASADownload(true);
                new BingDownload(true);
                new NOAADownload(true);
                new EarthObservDownload(true);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent root2 = null;
                        Stage primaryStage = new Stage();
                        try {
                            root2 = FXMLLoader.load(getClass().getResource("MainIoTdPage.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        primaryStage.setTitle("Image Of The Day");
                        assert root2 != null;
                        Scene scene = new Scene(root2);
                        double maxW = 1280;
                        primaryStage.setMaxWidth(maxW);
                        primaryStage.setScene(scene);
                        primaryStage.show();
                        splash_pane.getScene().getWindow().hide();
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
