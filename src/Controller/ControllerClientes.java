/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelClientes;
import static java.lang.Integer.parseInt;
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
    }
    
    public void actualizarPanel()
    {
        panelClientes.llenarListaClientes(modelo.getListaStringClientes());
    }
    
    class JListComprasListener implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e) {
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
            
            panelClientes.setNombres(nombre);
            panelClientes.setEdad(edad);
            panelClientes.setTelefono(tel+"");
            panelClientes.setCorreo(correoE);
            panelClientes.setNumeroCompras(noCompras);
        }
    }
    
    
    
}
