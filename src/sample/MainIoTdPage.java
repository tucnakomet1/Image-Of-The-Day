package sample;

import Settings.OpenUrl;
import Settings.SendNotif;
import Settings.SetWallpaper;
import Settings.ShowAlert;
import download.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.stream.Stream;

public class MainIoTdPage implements Initializable {
    static Main mn = new Main();
    static Class cls = mn.getClass();

    public int number;
    public boolean WelcomeRunNum = true;

    @FXML
    private AnchorPane MainPagePane;
    @FXML
    private Pane BlurPane;

    @FXML
    private ImageView BackImgYear, imgDownloadButton, imgSetWall, imgOpenPage;
    @FXML
    private ImageView imgView1, imgView2, imgView3, imgView4, imgView5, imgView6, imgView7, imgView8, imgView9, imgView10;
    @FXML
    private ImageView View1, View2, View3, View4, View5, View6, View7, View8, View9, View10;

    @FXML
    private Label DateLabel;
    @FXML
    private Label authorLabel1, authorLabel2, authorLabel3, authorLabel4, authorLabel5, authorLabel6, authorLabel7, authorLabel8, authorLabel9, authorLabel10;

    @FXML
    private Button settingsButt, downloadButt, SearchButt, DownloadButt, SetButt;


    @FXML
    void OpenImageView1() {
        number = 0;
        String Img = getJsonImg(number);

        View1.setImage(new Image("file:" + Img));
        View1.setFitWidth(580);

        BlurPane.setVisible(true);
        View1.setVisible(true);

        SearchButt.setVisible(true);
        DownloadButt.setVisible(true);
        SetButt.setVisible(true);
    }

    @FXML
    void OpenImageView2() {
        number = 1;
        String Img = getJsonImg(number);

        View2.setImage(new Image("file:" + Img));
        View2.setFitWidth(580);

        View2.setVisible(true);
        BlurPane.setVisible(true);

        SearchButt.setVisible(true);
        DownloadButt.setVisible(true);
        SetButt.setVisible(true);
    }

    @FXML
    void OpenImageView3() {
        number = 2;
        String Img = getJsonImg(number);

        View3.setImage(new Image("file:" + Img));
        View3.setFitWidth(580);

        BlurPane.setVisible(true);
        View3.setVisible(true);

        SearchButt.setVisible(true);
        DownloadButt.setVisible(true);
        SetButt.setVisible(true);
    }

    @FXML
    void OpenImageView4() {
        number = 3;
        String Img = getJsonImg(number);

        View4.setImage(new Image("file:" + Img));
        View4.setFitWidth(580);

        BlurPane.setVisible(true);
        View4.setVisible(true);

        SearchButt.setVisible(true);
        DownloadButt.setVisible(true);
        SetButt.setVisible(true);
    }

    @FXML
    void OpenImageView5() {
        number = 4;
        String Img = getJsonImg(number);

        View5.setImage(new Image("file:" + Img));
        View5.setFitWidth(580);

        BlurPane.setVisible(true);
        View5.setVisible(true);

        SearchButt.setVisible(true);
        DownloadButt.setVisible(true);
        SetButt.setVisible(true);
    }

    @FXML
    void OpenImageView6() {
        number = 5;
        String Img = getJsonImg(number);

        View6.setImage(new Image("file:" + Img));
        View6.setFitWidth(580);

        BlurPane.setVisible(true);
        View6.setVisible(true);

        SearchButt.setVisible(true);
        DownloadButt.setVisible(true);
        SetButt.setVisible(true);
    }

    @FXML
    void OpenImageView7() {
        number = 6;
        String Img = getJsonImg(number);

        View7.setImage(new Image("file:" + Img));
        View7.setFitWidth(580);

        BlurPane.setVisible(true);
        View7.setVisible(true);

        SearchButt.setVisible(true);
        DownloadButt.setVisible(true);
        SetButt.setVisible(true);
    }

    @FXML
    void OpenImageView8() {
        number = 7;
        String Img = getJsonImg(number);

        View8.setImage(new Image("file:" + Img));
        View8.setFitWidth(580);

        BlurPane.setVisible(true);
        View8.setVisible(true);

        SearchButt.setVisible(true);
        DownloadButt.setVisible(true);
        SetButt.setVisible(true);
    }

    @FXML
    void OpenImageView9() {
        number = 8;
        String Img = getJsonImg(number);

        View9.setImage(new Image("file:" + Img));
        View9.setFitWidth(580);

        BlurPane.setVisible(true);
        View9.setVisible(true);

        SearchButt.setVisible(true);
        DownloadButt.setVisible(true);
        SetButt.setVisible(true);
    }

    @FXML
    void OpenImageView10() {
        number = 9;
        String Img = getJsonImg(number);

        View10.setImage(new Image("file:" + Img));
        View10.setFitWidth(580);

        BlurPane.setVisible(true);
        View10.setVisible(true);

        SearchButt.setVisible(true);
        DownloadButt.setVisible(true);
        SetButt.setVisible(true);
    }

    @FXML
    void SearchButtGo() {
        String site = GetSiteName(number);
        System.out.println("Opening: " + site);
        switch (site) {
            case ("Unsplash") -> new OpenUrl("https://source.unsplash.com/collection/%1/3840x2160/daily");
            case ("Big Geek Daddy") -> new OpenUrl("https://biggeekdad.com/photo-of-the-day/");
            case ("National Geographic") -> new OpenUrl("https://www.nationalgeographic.co.uk/photo-of-day");
            case ("APOD NASA") -> new OpenUrl("https://apod.nasa.gov/apod/astropix.html");
            case ("Wikimedia Common") -> new OpenUrl("https://commons.wikimedia.org/wiki/Main_Page");
            case ("EPOD-USRA") -> new OpenUrl("https://epod.usra.edu/blog/");
            case ("NASA") -> new OpenUrl("https://www.nasa.gov/multimedia/imagegallery/iotd.html");
            case ("Bing") -> new OpenUrl("https://www.bing.com/");
            case ("NESDIS-NOAA") -> new OpenUrl("https://www.nesdis.noaa.gov/satellites-image-of-the-day");
            case ("Earth Observatory") -> new OpenUrl("https://earthobservatory.nasa.gov/topic/image-of-the-day");
            default -> throw new IllegalStateException("Unexpected value: " + site);
        }
    }

    @FXML
    void SetButtGo() throws IOException {
        String site = GetSiteName(number);
        System.out.println("Setting: " + site);
        String path = findPath();
        switch (site) {
            case ("Unsplash") -> {
                new UnsplashDownload(false, path);
                new SetWallpaper();
            }
            case ("Big Geek Daddy") -> {
                new BigGeekDaddyDownload(false, path);
                new SetWallpaper();
            }
            case ("National Geographic") -> {
                new NationGeoDownload(false, path);
                new SetWallpaper();
            }
            case ("APOD NASA") -> {
                new ApodNASADownload(false, path);
                new SetWallpaper();
            }
            case ("Wikimedia Common") -> {
                new WikimediaDownload(false, path);
                new SetWallpaper();
            }
            case ("EPOD-USRA") -> {
                new USRA(false, path);
                new SetWallpaper();
            }
            case ("NASA") -> {
                new SetWallpaper();
                new NASADownload(false, path);
            }
            case ("Bing") -> {
                new SetWallpaper();
                new BingDownload(false, path);
            }
            case ("NESDIS-NOAA") -> {
                new NOAADownload(false, path);
                new SetWallpaper();
            }
            case ("Earth Observatory") -> {
                new EarthObservDownload(false, path);
                new SetWallpaper();
            }
            default -> throw new IllegalStateException("Unexpected value: " + site);
        }
    }

    @FXML
    void DownloadButtGo() throws IOException {
        if (CheckDirSize()) {
            String site = GetSiteName(number);
            String path = findPath();
            System.out.println("Downloading: " + site + " to: " + path);

            switch (site) {
                case ("Unsplash") -> {
                    new ShowAlert("Downloading", "Image will be saved in " + path);
                    new UnsplashDownload(false, path);
                }
                case ("Big Geek Daddy") -> {
                    new ShowAlert("Downloading", "Image will be saved in " + path);
                    new BigGeekDaddyDownload(false, path);
                }
                case ("National Geographic") -> {
                    new ShowAlert("Downloading", "Image will be saved in " + path);
                    new NationGeoDownload(false, path);
                }
                case ("APOD NASA") -> {
                    new ShowAlert("Downloading", "Image will be saved in " + path);
                    new ApodNASADownload(false, path);
                }
                case ("Wikimedia Common") -> {
                    new ShowAlert("Downloading", "Image will be saved in " + path);
                    new WikimediaDownload(false, path);
                }
                case ("EPOD-USRA") -> {
                    new ShowAlert("Downloading", "Image will be saved in " + path);
                    new USRA(false, path);
                }
                case ("NASA") -> {
                    new ShowAlert("Downloading", "Image will be saved in " + path);
                    new NASADownload(false, path);
                }
                case ("Bing") -> {
                    new ShowAlert("Downloading", "Image will be saved in " + path);
                    new BingDownload(false, path);
                }
                case ("NESDIS-NOAA") -> {
                    new ShowAlert("Downloading", "Image will be saved in " + path);
                    new NOAADownload(false, path);
                }
                case ("Earth Observatory") -> {
                    new ShowAlert("Downloading", "Image will be saved in " + path);
                    new EarthObservDownload(false, path);
                }
                default -> throw new IllegalStateException("Unexpected value: " + site);
            }
            new SendNotif().SendInfoAlert(site, path);
        }
        else{
            new SendNotif().MaxCapacity();
        }
    }

    private boolean CheckDirSize() throws FileNotFoundException {
        boolean CanDownload = true;
        long size = 0;
        String path = findPath();
        int maxSize = FindCapacity();
        if (maxSize == 0){
        }
        else {
            try (Stream<Path> walk = Files.walk(Path.of(path))) {
                size = walk.filter(Files::isRegularFile).mapToLong(p -> {
                    try {
                        return Files.size(p);
                    } catch (IOException e) {
                        System.out.print("Failed to get size of " + p + " " + e);
                        return 0L;
                    }
                })
                        .sum();
            } catch (IOException e) {
                e.printStackTrace();
            }
            size = (int) (size / 1000000);
            int TooMuch = (maxSize / 100) * 90;
            System.out.print("Actual: " + size + "\tMax Size: " + maxSize + "\tMax calculated: " + TooMuch);

            if (size >= TooMuch) {
                CanDownload = false;
            }
        }
        return CanDownload;
    }

    private Integer FindCapacity() throws FileNotFoundException {
        String size = null;
        int maxSize = 0;
        URL dir = cls.getResource("/controllers/MaxCapacity.txt");
        Scanner myReader = new Scanner(new File(dir.getPath()));
        int num = 0;
        while (myReader.hasNextLine()) {
            num++;
            if (num == 1) {
                size = myReader.nextLine();
            }
        }
        assert size != null;
        if (!size.equals("none")) {
            maxSize = Integer.parseInt(size);
        }
        return maxSize;
    }
    private String findPath() throws FileNotFoundException {
        String path = null;
        URL dir = cls.getResource("/controllers/DownloadPath.txt");
        Scanner myReader = new Scanner(new File(dir.getPath()));
        int num = 0;
        while (myReader.hasNextLine()) {
            num++;
            if (num == 1) {
                path = myReader.nextLine();
            }
        }
        myReader.close();
        return path;
    }

    @FXML
    void CloseAnchorPane() {
        BlurPane.setVisible(false);
        View1.setVisible(false);
        View2.setVisible(false);
        View3.setVisible(false);
        View4.setVisible(false);
        View5.setVisible(false);
        View6.setVisible(false);
        View7.setVisible(false);
        View8.setVisible(false);
        View9.setVisible(false);
        View10.setVisible(false);
        SearchButt.setVisible(false);
        DownloadButt.setVisible(false);
        SetButt.setVisible(false);
    }


    @FXML
    void downloadButt() throws IOException {
        String OS = System.getProperty("os.name");
        String ImgsPath = findPath();
        if (OS.contains("Windows")) {
            Runtime.getRuntime().exec("explorer " + ImgsPath);
        }
        else if (OS.contains("Linux")) {
            try {
                Runtime.getRuntime().exec("xdg-open " + ImgsPath);
            }catch (Exception e){
                try {
                    Runtime.getRuntime().exec("gnome-open " + ImgsPath);
                }catch (Exception e1) {
                    try {
                        Runtime.getRuntime().exec("kde-open " + ImgsPath);
                    }catch (Exception e2){
                        try {
                            Runtime.getRuntime().exec("nautilus " + ImgsPath);
                        }catch (Exception e3){
                            System.out.println("Failed to open " + ImgsPath);
                            e.printStackTrace();
                            e1.printStackTrace();
                            e2.printStackTrace();
                            e3.printStackTrace();
                        }
                    }
                }
            }
        }
        if (OS.contains("Darwin")) {
            Runtime.getRuntime().exec("open" + ImgsPath);
        }
    }

    @FXML
    void settingsButtClick(ActionEvent event) {

        if (event.getSource() == settingsButt) {
            try {
                Parent root = null;
                Stage primaryStage = new Stage();
                try {
                    root = FXMLLoader.load(getClass().getResource("Settings.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                primaryStage.setTitle("Image Of The Day - Settings");

                assert root != null;
                Scene scene = new Scene(root);
                double maxW = 1280;
                primaryStage.setMaxWidth(maxW);
                primaryStage.setScene(scene);
                Image icon = new Image("file://" + (cls.getResource("/images/Logo/logo.png")).getPath());
                primaryStage.getIcons().add(icon);
                primaryStage.show();
                WelcomeRunNum = false;
                MainPagePane.getScene().getWindow().hide();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String todaysDate() {
        String date = null;

        try{
            Format format_date = new SimpleDateFormat("yyyy/MM/dd");
            date = format_date.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getImgUrl() {
        String imgUrl = null;
        String[] names;

        URL basicUrl = cls.getResource("/images/Splash/");
        File file_path = new File(basicUrl.getPath());
        names = file_path.list();

        assert names != null;
        for (String file_name : names) {
            if (file_name.contains(".png")) {
                URL imgPth = cls.getResource("/images/MainPage/background_image.png");
                imgUrl = "file://" + imgPth.getPath();
            }
        }
        return imgUrl;
    }

    public String getJsonImg(int num) {
        String site = GetSiteName(num);
        System.out.println(site);
        URL ImgPathJSON = cls.getResource("/JSON_data/img.json");
        String Img = null;
        try {
            Img = new ReadJson().GetElement(site, new FileReader(ImgPathJSON.getPath()));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return Img;
    }

    public String GetSiteName(int num){
        ArrayList<String> PrefResolList = null;
        try {
            PrefResolList = ResolPref.get_pref_resolution();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        assert PrefResolList != null;
        return PrefResolList.get(num);
    }

    public void initialize(URL location, ResourceBundle resources) {
        try {
            if (WelcomeRunNum) {
                boolean runWelcome = CheckWelcomeScreen();
                System.out.println("Welcome: " + runWelcome);
                if (runWelcome) {
                    try {
                        Parent root = null;
                        Stage primaryStage = new Stage();
                        try {
                            root = FXMLLoader.load(getClass().getResource("WelcomeScreen.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        primaryStage.setTitle("Image Of The Day - Welcome Screen");

                        assert root != null;
                        Scene scene = new Scene(root);
                        primaryStage.setMaxWidth(600);
                        primaryStage.setMaxHeight(400);
                        primaryStage.setScene(scene);
                        Image icon = new Image("file://" + (cls.getResource("/images/Logo/logo.png")).getPath());
                        primaryStage.getIcons().add(icon);
                        primaryStage.show();

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String todaysDate = todaysDate();
        System.out.println(todaysDate);
        String imageUrl = getImgUrl();
        System.out.println(imageUrl);
        try {
            run_again(imageUrl, todaysDate);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private boolean CheckWelcomeScreen() throws FileNotFoundException {
        boolean RunWelcome = false;
        int value = 0;

        String dValue = "";
        try {
            InputStream i = Main.class.getResourceAsStream("/controllers/RunWelcomeScreen.txt");
            BufferedReader r = new BufferedReader(new InputStreamReader(i));

            String dt;
            while((dt = r.readLine()) != null) {
                dValue = dValue + dt;
                value = Integer.parseInt(dValue);
            }
            i.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        System.out.println(value);

        if (value == 1) {
            RunWelcome = true;
        }
        return RunWelcome;
    }

    public void run_again(String imageUrl, String todaysDate) throws IOException, ParseException {
        ArrayList<String> PrefResolList = ResolPref.get_pref_resolution();

        String site1 = PrefResolList.get(0);
        String site2 = PrefResolList.get(1);
        String site3 = PrefResolList.get(2);
        String site4 = PrefResolList.get(3);
        String site5 = PrefResolList.get(4);
        String site6 = PrefResolList.get(5);
        String site7 = PrefResolList.get(6);
        String site8 = PrefResolList.get(7);
        String site9 = PrefResolList.get(8);
        String site10 = PrefResolList.get(9);

        if (site1.equals("100x300")){
            site1 = "580x386";
        }if (site2.equals("100x300")){
            site2 = "580x386";
        }if (site3.equals("100x300")){
            site3 = "580x386";
        }if (site4.equals("100x300")){
            site4 = "580x386";
        }if (site5.equals("100x300")){
            site5 = "580x386";
        }if (site6.equals("100x300")){
            site6 = "580x386";
        }if (site7.equals("100x300")){
            site7 = "580x386";
        }if (site8.equals("100x300")){
            site8 = "580x386";
        }if (site9.equals("100x300")){
            site9 = "580x386";
        }if (site10.equals("100x300")){
            site10 = "580x386";
        }
        String AuthorPathJSON = (cls.getResource("/JSON_data/author.json")).getPath();
        String ImgPathJSON = (cls.getResource("/JSON_data/img.json")).getPath();

        String Author1 = new ReadJson().GetElement(site1, new FileReader(AuthorPathJSON));
        String Author2 = new ReadJson().GetElement(site2, new FileReader(AuthorPathJSON));
        String Author3 = new ReadJson().GetElement(site3, new FileReader(AuthorPathJSON));
        String Author4 = new ReadJson().GetElement(site4, new FileReader(AuthorPathJSON));
        String Author5 = new ReadJson().GetElement(site5, new FileReader(AuthorPathJSON));
        String Author6 = new ReadJson().GetElement(site6, new FileReader(AuthorPathJSON));
        String Author7 = new ReadJson().GetElement(site7, new FileReader(AuthorPathJSON));
        String Author8 = new ReadJson().GetElement(site8, new FileReader(AuthorPathJSON));
        String Author9 = new ReadJson().GetElement(site9, new FileReader(AuthorPathJSON));
        String Author10 = new ReadJson().GetElement(site10, new FileReader(AuthorPathJSON));

        String Img1 = new ReadJson().GetElement(site1, new FileReader(ImgPathJSON));
        String Img2 = new ReadJson().GetElement(site2, new FileReader(ImgPathJSON));
        String Img3 = new ReadJson().GetElement(site3, new FileReader(ImgPathJSON));
        String Img4 = new ReadJson().GetElement(site4, new FileReader(ImgPathJSON));
        String Img5 = new ReadJson().GetElement(site5, new FileReader(ImgPathJSON));
        String Img6 = new ReadJson().GetElement(site6, new FileReader(ImgPathJSON));
        String Img7 = new ReadJson().GetElement(site7, new FileReader(ImgPathJSON));
        String Img8 = new ReadJson().GetElement(site8, new FileReader(ImgPathJSON));
        String Img9 = new ReadJson().GetElement(site9, new FileReader(ImgPathJSON));
        String Img10 = new ReadJson().GetElement(site10, new FileReader(ImgPathJSON));

        imgDownloadButton.setImage(new Image("file://" + (cls.getResource("/images/PNG_Sources/ImageInfo/download.png")).getPath()));
        imgDownloadButton.setPreserveRatio(true);
        imgDownloadButton.setFitWidth(37);
        imgDownloadButton.setFitHeight(34);
        imgOpenPage.setImage(new Image("file://" + (cls.getResource("/images/PNG_Sources/ImageInfo/search.png")).getPath()));
        imgOpenPage.setPreserveRatio(true);
        imgOpenPage.setFitWidth(30);
        imgOpenPage.setFitHeight(30);
        imgSetWall.setImage(new Image("file://" + (cls.getResource("/images/PNG_Sources/ImageInfo/image.png")).getPath()));
        imgSetWall.setPreserveRatio(true);
        imgSetWall.setFitWidth(42);
        imgSetWall.setFitHeight(33);


        BackImgYear.setImage(new Image(imageUrl));
        BackImgYear.setPreserveRatio(false);
        BackImgYear.setFitWidth(1280);
        BackImgYear.setFitWidth(2300);

        authorLabel1.setText(site1 + ": " + Author1);
        authorLabel2.setText(site2 + ": " + Author2);
        authorLabel3.setText(site3 + ": " + Author3);
        authorLabel4.setText(site4 + ": " + Author4);
        authorLabel5.setText(site5 + ": " + Author5);
        authorLabel6.setText(site6 + ": " + Author6);
        authorLabel7.setText(site7 + ": " + Author7);
        authorLabel8.setText(site8 + ": " + Author8);
        authorLabel9.setText(site9 + ": " + Author9);
        authorLabel10.setText(site10 + ": " + Author10);

        imgView1.setImage(new Image("file:" + Img1));
        imgView2.setImage(new Image("file:" + Img2));
        imgView3.setImage(new Image("file:" + Img3));
        imgView4.setImage(new Image("file:" + Img4));
        imgView5.setImage(new Image("file:" + Img5));
        imgView6.setImage(new Image("file:" + Img6));
        imgView7.setImage(new Image("file:" + Img7));
        imgView8.setImage(new Image("file:" + Img8));
        imgView9.setImage(new Image("file:" + Img9));
        imgView10.setImage(new Image("file:" + Img10));
        imgView1.setFitWidth(580);
        imgView2.setFitWidth(580);
        imgView3.setFitWidth(580);
        imgView4.setFitWidth(580);
        imgView5.setFitWidth(580);
        imgView6.setFitWidth(580);
        imgView7.setFitWidth(580);
        imgView8.setFitWidth(580);
        imgView9.setFitWidth(580);
        imgView10.setFitWidth(580);
        DateLabel.setText(todaysDate);
        System.out.println(site1 + ", " + site2 + ", " + site3 + ", " + site4 + ", " + site5 + ", " + site6 + ", " + site7 + ", " + site8 + ", " + site9 + ", " + site10);

        ImageView SettButtonImg = new ImageView(new Image("file://" + (cls.getResource("/images/MainPage/sett.png")).getPath()));
        SettButtonImg.setFitWidth(21);
        SettButtonImg.setFitHeight(21);
        settingsButt.setGraphic(SettButtonImg);

        ImageView DownButtonImg = new ImageView(new Image("file://" + (cls.getResource("/images/MainPage/down.png")).getPath()));
        DownButtonImg.setFitWidth(21);
        DownButtonImg.setFitHeight(21);
        downloadButt.setGraphic(DownButtonImg);
    }
}
