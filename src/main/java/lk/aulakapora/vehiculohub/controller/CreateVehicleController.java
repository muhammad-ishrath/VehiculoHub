package lk.aulakapora.vehiculohub.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.aulakapora.vehiculohub.dto.VehicleDTO;
import lk.aulakapora.vehiculohub.model.VehicleModel;

public class CreateVehicleController {

    //Controller - catching the data form ui to java variables and send it to model using a dto

    @FXML
    private TextField brandText;
    @FXML
    private TextField modelText;
    @FXML
    private TextField ecapacityText;
    @FXML
    private TextField tmodeText;
    @FXML
    private TextField qtyText;
    @FXML
    private TextField priceText;

    @FXML
     void  addVehicle (ActionEvent actionEvent){

        //from fxml we get only text data
        String brand = brandText.getText();
        String model = modelText.getText();
        int eCapacity = Integer.parseInt(ecapacityText.getText());
        String tMode = tmodeText.getText();
        int qty = Integer.parseInt(qtyText.getText());
        double price = Double.parseDouble(priceText.getText());

        VehicleDTO vehicleDTO = new VehicleDTO(brand,model,eCapacity,tMode,qty,price);



        if (VehicleModel.addVehicle(vehicleDTO)) {
            showAlert("Success", "Vehicle added successfully!", Alert.AlertType.INFORMATION);
        } else {
            showAlert("Error", "Failed to add vehicle.", Alert.AlertType.INFORMATION);
        }

    }

    @FXML
    void  exitbutton (ActionEvent actionEvent){
        System.exit(0);
    }

    void showAlert(String title, String msg, Alert.AlertType alertType){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }




}
