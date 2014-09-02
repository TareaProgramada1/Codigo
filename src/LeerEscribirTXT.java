/**
 * Sirve para poder leer datos de un txt o crear un nuevo txt y escribirle datos
*/
import java.io.*;
import org.blinkenlights.jid3.ID3Exception;
public class LeerEscribirTXT{
    boolean Bandera;
    String Ruta;
    PrintWriter Escribir_por_linea = null;
    
    /**
     * Crea un archivo .txt en donde se almacenan los datos nesesarios
     * @param nombre Nombre de la cancion seleccionada
     * @param direccion Ruta en donde se almacena la cancion
     * @throws org.blinkenlights.jid3.ID3Exception Error cuando no se puede extraer un dato
     * @throws java.io.IOException
     */
    public void crear(String nombre,String direccion)throws ID3Exception,IOException{
        File texto = new File(nombre+".txt");
        texto.createNewFile();
        FileWriter manejarTextoEscritura = new FileWriter(texto);
        //cambie el metodo de escribir para que todos los datos queden por linea de texto
        //se agrega la direccion de la imagen
        MetaDatos p=new MetaDatos(direccion);
        Extraer_imgen_allbum Album_can = new Extraer_imgen_allbum();
        Escribir_por_linea = new PrintWriter(manejarTextoEscritura);
        //Se guarda dato por dato
        Escribir_por_linea.println(direccion);
        Escribir_por_linea.println(nombre);
        Escribir_por_linea.println(p.getArtista());
        Escribir_por_linea.println(p.getAnno());
        Escribir_por_linea.println(p.getTitulo());
        Escribir_por_linea.println(p.getAlbum());
        Escribir_por_linea.println(p.getGenero());
        Escribir_por_linea.println(p.Duracion());
        Escribir_por_linea.println(Album_can.ObtenerImagen(direccion,nombre));
        manejarTextoEscritura.close();
        File miDir = new File (".");
        Ruta = miDir.getCanonicalPath() + "/Lista_canciones.txt";      
        File Archivo = new File(Ruta);
        Bandera = Archivo.exists();
        FileWriter Escribir = new FileWriter(Archivo, Bandera);
        Escribir.write("\n");
        Escribir.write(nombre);
        Escribir.close();
    }
}