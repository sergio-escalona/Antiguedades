/* Sergio Escalona y Kevin Rojas */
package BD;

import java.sql.Connection;
import java.sql.DriverManager;
public class Conexion {
    public Connection obtenerConexion(){
        Connection connection= null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/antiguedades", "root", "");
            System.out.println("Conexión exitosa");

        } catch(Exception e){
            System.out.println("No se puede conectar " + e.getMessage());
        }
        return connection;
    }
}
