/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelTienda;
import Vistas.VistaDashboard;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
    
    public ControllerDashboard(ModeloPrincipal modelo, VistaDashboard vista) {
        this.modelo = modelo;
        this.vista = vista;
        
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        
        agregarListenersBtnDashBoard();
        
        crearControladoresPaneles();
    }
    
    private void agregarListenersBtnDashBoard()
    {
        vista.addBtnTiendaMouseEvent(new BtnMouseTiendaListener());
        vista.addBtnProductosMouseEvent(new BtnMouseProductosListener());
        vista.addProveedoresMouseEvent(new BtnMouseProveedoresListener());
        vista.addRegistrosMouseEvent(new BtnMouseRegistrosListener());
        vista.addClientesMouseEvent(new BtnMouseClientesListener());
    }
    
    private void crearControladoresPaneles()
    {
        controladorTienda = new ControllerTienda(modelo, vista.getPanelTienda());
        controladorProductos = new ControllerProductos(modelo, vista.getPanelProductos());
        controladorClientes = new ControllerClientes(modelo, vista.getPanelClientes());
        controladorRegistros = new ControllerRegistros(modelo, vista.getPanelRegistros());
        controladorProveedores = new ControllerProveedores(modelo, vista.getPanelProveedores());
    }
    
    class BtnMouseProductosListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed(MouseEvent e) {
             System.out.println("Productos");
             controladorProductos = new ControllerProductos(modelo, vista.getPanelProductos());
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
    
    
    
    class BtnMouseClientesListener implements MouseListener
    {

        @Override
        public void mouseClicked(MouseEvent e) {
           // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public void mousePressed(MouseEvent e) {
             System.out.println("Clientes");
            controladorClientes = new ControllerClientes(modelo, vista.getPanelClientes());
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
             System.out.println("Proveedores");
            controladorProveedores = new ControllerProveedores(modelo, vista.getPanelProveedores());
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
}
