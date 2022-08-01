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
        
    }
    
    public void actualizarPanel()
    {
        panelTienda.llenarListaProductos(modelo.getListaStringProductos());
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
            if (panelTienda.getCantidadProductosCompra() != 0)
            {
               panelTienda.cambiarEstadoBotones(true); 
            }
            else
            {
                panelTienda.cambiarEstadoBotones(false); 
            }
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
                int indexProducto;
                try 
                { 
                    cantidad = parseInt(panelTienda.getTxtCantidad());
                    if(cantidad > 0)
                    {

                        codigo = parseInt(panelTienda.getProductoSeleccionado().substring(0, 6));
                        indexProducto = modelo.identificarItemCompras(panelTienda.getListaDeCompras(), modelo.getProductoCodigo(codigo).getNombre());
                        if (indexProducto ==-1)//No está en la lista de compras
                        {
                            panelTienda.addItemListaCompras(modelo.itemListaCompra(codigo, cantidad));
                        }
                        else
                        {
                          panelTienda.setItemCompra(modelo.getCantidadCompraCambiadaSuma(panelTienda.getListaDeCompras().get(indexProducto), cantidad), indexProducto);
                        }
                        
                        panelTienda.setTxtPrecioTotal(modelo.calcularTotal(panelTienda.getListaDeCompras()));
                        panelTienda.setTxtNumeroTotalDeProductos(modelo.calcularCantidadProductosTotal(panelTienda.getListaDeCompras()));
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
                    nuevaCantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad"));
                        
                    if (nuevaCantidad > 0)
                    {
                        String nombre;
                        nombre = panelTienda.getCompraSeleccionada().substring(0,panelTienda.getCompraSeleccionada().indexOf("x")-1);
                        int indexProducto;
                        indexProducto = modelo.identificarItemCompras(panelTienda.getListaDeCompras(),nombre);

                        panelTienda.setItemCompra(modelo.getCantidadCompraCambiada(panelTienda.getListaDeCompras().get(indexProducto), nuevaCantidad), indexProducto);

                        panelTienda.setTxtPrecioTotal(modelo.calcularTotal(panelTienda.getListaDeCompras()));
                        panelTienda.setTxtNumeroTotalDeProductos(modelo.calcularCantidadProductosTotal(panelTienda.getListaDeCompras()));
                    }
                    else
                    {
                        System.out.println("Ingrese valores enteros positivos");
                    }
 
                }
                catch (Exception ex)
                {
                    System.out.println("Ingrese un valor válido");
                }
            } else if ("BORRAR".equals(e.getActionCommand()))
            {
                
            }
        }
    }
        
}
