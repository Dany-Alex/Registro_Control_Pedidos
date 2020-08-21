/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Controlador;

import Backend.Consultas.ProductoConsultas;
import Backend.Producto;
import Fronted.TrabajadorGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author goldtux
 */
public class Controlador implements ActionListener{
    ProductoConsultas productoConsultas= new ProductoConsultas();
    Producto producto = new Producto();
    TrabajadorGUI trabajadorGUI=new TrabajadorGUI();
    DefaultTableModel tableModel = new DefaultTableModel();

    public Controlador(TrabajadorGUI trabajadorGUI) {
    this.trabajadorGUI=trabajadorGUI;
    this.trabajadorGUI.listarProducto.addActionListener(this);
    }
    
    public void ListarProducto(JTable tablaProductos){
        limpiarTabla(tablaProductos);
    tableModel=(DefaultTableModel)tablaProductos.getModel();
    
    List <Producto> listaProductos=productoConsultas.Listar();
    Object[] object = new Object[8];
        
        for (int i = 0; i < listaProductos.size(); i++) {
            object[0]=listaProductos.get(i).getCodigoProducto();
            object[1]=listaProductos.get(i).getNombre();
            object[2]=listaProductos.get(i).getFabricante();
            object[3]=listaProductos.get(i).getCantidad();
            object[4]=listaProductos.get(i).getPrecio();
            object[5]=listaProductos.get(i).getTienda();
            object[6]=listaProductos.get(i).getGarantia();
            object[7]=listaProductos.get(i).getDescripcion();
            tableModel.addRow(object);
           
        } 
        trabajadorGUI.jTablaProdutos.setModel(tableModel);
    
    }
    public void limpiarTabla(JTable Jtable){
        DefaultTableModel tb = (DefaultTableModel) Jtable.getModel();
        int a = Jtable.getRowCount()-1;
        for (int i = a; i >= 0; i--) {          
        tb.removeRow(tb.getRowCount()-1);
        }
    }
            
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource()==trabajadorGUI.listarProducto) {
            ListarProducto(trabajadorGUI.jTablaProdutos);
        }
    }
    
    
}
