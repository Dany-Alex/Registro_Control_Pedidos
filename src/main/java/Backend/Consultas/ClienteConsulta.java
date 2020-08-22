/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Consultas;

import Backend.Cliente;
import Backend.DBManager;
import Backend.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author goldtux
 */
public class ClienteConsulta {
    DBManager conectar = new DBManager();
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    
    
    public List Listar(){
    List<Producto>datos=new ArrayList<>();
    String sql="SELECT * FROM CLIENTE";
        try {
            connection=conectar.getConexion();
            
            resultSet=conectar.getResultSet(sql);
            
            while (resultSet.next()) {                
                Producto producto= new Producto();
                producto.setCodigoProducto(resultSet.getString(1));
                producto.setNombre(resultSet.getString(2));
                producto.setFabricante(resultSet.getString(3));
                producto.setCantidad(resultSet.getInt(4));
                producto.setPrecio(resultSet.getDouble(5));
                producto.setTienda(resultSet.getString(6));
                producto.setGarantia(resultSet.getInt(7));
                producto.setDescripcion(resultSet.getString(8));
                datos.add(producto);
                
            }
        } catch (Exception e) {
            
        }
        return datos;
    
    }
    public String crearCliente(Cliente cliente){
        try {
            connection=conectar.getConexion();
            
            preparedStatement = connection.prepareStatement("INSERT INTO CLIENTE (codigo, nombre, telefono, credito, correo_electronico, dpi) VALUES(?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, cliente.getCodigoCliente());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getTelefono());
            preparedStatement.setInt(4, cliente.getCredito());
            preparedStatement.setString(5, cliente.getCorreo());
            preparedStatement.setInt(6, cliente.getDpi());
 
            preparedStatement.executeUpdate();
          
        }   
        catch (SQLIntegrityConstraintViolationException e){
            return "Ya se encuentra registrado en el sistema";
        }
        catch (SQLException ex) {
            return ex.toString();
        }
        return "Cliente Codigo: " + cliente.getCodigoCliente()+ " registrado exitosamente";
    }
    
    
     public String modificarCliente(Cliente cliente){
        try {
            
            connection=conectar.getConexion();
            
            preparedStatement = connection.prepareStatement("UPDATE CLIENTE SET nombre=?, telefono=?, credito=?, correo=?, dpi=? WHERE nit = '"+cliente.getCodigoCliente()+"';");
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getTelefono());
            preparedStatement.setInt(3, cliente.getCredito());
            preparedStatement.setString(4, cliente.getCorreo());
            preparedStatement.setInt(5, cliente.getDpi());
            preparedStatement.executeUpdate();
        }   
        catch (SQLIntegrityConstraintViolationException e){
            return "No se encuentra registrado en el sistema";
        }
        catch (SQLException ex) {
            return ex.toString();
        }
        return "Cliente Codigo: " +cliente.getCodigoCliente()+ " modificado exitosamente";
    }
     
     public String eliminarCliente(String codigo){
        try {
            
            connection=conectar.getConexion();
            preparedStatement = connection.prepareStatement("DELETE FROM CLIENTE WHERE codigo = ? ;");
            preparedStatement.setString(1, codigo);
            preparedStatement.executeUpdate();
        }   
         catch (SQLIntegrityConstraintViolationException e){
            return "No se encuentra registrado en el sistema";
        }
        catch (SQLException ex) {
            return ex.toString();
        }
        return "Producto Codigo: " +codigo+ " eliminado exitosamente";
    }
     
}
