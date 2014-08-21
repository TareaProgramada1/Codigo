import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Control 
{
    FileInputStream archivo;
    BufferedInputStream Buffer_cancion;
    
    public Player player;
    
    public long pauseLocation;
    public long songtotalLength;
    
    public String fileLocation;
    
    public void Stop(){
        if(player != null){
            player.close();
            pauseLocation = 0;
            songtotalLength = 0;
        }
    }
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
            public void run(){
                
                try {
                    player.play();
                } catch (JavaLayerException ex) {
                    JOptionPane.showMessageDialog(null,"Error"+ex);
                }
            }
        }.start();
    }
    
     public void Play(String path){
        
        try{
            archivo = new FileInputStream(path);
            Buffer_cancion = new BufferedInputStream(archivo);
            
            player = new Player(Buffer_cancion);
            
            songtotalLength = archivo.available();
            
            fileLocation = path +"";
        }
        catch (FileNotFoundException | JavaLayerException ex){
            
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
