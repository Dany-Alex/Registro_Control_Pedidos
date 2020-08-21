/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author goldtux
 */
public class Producto {
String codigoProducto,nombre,fabricante,tienda,descripcion;    
int cantidad,garantia;
double precio;

    public Producto() {
    }

    public Producto(String codigoProducto, String nombre, String fabricante, String tienda, String descripcion, int cantidad, int garantia, double precio) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.fabricante = fabricante;
        this.tienda = tienda;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.garantia = garantia;
        this.precio = precio;
    }



    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
