package sample;

import Settings.CheckVersion;
import Settings.OpenUrl;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.awt.*;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Settings implements Initializable {

    @FXML
    private AnchorPane WholeSettingsPane, AboutPane, settingsPane, WallpaperPane, PagesPane;

    @FXML
    private ImageView BackImg, LogoImg, imgBack, GitUmg, WallpaperBackgrounImage, monitor_img, BrowserImg, FolderImg, FileImg, TaskBarImg, TaskBarLinuxImg, MacTaskBarImg, GitReport;
    @FXML
    private ImageView SiteImage, SiteLogo;

    @FXML
    private Button About, Settings, Wallpaper, Pages, backButton;

    @FXML
    private Label showVersion, SiteInfo;

    @FXML
    private Hyperlink VersionLinkAb;

    @FXML
    private CheckBox CheckAutoUpdates, MaxCapacityClick, RunStartupCheck;

    @FXML
    private TextField textPathField;

    @FXML
    private ChoiceBox<String> ChoiceBoxSetSource, MaxCapacityBox, ChoicePage;


    public void initialize(URL location, ResourceBundle resources) {
        String OS = System.getProperty("os.name");
        monitor_img.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/monitor.png"));
        monitor_img.setPreserveRatio(true);
        monitor_img.setFitWidth(530);

        BrowserImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/brave.png"));
        BrowserImg.setPreserveRatio(true);
        BrowserImg.setFitWidth(50);

        System.out.println(OS);
        //OS = "Windows";
        if (OS.contains("Linux")){
            FolderImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/Linux/LinuxFolder.png"));
            FolderImg.setPreserveRatio(true);
            FolderImg.setFitWidth(25);
            FileImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/Linux/LinuxFile.png"));
            FileImg.setPreserveRatio(true);
            FileImg.setFitWidth(25);
            TaskBarLinuxImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/Linux/LinuxTaskBar.png"));
            TaskBarLinuxImg.setPreserveRatio(true);
            TaskBarLinuxImg.setFitWidth(40);
        }
        else if (OS.contains("Windows")){
            FolderImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/Windows/WindowsFolder.png"));
            FolderImg.setPreserveRatio(true);
            FolderImg.setFitWidth(25);
            FileImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/Windows/WindowsFile.png"));
            FileImg.setPreserveRatio(true);
            FileImg.setFitWidth(25);
            TaskBarImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/Windows/WindowsTaskBar.png"));
            TaskBarImg.setPreserveRatio(true);
            TaskBarImg.setFitWidth(470);
        }
        else if (OS.contains("Mac")){
            FolderImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/MacOs/MacFolder.png"));
            FolderImg.setPreserveRatio(true);
            FolderImg.setFitWidth(25);
            FileImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/MacOs/MacFile.png"));
            FileImg.setPreserveRatio(true);
            FileImg.setFitWidth(25);
            MacTaskBarImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/MacOs/MacTaskBar.png"));
            MacTaskBarImg.setPreserveRatio(true);
            MacTaskBarImg.setFitWidth(370);
        }

        ChoiceBoxSetSource.getItems().add("Unsplash");
        ChoiceBoxSetSource.getItems().add("Bing");
        ChoiceBoxSetSource.getItems().add("NASA");
        ChoiceBoxSetSource.getItems().add("National Geographic");
        ChoiceBoxSetSource.getItems().add("Wikimedia Common");
        ChoiceBoxSetSource.getItems().add("EPOD-USRA");
        ChoiceBoxSetSource.getItems().add("NESDIS-NOAA");
        ChoiceBoxSetSource.getItems().add("Earth Observatory");
        ChoiceBoxSetSource.getItems().add("Big Geek Daddy");
        ChoiceBoxSetSource.getItems().add("APOD NASA");

        ChoiceBoxSetSource.setValue("None");

        try {
            textPathField.setText(GetDownloadPath());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ChoiceBoxSetSource.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
            System.out.println(newValue);

            String ImgPathJSON = "/home/tucna/Dokumenty/Java/ImageOfTheDay/JSON_data/img.json";

            String img = null;
            try {
                img = new ReadJson().GetElement(newValue, new FileReader(ImgPathJSON));
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

            WallpaperBackgrounImage.setImage(new Image("file:" + img));
            WallpaperBackgrounImage.setPreserveRatio(false);
            WallpaperBackgrounImage.setFitWidth(500);
            WallpaperBackgrounImage.setFitHeight(282);
        });


        BackImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/MainPage/background_image.png"));
        BackImg.setPreserveRatio(false);
        BackImg.setFitWidth(1280);

        LogoImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Logo/logo.png"));
        LogoImg.setPreserveRatio(true);
        LogoImg.setFitWidth(175);

        imgBack.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/Settings/back.png"));
        imgBack.setPreserveRatio(true);
        imgBack.setFitWidth(40);
        imgBack.setFitHeight(40);

        GitUmg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/Settings/git.png"));
        GitUmg.setPreserveRatio(true);
        GitUmg.setFitWidth(75);

        GitReport.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/PNG_Sources/Settings/report.png"));
        GitReport.setPreserveRatio(true);
        GitReport.setFitWidth(40);

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
    }

    private String GetDownloadPath() throws FileNotFoundException {
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

        return path;
    }

    @FXML
    void aboutAction() {
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
    void settingsAction() {
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
    void wallAction() {
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
    void pagesAction() {
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
    void OpenGitHubReport(){
        new OpenUrl("https://github.com/tucnakomet1/Image-Of-The-Day/issues");
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
    void ShowBingInfo() {
        SiteImage.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/Bing/bing.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(490);
        SiteLogo.setFitHeight(255);

        SiteLogo.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/Bing/logo.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(167);
        SiteLogo.setFitHeight(200);

        SiteInfo.setText("Microsoft Bing is a web search engine owned and operated by Microsoft. The service has its origins in Microsoft's previous search engines: MSN Search, Windows Live Search and later Live Search. Bing provides a variety of search services, including web, video, image and map search products");
    }
    @FXML
    void ShowNasaInfo() {
        SiteImage.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/NASA/nasa.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(490);
        SiteLogo.setFitHeight(255);

        SiteLogo.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/NASA/logo.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(200);
        SiteLogo.setFitHeight(150);

        SiteInfo.setText("The National Aeronautics and Space Administration is an independent agency of the U.S. federal government responsible for the civilian space program, as well as aeronautics and space research. NASA was established in 1958, succeeding the National Advisory Committee for Aeronautics.");
    }
    @FXML
    void ShowUnsplashInfo() {
        SiteImage.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/Unsplash/unsplash.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(490);
        SiteLogo.setFitHeight(255);

        SiteLogo.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/Unsplash/logo.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(200);
        SiteLogo.setFitHeight(200);

        SiteInfo.setText("Unsplash is a website dedicated to sharing stock photography under the Unsplash license. The website claims over 207,000 contributing photographers and generates more than 17 billion photo impressions per month on their growing library of over 2 million photos");
    }
    @FXML
    void ShowNgInfo() {
        SiteImage.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/NG/ng.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(490);
        SiteLogo.setFitHeight(255);

        SiteLogo.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/NG/logo.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(200);
        SiteLogo.setFitHeight(150);

        SiteInfo.setText("National Geographic is the long-lived official monthly magazine of the National Geographic Society. It is one of the most widely read magazines of all time.");
    }
    @FXML
    void ShowWikiInfo() {
        SiteImage.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/Wiki/wiki.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(490);
        SiteLogo.setFitHeight(255);

        SiteLogo.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/Wiki/logo.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(152);
        SiteLogo.setFitHeight(200);

        SiteInfo.setText("Wikimedia Commons is an online repository of free-use images, sounds, other media, and JSON files. It is a project of the Wikimedia Foundation. Files from Wikimedia Commons can be used across all Wikimedia projects in all languages, including Wikipedia, Wiktionary, Wikibooks, Wikivoyage, Wikispecies, Wikisource, and Wikinews, or downloaded for offsite use.");
    }
    @FXML
    void ShowBGDInfo() {
        SiteImage.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/BGD/bgd.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(490);
        SiteLogo.setFitHeight(255);

        SiteLogo.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/BGD/logo.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(200);
        SiteLogo.setFitHeight(200);

        SiteInfo.setText("I like to share videos that I find funny, interesting, cool, or otherwise entertaining as well as some computer information I think people might find helpful. I have a very diverse set of interests and a sense of humor.");
    }
    @FXML
    void ShowEOInfo() {
        SiteImage.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/EO/eo.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(490);
        SiteLogo.setFitHeight(255);

        SiteLogo.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/EO/logo.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(200);
        SiteLogo.setFitHeight(104);

        SiteInfo.setText("NASA Earth Observatory is an online publishing outlet for NASA which was created in 1999. It is the principal source of satellite imagery and other scientific information pertaining to the climate and the environment which are being provided by NASA for consumption by the general public.");
    }
    @FXML
    void ShowAPODInfo() {
        SiteImage.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/APOD/apod.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(490);
        SiteLogo.setFitHeight(255);

        SiteLogo.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/APOD/logo.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(200);
        SiteLogo.setFitHeight(200);

        SiteInfo.setText("Astronomy Picture of the Day is a website provided by NASA and Michigan Technological University. According to the website, \"Each day a different image or photograph of our universe is featured, along with a brief explanation written by a professional astronomer.\" The photograph does not necessarily correspond to a celestial event on the exact day that it is displayed, and images are sometimes repeated");
    }
    @FXML
    void ShowEPODInfo() {
        SiteImage.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/EPOD/epod.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(490);
        SiteLogo.setFitHeight(255);

        SiteLogo.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/EPOD/logo.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(200);
        SiteLogo.setFitHeight(146);

        SiteInfo.setText("The USRA standard locomotives and railroad cars were designed by the United States Railroad Administration, the nationalized rail system of the United States during World War I. 1,856 steam locomotives and over 100,000 railroad cars were built to these designs during the USRA's tenure");
    }
    @FXML
    void ShowNESDISInfo() {
        SiteImage.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/NESDIS/nesdis.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(490);
        SiteLogo.setFitHeight(255);

        SiteLogo.setImage(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sites/NESDIS/logo.png"));
        SiteLogo.setPreserveRatio(true);
        SiteLogo.setFitWidth(200);
        SiteLogo.setFitHeight(200);

        SiteInfo.setText("The National Environmental Satellite, Data, and Information Service was created by the National Oceanic and Atmospheric Administration to operate and manage the United States environmental satellite programs, and manage the data gathered by the National Weather Service and other government agencies and departments.");
    }

    @FXML
    void CheckUpdatesOnline() throws IOException, AWTException, InterruptedException {
        new CheckVersion().Version();
    }

    @FXML
    void OpenPathManager() throws IOException {
        DirectoryChooser dir = new DirectoryChooser();

        Stage stage = (Stage) WholeSettingsPane.getScene().getWindow();
        File file = dir.showDialog(stage);

        if (file != null) {
            System.out.println(file.getAbsoluteFile());
            String SelectedPath = String.valueOf(file.getAbsoluteFile());
            textPathField.clear();
            textPathField.setText(SelectedPath);

            File FilePath = new File("/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/DownloadPath.txt");
            FileWriter fWriter = new FileWriter(FilePath, false);
            fWriter.write(SelectedPath + "/");
            fWriter.close();
        }
    }

    @FXML
    void CheckAutoUpdatesChoice() throws IOException {
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
    void RunAtStartupCheck() {
        if (!RunStartupCheck.isSelected()) {
            ChoicePage.setDisable(true);
            ChoicePage.setValue("-None-");
        }
        else {
            ChoicePage.setDisable(false);

            ChoicePage.getItems().add("Unsplash");
            ChoicePage.getItems().add("Bing");
            ChoicePage.getItems().add("NASA");
            ChoicePage.getItems().add("National Geographic");
            ChoicePage.getItems().add("Wikimedia Common");
            ChoicePage.getItems().add("EPOD-USRA");
            ChoicePage.getItems().add("NESDIS-NOAA");
            ChoicePage.getItems().add("Earth Observatory");
            ChoicePage.getItems().add("Big Geek Daddy");
            ChoicePage.getItems().add("APOD NASA");
            ChoicePage.getItems().add("All - random choose");

            ChoicePage.setValue("-None-");

            MaxCapacityBox.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, page) -> {
                System.out.println(page);
            });
        }
    }

    @FXML
    void MaxCapacityClickChoice() {
        if (!MaxCapacityClick.isSelected()){
            MaxCapacityBox.setDisable(true);
            String path = "/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/MaxCapacity.txt";

            File file = new File(path);
            try {
                FileWriter fw = new FileWriter(file, false);
                fw.write("none");
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            MaxCapacityBox.setDisable(false);

            MaxCapacityBox.getItems().add("100 MB");
            MaxCapacityBox.getItems().add("200 MB");
            MaxCapacityBox.getItems().add("500 MB");
            MaxCapacityBox.getItems().add("1024 MB");
            MaxCapacityBox.getItems().add("2048 MB");
            MaxCapacityBox.getItems().add("4096 MB");

            MaxCapacityBox.setValue("100 MB");

            MaxCapacityBox.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, capacity) -> {
                System.out.println(capacity);

                String path = "/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/MaxCapacity.txt";

                File file = new File(path);
                try {
                    FileWriter fw = new FileWriter(file, false);
                    fw.write(capacity.replace(" MB", ""));
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
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
