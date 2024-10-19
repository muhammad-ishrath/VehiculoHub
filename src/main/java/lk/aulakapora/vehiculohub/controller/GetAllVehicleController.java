package lk.aulakapora.vehiculohub.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.aulakapora.vehiculohub.model.VehicleModel;
import lk.aulakapora.vehiculohub.tm.VehicleTM;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class GetAllVehicleController implements Initializable {

    @FXML
    TableView<VehicleTM> vehicleTable;

    @FXML
    TableColumn<VehicleTM,Integer> colId;

    @FXML
    TableColumn<VehicleTM,String> colBrand;

    @FXML
    TableColumn<VehicleTM,String> colModel;

    @FXML
    TableColumn<VehicleTM,Integer> colEngineCapacity;

    @FXML
    TableColumn<VehicleTM,String> colTransmissionMode;

    @FXML
    TableColumn<VehicleTM,Integer> colQty;

    @FXML
    TableColumn<VehicleTM,Double> colPrice;


    //observable list oversee changes if we add data or gui added data
    //initializes this as an observable arraylist
    public static ObservableList<VehicleTM> vehicleList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBrand.setCellValueFactory(new PropertyValueFactory<>("brand"));
        colModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        colEngineCapacity.setCellValueFactory(new PropertyValueFactory<>("engineCapacity"));
        colTransmissionMode.setCellValueFactory(new PropertyValueFactory<>("transmissionMode"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        try {
            vehicleTable.setItems(VehicleModel.viewAllVehicle());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }


}
