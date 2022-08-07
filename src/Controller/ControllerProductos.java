/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Paul
 */

import Vistas.PanelProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.ModeloPrincipal;
import modelo.Producto;

    


public class ControllerProductos 
{
    private ModeloPrincipal modelo;
    private PanelProductos panelProductos;
    
    public ControllerProductos(ModeloPrincipal _modelo, PanelProductos _panelProductos)
    {
        modelo = _modelo;
        panelProductos = _panelProductos;
        
        panelProductos.addListaProductoListener(new JListComprasListener());
        panelProductos.addBtnBorrarListener(new BtnListener());
        panelProductos.addBtnActualizarListener(new BtnListener());
    }
    
    public void actualizarPanel()
    {
        panelProductos.llenarListaProductos(modelo.getListaStringProductos());
        panelProductos.setBtnTextActualizar();
    }
    
    public void vaciarCampos()
    {
        panelProductos.vaciarCampos();
    }
    
    public void addBtnCrearListener(ActionListener actionListener)
    {
        panelProductos.addBtnCrearListener(actionListener);
    }
    
    public void addBtnComprarProductosListener(ActionListener actionListener)
    {
        panelProductos.addBtnComprarListener(actionListener);
    }
    
    class JListComprasListener implements ListSelectionListener
    {

       @Override
        public void valueChanged(ListSelectionEvent e) {
            if (panelProductos.getProductoSeleccionado()!=null)
            {
                Producto auxProducto;
                String nombre;
                nombre = panelProductos.getProductoSeleccionado().substring(panelProductos.getProductoSeleccionado().indexOf("-")+2,
                        panelProductos.getProductoSeleccionado().indexOf("$")-3);
                 
                auxProducto = modelo.getProductoNombre(nombre);
                
                int codigo;
                float precioCompra;
                float precioVenta;
                int cant;
                int vendidos;
                
                
                codigo = auxProducto.getCodigo();
                precioCompra = auxProducto.getPrecioCompra();
                precioVenta = auxProducto.getPrecioVenta();
                cant = auxProducto.getCant();
                vendidos = auxProducto.getNoVendidos();
                
               String nombreProv = modelo.getProveedorDeProducto(nombre).getNombre();
               panelProductos.llenarComboProveedores(modelo.getNombresProveedores());
               panelProductos.setSelectedComboProveedores(nombreProv);
                
                panelProductos.setCodigo(codigo+"");
                panelProductos.setNombre(nombre);
                panelProductos.setPrecioCompra(precioCompra);
                panelProductos.setPrecioVenta(precioVenta);
                panelProductos.setInventario(cant);
                panelProductos.setVendidos(vendidos+"");
                
                panelProductos.habilitarBotonActualizar(true);
                panelProductos.habilitarBotonBorrar(true);
            }
            else
            {
                panelProductos.habilitarBotonActualizar(false);
                panelProductos.habilitarBotonBorrar(false);
            }
        }
    }
    
    class BtnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if ("BORRAR".equals(e.getActionCommand()))
            {
                Producto auxProducto;
                String nombre;
                nombre = panelProductos.getProductoSeleccionado().substring(panelProductos.getProductoSeleccionado().indexOf("-")+2,
                        panelProductos.getProductoSeleccionado().indexOf("$")-3);
                 
                auxProducto = modelo.getProductoNombre(nombre);
                
                modelo.borrarProductoObj(auxProducto);
                
                try 
                {
                    modelo.guardarEstadoProductos();
                } 
                catch (IOException ex) 
                {
                    System.out.println("Ocurrió un error guardando el archivo");
                }
                
                vaciarCampos();
                actualizarPanel();
            }
            else if ("ACTUALIZAR".equals(e.getActionCommand()))
            {
                panelProductos.cambiarEstadoCampos(true);
                panelProductos.cambiarTextoActualizar();
            }
            else if ("ACEPTAR".equals(e.getActionCommand()))
            {
                int codigo;
                float precioCompra;
                float precioVenta;
                String nombreProveedor;
                int cant;
                int vendidos; 
               
                
                
                
            }
        }
        
    }
    
}
