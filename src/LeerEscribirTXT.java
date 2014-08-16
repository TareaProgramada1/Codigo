import java.io.*;
import org.blinkenlights.jid3.ID3Exception;
public class LeerEscribirTXT{
    PrintWriter Escribir_por_linea = null;
    public void crear(String nombre,String direccion)throws ID3Exception,IOException{
        File texto = new File(nombre+".txt");
        texto.createNewFile();
        FileWriter manejarTextoEscritura = new FileWriter(texto);
        //cambie el metodo de escribir para que todos los datos queden por linea de texto
        MetaDatos p=new MetaDatos(direccion);
        Escribir_por_linea = new PrintWriter(manejarTextoEscritura);
        Escribir_por_linea.println(direccion);
        Escribir_por_linea.println(p.getArtista());
        Escribir_por_linea.println(p.getAnno());
        Escribir_por_linea.println(p.getTitulo());
        Escribir_por_linea.println(p.getAlbum());
        manejarTextoEscritura.close(); 
    }
}