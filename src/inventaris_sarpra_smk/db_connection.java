package inventaris_sarpra_smk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class db_connection {
    
    public static Connection mysqlconfig;
    public static Connection configDB() throws SQLException {
        
        try {
         
            String url = "jdbc:mysql://localhost:3306/db_inventaris_sarana_prasarana2";
            String username = "root";
            String password = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            mysqlconfig = DriverManager.getConnection(url, username, password);
            
        } catch (Exception e) {
            
            System.err.println("Connection failed, there was an error occured : " + e.getMessage());
                    
        }
        
        return mysqlconfig;
        
    }
    
}