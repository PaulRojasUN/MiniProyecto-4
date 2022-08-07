/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Cliente;
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
        
        panelClientes.addListaClientesListener(new JListComprasListener());
        panelClientes.addBtnBorrarListener(new BtnListener());
    }
    
    public void actualizarPanel()
    {
        panelClientes.llenarListaClientes(modelo.getListaStringClientes());
    }
    
    class JListComprasListener implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e) {
            if (panelClientes.getClienteSeleccionado() != null)
            {
                Cliente auxCliente;
                int id;
                String nombre;
                int edad;
                int tel;
                String correoE;
                String genero;
                int noCompras;


                id = parseInt(panelClientes.getClienteSeleccionado().substring(0, panelClientes.getClienteSeleccionado().indexOf(" ")));
                auxCliente = modelo.identificarClienteId(id);
                nombre = auxCliente.getNombre();
                edad = auxCliente.getEdad();
                tel = auxCliente.getTel();
                correoE = auxCliente.getCorreoE();
                genero = auxCliente.getGenero();
                noCompras = auxCliente.getNoCompras();

                panelClientes.setTxtID(id+"");
                panelClientes.setNombres(nombre);
                panelClientes.setEdad(edad);
                panelClientes.setTelefono(tel+"");
                panelClientes.setCorreo(correoE);
                panelClientes.setNumeroCompras(noCompras);
                panelClientes.setGeneroSeleccionado(genero);
                
               
                panelClientes.habilitarBotonActualizar(true);
                panelClientes.habilitarBotonBorrar(true);
               }
                else
                {
                    panelClientes.cambiarEstadoCampos(false);
                    panelClientes.habilitarBotonActualizar(false);
                    panelClientes.habilitarBotonBorrar(false);
                }
        }
    }
    
    class BtnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            int id;
            Cliente auxCliente;
            if ("BORRAR".equals(e.getActionCommand()))
            {
                id = parseInt(panelClientes.getClienteSeleccionado().substring(0, panelClientes.getClienteSeleccionado().indexOf(" ")));
                auxCliente = modelo.identificarClienteId(id);
                
                modelo.borrarClienteObj(auxCliente);
                
                try 
                {
                    modelo.guardarEstadoClientes();
                } 
                catch (IOException ex)
                {
                
                }
                
                actualizarPanel(); 
                
            }
            else if  ("ACTUALIZAR".equals(e.getActionCommand()))
            {
                panelClientes.cambiarEstadoCampos(true);
                panelClientes.cambiarTextoActualizar();
            }   
            else if ("ACEPTAR".equals(e.getActionCommand()))
            {
                panelClientes.cambiarEstadoCampos(true);
                id = parseInt(panelClientes.getClienteSeleccionado().substring(0, panelClientes.getClienteSeleccionado().indexOf(" ")));
                
                int nuevoId;
                String nombre;
                int edad;
                int tel;
                String correoE;
                String genero;
                int noVentas;
                
                try
                {
                   nuevoId = parseInt(panelClientes.getTxtID());
                    nombre = panelClientes.getNombres();
                    edad = panelClientes.getEdad(); 
                    tel = parseInt(panelClientes.getTelefono());
                    correoE = panelClientes.getCorreo();
                    genero = panelClientes.getGeneroSeleccionado();
                    noVentas = panelClientes.getNumeroCompras();
                    
                    if (modelo.adicionarNuevoCliente(id, nombre, edad, tel, correoE, genero, noVentas) == null)
                    {
                        modelo.identificarClienteId(id).cambiarDatoCliente(id, nombre, edad, tel, correoE, genero, noVentas);
                    }
                    else
                    {
                        System.out.println("No puede haber dos clientes con los mismos id");
                    }
                }
                catch (Exception ex)
                {
                    System.out.println("Ingrese datos válidos");
                }
                
                
                
            }
        }
        
    }
    
    
    
}
