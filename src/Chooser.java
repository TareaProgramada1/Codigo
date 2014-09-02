import javax.swing.JFileChooser;
/**
 * Sirve para poder elegir un archivo, en este caso serian los archivos con formato mp3
*/
public class Chooser {
    public static void main(String s[]) {
    //Creamos selector de apertura
    JFileChooser chooser = new JFileChooser();
    chooser.setCurrentDirectory(new java.io.File("."));
    //Titulo que llevara la ventana
    chooser.setDialogTitle("Titulo");
    //Elegiremos archivos del directorio
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    chooser.setAcceptAllFileFilterUsed(false);
    //Si seleccionamos algún archivo retornaremos su directorio
    }
}
