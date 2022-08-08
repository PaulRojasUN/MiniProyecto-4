/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author Paul
 */
public class Compra {
    ArrayList<String> listaCompras;
    float totalCompra;
    public Compra(){
        
    }

    public ArrayList<String> getListaCompras() {
        return listaCompras;
    }

    public void setListaProductos(ArrayList<String> listaProductos) {
        this.listaCompras = listaProductos;
    }

    public float getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(float totalCompra) {
        this.totalCompra = totalCompra;
    }
    
    
}
