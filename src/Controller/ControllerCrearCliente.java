/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelClientes;
import Vistas.PanelCrearCliente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import modelo.ModeloPrincipal;

/**
 *
 * @author Paul
 */
public class ControllerCrearCliente 
{
    private ModeloPrincipal modelo;
    private PanelCrearCliente panelCrearCliente;
    ControllerCrearCliente(ModeloPrincipal _modelo, PanelCrearCliente _panelCrearCliente)
    {
        modelo = _modelo;
        panelCrearCliente = _panelCrearCliente;
        
        panelCrearCliente.addBtnCrearListener(new BtnListener());
    }
    
    public void addBtnRegresarListener(ActionListener listenControles)
    {
        panelCrearCliente.addBtnVolverListener(listenControles);
        panelCrearCliente.addBtnCancelarListener(listenControles);
        panelCrearCliente.addBtnCrearListener(listenControles);
    }
    
    public void crearCliente()
    {
        int id;
                String nombre;
                int edad;
                int tel;
                String correoE;
                String genero;
                int noCompras;
                
                try {
                id = panelCrearCliente.getId();
                nombre = panelCrearCliente.getNombres() +" "+ panelCrearCliente.getApellidos();
                edad = panelCrearCliente.getEdad();
                tel = parseInt(panelCrearCliente.getTelefono());
                correoE = panelCrearCliente.getCorreo();
                genero = panelCrearCliente.getGeneroSeleccionado();
                noCompras = panelCrearCliente.getNumeroCompras();
                
                    if (modelo.adicionarNuevoCliente(id, nombre, edad, tel, correoE, genero, noCompras)==false)
                    {
                        System.out.println("Ya existe un cliente con ese id");
                    }
                modelo.guardarEstadoClientes();
                }
                catch (Exception ex){
                    System.out.println("Ingrese TODOS los valores correctamente");
                }
    }
    
    class BtnListener implements ActionListener
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

