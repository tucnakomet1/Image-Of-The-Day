package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class WelcomeScreen implements Initializable {

    public int num = 0;

    public Image WelcomeImg1 = new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Welcome/WelcomeImg1.png");
    public Image WelcomeImg2 = new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Welcome/WelcomeImg2.png");
    public Image WelcomeImg3 = new Image("file:/home/tucna/Dokumenty/Java/ImageOfTheDay/images/Welcome/WelcomeImg3.png");
    public String WelcomeTxt1 = "Image-Of-The-Day is a JavaFX project that allows you to see, download or set image as a wallpaper from NASA, Bing, National Geographic, etc. in a friendly graphical interface.";
    public String WelcomeTxt2 = "You can open given web page, you can download your chosen image and you can set it as your wallpaper! In the right corner there is an icon to open directory with downloaded images.";
    public String WelcomeTxt3 = "In the left corner there is an settings icon. You can choose your download location, you can look at wallpaper preview, you can see information about web pages, report bugs and more! ";

    @FXML
    private AnchorPane AnchorWelcome;
    @FXML
    private ImageView WelcomeImage;
    @FXML
    private Label WelcomeText;
    @FXML
    private Button next, Back;
    @FXML
    private CheckBox NoAgain;


    @FXML
    void GoBack() {
        num--;
        if (num == 0) {
            WelcomeImage.setImage(WelcomeImg1);
            WelcomeText.setText(WelcomeTxt1);
            Back.setVisible(false);
            NoAgain.setVisible(false);
        }
        if (num == 1) {
            next.setText("Next");
            WelcomeImage.setImage(WelcomeImg2);
            WelcomeText.setText(WelcomeTxt2);
            Back.setVisible(true);
            NoAgain.setVisible(false);
        }
    }

    @FXML
    void GoNext() {
        num++;
        if (num == 1) {
            Back.setVisible(true);
            WelcomeImage.setImage(WelcomeImg2);
            WelcomeText.setText(WelcomeTxt2);
        }
        if (num == 2) {
            next.setText("Finish!");
            Back.setVisible(true);
            WelcomeImage.setImage(WelcomeImg3);
            WelcomeText.setText(WelcomeTxt3);
            NoAgain.setVisible(true);
        }
        if (num == 3) {
            AnchorWelcome.getScene().getWindow().hide();
        }
    }

    @FXML
    void NoAgainClick() throws IOException {
        if (NoAgain.isSelected()){
            System.out.println("Don't show this again!");
            File file = new File("/home/tucna/Dokumenty/Java/ImageOfTheDay/controllers/RunWelcomeScreen.txt");
            FileWriter fw = new FileWriter(file);
            fw.write("0");
            fw.close();
        }
        System.out.println("Who cares?!");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (num == 0){
            WelcomeImage.setImage(WelcomeImg1);
            WelcomeText.setText(WelcomeTxt1);
            Back.setVisible(false);
            NoAgain.setVisible(false);
        }
    }
}
