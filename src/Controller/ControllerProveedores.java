/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelProveedores;
import modelo.ModeloPrincipal;

/**
 *
 * @author Paul
 */
public class ControllerProveedores {
    private ModeloPrincipal modelo;
    private PanelProveedores panelProveedores;
    
    public ControllerProveedores(ModeloPrincipal _modelo, PanelProveedores _panelProveedores)
    {
        modelo = _modelo;
        panelProveedores = _panelProveedores;
        
        
    }
}
