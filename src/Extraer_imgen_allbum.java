

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

public class Extraer_imgen_allbum {
    
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
                Ruta = Ruta+"/"+Nombre+".GIF";
                ImageIO.write(img, "gif", new File(Ruta));
            }
        }
         catch(NullPointerException e){
                       
                }
        catch (IOException | UnsupportedTagException | InvalidDataException ex) {
            Logger.getLogger(Extraer_imgen_allbum.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ruta;
            }   
    }

