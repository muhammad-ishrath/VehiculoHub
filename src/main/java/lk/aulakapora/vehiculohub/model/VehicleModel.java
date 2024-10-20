package lk.aulakapora.vehiculohub.model;

import javafx.collections.ObservableList;
import lk.aulakapora.vehiculohub.controller.GetAllVehicleController;
import lk.aulakapora.vehiculohub.db.DBConnection;
import lk.aulakapora.vehiculohub.dto.VehicleDTO;
import lk.aulakapora.vehiculohub.tm.VehicleTM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VehicleModel {

    static int id;
    static String brand;
    static String model;
    static int engineCapacity;
    static String transmissionMode;
    static int qty;
    static double price;



    public static boolean addVehicle(VehicleDTO vehicleDTO){

        //step 03
        String insertQuery = "INSERT INTO vehicle(brand,model,engineCapacity,transmissionMode,qty,price) VALUES(?,?,?,?,?,?)";
        try(
                //In the parentheses after try, you declare resources
                // (like Connection and Statement) that will be automatically closed at the end of the block.
                // So don’t have to explicitly close them in a finally block.

                //step 02
                Connection connection = DBConnection.getDBConnection().getConnection();

                //step 04
                PreparedStatement stm  = connection.prepareStatement(insertQuery)
        ){
            //step 05
            stm.setString(1, vehicleDTO.getBrand());
            stm.setString(2, vehicleDTO.getModel());
            stm.setInt(3, vehicleDTO.geteCapacity());
            stm.setString(4,vehicleDTO.gettMode());
            stm.setInt(5,vehicleDTO.getQty());
            stm.setDouble(6,vehicleDTO.getPrice());

            return stm.executeUpdate()>0;

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }


    }

    public static boolean  deleteVehicle(int vid){


        try {
            Connection connection = DBConnection.getDBConnection().getConnection();

            String deleteQuery = "DELETE FROM vehicle WHERE vid = ?";

            PreparedStatement stm = connection.prepareStatement(deleteQuery);

            stm.setInt(1,vid);
            // executeQuery() for getting only
            int update  = stm.executeUpdate();


            // if data changed a number greater than 0
            return update>0 ;


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ObservableList<VehicleTM> viewAllVehicle() throws SQLException {

        Connection connection = DBConnection.getDBConnection().getConnection();

        String getAllQuery = "SELECT * FROM vehicle";

        PreparedStatement stm = connection.prepareStatement(getAllQuery);

        stm.executeQuery();

        while (stm.getResultSet().next()){
            int id  = stm.getResultSet().getInt("vid");
            String brand   = stm.getResultSet().getString("brand");
            String model  = stm.getResultSet().getString("model");
            int engineCapacity  = stm.getResultSet().getInt("engineCapacity");
            String transmissionMode  = stm.getResultSet().getString("transmissionMode");
            int qty  = stm.getResultSet().getInt("qty");
            double price  = stm.getResultSet().getInt("price");

            VehicleTM vehicleTM = new VehicleTM(id,brand,model,engineCapacity,transmissionMode,qty,price);

            System.out.println(vehicleTM);
            GetAllVehicleController.vehicleList.add(vehicleTM);

        }
        return GetAllVehicleController.vehicleList;

    }

    public static VehicleDTO  searchVehicle(int vid) throws SQLException {

        Connection connection = DBConnection.getDBConnection().getConnection();

        String searchQuery = " SELECT brand,model,engineCapacity,transmissionMode,qty,price FROM vehicle WHERE vid = ?";

        PreparedStatement stm = connection.prepareStatement(searchQuery);

        stm.setInt(1,vid);

        stm.executeQuery();

        if (stm.getResultSet().next()){
            brand = stm.getResultSet().getString("brand");
            model = stm.getResultSet().getString("model");
            transmissionMode = stm.getResultSet().getString("transmissionMode");
            engineCapacity = stm.getResultSet().getInt("engineCapacity");
            qty = stm.getResultSet().getInt("qty");
            price = stm.getResultSet().getInt("price");


        }

        VehicleDTO vehicleDTO = new VehicleDTO(brand,model,engineCapacity,transmissionMode,qty,price);

        return vehicleDTO;


    }

    public static boolean updateVehicle(VehicleDTO vehicleDTO) throws SQLException {

        Connection connection = DBConnection.getDBConnection().getConnection();

        String updateQuery = "UPDATE vehicle SET brand = ?, model = ?, engineCapacity = ?, transmissionMode = ?, qty = ?, price = ? WHERE vid = ?";

        PreparedStatement stm = connection.prepareStatement(updateQuery);   

        stm.setString(1, vehicleDTO.getBrand());
        stm.setString(2, vehicleDTO.getModel());
        stm.setInt(3, vehicleDTO.geteCapacity());
        stm.setString(4, vehicleDTO.gettMode());
        stm.setInt(5, vehicleDTO.getQty());
        stm.setDouble(6, vehicleDTO.getPrice());
        stm.setInt(7, vehicleDTO.getVid());

        stm.executeUpdate();

        return stm.executeUpdate()>0;

    }


}
