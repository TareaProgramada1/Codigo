
import java.io.*;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.blinkenlights.jid3.*;
import org.blinkenlights.jid3.ID3Exception;
import org.blinkenlights.jid3.v1.*;
import org.blinkenlights.jid3.v2.*;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.TagException;

public class MetaDatos {


    private String Artista,Album,Titulo, Genero, Duracion_completo;
    private int anno;
    int hor, min,seg,num;
    int duracion;
    private Object audioFile;
    
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
                    try{
                    anno=oID3V2_3_0Tag.getYear();
                    }
                    catch(org.blinkenlights.jid3.ID3Exception e){
                    }
                    Genero=oID3V2_3_0Tag.getGenre();
                    AudioFile Duracion_can;
                try {
                    Duracion_can = AudioFileIO.read(oSourceFile);
                    duracion = Duracion_can.getAudioHeader().getTrackLength();
                    num=duracion;
                    hor=num/3600;  
                    min=(num-(3600*hor))/60;  
                    seg=num-((hor*3600)+(min*60));  
                    Duracion_completo= hor+"h "+min+"m "+seg+"s";
                } catch (CannotReadException | IOException | TagException | ReadOnlyFileException | InvalidAudioFrameException ex) {
                    Logger.getLogger(MetaDatos.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                    
                    
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
    public String getGenero(){
        return Genero;
    }
    public String Duracion(){
        return Duracion_completo;
    }  
    
    
}
