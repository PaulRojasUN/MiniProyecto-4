/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Modelo;
import Vistas.VistaLogin;

/**
 *
 * @author RYZEN
 */
public class ControllerPrincipal {
    
    private Modelo modelo;
    private VistaLogin vista;

    public ControllerPrincipal(Modelo modelo, VistaLogin vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
    }
    
    
    
}
