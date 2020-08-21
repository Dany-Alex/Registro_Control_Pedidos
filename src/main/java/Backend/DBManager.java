/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author goldtux
 */
public class DBManager {
    // Librería de MySQL
   final public  static String driver = "com.mysql.jdbc.Driver";

    // Nombre de la base de datos
    public static String database = "INTELAF";

    // Host
    public static String hostname = "localhost";

    // Puerto
    public static String port = "3306";

    // Ruta de nuestra base de datos (desactivamos el uso de SSL con "?useSSL=false")
    public String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";

    // Nombre de usuario
    public static String username = "Tux";

    // Clave de usuario
    public static String password = "Tux1234567";
    
    //Variables
     Connection connection = null;
    private Statement statement;
    private PreparedStatement preparedStatement;
    private ResultSet resultSet;
    
     
     
     
    public Connection getConexion() {
        
        try {
            // Conectamos con la base de datos
            connection = DriverManager.getConnection(
                    url,
                    username, password);           
            boolean valid = connection.isValid(50000);
            System.out.println(valid ? "Estado de conexion con la BD: OK" : "Estado de conexion con la BD: FAIL");
             return connection;
        } catch (java.sql.SQLException sqle) {
            System.out.println("Error al conectar con la base de datos de MySQL (" + url + "): " + sqle);
        }
    return connection;}  

    public Statement getStatement() {
        
        return statement;
    }

    public PreparedStatement getPreparedStatement() {
        
        return preparedStatement;
    }

    public ResultSet getResultSet(String MySQLCodigo) {
         try {
          
            statement = connection.createStatement();
            resultSet = statement.executeQuery(MySQLCodigo);
        } catch (SQLException ex) {
            System.out.println("Error de conexion con la base de datos");
        }

        return resultSet;
    }
    
    
}
