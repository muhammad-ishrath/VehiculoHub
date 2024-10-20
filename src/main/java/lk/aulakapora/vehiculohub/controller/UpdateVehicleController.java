package lk.aulakapora.vehiculohub.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import lk.aulakapora.vehiculohub.dto.VehicleDTO;
import lk.aulakapora.vehiculohub.model.VehicleModel;

import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateVehicleController {

    @FXML
    TextField vehicleIdText;

    @FXML
    TextField brandText;
    @FXML
    TextField modelText;
    @FXML
    TextField engineCapacityText;
    @FXML
    TextField transmissionModeText;
    @FXML
    TextField quantityText;
    @FXML
    TextField priceText;





    @FXML
    void search(ActionEvent actionEvent){
        int vid = Integer.parseInt(vehicleIdText.getText());
        try {
            VehicleDTO vehicleDTO =  VehicleModel.searchVehicle(vid);

            brandText.setText(vehicleDTO.getBrand());
            modelText.setText(vehicleDTO.getModel());
            engineCapacityText.setText(String.valueOf(vehicleDTO.geteCapacity()));
            transmissionModeText.setText(vehicleDTO.gettMode());
            quantityText.setText(String.valueOf(vehicleDTO.getQty()));
            priceText.setText(String.valueOf(vehicleDTO.getPrice()));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void update(ActionEvent actionEvent){
        int vid = Integer.parseInt(vehicleIdText.getText());
        String brand = brandText.getText();
        String model = modelText.getText();
        int eCapacity = Integer.parseInt(engineCapacityText.getText());
        String tMode = transmissionModeText.getText();
        int qty = Integer.parseInt(quantityText.getText());
        double price = Double.parseDouble(priceText.getText());

        VehicleDTO vehicleDTO = new VehicleDTO(vid, brand, model, eCapacity, tMode, qty, price);

        try {
            boolean isUpdated = VehicleModel.updateVehicle(vehicleDTO);
            if(isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Vehicle Updated Successfully").show();
            }else{
                new Alert(Alert.AlertType.ERROR, "Vehicle Update Failed").show();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    

}





