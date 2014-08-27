
import java.awt.Component;
import java.io.File;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jhonson
 */
//devuleve la ruta de la cancion para reproducirla
public class Info_cancion_seleccionada {
    
    String [] lista_metadatos;
    String Nombre_can;
    String Ruta;
    private Component frame;
    
    public Info_cancion_seleccionada(){
    }
    
    public String RutaCancion(int indice_lista, String [] lista_p){
        
    
        if(indice_lista >=0){
            Nombre_can = lista_p[indice_lista];
            leer_archivo Consulta_cancion = new leer_archivo(9);
            File miDir = new File (".");
        try {
            Ruta = miDir.getCanonicalPath() + "/"+Nombre_can+".txt";
            }
        catch(Exception e) {
               e.printStackTrace();
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
