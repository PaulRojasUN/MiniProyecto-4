/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Paul
 */

import Vistas.PanelProductos;
import modelo.ModeloPrincipal;

    


public class ControllerProductos 
{
    private ModeloPrincipal modelo;
    private PanelProductos panelProductos;
    
    public ControllerProductos(ModeloPrincipal _modelo, PanelProductos _panelProductos)
    {
        modelo = _modelo;
        panelProductos = _panelProductos;
        
        
    }
    
}
