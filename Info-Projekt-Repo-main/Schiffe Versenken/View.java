import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class View extends Application {
    private Stage fenster;
    //Benötigt zum Starten
    public static void main(String[] args) {

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        fenster = primaryStage;
        fenster.setTitle("Schiffe Versenken");
        fenster.setResizable(false);

        VBox box = new VBox();
        
        Scene szene1 = new Scene(box, 700, 700);
        primaryStage.setScene(szene1);
        primaryStage.show();
    }

}