package lk.aulakapora.vehiculohub.model;

import lk.aulakapora.vehiculohub.db.DBConnection;
import lk.aulakapora.vehiculohub.dto.VehicleDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VehicleModel {

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

}
