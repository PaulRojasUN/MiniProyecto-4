/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Vistas.PanelClientes;
import Vistas.PanelProductos;
import Vistas.PanelProveedores;
import Vistas.PanelRegistros;
import Vistas.PanelTienda;
import Vistas.VistaDashboard;
import Vistas.VistaLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloPrincipal;

/**
 *
 * @author RYZEN
 */
public class ControllerPrincipal {
    
    private ModeloPrincipal modelo;
    private VistaLogin vista;

    public ControllerPrincipal(ModeloPrincipal modelo, VistaLogin vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        this.vista.addBtnIniciarListener(new IniciarDashboard());
    }
    
    class IniciarDashboard implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
                    
            if(e.getActionCommand().equalsIgnoreCase("INICIAR")){
                vista.dispose();
                VistaDashboard dashboard = new VistaDashboard();
                
                PanelTienda panelTienda = new PanelTienda();
                PanelClientes panelClientes = new PanelClientes();
                PanelProductos panelProductos= new PanelProductos();
                PanelProveedores panelProveedores = new PanelProveedores();
                PanelRegistros panelRegistros = new PanelRegistros();
                
                dashboard.crearPanelTienda(panelTienda);
                dashboard.crearPanelClientes(panelClientes);
                dashboard.crearPanelProductos(panelProductos);
                dashboard.crearPanelProveedores(panelProveedores);
                dashboard.crearPanelRegistros(panelRegistros);
                
                ControllerDashboard controllerDashboard = new ControllerDashboard(modelo,dashboard);
           }
 
        }
        
    }
    
    
    
}
