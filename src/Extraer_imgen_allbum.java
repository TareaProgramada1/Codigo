//Libreria para extraer la imagen de la cancion
import java.io.IOException;
import java.io.File;
import java.io.ByteArrayInputStream;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import com.mpatric.mp3agic.ID3v2;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhonson
 * Clase para extraer la imagen de la cancion
 */

public class Extraer_imgen_allbum {
    //Obtiene la imagen de la cancion en bytes y se guarda por aparte
    /**
     * Obtiene la imagen de la cancion cuando se agrega 
     * @param Ruta Resive la direccion de la cancion
     * @param Nombre Resive el nombre de la cancion que sera el  nombre de la imagen
     * @return Devuelve la ruta en donde la imagen se guardo
     */
    public String ObtenerImagen(String Ruta, String Nombre){   
        try {
            Mp3File mp3file = null;
            mp3file = new Mp3File(Ruta);
            if (mp3file != null && mp3file.hasId3v2Tag()) {
                ID3v2 id3v2Tag = mp3file.getId3v2Tag();
                byte[] imageData = id3v2Tag.getAlbumImage();
                BufferedImage img = ImageIO.read(new ByteArrayInputStream(imageData));
                File miDir = new File (".");
                try {
                    Ruta = miDir.getCanonicalPath();
                         }
                catch(IOException e) {
                    }
                //Guarsda la imagen extraida
                Ruta = Ruta+"/"+Nombre+".GIF";
                ImageIO.write(img, "gif", new File(Ruta));
            }
        }
         catch(NullPointerException e){
                       
                }
        catch (IOException | UnsupportedTagException | InvalidDataException ex) {
            Logger.getLogger(Extraer_imgen_allbum.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Devuelve la ruta de la imagen para relacionarla con la cancion
        return Ruta;
            }   
    }

