package Settings;

import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import java.net.MalformedURLException;
import java.net.URL;

public class SendNotif {
    public static String MyPath = System.getProperty("user.dir");
    public static String CSS;

    static {
        try {
            CSS = new URL("file:" + MyPath + "/out/production/ImageOfTheDay/sample/css.css").toExternalForm();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public SendNotif(){
    }
    public void SendInfoAlert(String site, String path) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Downloading was successful!");
        alert.setHeaderText(null);
        alert.setContentText("Your image '" + site + "' is saved in '" + path + "'.");

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(CSS);
        dialogPane.getStyleClass().add("alertDialog");
        alert.show();
        System.out.println("Alerted");
    }

    public void SendErrorAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Internet Connection Error");
        alert.setHeaderText("No Internet Connection");
        alert.setContentText("Please check your internet connection and run Image-Of-The-Day again.");

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(CSS);
        dialogPane.getStyleClass().add("alertDialog");
        alert.show();
        System.out.println("Alerted");
    }

    public void SendDownloadErrorAlert(Exception e) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Downloading Image Error");
        alert.setHeaderText("Failed to download image.");
        alert.setContentText(String.valueOf(e));

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(CSS);
        dialogPane.getStyleClass().add("alertDialog");
        alert.show();
        System.out.println("Alerted");
    }

    public void MaxCapacity() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Downloading Image Error");
        alert.setHeaderText("Can not download selected image.");
        alert.setContentText("In your directory is not enaught space!\nTry to change max capacity of the folder.");

        DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(CSS);
        dialogPane.getStyleClass().add("alertDialog");
        alert.show();
        System.out.println("Alerted");
    }
}
