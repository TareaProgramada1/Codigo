import java.io.*;
public class LeerEscribirTXT{
    public void crear(String nombre,String direccion)throws IOException{
        File texto = new File(nombre+".txt");
        texto.createNewFile();
        FileWriter manejarTextoEscritura = new FileWriter(texto); 
        manejarTextoEscritura.write(direccion); 
        manejarTextoEscritura.flush();
        manejarTextoEscritura.close();
//        FileReader manejarTextoLectura = new FileReader(texto); 
//        char [] contenido = new char[50];
//        manejarTextoLectura.read(contenido);
//        for(char letra : contenido)
//            System.out.print(letra);
//        manejarTextoLectura.close(); 
    }
}