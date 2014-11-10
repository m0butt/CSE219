package Application;

import JourneyUI.JourneyUI;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/**
 * Created by omar on 11/10/14.
 */
public class Main extends Application{
    public void start(Stage primaryStage) {
        try {
            JourneyUI root = new JourneyUI();
            BorderPane mainPane = root.GetMainPane();
            root.SetStage(primaryStage);
            Scene scene = new Scene(mainPane, mainPane.getWidth(), mainPane.getHeight());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
