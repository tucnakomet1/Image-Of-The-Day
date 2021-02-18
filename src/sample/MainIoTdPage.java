package sample;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class MainIoTdPage implements Initializable {

    @FXML
    private AnchorPane MainPagePane;

    @FXML
    private ImageView BackImgYear;
    @FXML
    private ImageView imgView1, imgView2, imgView3, imgView4, imgView5, imgView6, imgView7, imgView8, imgView9, imgView10;

    @FXML
    private Label DateLabel;
    @FXML
    private Label authorLabel1, authorLabel2, authorLabel3, authorLabel4, authorLabel5, authorLabel6, authorLabel7, authorLabel8, authorLabel9, authorLabel10;

    @FXML
    private Button settingsButt, downloadButt;

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
                primaryStage.setTitle("Image Of The Day - settings");

                assert root != null;
                Scene scene = new Scene(root);
                double maxW = 1280;
                primaryStage.setMaxWidth(maxW);
                primaryStage.setScene(scene);
                primaryStage.show();
                MainPagePane.getScene().getWindow().hide();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String todaysDate() {
        String date = null;

        try{
            Format format_date = new SimpleDateFormat("dd/MM/yyyy");
            date = format_date.format(new Date());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getImgUrl() {
        String imgUrl = null;
        String[] names;

        String basicUrl = "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Splash/";
        File file_path = new File(basicUrl);
        names = file_path.list();

        assert names != null;
        for (String file_name : names) {
            if (file_name.contains(".png")) {
                //imgUrl = "file:" + basicUrl + file_name;
                imgUrl = "file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/background_image.png";
                System.out.println(imgUrl);
            }
        }

        return imgUrl;
    }

    public void initialize(URL location, ResourceBundle resources) {
        String todaysDate = todaysDate();
        String imageUrl = getImgUrl();
        System.out.println(imageUrl);
        try {
            run_again(imageUrl, todaysDate);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public void run_again(String imageUrl, String todaysDate) throws IOException, ParseException {
        ArrayList<String> PrefResolList = ResolPref.get_pref_resolution();
        System.out.println(PrefResolList);

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
        System.out.println(site1 + ", " + site2 + ", " + site3 + ", " + site4 + ", " + site5 + ", " + site6 + ", " + site7 + ", " + site8 + ", " + site9 + ", " + site10);

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
        System.out.println(site1 + ", " + site2 + ", " + site3 + ", " + site4 + ", " + site5 + ", " + site6 + ", " + site7 + ", " + site8 + ", " + site9 + ", " + site10);
        String AuthorPathJSON = "/home/tucna/Dokumenty/Java/ImageOfTheDay/JSON_data/author.json";
        String ImgPathJSON = "/home/tucna/Dokumenty/Java/ImageOfTheDay/JSON_data/img.json";

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

        ImageView SettButtonImg = new ImageView(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/sett.png"));
        SettButtonImg.setFitWidth(21);
        SettButtonImg.setFitHeight(21);
        settingsButt.setGraphic(SettButtonImg);

        ImageView DownButtonImg = new ImageView(new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/down.png"));
        DownButtonImg.setFitWidth(21);
        DownButtonImg.setFitHeight(21);
        downloadButt.setGraphic(DownButtonImg);
    }
}
