package home;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Keziah Odoi
 */
public class Home extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = (Parent)FXMLLoader.load(getClass().getResource("HomeUI.fxml"));
        primaryStage.setTitle("Mutual Savings Credit and Debit Application");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/images/save-money.png")));
        primaryStage.show();
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
   
}
