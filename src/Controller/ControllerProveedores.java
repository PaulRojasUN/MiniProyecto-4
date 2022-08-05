/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelProveedores;
import static java.lang.Integer.parseInt;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.Cliente;
import modelo.ModeloPrincipal;
import modelo.Proveedor;

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
        
        panelProveedores.addListaProveedoresListener(new JListComprasListener());
    }


    public void actualizarPanel()
    {
        panelProveedores.llenarListaProveedores(modelo.getListaStringProveedores());
    }
    
    class JListComprasListener implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e)
        {
             if (panelProveedores.getProveedorSeleccionado()!=null)
            {
                Proveedor auxProveedor;
                String nit;
                nit = panelProveedores.getProveedorSeleccionado().substring(0, panelProveedores.getProveedorSeleccionado().indexOf(" "));
                
                auxProveedor = modelo.identificarProveedorNit(nit);
                
                String nombre;
                int tel;
                String correoE;
                int noCompra;
                
                nombre = auxProveedor.getNombre();
                tel = auxProveedor.getTel();
                correoE = auxProveedor.getCorreoE();
                noCompra = auxProveedor.getNoCompras();
                
                panelProveedores.setNit(nit);
                panelProveedores.setNombre(nombre);
                panelProveedores.setTelefono(tel+"");
                panelProveedores.setCorreo(correoE);
                panelProveedores.setNumeroVentas(noCompra);
                
                panelProveedores.llenarListaProveedores(modelo.getListaStringProveedores());
                
                panelProveedores.llenarListaProductos(modelo.getListaStringProductosProveedores(nit));

            }
        }
        }
}

