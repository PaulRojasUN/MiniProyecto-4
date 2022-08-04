/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelTienda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.ModeloPrincipal;

/**
 *
 * @author Paul
 */
public class ControllerTienda {
    private ModeloPrincipal modelo;
    private PanelTienda panelTienda;
    public ControllerTienda(ModeloPrincipal _modelo, PanelTienda _panelTienda)
    {
        modelo = _modelo;
        panelTienda = _panelTienda;
        
        BtnListener btnListener = new BtnListener();
        
        panelTienda.addListaProductosListener(new JListProductosListener());
        panelTienda.addListaComprasListener(new JListComprasListener());
        panelTienda.addBtnAgregarListener(btnListener);
        panelTienda.addBtnCambiarCantidadListaListener(btnListener);
        panelTienda.addBtnBorrarElementoListaListener(btnListener);
        
    }
    
    public void actualizarPanel()
    {
        panelTienda.llenarListaProductos(modelo.getListaStringProductos());
    }
    
    public void addBtnVenderListener(ActionListener listenControles)
    {
        panelTienda.addBtnVenderListener(listenControles);
    }
    
    class JListProductosListener implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            System.out.println("Seleccionó: "+panelTienda.getProductoSeleccionado());
        }
    }
    
    class JListComprasListener implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            if (panelTienda.getCompraSeleccionada() != null)
            {
               panelTienda.cambiarEstadoBotones(true); 
            }
            else
            {
                panelTienda.cambiarEstadoBotones(false); 
            }
            
            System.out.println("Cambio");
        }
    }
    
    class BtnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if ("AGREGAR".equals(e.getActionCommand()))
            {
                int cantidad;
                int codigo;
                int indexCompra;
                int indexProducto;
                int cantidadNueva;
                try 
                { 
                    cantidad = parseInt(panelTienda.getTxtCantidad());
                    if(cantidad > 0)
                    {
                        String nombreProducto;
                        nombreProducto = panelTienda.getProductoSeleccionado().substring(panelTienda.getProductoSeleccionado().indexOf("-")+2, panelTienda.getProductoSeleccionado().indexOf("$")-3);
                        codigo = modelo.getProductoNombre(nombreProducto).getCodigo();
                        indexCompra = modelo.identificarItemCompra(panelTienda.getListaDeCompras(), nombreProducto);
                        
                        if (modelo.getProductoNombre(nombreProducto).getCant()>=cantidad)
                        {
                            indexProducto = modelo.identificarItemProducto(panelTienda.getListaDeProductos(), nombreProducto);
                        
                            
                            if (indexCompra ==-1)//No está en la lista de compras
                            {
                                panelTienda.addItemListaCompras(modelo.itemListaCompra(codigo, cantidad));
                            }
                            else
                            {
                              panelTienda.setItemCompra(modelo.getCantidadCompraCambiadaSuma(panelTienda.getListaDeCompras().get(indexCompra), cantidad), indexCompra);
                            }
                            
                            modelo.restarUnidadesProducto(nombreProducto, cantidad);
                            
                            indexProducto = modelo.identificarItemProducto(panelTienda.getListaDeProductos(), nombreProducto);
 
                            cantidadNueva = modelo.getProductoNombre(nombreProducto).getCant();
                            
                            
                            panelTienda.setItemProducto(modelo.getNuevoItemProductos(panelTienda.getItemListaDeProductos(indexProducto), cantidadNueva) , indexProducto);
                            panelTienda.setTxtPrecioTotal(modelo.calcularTotal(panelTienda.getListaDeCompras()));
                            panelTienda.setTxtNumeroTotalDeProductos(modelo.calcularCantidadProductosTotal(panelTienda.getListaDeCompras()));
                            panelTienda.setEstadoBotonVender(true);
                        }
                        else
                        {
                            System.out.println("No hay suficientes unidades disponibles de ese producto");
                            panelTienda.setTxtCantidad("");
                        }
                    }
                    else
                    {
                        System.out.println("Asigne un número mayor que cero");
                    }
                } 
                catch (Exception ex)
                {
                    System.out.println("Ingrese una cantidad númerica entera y seleccione un item");
                }
                panelTienda.setTxtCantidad("");
            }
            else if ("CAMBIAR CANTIDAD".equals(e.getActionCommand()))
            {
                
                try
                {
                    int nuevaCantidad;
                    int cantidadEnCompras;
                    nuevaCantidad = panelTienda.crearInputPane();
                    cantidadEnCompras = parseInt(panelTienda.getCompraSeleccionada().substring(
                        panelTienda.getCompraSeleccionada().indexOf("x")+2,panelTienda.getCompraSeleccionada().indexOf("=")-1));
                    System.out.println(cantidadEnCompras);
                            
                            
                    if (nuevaCantidad > 0)
                    {
                        String nombre;
                        nombre = panelTienda.getCompraSeleccionada().substring(0,panelTienda.getCompraSeleccionada().indexOf("x")-1);
                        //System.out.println(nombre);
                        int indexProducto;
                        indexProducto = modelo.identificarItemProducto(panelTienda.getListaDeProductos(),nombre);
                        int indexCompra;
                        indexCompra = modelo.identificarItemCompra(panelTienda.getListaDeCompras(),nombre);
                        modelo.sumarUnidadesProducto(nombre, cantidadEnCompras);
                        if (modelo.getProductoNombre(nombre).getCant()>=nuevaCantidad)
                        {
                            modelo.restarUnidadesProducto(nombre, nuevaCantidad);
                            panelTienda.setItemCompra(modelo.getCantidadCompraCambiada(panelTienda.getListaDeCompras().get(indexCompra), nuevaCantidad), indexCompra);
                        }
                        else
                        {
                            System.out.println("No hay unidades suficientes");
                            modelo.restarUnidadesProducto(nombre, cantidadEnCompras);
                            panelTienda.setItemCompra(modelo.getCantidadCompraCambiada(panelTienda.getListaDeCompras().get(indexCompra), cantidadEnCompras), indexCompra);
                        }
                        

                            //panelTienda.setItemCompra(modelo.getCantidadCompraCambiada(panelTienda.getListaDeCompras().get(indexProducto), nuevaCantidad), indexProducto);

                            panelTienda.setTxtPrecioTotal(modelo.calcularTotal(panelTienda.getListaDeCompras()));
                            panelTienda.setTxtNumeroTotalDeProductos(modelo.calcularCantidadProductosTotal(panelTienda.getListaDeCompras()));

                            panelTienda.setItemProducto(modelo.getNuevoItemProductos(panelTienda.getListaDeProductos().get(indexProducto), modelo.getProductoNombre(nombre).getCant()), indexProducto);
                        
                    }
                    else
                    {
                        System.out.println("Ingrese valores enteros positivos");
                    }
 
                }
                catch (Exception ex)
                {
                   // ex.printStackTrace();
                    System.out.println("Ingrese un valor válido");
                }
            } else if ("BORRAR".equals(e.getActionCommand()))
            {
                int indexCompra;
                String nombre;
                int cantidad;
                int indexProducto;
                
                
              
                nombre = panelTienda.getCompraSeleccionada().substring(0,panelTienda.getCompraSeleccionada().indexOf("x")-1);
                indexCompra = modelo.identificarItemCompra(panelTienda.getListaDeCompras(),nombre);
                indexProducto = modelo.identificarItemProducto(panelTienda.getListaDeProductos(), nombre);
                
                cantidad = parseInt(panelTienda.getCompraSeleccionada().substring(
                        panelTienda.getCompraSeleccionada().indexOf("x")+2,panelTienda.getCompraSeleccionada().indexOf("=")-1));
                
                modelo.sumarUnidadesProducto(nombre, cantidad);
               
                panelTienda.setItemProducto(modelo.getNuevoItemProductos(panelTienda.getListaDeProductos().get(indexProducto), modelo.getProductoNombre(nombre).getCant()), indexProducto);
               
                panelTienda.setTxtPrecioTotal(modelo.calcularTotal(panelTienda.getListaDeCompras()));
                panelTienda.setTxtNumeroTotalDeProductos(modelo.calcularCantidadProductosTotal(panelTienda.getListaDeCompras()));
                panelTienda.quitarElementoCompras(indexCompra);
                
                if (panelTienda.getCantidadProductosCompra() == 0)
                {
                    panelTienda.setEstadoBotonVender(false);
                }
                
                panelTienda.cambiarEstadoBotones(false); 
            }
            
        }
    }
        
}
