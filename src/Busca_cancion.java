/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janeth
 */
import java.io.*;
import java.util.Arrays;
public class Busca_cancion {
    //Declaracion de variables
    private String nomArchi;
    private String Nombre;
    String Nombre_can;
    private int size=0;
    private String lista1[];
    String album[];
    String Listageneral[];
    String Artista[];
    String [] lista2;
    String [] Obtenerdato;
    String direccion;
    String Nombr[];
    
    
public void Busca_cancion()
{
    
}
public String[] listacanciones( String nomArchi )
{
    File miDir = new File (".");
     try {
       direccion = miDir.getCanonicalPath() + "/"+nomArchi+".txt";
       }
     catch(Exception e) {
       e.printStackTrace();
       }
     leer_archivo extraer = new leer_archivo(11);
     this.lista1=extraer.leer_archivo1(direccion);
     return this.lista1;
}
public void asignarNombre(String Nombre)
{
 this.Nombre=Nombre;  
}
public String obtenerNombre()
{
    return Nombre;
}

public String[] obtenerAlbum(String list[])
        
{  
   
    Listas album1 = new Listas(11);
    Listageneral=new String[11];
    File miDir = new File(".");
    this.album=list;
    int tamaño = this.album.length;
        for (int i = 0; i < tamaño; i++) {
            this.Nombre_can = this.album[i];
            try {
                direccion = miDir.getCanonicalPath() + "/" + this.Nombre_can + ".txt";
            } catch (Exception e) {
                e.printStackTrace();
            }
            leer_archivo Consulta_cancion = new leer_archivo(11);
            this.Obtenerdato = Consulta_cancion.leer_archivo1(direccion);
            album1.agregarele(Obtenerdato[4]);
            this.Listageneral = album1.imprimir(lista1.length);
}
        return this.Listageneral;
}

public String[] obtenerArtista(String list[])
{  
   
    
    Listas album1 = new Listas(11);
    Listageneral=new String[11];
    File miDir = new File(".");
    this.album=list;
    int tamaño = this.album.length;
        for (int i = 0; i < tamaño; i++) {
            this.Nombre_can = this.album[i];
            try {
                direccion = miDir.getCanonicalPath() + "/" + this.Nombre_can + ".txt";
            } catch (Exception e) {
                e.printStackTrace();
            }
            leer_archivo Consulta_cancion = new leer_archivo(11);
            this.Obtenerdato = Consulta_cancion.leer_archivo1(direccion);
            album1.agregarele(Obtenerdato[2]);
            this.Listageneral = album1.imprimir(lista1.length);
}
        return this.Listageneral;
}
public String[] obtenerNombre(String list[])
{  
    Listas album1 = new Listas(11);
    Listageneral=new String[11];
    File miDir = new File(".");
    this.album=list;
    int tamaño = this.album.length;
        for (int i = 0; i < tamaño; i++) {
            this.Nombre_can = this.album[i];
            try {
                direccion = miDir.getCanonicalPath() + "/" + this.Nombre_can + ".txt";
            } catch (Exception e) {
                e.printStackTrace();
            }
            leer_archivo Consulta_cancion = new leer_archivo(11);
            this.Obtenerdato = Consulta_cancion.leer_archivo1(direccion);
            album1.agregarele(Obtenerdato[1]);
            this.Listageneral = album1.imprimir(lista1.length);
}
        return this.Listageneral;
}
    
    
}
