
package modelo;

/**
 *
 * @author Paul
 */
public class Registro 
{
    String date;
    String movimiento;
    String nombreProducto;
    int cant;
    float precio;
    
    public Registro(String _date, String _movimiento, String _nombreProducto, 
            int _cant, float _precio)
    {
        this.date = _date;
        this.movimiento = _movimiento;
        this.nombreProducto = _nombreProducto;
        this.cant = _cant;
        this.precio = _precio;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
    
}
