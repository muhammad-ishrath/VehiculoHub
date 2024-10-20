package lk.aulakapora.vehiculohub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("update-vehicle-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("\uD83D\uDE99✨ VehiculoHub ✨\uD83D\uDE97");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}