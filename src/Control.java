//Librerias para la reproduccion de la cancion
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *Clase que contiene todas las acciones para manipular la reproduccion de la cancion
 * @author jhonson
 * 
 */
public class Control {
    //Variables necesarias de buffer y dirreccion de la cancion
    FileInputStream archivo;
    BufferedInputStream Buffer_cancion;
    
    public Player player;
    
    public long pauseLocation;
    public long songtotalLength;
    
    public String fileLocation;
    //Metodo para detener la cancion que se esta reproduciendo
    public void Stop(){
        if(player != null){
            player.close();
            pauseLocation = 0;
            songtotalLength = 0;
        }
    }
    //Metodo que pausa la cancion
    /**
     * Pausa la cancion que se esta reproducciendo en memoria
     */
    public void Pause(){
        if(player != null){
            try {
                pauseLocation =archivo.available();
                player.close();
                } 
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null,"Error");
            }   
        }
    }
    /**
     * Renueva la cancion pausada
    */
    public void Resume(){
        try{
            archivo = new FileInputStream(fileLocation);
            Buffer_cancion = new BufferedInputStream(archivo);
            player = new Player(Buffer_cancion);
            archivo.skip(songtotalLength - pauseLocation);
        }
        catch (FileNotFoundException | JavaLayerException ex){
            
             JOptionPane.showMessageDialog(null," Error -"+ex);
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Error"+ex);
        }
        new Thread()
        {
            @Override
            //inicializa la reproduccion de la cancion
            public void run(){
                
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    JOptionPane.showMessageDialog(null,"Error"+ex);
                }
            }
        }.start();
    }
    //Metodo que recibe la ubicacion de la direccion para reproducirla
    /**
     * Metodo para reproduccir la cancion seleccionada
     * @param path ruta en donde se almacena la cancion
     * 
     */
     public void Play(String path){
        
        try{
            archivo = new FileInputStream(path);
            Buffer_cancion = new BufferedInputStream(archivo);
            
            player = new Player(Buffer_cancion);
            
            songtotalLength = archivo.available();
            
            fileLocation = path +"";
        }
        catch (FileNotFoundException | JavaLayerException ex ){
            
             JOptionPane.showMessageDialog(null," Error -"+ex);
        } catch (IOException ex) {
            Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread()
        {
            @Override
            public void run(){
                
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    JOptionPane.showMessageDialog(null,"Error"+ex);
                }
            }
        }.start();
    }
}
