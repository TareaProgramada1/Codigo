

/**
 *La clase Busca_cancion permite obtener los nombres de: las canciones,album,genero,artista. 
 * @author Jose Luis
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
    String cadena;
    String obtener[];
    int lineas = 0;
    String l[];
    
public void Busca_cancion()
{
    
}
/**
 * 
 * @param archi este método recibe un archivo.
 * @return Devuelve las lineas de texto que contiene.
 */
public int lineas(String archi)
{
    try{
        FileReader abrir = new FileReader(archi+".txt"); 
        BufferedReader leer = new BufferedReader(abrir);
        while ((cadena = leer.readLine())!=null)
        {
            lineas++;
        }
    }
     catch (FileNotFoundException e)
     {
          e.printStackTrace();
     }
    catch (IOException ioe)
    {
        ioe.printStackTrace();
    }
    return lineas;
}
/**
 * 
 * @param nomArchi recibe un archivo.
 * @return retorna una lista con las canciones.
 */
public String[] listacanciones( String nomArchi )
{
    Busca_cancion num=new Busca_cancion();
    int cant=num.lineas("Lista_canciones");
    File miDir = new File (".");
     try {
       direccion = miDir.getCanonicalPath() + "/"+nomArchi+".txt";
       }
     catch(Exception e) {
       e.printStackTrace();
       }
     leer_archivo extraer = new leer_archivo(cant);
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
/**
 * 
 * @param list recibe una lista.
 * @return retorna el nombre de los albunes segun su posición.
 */
public String[] obtenerAlbum(String list[])
        
{  
   
    Listas album1 = new Listas(20);
    Listageneral=new String[20];
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
            leer_archivo Consulta_cancion = new leer_archivo(20);
            this.Obtenerdato = Consulta_cancion.leer_archivo1(direccion);
            if(this.Obtenerdato[4]==null)
             {
            this.Obtenerdato[4]="null";
             }
            album1.agregarele(this.Obtenerdato[4]);  
            this.Listageneral = album1.imprimir(lista1.length);
            }

        return this.Listageneral;
}
/**
 * 
 * @param list recibe una lista.
 * @return retorna el nombre de los artistas segun su posición.
 * 
 */

public String[] obtenerArtista(String list[])
{  
   
    
    Listas album1 = new Listas(20);
    Listageneral=new String[20];
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
            leer_archivo Consulta_cancion = new leer_archivo(20);
            this.Obtenerdato = Consulta_cancion.leer_archivo1(direccion);
            if(this.Obtenerdato[2]==null)
             {
            this.Obtenerdato[2]="null";
             }
            album1.agregarele(this.Obtenerdato[2]);  
            this.Listageneral = album1.imprimir(lista1.length);
            
}
        return this.Listageneral;
}
/**
 * 
 * @param list recibe una lista.
 * @return retorna el nombre de las canciones segun su posición.
 * 
 */
public String[] obtenerNombre(String list[])
{  
    Listas album1 = new Listas(20);
    Listageneral=new String[20];
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
            leer_archivo Consulta_cancion = new leer_archivo(20);
            this.Obtenerdato = Consulta_cancion.leer_archivo1(direccion);
            if(this.Obtenerdato[1]==null)
             {
            this.Obtenerdato[1]="null";
             }
            album1.agregarele(this.Obtenerdato[1]);  
            this.Listageneral = album1.imprimir(lista1.length);
            }

        return this.Listageneral;
}
/**
 * 
 * @param list recibe una lista.
 * @return retorna el nombre de los generos segun su posición.
 *  
 */
public String[] obtenerGenero(String list[])
{  
    Listas album1 = new Listas(20);
    Listageneral=new String[20];
    obtener=new String[8];
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
            leer_archivo Consulta_cancion = new leer_archivo(20);
            this.Obtenerdato = Consulta_cancion.leer_archivo1(direccion);
            if(this.Obtenerdato[6]==null)
             {
            this.Obtenerdato[6]="null";
             }
            album1.agregarele(this.Obtenerdato[6]);  
            this.Listageneral = album1.imprimir(lista1.length);
            }
            return this.Listageneral;
            
     }
/**
 * 
 * @param list recibe una lista.
 * @return retorna una lista en caso que los indices sean null, ingresa el string "null".
 * 
 */
public String[] listacanc( String list[] )
{ 
   this.album=list;
   for(int i=1;i<8;i++)
   {
       if(album[i]==null)
         {
             album[i]="null";
         }
             
              
     }
     return this.album; 
}
    
    
}
