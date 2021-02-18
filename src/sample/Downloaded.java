package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Downloaded implements Initializable {

    @FXML
    private AnchorPane DownloadedPane;

    @FXML
    private ImageView BackImg;

    @FXML
    private Button BackButton;

    @FXML
    void GetMainPageBack(ActionEvent event){
        if (event.getSource() == BackButton) {
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
                DownloadedPane.getScene().getWindow().hide();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        BackImg.setImage(new Image("file:" + "/home/tucna/Dokumenty/Java/ImageOfTheDay/images/background_image.png"));
        BackImg.setPreserveRatio(false);
        BackImg.setFitWidth(1280);
    }
}
