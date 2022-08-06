/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelComprarProducto;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.lang.model.SourceVersion;
import modelo.ModeloPrincipal;
import modelo.Producto;

/**
 *
 * @author Paul
 */
public class ControllerComprarProducto 
{
    private ModeloPrincipal modelo;
    private PanelComprarProducto panelComprarProducto;
    ControllerComprarProducto(ModeloPrincipal _modelo, PanelComprarProducto _panelComprarProducto)
    {
        modelo = _modelo;
        panelComprarProducto = _panelComprarProducto;
        
        panelComprarProducto.addComboProductosListener(new ItemListenerProductos());
    }
    
    public void addBtnVolverListener(ActionListener actionListener)
    {
        panelComprarProducto.addBtnVolverListener(actionListener);
        panelComprarProducto.addBtnCancelarListener(actionListener);
    }
    
    public void actualizarPanel()
    {
        panelComprarProducto.llenarComboProductos(modelo.getNombresProductos());
        llenarDatos();
    }
    
    public void llenarDatos()
    {
        String nombre;
        String proveedor;
        int vendidos;
        int inventario;
        float precioCompra;
        
        nombre = panelComprarProducto.getSelectedProducto();
        Producto auxProducto;
        auxProducto = modelo.getProductoNombre(nombre);
        proveedor = modelo.getProveedorDeProducto(nombre).getNombre();
        vendidos = auxProducto.getNoVendidos();
        inventario =  auxProducto.getCant();
        precioCompra = auxProducto.getPrecioCompra();
        
        panelComprarProducto.setProveedor(proveedor);
        panelComprarProducto.setNumeroVendidos(vendidos+"");
        panelComprarProducto.setInventario(inventario+"");
        panelComprarProducto.setPrecio(precioCompra);
    }
    
    public class ItemListenerProductos implements ItemListener
    {

        @Override
        public void itemStateChanged(ItemEvent e) 
        {
            if (panelComprarProducto.getSelectedProducto() != null)
            {
              llenarDatos();  
            }
           
        }
        
        
    }
}
