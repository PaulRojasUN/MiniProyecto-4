/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Paul
 */
public class Cliente 
{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }
    
    public void addNoCompra()
    {
        this.noCompras++;
    }

    public String getCorreoE() {
        return correoE;
    }

    public void setCorreoE(String correoE) {
        this.correoE = correoE;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getNoCompras() {
        return noCompras;
    }

    public void setNoCompras(int noCompras) {
        this.noCompras = noCompras;
    }
    
     public void cambiarDatoCliente(int _id, String _nombre, int _edad, int _tel,
             String _correo, String _genero, int _noCompras)
    {
        setId(_id);
        setNombre(_nombre);
        setEdad(_edad);
        setTel(_tel);
        setCorreoE(_correo);
        setGenero(_genero);
        setNoCompras(_noCompras);
    }
    
    int id;
    String nombre;
    int edad;
    int tel;
    String correoE;
    String genero;
    int noCompras;
    
    public Cliente(int _id, String _nombre, int _edad, int _tel, String _correoE
    , String _genero, int _noCompras)
    {
        this.id = _id;
        this.nombre = _nombre;
        this.edad = _edad;
        this.tel = _tel;
        this.correoE = _correoE;
        this.genero = _genero;
        this.noCompras = _noCompras;
    }
}
