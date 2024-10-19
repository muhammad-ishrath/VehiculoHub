package lk.aulakapora.vehiculohub.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuVehicleController {

    @FXML
    void openCreateVehicleWindow(ActionEvent actionEvent){
        showWindow("/lk/aulakapora/vehiculohub/create-vehicle-view.fxml","Create Vehicle");
    }

    @FXML
    void openViewAllVehicleWindow(ActionEvent actionEvent){

    }

    @FXML
    void openUpdateVehicleWindow(ActionEvent actionEvent){

    }

    @FXML
    void openDeleteVehicleWindow(ActionEvent actionEvent){

    }
    @FXML
    void closeApplication(ActionEvent actionEvent){
        System.exit(0);
    }


    public void showWindow(String fxmlFile, String title){
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
        try {
            Parent root  = loader.load();
            Scene scene = new Scene(root);
            // Scene scene = new Scene(loader.load ); here same thing no need parent
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
