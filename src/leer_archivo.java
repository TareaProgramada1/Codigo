
/**
 *Clase que lee los datos del txt de la cancion
 * @author jhonson
 */
import java.io.*;
public class leer_archivo {
public String [] Lista_meta;
public int Contador;
public String aux;
/**
 * @param capacidad indica el tamaño de la lista o la cantidad de elementos que contiene el txt
 */
public leer_archivo(int capacidad){
    Lista_meta = new String [capacidad];
    Contador = 0;
}
/**
 * @param nombre Nombre de la cancion para  para abrir el archivo txt
 * @return Devuelve la lista con todos los datos almacenados sobre la cancion
 */
public String[] leer_archivo1(String nombre){
try{
    File Archivo;
    FileReader lectorArchivo;
    Archivo = new File(nombre);
    lectorArchivo = new FileReader(Archivo);
    BufferedReader br = new BufferedReader(lectorArchivo);
    String l="";
    String aux="";
    while(true){
        aux=br.readLine();
        if(aux!=null){
        Lista_meta [Contador]= aux;
        Contador++; 
        }
        else
            break;
    }
    br.close();
    lectorArchivo.close();
    }
    catch(IOException e){}
    return Lista_meta;
    }
}