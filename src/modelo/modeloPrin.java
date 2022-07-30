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
public class modeloPrin 
{
    ArrayList<Producto> listaProductos = new ArrayList<Producto>();
    ArrayList<Proveedor> listaProveedores = new ArrayList<Proveedor>();
    ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();
    
    public modeloPrin() throws IOException
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
        //guardarEstadoProveedores();
    }
    
    
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
        //ArrayList<String> auxListaProd2;
        
        
        String auxString; //String auxiliar para recorrer la lista de productos que
        //proveedor vende
        String auxString2;
        
        StringTokenizer auxSt;//StringTokenizer auxiliar para recorrer la lista de productos que
        //proveedor vende
        StringTokenizer auxSt2;
        while( (line = br.readLine()) != null)
        {
            auxListaProd = new ArrayList<ArrayList<String>>();
            //auxListaProd2 = new ArrayList<String>();
            
            auxString = "";
            auxString2 = "";
            
            st = new StringTokenizer(line, ",");
            nit = st.nextToken();
            nombre = st.nextToken();
            tel = parseInt(st.nextToken());
            
            auxString = st.nextToken();
            auxString.substring(1, auxString.length()
                    - 1);//Se retira los corchetes
            auxSt = new StringTokenizer(auxString, ":");
            while (auxSt.hasMoreTokens())
            {
                auxString2 = auxSt.nextToken();
                auxString2.substring(1, auxString2.length()
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
                    auxString = auxString+"("+lista.get(0)+","+lista.get(1)+","+lista.get(2)+","+lista.get(3)+","+lista.get(4)+")"+":";
                }
                pw.print(pr.getNit()+","+pr.getNombre()+","+pr.getTel()+
                        ","+"["+auxString+"]"+"\n");
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
    
}
