/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelTienda;
import Vistas.VistaDashboard;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.ModeloPrincipal;

/**
 *
 * @author RYZEN
 */
public class ControllerDashboard {
    private ModeloPrincipal modelo;
    private VistaDashboard vista;

    public ControllerDashboard(ModeloPrincipal modelo, VistaDashboard vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        PanelTienda tienda = vista.getPanelTienda();
        tienda.addListaProductosListener(new JListListener());


    }
    
    class JListListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent e) {
            System.out.println("Hola mundo");
        }
        
    }
    
    
    
}
