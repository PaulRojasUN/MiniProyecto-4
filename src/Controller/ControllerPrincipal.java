/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Vistas.PanelClientes;
import Vistas.PanelComprarProducto;
import Vistas.PanelCrearCliente;
import Vistas.PanelCrearProducto;
import Vistas.PanelCrearProveedor;
import Vistas.PanelProductos;
import Vistas.PanelProveedores;
import Vistas.PanelRegistros;
import Vistas.PanelTienda;
import Vistas.PanelTiendaVender;
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
                PanelTiendaVender panelTiendaVender = new PanelTiendaVender();
                PanelCrearCliente panelCrearCliente = new PanelCrearCliente();
                PanelCrearProveedor panelCrearProveedor = new PanelCrearProveedor();
                PanelCrearProducto panelCrearProducto = new PanelCrearProducto();
                PanelComprarProducto panelComprarProducto = new PanelComprarProducto();
                
                dashboard.crearPanelTienda(panelTienda);
                dashboard.crearPanelClientes(panelClientes);
                dashboard.crearPanelProductos(panelProductos);
                dashboard.crearPanelProveedores(panelProveedores);
                dashboard.crearPanelRegistros(panelRegistros);
                dashboard.crearPanelTiendaVender(panelTiendaVender);
                dashboard.crearPanelCrearCliente(panelCrearCliente);
                dashboard.crearPanelCrearProveedor(panelCrearProveedor);
                dashboard.crearPanelCrearProducto(panelCrearProducto);
                dashboard.crearPanelComprarProducto(panelComprarProducto);
                
                ControllerDashboard controllerDashboard = new ControllerDashboard(modelo,dashboard);
           }
 
        }
        
    }
    
    
    
}
