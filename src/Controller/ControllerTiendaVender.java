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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.ModeloPrincipal;

/**
 *
 * @author Paul
 */
public class ControllerTiendaVender {
   
    private ModeloPrincipal modelo;
    private PanelTiendaVender panelTiendaVender;
    private Compra compra;
    public ControllerTiendaVender(ModeloPrincipal _modelo, PanelTiendaVender _panelTiendaVender)
    {
        this.modelo = _modelo;
        this.panelTiendaVender = _panelTiendaVender;
        
        panelTiendaVender.addListaClientesListener(new JListClientesListener());
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
                   Logger.getLogger(ControllerTiendaVender.class.getName()).log(Level.SEVERE, null, ex);
               }
               
           }
        }
        
    }
    
    class JListClientesListener implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            System.out.println("Seleccionó: "+panelTiendaVender.getClienteSeleccionado());
            panelTiendaVender.activarBotonAceptarCompra(true);
        }
    }
    
    
}
