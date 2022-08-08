/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelCrearProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import modelo.ModeloPrincipal;

/**
 *
 * @author Paul
 */
public class ControllerCrearProducto
{
    
    private ModeloPrincipal modelo;
    private PanelCrearProducto panelCrearProducto;
    ControllerCrearProducto(ModeloPrincipal _modelo, PanelCrearProducto _panelCrearProducto)
    {
        modelo = _modelo;
        panelCrearProducto = _panelCrearProducto;
        
        panelCrearProducto.addBtnCrearListener(new BtnListener());
    }
    
    public void actualizarPanel()
    {
        panelCrearProducto.llenarComboProveedores(modelo.getNombresProveedores());
    }
    
    
    public void addBtnCrearProductoListener(ActionListener actionListener)
    {
       //panelCrearProducto.addBtnCrearListener(actionListener);
    }
    
    public void vaciarCampos()
    {
        panelCrearProducto.vaciarCampos();
    }
    
    public void addBtnVolverListener(ActionListener actionListener)
    {
       panelCrearProducto.addBtnVolverListener(actionListener);
       panelCrearProducto.addBtnCancelarListener(actionListener);
    }
    
    class BtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            int codigo;
            String nombre;
            float precioCompra;
            float precioVenta;
            int cant;
            int noVendidos;
            String proveedor;
            
            try
            {
              codigo = parseInt(panelCrearProducto.getCodigo());
              nombre = panelCrearProducto.getNombre(); 
              noVendidos = panelCrearProducto.getNumeroVendidos();
              precioCompra = panelCrearProducto.getPrecioCompra();
              precioVenta = panelCrearProducto.getPrecioVenta();
              cant = panelCrearProducto.getInventario();
              proveedor = panelCrearProducto.getProveedorSeleccionado();
              if (modelo.getProductoCodigo(codigo)==null && modelo.getProductoNombre(nombre)==null)
              {
                  if (codigo > 0 && precioCompra > 0 && precioVenta > 0 && cant > 0 && noVendidos >0)
                  {
                  modelo.agregarNuevoProducto(nombre, codigo, precioCompra, precioVenta, cant, noVendidos);
                  modelo.agregarProductoAProveedor(modelo.getProveedorNombre(proveedor).getNit(),codigo,nombre, precioCompra, precioVenta);
                  modelo.guardarEstadoProductos();
                  modelo.guardarEstadoProveedores();
                  
                  vaciarCampos();
                  
                  JOptionPane.showMessageDialog(null, "Creado con exito");
                  }
                  else
                  {
                      System.out.println("Ingrese valores númericos mayores a cero");
                  }
              }
              else
              {
                  System.out.println("No puede haber dos productos con el mismo código o nombre");
              }
            }
            catch (Exception ex)
            {
                System.out.println("Ingrese valores válidos");
                ex.printStackTrace();
            }
            
            
        }
        
    }
    
}
