/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


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
                ControllerDashboard controllerDashboard = new ControllerDashboard(modelo,dashboard);
           }
 
        }
        
    }
    
    
    
}
