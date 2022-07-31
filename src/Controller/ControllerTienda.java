/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelTienda;
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
        
        
        panelTienda.llenarListaProductos(modelo.getListaStringProductos());
        panelTienda.addListaProductosListener(new JListListener());
    }
    
    
    class JListListener implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            System.out.println("Seleccionó: "+panelTienda.getProductoSeleccionado());
        }
        
    }
}
