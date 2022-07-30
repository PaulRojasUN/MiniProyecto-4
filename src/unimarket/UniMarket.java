/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unimarket;

import Controller.ControllerPrincipal;
import Modelo.Modelo;
import Vistas.VistaLogin;
import java.io.IOException;
import modelo.modeloPrin;


/**
 *
 * @author Paul
 */
public class UniMarket {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       /* Activacion temporal de la vista */
       
        VistaLogin vista = new VistaLogin();
        modeloPrin modelo = new modeloPrin();
        
        ControllerPrincipal controller = new ControllerPrincipal(modelo,vista);
    }
    
}
