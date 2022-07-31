/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author RYZEN
 */
public class PanelTienda extends javax.swing.JPanel {
    DefaultListModel modelo;

    /**
     * Creates new form PanelTienda
     */
    public PanelTienda() {
        initComponents();
        modelo = new DefaultListModel();
        listaProductos.setModel(modelo);
        modelo.addElement("Hola");
        modelo.addElement("HolaMundo");
    }
    
    public void llenarListaProductos(ArrayList<String> productos){
        for (String producto : productos)
            {
                modelo.addElement(producto);
            }
    }
    
    public String getValorSeleccionadoListaProductos(){
        return "Hola";
    }
    
    public void activarBotonAgregar(boolean estado){
        btnAgregarCantidad.setEnabled(estado); 
    }
    
    public int getCantidadProductos(){
        return Integer.parseInt(txtNumeroDeProductos.getText());
    }
    
    public void setPrecioTotal(int precioTotal){
        txtPrecioTotal.setText(String.valueOf(precioTotal));
    }
    
    public void setNumeroTotalDeProductos(int numeroTotalProductos){
        txtNumeroDeProductos.setText(String.valueOf(numeroTotalProductos));
    }
    
    public void addBtnAgregarListener(ActionListener listenControles){
        btnAgregarCantidad.addActionListener(listenControles);
    }
    
    public void addBtnBorrarElementoListaListener(ActionListener listenControles){
        btnBorrarElementoLista.addActionListener(listenControles);
    }
    
    public void addBtnCambiarCantidadListaListener(ActionListener listenControles){
        btnCambiarCantidadLista.addActionListener(listenControles);
    }
    
    public void addVenderProductosListener(ActionListener listenControles){
        btnVenderProductos.addActionListener(listenControles);
    }
    
    public void addListaProductosListener(ListSelectionListener listenSelectionController){
        listaProductos.addListSelectionListener(listenSelectionController);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaCompra = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaProductos = new javax.swing.JList<>();
        lblListaProductos = new javax.swing.JLabel();
        lblListaCompras = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        btnAgregarCantidad = new javax.swing.JButton();
        btnBorrarElementoLista = new javax.swing.JButton();
        btnCambiarCantidadLista = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtPrecioTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtNumeroDeProductos = new javax.swing.JTextField();
        btnVenderProductos = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(750, 430));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(listaCompra);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 230, 270));

        listaProductos.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(listaProductos);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 230, 310));

        lblListaProductos.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblListaProductos.setText("LISTA DE PRODUCTOS");
        add(lblListaProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        lblListaCompras.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        lblListaCompras.setText("LISTA DE COMPRAS");
        add(lblListaCompras, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 70, -1, -1));

        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 150, 120, -1));

        lblCantidad.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        lblCantidad.setText("Cantidad: ");
        add(lblCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, -1, -1));

        btnAgregarCantidad.setBackground(new java.awt.Color(176, 230, 253));
        btnAgregarCantidad.setFont(new java.awt.Font("Roboto", 1, 18)); // NOI18N
        btnAgregarCantidad.setForeground(new java.awt.Color(0, 86, 158));
        btnAgregarCantidad.setBorder(null);
        btnAgregarCantidad.setLabel("AGREGAR"); // NOI18N
        btnAgregarCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarCantidadActionPerformed(evt);
            }
        });
        add(btnAgregarCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 190, 120, 70));

        btnBorrarElementoLista.setBackground(new java.awt.Color(176, 230, 253));
        btnBorrarElementoLista.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnBorrarElementoLista.setForeground(new java.awt.Color(0, 86, 158));
        btnBorrarElementoLista.setText("BORRAR");
        btnBorrarElementoLista.setBorder(null);
        btnBorrarElementoLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarElementoListaActionPerformed(evt);
            }
        });
        add(btnBorrarElementoLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 380, 70, 40));

        btnCambiarCantidadLista.setBackground(new java.awt.Color(176, 230, 253));
        btnCambiarCantidadLista.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnCambiarCantidadLista.setForeground(new java.awt.Color(0, 86, 158));
        btnCambiarCantidadLista.setText("CAMBIAR CANTIDAD");
        btnCambiarCantidadLista.setBorder(null);
        add(btnCambiarCantidadLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 380, 150, 40));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel1.setText("Precio Total:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 100, -1, -1));

        txtPrecioTotal.setEnabled(false);
        add(txtPrecioTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, 100, -1));

        jLabel2.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel2.setText("No. Productos:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, -1, -1));

        txtNumeroDeProductos.setEnabled(false);
        add(txtNumeroDeProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 180, 100, -1));

        btnVenderProductos.setBackground(new java.awt.Color(176, 230, 253));
        btnVenderProductos.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnVenderProductos.setForeground(new java.awt.Color(0, 86, 158));
        btnVenderProductos.setText("VENDER");
        btnVenderProductos.setBorder(null);
        add(btnVenderProductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 380, 100, 40));
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void btnAgregarCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarCantidadActionPerformed

    private void btnBorrarElementoListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarElementoListaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBorrarElementoListaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarCantidad;
    private javax.swing.JButton btnBorrarElementoLista;
    private javax.swing.JButton btnCambiarCantidadLista;
    private javax.swing.JButton btnVenderProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblListaCompras;
    private javax.swing.JLabel lblListaProductos;
    private javax.swing.JList<String> listaCompra;
    private javax.swing.JList<String> listaProductos;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtNumeroDeProductos;
    private javax.swing.JTextField txtPrecioTotal;
    // End of variables declaration//GEN-END:variables
}
