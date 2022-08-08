/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelRegistros;
import Vistas.PanelTienda;
import modelo.ModeloPrincipal;

/**
 *
 * @author Paul
 */
public class ControllerRegistros {
    private ModeloPrincipal modelo;
    private PanelRegistros panelRegistros;
    
    public ControllerRegistros(ModeloPrincipal _modelo, PanelRegistros _panelRegistros)
    {
        modelo = _modelo;
        panelRegistros = _panelRegistros;
        
        
    }
    
    public void actualizarPanel()
    {
        panelRegistros.llenarTabla(modelo.getRegistosList());
    }
}
