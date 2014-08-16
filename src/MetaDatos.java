
import java.io.File;
/**
 *obtinene artista, año, titulo, album, de las canciones y se guarda en el archivo de texto de
 * agregar junto con la ruta
 * @author jhonson
 */
import org.blinkenlights.jid3.ID3Exception;
import java.io.*;
import org.blinkenlights.jid3.*;
import org.blinkenlights.jid3.v1.*;
import org.blinkenlights.jid3.v2.*;

public class MetaDatos {


    private String Artista,Album,Titulo;
    private int anno;
    
    public MetaDatos(String mp3 ) throws ID3Exception
        
    {
        File oSourceFile = new File(mp3);
        MediaFile oMediaFile = new MP3File(oSourceFile);

        ID3Tag[] aoID3Tag = oMediaFile.getTags();        
        for (int i=0; i < aoID3Tag.length; i++){
            if (aoID3Tag[i] instanceof ID3V1_0Tag)
            {
                ID3V1_0Tag oID3V1_0Tag = (ID3V1_0Tag)aoID3Tag[i];
     
                if (oID3V1_0Tag.getTitle() != null)
                {
                    System.out.println("Title = " + oID3V1_0Tag.getTitle());
                }
            }
            else if (aoID3Tag[i] instanceof ID3V2_3_0Tag)
            {
                ID3V2_3_0Tag oID3V2_3_0Tag = (ID3V2_3_0Tag)aoID3Tag[i];
                if (oID3V2_3_0Tag.getTIT2TextInformationFrame() != null)
                {
                }
                    Artista=oID3V2_3_0Tag.getArtist();
                    Album=oID3V2_3_0Tag.getAlbum();
                    Titulo=oID3V2_3_0Tag.getTitle();
                    anno=oID3V2_3_0Tag.getYear();
                    
            }
        }
    }
    public String getArtista(){
    return this.Artista;
    }
    public String getTitulo(){
    return this.Titulo;
    }
    public String getAlbum(){
    return this.Album;
    }
    public int getAnno(){
    return this.anno;
    }
    public void setTitulo(String m){
    this.Titulo=m;
    }
    
}
