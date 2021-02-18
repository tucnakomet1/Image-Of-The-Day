package sample;

import Settings.*;
import edu.stanford.ejalbert.BrowserLauncher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.awt.*;
import java.io.*;
import java.net.*;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Settings implements Initializable {

    @FXML
    private AnchorPane WholeSettingsPane, AboutPane, settingsPane, WallpaperPane, PagesPane;

    @FXML
    private ImageView BackImg, LogoImg, imgBack, GitUmg;

    @FXML
    private Button About, Settings, Wallpaper, Pages, backButton, clickPath;

    @FXML
    private Label showVersion, AuthorAb, mailLabelAb, GitMyLabelAb, VersionAb, SourceLabelAb, LicenseLabelAb;

    @FXML
    private Hyperlink AuthorMailLinkAb, GitHubLinkAb, VersionLinkAb, SourceCLinkAb, LicenseLinkAb, CheckUpdatesOnline;

    @FXML
    private CheckBox CheckAutoUpdates, CheckSplashScreen;

    @FXML
    private TextField textPathField;

    public void initialize(URL location, ResourceBundle resources) {
        BackImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/background_image.png"));
        BackImg.setPreserveRatio(false);
        BackImg.setFitWidth(1280);

        LogoImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Logo/logo.png"));
        LogoImg.setPreserveRatio(true);
        LogoImg.setFitWidth(175);

        imgBack.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/back.png"));
        imgBack.setPreserveRatio(true);
        imgBack.setFitWidth(50);

        GitUmg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/git.png"));
        GitUmg.setPreserveRatio(true);
        GitUmg.setFitWidth(50);

        String ver = null;
        try {
            ver = new CheckVersion().ReadFileVersion("/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/version.txt");
        } catch (AWTException | InterruptedException | IOException e) {
            e.printStackTrace();
        }
        VersionLinkAb.setText("v" + ver);
        showVersion.setText("Installed Version: v" + ver);

        boolean SplashChecked = CheckIsSplashScreen();
        boolean UpdatesChecked = CheckIsAutoUpdate();
        if (UpdatesChecked){
            CheckAutoUpdates.setSelected(true);
        }
        if (SplashChecked){
            CheckSplashScreen.setSelected(true);
        }

    }

    @FXML
    void aboutAction(ActionEvent event) {
        About.setStyle("-fx-background-color: #8F8F8F");
        Settings.setStyle("-fx-background-color: #444");
        Wallpaper.setStyle("-fx-background-color: #444");
        Pages.setStyle("-fx-background-color: #444");
        AboutPane.setVisible(true);
        settingsPane.setVisible(false);
        WallpaperPane.setVisible(false);
        PagesPane.setVisible(false);
    }

    @FXML
    void settingsAction(ActionEvent event) {
        About.setStyle("-fx-background-color: #444");
        Settings.setStyle("-fx-background-color: #8F8F8F");
        Wallpaper.setStyle("-fx-background-color: #444");
        Pages.setStyle("-fx-background-color: #444");
        AboutPane.setVisible(false);
        settingsPane.setVisible(true);
        WallpaperPane.setVisible(false);
        PagesPane.setVisible(false);
    }

    @FXML
    void wallAction(ActionEvent event) {
        About.setStyle("-fx-background-color: #444");
        Settings.setStyle("-fx-background-color: #444");
        Wallpaper.setStyle("-fx-background-color: #8F8F8F");
        Pages.setStyle("-fx-background-color: #444");
        AboutPane.setVisible(false);
        settingsPane.setVisible(false);
        WallpaperPane.setVisible(true);
        PagesPane.setVisible(false);
    }

    @FXML
    void pagesAction(ActionEvent event) {
        About.setStyle("-fx-background-color: #444");
        Settings.setStyle("-fx-background-color: #444");
        Wallpaper.setStyle("-fx-background-color: #444");
        Pages.setStyle("-fx-background-color: #8F8F8F");
        AboutPane.setVisible(false);
        settingsPane.setVisible(false);
        WallpaperPane.setVisible(false);
        PagesPane.setVisible(true);
    }

    @FXML
    void GetMainPageBack(ActionEvent event){
        if (event.getSource() == backButton) {
            try {
                Parent root = null;
                Stage primaryStage = new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource("MainIoTdPage.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                primaryStage.setTitle("Image Of The Day");

                assert root != null;
                Scene scene = new Scene(root);
                double maxW = 1280;
                primaryStage.setMaxWidth(maxW);
                primaryStage.setScene(scene);
                primaryStage.show();
                WholeSettingsPane.getScene().getWindow().hide();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }


    @FXML
    void OpenMail(){
        new OpenUrl("mailto:tucnakomet@gmail.com");
    }

    @FXML
    void OpenGitHub(){
        new OpenUrl("https://github.com/tucnakomet1");
    }

    @FXML
    void OpenReleases() {
        new OpenUrl("https://github.com/tucnakomet1/Image-Of-The-Day/releases");
    }

    @FXML
    void OpenSourceCode() {
        new OpenUrl("https://github.com/tucnakomet1/Image-Of-The-Day");
    }

    @FXML
    void OpenLicense() {
        new OpenUrl("https://github.com/tucnakomet1/Image-Of-The-Day/blob/master/LICENSE");
    }

    @FXML
    void BingOpen() {
        new OpenUrl("https://www.bing.com/");
    }
    @FXML
    void NasaOpen() { new OpenUrl("https://www.nasa.gov/");}
    @FXML
    void UnsplashOpen() { new OpenUrl("https://unsplash.com/"); }
    @FXML
    void NGOpen() { new OpenUrl("https://www.nationalgeographic.co.uk/");}
    @FXML
    void WikiOpen() { new OpenUrl("https://commons.wikimedia.org/wiki/Main_Page"); }
    @FXML
    void DaddyOpen() { new OpenUrl("https://biggeekdad.com/"); }
    @FXML
    void EarthOOpen() { new OpenUrl("https://earthobservatory.nasa.gov/"); }
    @FXML
    void APODOpen() { new OpenUrl("https://apod.nasa.gov/apod/astropix.html"); }
    @FXML
    void EPODOpen() { new OpenUrl("https://epod.usra.edu/"); }
    @FXML
    void NESDISOpen() { new OpenUrl("https://www.nesdis.noaa.gov/"); }


    @FXML
    void CheckUpdatesOnline() throws IOException, AWTException, InterruptedException {
        new CheckVersion().Version();
    }

    @FXML
    void OpenPathManager(ActionEvent event) throws IOException {
        DirectoryChooser dir = new DirectoryChooser();

        Stage stage = (Stage) WholeSettingsPane.getScene().getWindow();
        File file = dir.showDialog(stage);

        if (file != null) {
            System.out.println(file.getAbsoluteFile());
            textPathField.setText(String.valueOf(file.getAbsoluteFile()));
        }
    }

    @FXML
    void CheckAutoUpdatesChoice(ActionEvent event) throws IOException {
        if (CheckAutoUpdates.isSelected()){
            String filePath = "/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/AutoUpdates.txt";
            FileWriter fw = new FileWriter(filePath, false);
            fw.write("1");
            fw.close();
        }
        else{
            String filePath = "/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/AutoUpdates.txt";
            FileWriter fw = new FileWriter(filePath, false);
            fw.write("0");
            fw.close();
        }

    }

    @FXML
    void CheckSplashScreenChoice(ActionEvent event) throws IOException {
        if (CheckSplashScreen.isSelected()){
            String filePath = "//home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/SplashScreen.txt";
            FileWriter fw = new FileWriter(filePath, false);
            fw.write("1");
            fw.close();
        }
        else{
            String filePath = "/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/SplashScreen.txt";
            FileWriter fw = new FileWriter(filePath, false);
            fw.write("0");
            fw.close();
        }

    }

    public static boolean CheckIsSplashScreen() {
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

    public static boolean CheckIsAutoUpdate() {
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

}
