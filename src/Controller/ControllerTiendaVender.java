/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Compra;
import Vistas.PanelTiendaVender;
import java.awt.event.ActionListener;
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
