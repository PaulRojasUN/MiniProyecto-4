/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Paul
 */

public class Producto
{
    String nombre;
    int codigo;
    String descripcion;
    float precioCompra;
    float precioVenta;
    int cant;
    Producto(String _nombre, int _codigo, String _descripcion, 
            float _precioCompra, float _precioVenta, int _cant)
    {
        this.nombre = _nombre;
        this.codigo = _codigo;
        this.descripcion = _descripcion;
        this.precioCompra = _precioCompra;
        this.precioVenta = _precioVenta;
        this.cant = _cant;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }
    
    public void sumarCant(int _cant)
    {
        this.cant += _cant;
    }
    
    public void restarCant(int _cant)
    {
        this.cant -= _cant;
    }
    
    
}
