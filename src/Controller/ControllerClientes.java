/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelClientes;
import modelo.ModeloPrincipal;

/**
 *
 * @author Paul
 */
public class ControllerClientes 
{
    private ModeloPrincipal modelo;
    private PanelClientes panelClientes;
    
    public ControllerClientes(ModeloPrincipal _modelo, PanelClientes _panelClientes)
    {
        modelo = _modelo;
        panelClientes = _panelClientes;
        
        
    }
}
