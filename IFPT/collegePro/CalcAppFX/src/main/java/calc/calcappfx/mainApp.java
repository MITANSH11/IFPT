package calc.calcappfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class mainApp extends Application {
    private static Stage MainStage;
    @Override
    public void start(Stage stage) throws IOException {
        MainStage= stage;

        FXMLLoader fxmlLoader = new FXMLLoader(mainApp.class.getResource("first-frame.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);

        stage.setTitle("Calculators");
        stage.setScene(scene);
        stage.show();
    }

    public static void changePage(String fxml, String titleName) throws IOException {
        Parent root = FXMLLoader.load(mainApp.class.getResource(fxml));
        MainStage.setScene(new Scene(root));
        MainStage.setTitle(titleName);
    }

    public static Stage getMainStage() {
        return MainStage;
    }

    public static void main(String[] args) {
        launch();
    }
}