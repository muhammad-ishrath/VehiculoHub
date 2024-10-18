package lk.aulakapora.vehiculohub.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {

    private DBConnection dbConnection;
    private Connection connection;

    private  DBConnection() throws SQLException{
        // no need this cuz we are using jdbc 8 odd > 4  -the driver automatically registers itself
        //Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/vehiculo_hub","Ishrath","Ishrath@123");
    }
    public DBConnection getDBConnection() throws SQLException{
        if (dbConnection==null){
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }
}
