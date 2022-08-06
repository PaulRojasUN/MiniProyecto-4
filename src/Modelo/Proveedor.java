/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Paul
 */
public class Proveedor {

    public ArrayList<ArrayList<String>> getListaProdProv() {
        return listaProdProv;
    }
    
    public void agregarProducto(int _codigo, String _nombre, float _precioCompra, float _precioVenta)
    {
        listaProdProv.add(new ArrayList<String>(Arrays.asList(_codigo+"",
                _nombre, _precioCompra+"", _precioVenta+"")));
    }

    public void setListaProdProv(ArrayList<ArrayList<String>> listaProdProv) {
        this.listaProdProv = listaProdProv;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTel() {
        return tel;
    }

    public void agregarNoCompras()
    {
        noCompras++;
    }
    
    public void setTel(int tel) {
        this.tel = tel;
    }
    ArrayList<ArrayList<String>> listaProdProv;//Lista de lista de String que
    //describe los productos que vende el proveedor
    
    String nit;
    String nombre;
    int tel;
    String correoE;
    int noCompras;
    
    public Proveedor(String _nit, String _nombre, int _tel,  String _correoE, int _noCompras,
            ArrayList<ArrayList<String>> _productos)
    {
        this.nit = _nit;
        this.nombre = _nombre;
        this.tel = _tel;
        this.correoE = _correoE;
        this.noCompras = _noCompras;
        this.listaProdProv = _productos;
    }
    
    

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public int getNoCompras() {
        return noCompras;
    }

    public void setNoCompras(int noCompras) {
        this.noCompras = noCompras;
    }
    
}
