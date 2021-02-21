package Settings;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;

import java.io.IOException;

public class SendNotif {
    public SendNotif(){
    }
    public void SendInfoAlert(String site, String path) {
        System.out.println("Alerting");
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Downloading was successful!");
        alert.setHeaderText(null);
        alert.setContentText("Your image '" + site + "' is saved in '" + path + "'.");

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("../sample/css.css").toExternalForm());
        dialogPane.getStyleClass().add("alertDialog");
        alert.show();
        System.out.println("Alerted");
    }

    public void SendErrorAlert() {
        System.out.println("Alerting");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Internet Connection Error");
        alert.setHeaderText("No Internet Connection");
        alert.setContentText("Please check your internet connection and run Image-Of-The-Day again.");

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("../sample/css.css").toExternalForm());
        dialogPane.getStyleClass().add("alertDialog");
        alert.show();
        System.out.println("Alerted");
    }

    public void SendDownloadErrorAlert(Exception e) {
        System.out.println("Alerting");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Downloading Image Error");
        alert.setHeaderText("Failed to download image.");
        alert.setContentText(String.valueOf(e));

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("../sample/css.css").toExternalForm());
        dialogPane.getStyleClass().add("alertDialog");
        alert.show();
        System.out.println("Alerted");
    }

    public void MaxCapacity() {
        System.out.println("Alerting");
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Downloading Image Error");
        alert.setHeaderText("Can not download selected image.");
        alert.setContentText("In your directory is not enaught space!\nTry to change max capacity of the folder.");

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(getClass().getResource("../sample/css.css").toExternalForm());
        dialogPane.getStyleClass().add("alertDialog");
        alert.show();
        System.out.println("Alerted");
    }
}
