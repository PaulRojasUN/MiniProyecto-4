/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Compra;
import Vistas.PanelTiendaVender;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.ModeloPrincipal;

/**
 *
 * @author Paul
 */
public class ControllerTiendaVender 
{
   
    private ModeloPrincipal modelo;
    private PanelTiendaVender panelTiendaVender;
    private Compra compra;
    
    public ControllerTiendaVender(ModeloPrincipal _modelo, PanelTiendaVender _panelTiendaVender)
    {
        
        this.modelo = _modelo;
        this.panelTiendaVender = _panelTiendaVender;
        
        panelTiendaVender.addListaClientesListener(new JListClientesListener());
        panelTiendaVender.addBtnVerClienteListener(new BtnListener());
    }
    
    public void addBtnRegresarListener(ActionListener listenControles)
    {
        panelTiendaVender.addBtnRegresarListener(listenControles);
    }
    
    public void addBtnAceptarListener(ActionListener listenControles)
    {
        panelTiendaVender.addBtnAceptarCompraListener(listenControles);
        panelTiendaVender.addBtnAceptarCompraListener(new BtnListener());
    }
    
    public void addBtnCrearClienteListener(ActionListener listenControles)
    {
        panelTiendaVender.addBtnCrearClienteListener(listenControles);
    }
    
     public void setCompra(Compra _compra)
    {
        this.compra = _compra;
    }
    
    public void actualizarPanel()
    {
       panelTiendaVender.llenarListaProductos(compra.getListaCompras());
       panelTiendaVender.setPrecioPagar(compra.getTotalCompra());
       panelTiendaVender.llenarListaClientes(modelo.getListaStringClientes());
    }
    
    public void deshabilitarBotones()
    {
        panelTiendaVender.activarBotonAceptarCompra(false);
        panelTiendaVender.activarBotonVerCliente(false);
    }
    
    class BtnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
           if ("ACEPTAR".equals(e.getActionCommand()))
           {
               try 
               {
                   
                   int id;
                   id = parseInt(panelTiendaVender.getClienteSeleccionado().substring(0, panelTiendaVender.getClienteSeleccionado().indexOf(" ")));
                   modelo.adicionarCompraCliente(id);
                   
                   
                   modelo.guardarEstadoProductos();
                   modelo.guardarEstadoClientes();
               } catch (IOException ex) {
                   System.out.println("Algo salió mal en la venta");
               }
               
           }
           else if ("Ver Cliente".equals(e.getActionCommand()))
           {
               
                String seleccion;
                seleccion = panelTiendaVender.getClienteSeleccionado();
                String nombre;
                String id;
                nombre = seleccion.substring(seleccion.indexOf(" ")+1);
                id = seleccion.substring(0, seleccion.indexOf(" "));
                
                JOptionPane.showMessageDialog(null, "Nombre: "+ nombre+"\n"
                +"ID: " +id);
           }
        }
        
    }
    
    class JListClientesListener implements ListSelectionListener
    { 
 
        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            if (panelTiendaVender.getClienteSeleccionado() != null)
            {
                System.out.println("Seleccionó: "+panelTiendaVender.getClienteSeleccionado());
                panelTiendaVender.activarBotonAceptarCompra(true);
                panelTiendaVender.activarBotonVerCliente(true);
            }
            else
            {
                deshabilitarBotones();
            }
        }
    }
}