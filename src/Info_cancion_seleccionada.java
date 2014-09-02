
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *Clase que extrae la ruta del .txt para reproducir la cacion
 * @author jhonson
 */
//devuleve la ruta de la cancion para reproducirla
public class Info_cancion_seleccionada {
    
    String [] lista_metadatos;
    String Nombre_can;
    String Ruta;
    private Component frame;
    
    //Devuelve la dirreccion en donde se almacena la cancion para ser reproducida
    /**
     * Metodo para extraer la ruta
     * @param indice_lista recibe el indice que devuelve la lista de reproduccion
     * @param lista_p lista que contiene la lista de canciones
     * @return Devuelve un String con la direecion de la cancion
     */
    public String RutaCancion(int indice_lista, String [] lista_p){
        
    
        if(indice_lista >=0){
            Nombre_can = lista_p[indice_lista];
            leer_archivo Consulta_cancion = new leer_archivo(9);
            File miDir = new File (".");
        try {
            Ruta = miDir.getCanonicalPath() + "/"+Nombre_can+".txt";
            }
        catch(IOException e) {
            }
        lista_metadatos=Consulta_cancion.leer_archivo1(Ruta);
        return lista_metadatos[0];
            }
        else{
            JOptionPane.showMessageDialog(frame,"Por favor seleccione una cancion");
            
            }
        
    return " ";
    } 
}
