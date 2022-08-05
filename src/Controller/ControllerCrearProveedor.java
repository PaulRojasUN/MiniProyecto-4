/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelCrearProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.ModeloPrincipal;

/**
 *
 * @author Paul
 */
public class ControllerCrearProveedor 
{
    private ModeloPrincipal modelo;
    private PanelCrearProveedor panelCrearProveedor;
    ControllerCrearProveedor(ModeloPrincipal _modelo, PanelCrearProveedor _panelCrearProveedor)
    {
        modelo = _modelo;
        panelCrearProveedor = _panelCrearProveedor;
        
        
    }
    
    public void addBtnVolverProveedorListener(ActionListener listenControles)
    {
        panelCrearProveedor.addBtnVolverListener(listenControles);
        panelCrearProveedor.addBtnCancelarListener(listenControles);
    }
    
    public class BtnListener implements ActionListener 
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if ("CREAR".equals(e.getActionCommand()))
            {
                
            }
        }
        
    }
}
