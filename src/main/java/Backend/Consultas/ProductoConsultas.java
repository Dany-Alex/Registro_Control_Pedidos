/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Consultas;

import Backend.DBManager;
import Backend.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author goldtux
 */
public class ProductoConsultas {
    DBManager conectar = new DBManager();
    Connection connection;
    ResultSet resultSet;
    PreparedStatement preparedStatement;
    
    
    public List Listar(){
    List<Producto>datos=new ArrayList<>();
    String sql="SELECT * FROM PRODUCTO";
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
    public String crearProducto(Producto producto){
        try {
            connection=conectar.getConexion();
            
            preparedStatement = connection.prepareStatement("INSERT INTO PRODUCTO (codigo_Producto, nombre, fabricante, cantidad, precio, codigo_tienda, garantia, descripcion) VALUES(?, ?, ?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, producto.getCodigoProducto());
            preparedStatement.setString(2, producto.getNombre());
            preparedStatement.setString(3, producto.getFabricante());
            preparedStatement.setInt(4, producto.getCantidad());
            preparedStatement.setDouble(5, producto.getPrecio());
            preparedStatement.setString(6, producto.getTienda());
            preparedStatement.setInt(7, producto.getGarantia());
            preparedStatement.setString(8, producto.getDescripcion());
            preparedStatement.executeUpdate();
          
        }   
        catch (SQLIntegrityConstraintViolationException e){
            return "El nombre de usuario ya se encuentra registrado en el sistema";
        }
        catch (SQLException ex) {
            return ex.toString();
        }
        return "Usuario " + producto.getNombre() + " registrado exitosamente";
    }
    
    
     public String modificarUsuario(Producto producto){
        try {
            
            connection=conectar.getConexion();
            preparedStatement = connection.prepareStatement("UPDATE Usuario SET nombre=?, fabricante=?, cantidad=?, precio=?, codigo_tienda=?, garantia=?, descripcion=? WHERE codigo_Producto = '"+producto.getCodigoProducto()+"';");
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setString(2, producto.getFabricante());
            preparedStatement.setInt(3, producto.getCantidad());
            preparedStatement.setDouble(4, producto.getPrecio());
            preparedStatement.setString(5, producto.getTienda());
            preparedStatement.setInt(6, producto.getGarantia());
            preparedStatement.setString(7, producto.getDescripcion());
            preparedStatement.executeUpdate();
        }   
        catch (SQLException ex) {
            return ex.toString();
        }
        return "Usuario " + producto.getNombre() + " modificado exitosamente";
    }
}
