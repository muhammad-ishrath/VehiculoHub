package lk.aulakapora.vehiculohub.db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnection {

    private static DBConnection dbConnection;
    private static Connection connection;

    private final String URL = "jdbc:mysql://localhost:3306/vehiculo_hub";
    private final String USER = "Ishrath";

    private final String  PASSWORD = "Ishrath@123";

    private  DBConnection() throws SQLException{
        // no need this cuz we are using jdbc 8 odd > 4  -the driver automatically registers itself
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //step 01
        connection = DriverManager.getConnection(URL,USER,PASSWORD);
    }
//    public static DBConnection getDBConnection() throws SQLException{
//        if (dbConnection==null){
//            dbConnection = new DBConnection();
//        }
//        return dbConnection;
//    }

    public static DBConnection getDBConnection() throws SQLException {
        if (dbConnection == null) {
            dbConnection = new DBConnection();
        } else if (dbConnection.getConnection().isClosed()) {
            dbConnection = new DBConnection();
        }
        return dbConnection;
    }

    public static Connection getConnection() {
        return connection;
    }
}
