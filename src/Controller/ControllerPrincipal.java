/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Vistas.VistaLogin;
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
        
    }
    
    
    
}
