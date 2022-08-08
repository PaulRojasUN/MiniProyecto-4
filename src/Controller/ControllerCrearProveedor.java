/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelCrearProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
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
        
        panelCrearProveedor.addBtnCrearListener(new BtnListener());
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
                String nit;
                String nombre;
                String correo;
                int tel;
                int noCompras;
                
                nit = panelCrearProveedor.getNit();
                nombre = panelCrearProveedor.getNombres();
                correo = panelCrearProveedor.getCorreo();
                try
                {
                    tel = parseInt(panelCrearProveedor.getTelefono());
                    noCompras = panelCrearProveedor.getNumeroVentas();
                    
                    if (tel > 0 && noCompras > 0)
                    {
                        modelo.agregarNuevoProveedor(nit, nombre, tel, correo, noCompras);
                        
                        modelo.guardarEstadoProveedores();
                        
                        JOptionPane.showMessageDialog(null, "Se ha creado con éxito");
                    }
                    else 
                    {
                        System.out.println("Ingrese valores mayores de cero");
                    }
                }
                catch (Exception ex)
                {
                    System.out.println("Ingrese valores válidos");
                }
                
            }
        }
        
    }
}
