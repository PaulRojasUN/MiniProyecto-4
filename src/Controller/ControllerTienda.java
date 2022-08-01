/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Vistas.PanelTienda;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Integer.parseInt;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import modelo.ModeloPrincipal;

/**
 *
 * @author Paul
 */
public class ControllerTienda {
    private ModeloPrincipal modelo;
    private PanelTienda panelTienda;
    public ControllerTienda(ModeloPrincipal _modelo, PanelTienda _panelTienda)
    {
        modelo = _modelo;
        panelTienda = _panelTienda;
        
        
        
        panelTienda.addListaProductosListener(new JListListener());
        panelTienda.addBtnAgregarListener(new BtnAgregarListener());
    }
    
    public void actualizarPanel()
    {
        panelTienda.llenarListaProductos(modelo.getListaStringProductos());
    }
    
    class JListListener implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            System.out.println("Seleccionó: "+panelTienda.getProductoSeleccionado());
        }
    }
    
    class BtnAgregarListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            int cantidad;
            int codigo;
            try 
            {
                cantidad = parseInt(panelTienda.getTxtCantidad());
                codigo = parseInt(panelTienda.getProductoSeleccionado().substring(0, 6));
                panelTienda.addItemListaCompras(modelo.getProductoCodigo(codigo).getNombre() + " x "+cantidad);
                System.out.println(modelo.getProductoCodigo(codigo).getNombre());
            } 
            catch (Exception E)
            {
                System.out.println("Ingrese una cantidad númerica entera y seleccione un item");
                panelTienda.setTxtCantidad("");
            }
        }
        
    }
}
