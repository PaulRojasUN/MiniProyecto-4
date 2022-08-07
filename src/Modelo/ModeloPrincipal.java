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
        float precioCompra;
        float precioVenta;
        int cant;
        int noVendidos;
        
        while( (line = br.readLine()) != null)
        {
            st = new StringTokenizer(line, ",");
            codigo = parseInt(st.nextToken());
            nombre = st.nextToken();
            precioCompra = parseFloat(st.nextToken());
            precioVenta = parseFloat(st.nextToken());
            cant = parseInt(st.nextToken());
            noVendidos = parseInt(st.nextToken());
            
            
            listaProductos.add(new Producto(nombre, codigo, 
                    precioCompra, precioVenta, cant, noVendidos));
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
        String correoE;
        int noCompras;
        
        //Variables auxiliares:
        String auxCodProd;
        String auxNombreProd;
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
            correoE = st.nextToken();
            noCompras = parseInt(st.nextToken());
            
            
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
                auxPreComProd = auxSt2.nextToken();
                auxPreVenProd = auxSt2.nextToken();
                auxListaProd.add(new 
            ArrayList<String>(Arrays.asList(auxCodProd,auxNombreProd, auxPreComProd, auxPreVenProd)));
            }
            listaProveedores.add(new Proveedor(nit, nombre, tel, correoE,noCompras,auxListaProd));  
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
        String correoE;
        String genero;
        int noCompras;
        
        while( (line = br.readLine()) != null)
        {
            st = new StringTokenizer(line, ",");
            id = parseInt(st.nextToken());
            nombre = st.nextToken();
            edad = parseInt(st.nextToken());
            tel = parseInt(st.nextToken());
            correoE = st.nextToken();
            genero = st.nextToken();
            noCompras = parseInt(st.nextToken());
            
            listaClientes.add(new Cliente(id, nombre, edad, tel, correoE, genero,
            noCompras));
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
                pw.print(pr.getCodigo()+","+pr.getNombre()+
                        ","+pr.getPrecioCompra()+","+pr.getPrecioVenta()+","+
                        pr.getCant()+","+pr.getNoVendidos()+"\n");
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
                    auxString = auxString+"("+lista.get(0)+";"+lista.get(1)+";"+lista.get(2)+";"+lista.get(3)+")"+":";
                }
                pw.print(pr.getNit()+","+pr.getNombre()+","+pr.getTel()+","
                        +pr.getCorreoE()+","+pr.getNoCompras()+","+"["+auxString+"]"+"\n");
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
                       ","+cl.getTel()+","+cl.getCorreoE()+","+cl.getGenero()+","+cl.getNoCompras()+"\n");
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
    
    public void borrarProductoObj(Producto _producto)
    {
        listaProductos.remove(listaProductos.indexOf(_producto));
    }
    
    public void borrarClienteObj(Cliente _cliente)
    {
        borrarCliente(listaClientes.indexOf(_cliente));
    }
    
    public void borrarProveedor(int _index)
    {
        listaProveedores.remove(_index);
    }
    
    public void borrarCliente(int _index)
    {
        listaClientes.remove(_index);
    }
    
    public Proveedor getProveedorDeProducto(String _name)
    {
        for (Proveedor pr: listaProveedores)
        {
            for (ArrayList<String> lista: pr.getListaProdProv())
            {
                if (_name.equals(lista.get(1)))
                {
                    return pr;
                }
            }
        }
        return null;
    }
    
    public ArrayList<String> getListaStringProductos()
    {
        ArrayList<String> lista = new ArrayList<String>();
        for (Producto pr : listaProductos)
        {
            lista.add(pr.getCant()+ "u - " + pr.getNombre()+" - $"+
                    pr.getPrecioVenta());
        }
        
        return lista;
    }
    
    public ArrayList<String> getNombresProveedores()
    {
        ArrayList<String> lista;
        lista = new ArrayList<String>();
        for (Proveedor pr: listaProveedores)
        {
            lista.add(pr.getNombre());
        }
        return lista;
    }
    
    public ArrayList<String> getNombresProductos()
    {
        ArrayList<String> lista;
        lista = new ArrayList<String>();
        for (Producto pr: listaProductos)
        {
            lista.add(pr.getNombre());
        }
        return lista;
    }
    
    public ArrayList<String> getListaStringClientes()
    {
        ArrayList<String> lista = new ArrayList<String>();
        for (Cliente cl : listaClientes)
        {
            lista.add(cl.getId()+ " " + cl.getNombre());
        }
        
        return lista;
    }
    
    
    
    public void sumarUnidadesProducto(String _nombre, int _cant)
    {
        getProductoNombre(_nombre).sumarCant(_cant);
    }
    
    public void restarUnidadesProducto(String _nombre, int _cant)
    {
        getProductoNombre(_nombre).restarCant(_cant);
    }
    
    public String getNuevoItemProductos(String _item, int _cant)
    {
        return _cant+_item.substring(_item.indexOf("u"));
    }
    
    public ArrayList<String> getListaStringProveedores()
    {
        ArrayList<String> lista = new ArrayList<String>();
        for (Proveedor pr : listaProveedores)
        {
            lista.add(pr.getNit()+ " " + pr.getNombre());
        }
        
        return lista;
    }
    
    public ArrayList<String> getListaStringProductosProveedores(String _nit)
    {
        Proveedor auxPr;
        auxPr = identificarProveedorNit(_nit);
        ArrayList<String> auxLista;
        auxLista = new ArrayList<String>();
        for (ArrayList<String> lista: auxPr.getListaProdProv())
        {
            auxLista.add(lista.get(0) + " " +lista.get(1));
        }
        return auxLista;
    }
    
    public Proveedor identificarProveedorNit(String _nit)
    {
        for (Proveedor pr:listaProveedores)
        {
            if (pr.getNit().equals(_nit))
            {
                return pr;
            }
        } 
        return null;
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
            return null;
        
    }
    
    public Producto getProductoNombre(String _nombre)
    {
        Boolean encontrado = false;
        for (Producto pr: listaProductos)
        {
            if (pr.getNombre().equals(_nombre))
            {
                encontrado = true;
                return pr;
            }
        }
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
    
    public int identificarItemCompra(ArrayList<String> _lista, String _nombre)
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
    
    public int identificarItemProducto(ArrayList<String> _lista, String _nombre)
    {
        int index = -1;//El -1 indica que no lo encontró.
        String nombreProducto;
        for (int i = 0; i < _lista.size(); i++)
        {
            nombreProducto = _lista.get(i).substring(_lista.get(i).indexOf("-")+2, _lista.get(i).indexOf("$")-3);
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
    
    public void adicionarCompraCliente(int _id)
    {
         identificarClienteId(_id).addNoCompra();
    }
    
    public Cliente identificarClienteId(int _id)
    {
        for (Cliente cl:listaClientes)
        {
            if (cl.getId() == _id)
            {
                return cl;
            }
        } 
        return null;
    }
    
    public Boolean adicionarNuevoCliente(int _id, String _nombre, int _edad, int _tel, String _correoE
    , String _genero, int _noCompras)
    {
        if (identificarClienteId(_id) == null)
        {
            listaClientes.add(new Cliente(_id, _nombre, _edad, _tel, _correoE
    , _genero,  _noCompras));
         return true;
        }
        return false;
    }
    
    public void agregarNuevoProducto(String _nombre, int _codigo, 
            float _precioCompra, float _precioVenta, int _cant, int _noVendidos)
    {
        listaProductos.add(new Producto(_nombre, _codigo, _precioCompra, _precioVenta, _cant, _noVendidos));
    }
    
    public void agregarNuevoProveedor(String _nit, String _nombre, int _tel, String correoE,int _noCompras)
    {
        listaProveedores.add(new Proveedor(_nit, _nombre, _tel,correoE, _noCompras, new ArrayList<ArrayList<String>>()));
    }
    
    public void agregarProductoAProveedor(String _nit, int _codigo, 
            String _nombre, float _precioCompra, float _precioVenta)
    {
        identificarProveedorNit(_nit).agregarProducto(_codigo, _nombre, _precioCompra, _precioVenta);
    }
    
    public Proveedor getProveedorNombre(String _nombre)
    {
        for (Proveedor pr:listaProveedores)
        {
            if (pr.getNombre().equals(_nombre))
            {
                return pr;
            }
        } 
        return null;
    }
}   
