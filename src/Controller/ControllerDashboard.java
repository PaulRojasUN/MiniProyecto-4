/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Modelo.Compra;
import Vistas.PanelTienda;
import Vistas.PanelTiendaVender;
import Vistas.VistaDashboard;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.concurrent.TimeUnit;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.ModeloPrincipal;

/**
 *
 * @author RYZEN
 */
public class ControllerDashboard {
    private ModeloPrincipal modelo;
    private VistaDashboard vista;
    
    private ControllerTienda controladorTienda;
    private ControllerProductos controladorProductos;
    private ControllerClientes controladorClientes;
    private ControllerProveedores controladorProveedores;
    private ControllerRegistros controladorRegistros;
    private ControllerTiendaVender controladorTiendaVender;
    private ControllerCrearCliente controladorCrearCliente;
    private ControllerCrearProveedor controladorCrearProveedor;
    private ControllerCrearProducto controladorCrearProducto;
    private ControllerComprarProducto controladorComprarProducto;
    
    
    private Compra compra;
    
    public ControllerDashboard(ModeloPrincipal modelo, VistaDashboard vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        agregarListenersBtnDashBoard();
        
        
        crearControladoresPaneles();
        agregarListenerBtnExtras();
        
        compra = new Compra();
        
    }
    
    private void agregarListenersBtnDashBoard()
    {
        vista.addBtnTiendaMouseEvent(new BtnMouseTiendaListener());
        vista.addBtnProductosMouseEvent(new BtnMouseProductosListener());
        vista.addProveedoresMouseEvent(new BtnMouseProveedoresListener());
        vista.addRegistrosMouseEvent(new BtnMouseRegistrosListener());
        vista.addClientesMouseEvent(new BtnMouseClientesListener());
        vista.addProveedoresMouseEvent(new BtnMouseProveedoresListener());
    }
    
    private void agregarListenerBtnExtras()
    {
        controladorTienda.addBtnVenderListener(new BtnListenerToTiendaVender());
        controladorTiendaVender.addBtnRegresarListener(new BtnListenerToTienda());
        controladorTiendaVender.addBtnAceptarListener(new BtnListenerToTienda());
        controladorTiendaVender.addBtnCrearClienteListener(new BtnListenerToCrearCliente());
        controladorCrearCliente.addBtnRegresarListener(new BtnListenerToTiendaVender());
        controladorProveedores.addBtnCrearListener(new BtnListenerToCrearProveedor());
        controladorCrearProveedor.addBtnVolverProveedorListener(new BtnListenerToProveedores());
        controladorCrearProducto.addBtnVolverListener(new BtnListenerToProductos());
        controladorCrearProducto.addBtnCrearProductoListener(new BtnListenerToProductos());
        controladorProductos.addBtnCrearListener(new BtnListenerToCrearProductos());
        controladorProductos.addBtnComprarProductosListener(new BtnListenerToComprarProductos());
        controladorComprarProducto.addBtnVolverListener(new BtnListenerToProductos());
    }
    
    private void crearControladoresPaneles()
    {
        controladorTienda = new ControllerTienda(modelo, vista.getPanelTienda());
        controladorProductos = new ControllerProductos(modelo, vista.getPanelProductos());
        controladorClientes = new ControllerClientes(modelo, vista.getPanelClientes());
        controladorRegistros = new ControllerRegistros(modelo, vista.getPanelRegistros());
        controladorProveedores = new ControllerProveedores(modelo, vista.getPanelProveedores());
        controladorTiendaVender = new ControllerTiendaVender(modelo, vista.getPanelTiendaVender());
        controladorCrearCliente = new ControllerCrearCliente(modelo, vista.getPanelCrearCliente());
        controladorCrearProveedor = new ControllerCrearProveedor(modelo, vista.getPanelCrearProveedor());
        controladorCrearProducto = new ControllerCrearProducto(modelo, vista.getPanelCrearProducto());
        controladorComprarProducto = new ControllerComprarProducto(modelo, vista.getPanelComprarProducto());
    }
    
    class BtnMouseProductosListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed(MouseEvent e) {
             controladorProductos.actualizarPanel();
          }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseExited(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    
    class BtnMouseTiendaListener implements MouseListener
    {
       
        @Override
        public void mouseClicked(MouseEvent e) {
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed(MouseEvent e) {
            System.out.println("Tienda");
            controladorTienda.actualizarPanel();
              
           }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseExited(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    
    
    class BtnMouseClientesListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed(MouseEvent e) {
             System.out.println("Clientes");
            controladorClientes.actualizarPanel();
          }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseExited(MouseEvent e) {
          //  throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    
    class BtnMouseProveedoresListener implements MouseListener
    {
       
        @Override
        public void mouseClicked(MouseEvent e) {
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed(MouseEvent e) {
            controladorProveedores.actualizarPanel();  
           }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseExited(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    
    class BtnMouseRegistrosListener implements MouseListener
    {
       
        @Override
        public void mouseClicked(MouseEvent e) {
//throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed(MouseEvent e) {
             System.out.println("Registros");
            ControllerRegistros controladorRegistros = new ControllerRegistros(modelo, vista.getPanelRegistros());
            //vista.getPanelTienda().addListaProductosListener(new JListListener());   
           }

        @Override
        public void mouseReleased(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mouseExited(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }
        
    }
    
    
    //Aquí se colocan los listener de los botones en los paneles que abren el panelTiendaVender
    class BtnListenerToTiendaVender implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if ("VENDER".equals(e.getActionCommand()))
            {
                compra.setListaProductos(vista.getPanelTienda().getListaDeCompras());
                compra.setTotalCompra(parseFloat(vista.getPanelTienda().getTxtPrecioTotal()));
                
                 vista.realizarCambioPanelDashboard(vista.getPanelTiendaVender());
                 controladorTiendaVender.setCompra(compra);
                 controladorTiendaVender.actualizarPanel();
                 
            }
            else if ("VOLVER".equals(e.getActionCommand()) || "CANCELAR".equals(e.getActionCommand()) 
                    || "CREAR".equals(e.getActionCommand()))
            {
                controladorCrearCliente.crearCliente();
                controladorTiendaVender.actualizarPanel();
                vista.realizarCambioPanelDashboard(vista.getPanelTiendaVender());
            }
        }
    }
    
    //Aquí se colocan los listener de los botones en los paneles que abren el panelTienda
    class BtnListenerToTienda implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if ("REGRESAR".equals(e.getActionCommand()))//Botón Regresar en panelTiendaVender
            {
                vista.realizarCambioPanelDashboard(vista.getPanelTienda());
            }
            else if ("ACEPTAR".equals(e.getActionCommand()))//Botón Aceptar en panelTiendaVender
            {
                vista.realizarCambioPanelDashboard(vista.getPanelTienda());
            }
        }
    }
    
    class BtnListenerToCrearCliente implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if ("Crear Cliente".equals(e.getActionCommand()))//Botón Regresar en panelTiendaVender
            {
                vista.realizarCambioPanelDashboard(vista.getPanelCrearCliente());
                System.out.println("Creando cliente");
            }
        }
    }
    
    class BtnListenerToCrearProveedor implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if ("CREAR".equals(e.getActionCommand()))//Botón Regresar en panelTiendaVender
            {
                vista.realizarCambioPanelDashboard(vista.getPanelCrearProveedor());
            }
        }
    }
    
    class BtnListenerToProveedores implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if ("VOLVER".equals(e.getActionCommand()) || "CANCELAR".equals(e.getActionCommand()))//Botón Regresar en panelTiendaVender
            {
                vista.realizarCambioPanelDashboard(vista.getPanelProveedores());
            }
        }
    }
    
    class BtnListenerToCrearProductos implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if ("CREAR".equals(e.getActionCommand()))//Botón Regresar en panelTiendaVender
            {
                controladorCrearProducto.actualizarPanel();
                vista.realizarCambioPanelDashboard(vista.getPanelCrearProducto());
            }
        }
    }
    
    class BtnListenerToProductos implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if ("VOLVER".equals(e.getActionCommand()) || "CANCELAR".equals(e.getActionCommand()))//Botón Regresar en panelTiendaVender
            {
                vista.realizarCambioPanelDashboard(vista.getPanelProductos());
            }
            else if ("CREAR".equals(e.getActionCommand()))
            {
                vista.realizarCambioPanelDashboard(vista.getPanelProductos());
            }
        }
    }
    
    class BtnListenerToComprarProductos implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            if ("COMPRAR PRODUCTO".equals(e.getActionCommand()))//Botón Regresar en panelTiendaVender
            {
                controladorComprarProducto.actualizarPanel();
                vista.realizarCambioPanelDashboard(vista.getPanelComprarProducto());
            }
        }
    }
}


