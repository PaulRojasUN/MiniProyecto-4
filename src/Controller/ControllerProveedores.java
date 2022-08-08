/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelProveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
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
        panelProveedores.addBtnBorrarListener(new BtnListener());
        panelProveedores.addBtnActualizarListener(new BtnListener());
    }
    
    public void addBtnCrearListener(ActionListener listenControles)
    {
        panelProveedores.addBtnCrearListener(listenControles);
    }
    
    public void vaciarCampos()
    {
        panelProveedores.vaciarCampos();
    }


    public void actualizarPanel()
    {
        panelProveedores.llenarListaProveedores(modelo.getListaStringProveedores());
        panelProveedores.vaciarCampos();
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
                
                //panelProveedores.llenarListaProveedores(modelo.getListaStringProveedores());
                
                panelProveedores.llenarListaProductos(modelo.getListaStringProductosProveedores(nit));
                
                panelProveedores.habilitarBotonBorrar(true);
                panelProveedores.habilitarBotonActualizar(true);
            }
            else
            {
                panelProveedores.habilitarBotonBorrar(false);
                panelProveedores.habilitarBotonActualizar(false);
            }
        }
    }
    
    class BtnListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if ("BORRAR".equals(e.getActionCommand()))
            {
                int respuesta;
                respuesta = JOptionPane.showConfirmDialog(null,"Esta acción borrará también los productos asociados. ¿Estás seguro?");
                if (respuesta == 0)
                {
                    Proveedor auxProveedor;
                    String nit;
                    nit = panelProveedores.getProveedorSeleccionado().substring(0, panelProveedores.getProveedorSeleccionado().indexOf(" "));

                    auxProveedor = modelo.identificarProveedorNit(nit);
                    
                    modelo.borrarProductosDeProveedor(auxProveedor.getNombre());
                    modelo.borrarProveedorObj(auxProveedor);
                    

                    panelProveedores.llenarListaProveedores(modelo.getListaStringProveedores());

                    try {
                        modelo.guardarEstadoProveedores();
                        modelo.guardarEstadoProductos();
                    } catch (IOException ex) {
                        }
                    vaciarCampos();
                }
            }
            else if ("ACTUALIZAR".equals(e.getActionCommand()))
            {
                panelProveedores.cambiarEstadoCampos(true);
                panelProveedores.cambiarTextoActualizar();
            }
            else if ("ACEPTAR".equals(e.getActionCommand()))
            {
                String nuevoNit;
                String nuevoNombre;
                String correoE;
                int tel;
                int noVentas;
                ArrayList<ArrayList<String>> listaDeProductos;
                
                try 
                {
                    Proveedor auxProveedor;
                    String nit;
                    nit = panelProveedores.getProveedorSeleccionado().substring(0, panelProveedores.getProveedorSeleccionado().indexOf(" "));

                    auxProveedor = modelo.identificarProveedorNit(nit);
                    
                    nuevoNit = panelProveedores.getNit();
                    nuevoNombre = panelProveedores.getNombre();
                    correoE = panelProveedores.getCorreo();
                    tel = parseInt(panelProveedores.getTelefono());
                    noVentas = panelProveedores.getNumeroVentas();
                    listaDeProductos = auxProveedor.getListaProdProv();
                    
                    modelo.borrarProveedorObj(auxProveedor);
                    
                    if (modelo.getProveedorNombre(nuevoNombre) == null && modelo.getProveedorNit(nuevoNit) == null)
                    {
                        modelo.agregarNuevoProveedorConLista(nuevoNit, nuevoNombre, tel, correoE, noVentas, listaDeProductos);
                        panelProveedores.cambiarTextoActualizar();
                        panelProveedores.cambiarEstadoCampos(false);
                        actualizarPanel();
                    }
                    else
                    {
                        System.out.println("No puede haber dos proveedores con el mismo nit o nombre");
                        modelo.agregarNuevoProveedorConLista(auxProveedor.getNit(), auxProveedor.getNombre(),auxProveedor.getTel(), auxProveedor.getCorreoE(), auxProveedor.getNoCompras(),listaDeProductos);
                    }
                    
                    modelo.guardarEstadoProveedores();
                    
                    
                    
                }
                catch (Exception ex)
                {
                    System.out.println("Ingrese datos válidos");
                }
            }
        }
        
    }
}

