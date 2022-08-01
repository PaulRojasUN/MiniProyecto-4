/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 * @author Paul
 */
public class ModeloPrincipal 
{
    //Lista de productos con los que cuenta la tienda con su respectiva cantidad
    ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    
    //Lista de proveedores. Contiene la lista de las descripciones de los 
    //productos que ofrece
    ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
    
    //Lista de clientes.
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
    public ModeloPrincipal() throws IOException
    {
        try 
        {
            importarProductos("src\\archivos\\productos.txt");
            importarProveedores("src\\archivos\\proveedores.txt");
            importarClientes("src\\archivos\\clientes.txt");
        }
        catch (Exception E)
        {
            System.out.println("Ha ocurrido un error al cargar los archivos");
        }
    }
    
    //Importa los datos de los productos a la estructura de datos
    public void importarProductos(String _path) throws FileNotFoundException, IOException
    {
        FileReader fr = new FileReader(_path);
        BufferedReader br = new BufferedReader(fr);
        StringTokenizer st;
        String line;
        
        int codigo;
        String nombre;
        String descripcion;
        float precioCompra;
        float precioVenta;
        int cant;
        
        while( (line = br.readLine()) != null)
        {
            st = new StringTokenizer(line, ",");
            codigo = parseInt(st.nextToken());
            nombre = st.nextToken();
            descripcion = st.nextToken();
            precioCompra = parseFloat(st.nextToken());
            precioVenta = parseFloat(st.nextToken());
            cant = parseInt(st.nextToken());
            
            listaProductos.add(new Producto(nombre, codigo, descripcion, 
                    precioCompra, precioVenta, cant));
        }
        
    }
    
    
    //Importa los datos de los proveedores a la estructura de datos
    public void importarProveedores(String _path) throws FileNotFoundException, 
            IOException
    {
        FileReader fr = new FileReader(_path);
        BufferedReader br = new BufferedReader(fr);
        StringTokenizer st;
        String line;
        
        String nit;
        String nombre;
        int tel;
        
        //Variables auxiliares:
        String auxCodProd;
        String auxNombreProd;
        String auxDescProd;
        String auxPreComProd;
        String auxPreVenProd;
        ArrayList<ArrayList<String>> auxListaProd;
        
        
        String auxString; //String auxiliar para recorrer la lista de productos que
        String auxString2;
        
        StringTokenizer auxSt;//StringTokenizer auxiliar para recorrer la lista de productos que
        StringTokenizer auxSt2;
        while( (line = br.readLine()) != null)
        {
            auxListaProd = new ArrayList<ArrayList<String>>();
            
            auxString = "";
            auxString2 = "";
            
            st = new StringTokenizer(line, ",");
            nit = st.nextToken();
            nombre = st.nextToken();
            tel = parseInt(st.nextToken());
            
            auxString = st.nextToken();
            auxString = auxString.substring(1, auxString.length()
                    - 1);//Se retira los corchetes
            auxSt = new StringTokenizer(auxString, ":");
            while (auxSt.hasMoreTokens())
            {
                auxString2 = auxSt.nextToken();
                auxString2 = auxString2.substring(1, auxString2.length()
                    - 1); // Se retira los parentesis
                auxSt2 = new StringTokenizer(auxString2, ";");
                auxCodProd = auxSt2.nextToken();
                auxNombreProd = auxSt2.nextToken();
                auxDescProd = auxSt2.nextToken();
                auxPreComProd = auxSt2.nextToken();
                auxPreVenProd = auxSt2.nextToken();
                auxListaProd.add(new 
            ArrayList<String>(Arrays.asList(auxCodProd,auxNombreProd, 
                auxDescProd, auxPreComProd, auxPreVenProd)));
            }
            listaProveedores.add(new Proveedor(nit, nombre, tel, auxListaProd));  
        }
    }
    
    
    //Importa los datos de los clientes a la estructura de datos
    public void importarClientes(String _path) throws FileNotFoundException, 
            IOException
    {
        FileReader fr = new FileReader(_path);
        BufferedReader br = new BufferedReader(fr);
        StringTokenizer st;
        String line;
        
        int id;
        String nombre;
        int edad;
        int tel;
        
        while( (line = br.readLine()) != null)
        {
            st = new StringTokenizer(line, ",");
            id = parseInt(st.nextToken());
            nombre = st.nextToken();
            edad = parseInt(st.nextToken());
            tel = parseInt(st.nextToken());
            
            listaClientes.add(new Cliente(id, nombre, edad, tel));
        }
    }
    
    //Guarda todos los datos de la estructura de datos en el archivo de 
    //productos
    public void guardarEstadoProductos() throws IOException
    {
        try
        {
            FileWriter archivo = new FileWriter("src\\archivos\\productos.txt", false);
            PrintWriter pw = new PrintWriter(archivo);
            for (Producto pr:listaProductos)
            {
                pw.print(pr.getCodigo()+","+pr.getNombre()+","+pr.getDescripcion()+
                        ","+pr.getPrecioCompra()+","+pr.getPrecioVenta()+","+
                        pr.getCant()+"\n");
            }
            pw.print("Impreso");
            archivo.flush();
            archivo.close();
        }
        catch (Exception E)
        {
           System.out.println("Algo salió mal al guardar el archivo");
        }
    }
    
    //Guarda todos los datos de la estructura de datos en el archivo de 
    //proveedores
    public void guardarEstadoProveedores() throws IOException
    {
        try
        {
            FileWriter archivo = new FileWriter("src\\archivos\\proveedores.txt", false);
            PrintWriter pw = new PrintWriter(archivo);
            String auxString;
            
                    
            for (Proveedor pr:listaProveedores)
            {
                auxString = "";
                for (ArrayList<String> lista: pr.getListaProdProv())
                {
                    auxString = auxString+"("+lista.get(0)+";"+lista.get(1)+";"+lista.get(2)+";"+lista.get(3)+";"+lista.get(4)+")"+":";
                }
                pw.print(pr.getNit()+","+pr.getNombre()+","+pr.getTel()+
                        ","+"["+auxString+"]"+"\n");
            }
            archivo.flush();
            archivo.close();
        }
        catch (Exception E)
        {
           System.out.println("Algo salió mal al guardar el archivo");
        }
    }
    
    //Guarda todos los datos de la estructura de datos en el archivo de 
    //clentes
    public void guardarEstadoClientes() throws IOException
    {
        try
        {
            FileWriter archivo = new FileWriter("src\\archivos\\clientes.txt", false);
            PrintWriter pw = new PrintWriter(archivo);
            
                    
            for (Cliente cl:listaClientes)
            {
                    pw.print(cl.getId()+","+cl.getNombre()+","+cl.getEdad()+
                       ","+cl.getTel()+"\n");
            }
            archivo.flush();
            archivo.close();
        }
        catch (Exception E)
        {
           System.out.println("Algo salió mal al guardar el archivo");
        }
    }
    
    public Producto getProducto(int _index)
    {
        return listaProductos.get(_index);
    }
    
    public Proveedor getProveedor(int _index)
    {
        return listaProveedores.get(_index);
    }
    
    public Cliente getCliente(int _index)
    {
        return listaClientes.get(_index);
    }
    
    public void borrarProducto(int _index)
    {
        listaProductos.remove(_index);
    }
    
    public void borrarProveedor(int _index)
    {
        listaProveedores.remove(_index);
    }
    
    public void borrarCliente(int _index)
    {
        listaClientes.remove(_index);
    }
    
    public ArrayList<String> getListaStringProductos()
    {
        ArrayList<String> lista = new ArrayList<String>();
        for (Producto pr : listaProductos)
        {
            lista.add(pr.getCodigo()+ " - " + pr.getNombre()+" - $"+
                    pr.getPrecioVenta());
        }
        
        return lista;
    }
    
    public Producto getProductoCodigo(int _codigo)
    {
        Boolean encontrado = false;
        for (Producto pr: listaProductos)
        {
            if (pr.getCodigo() == _codigo)
            {
                encontrado = true;
                return pr;
            }
        }
            System.out.println("No se halló el código");
            return null;
        
    }
    
    public float calcularTotal(ArrayList<String> _lista)
    {
        float total = 0f;
        for (String item : _lista)
        {
            total += parseFloat(item.substring(item.indexOf("=") + 2));
        }
        return total;
    }
    
    public String itemListaCompra(int codigo, int _cantidad)
    {
        Producto auxProduct;
        auxProduct = getProductoCodigo(codigo);
        return (auxProduct.getNombre() + " x " + _cantidad + " = "+
                (auxProduct.getPrecioVenta()*_cantidad));
    }
    
    public int calcularCantidadProductosTotal(ArrayList<String> _lista)
    {
        int cantidad = 0;
        for (String item : _lista)
        {
            cantidad += parseFloat(item.substring(item.indexOf("x") + 2, 
                    item.indexOf("=")-1));
        }
        return cantidad;
    }
    
    public int identificarItemCompras(ArrayList<String> _lista, String _nombre)
    {
        int index = -1;//El -1 indica que no lo encontró.
        String nombreProducto;
        for (int i = 0; i < _lista.size(); i++)
        {
            nombreProducto = _lista.get(i).substring(0, _lista.get(i).indexOf("x")-1);
            if (nombreProducto.equals(_nombre))
            {
                index = i;
                break;
            }
        }
        return index;
    }
    
    public String getCantidadCompraCambiada(String _item, int _cantidad)
    {
        String item;
        float precio;
        precio = parseFloat(_item.substring(_item.indexOf("=")+2)) / parseFloat(_item.substring(_item.indexOf("x")+2, 
                _item.indexOf("=")-1));
        item = _item.substring(0, _item.indexOf("x")+2)+_cantidad+_item.substring(_item.indexOf("=")-1, _item.indexOf("=")+2) + (precio*_cantidad);
        return item;
    }
    
    public String getCantidadCompraCambiadaSuma(String _item, int _cantidad)
    {
        String item;
        float precio;
        precio = parseFloat(_item.substring(_item.indexOf("=")+2)) / parseFloat(_item.substring(_item.indexOf("x")+2, 
                _item.indexOf("=")-1));
        int cantidadNueva;
        cantidadNueva = parseInt(_item.substring(_item.indexOf("x")+2, _item.indexOf("=")-1))+_cantidad;
        item = _item.substring(0, _item.indexOf("x")+2)+cantidadNueva+
                _item.substring(_item.indexOf("=")-1, _item.indexOf("=")+2) + (precio*cantidadNueva);
        return item;
    }
    
}
