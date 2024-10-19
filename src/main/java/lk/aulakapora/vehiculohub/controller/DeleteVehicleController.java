package lk.aulakapora.vehiculohub.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.aulakapora.vehiculohub.model.VehicleModel;

public class DeleteVehicleController {


    @FXML
    void close(ActionEvent actionEvent){
        MenuVehicleController.close();
    }

    @FXML
    private TextField vehicleIdText;

    @FXML
    void deleteVehicle(ActionEvent actionEvent){


        int vid  =  Integer.parseInt(vehicleIdText.getText());

        if (VehicleModel.deleteVehicle(vid)){

            MenuVehicleController.showAlert("Success", "Vehicle Deleted Successfully", Alert.AlertType.INFORMATION);
        }else {
            MenuVehicleController.showAlert("Fail", "No Vehicle Found", Alert.AlertType.INFORMATION);
        }
    }


}
