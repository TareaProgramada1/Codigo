import java.io.*;
import org.blinkenlights.jid3.ID3Exception;
public class LeerEscribirTXT{
    String Ruta;
    PrintWriter Escribir_por_linea = null;
    PrintWriter Escribir_por_linea1;
    
    public void crear(String nombre,String direccion)throws ID3Exception,IOException{
        File texto = new File(nombre+".txt");
        texto.createNewFile();
        FileWriter manejarTextoEscritura = new FileWriter(texto);
        //cambie el metodo de escribir para que todos los datos queden por linea de texto
        MetaDatos p=new MetaDatos(direccion);
        Escribir_por_linea = new PrintWriter(manejarTextoEscritura);
        Escribir_por_linea.println(direccion);
        Escribir_por_linea.println(nombre);
        Escribir_por_linea.println(p.getArtista());
        Escribir_por_linea.println(p.getAnno());
        Escribir_por_linea.println(p.getTitulo());
        Escribir_por_linea.println(p.getAlbum());
        manejarTextoEscritura.close();
        File miDir = new File (".");
     try {
       Ruta = miDir.getCanonicalPath() + "/Lista_canciones.txt";
       }
     catch(Exception e) {
       e.printStackTrace();
       }
    File Archivo = new File(Ruta);
    FileWriter Escribir = new FileWriter(Archivo, true);
    Escribir.write("\n");
    Escribir.write(nombre);
    Escribir.close();
    }
}