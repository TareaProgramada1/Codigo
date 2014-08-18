/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jhonson
 */
import java.io.*;
import java.util.Arrays;
public class leer_archivo {
public String [] Lista_meta;
public int Contador;
public String aux;
public leer_archivo(int capacidad){
    Lista_meta = new String [capacidad];
    Contador = 0;
}
//El parametro nombre indica el nombre del archivo por ejemplo
public String[] leer_archivo1(String nombre){
try{
File f;
FileReader lectorArchivo;
//Creamos el objeto del archivo que vamos a leer
f = new File(nombre);
//Creamos el objeto FileReader que abrira el flujo(Stream) de datos para realizar la lectura
lectorArchivo = new FileReader(f);
//Creamos un lector en buffer para recopilar datos a travez del flujo "lectorArchivo" que hemos creado
BufferedReader br = new BufferedReader(lectorArchivo);
String l="";
//Esta variable "l" la utilizamos para guardar mas adelante toda la lectura del archivo
String aux="";/*variable auxiliar*/
while(true)
//este ciclo while se usa para repetir el proceso de lectura, ya que se lee solo 1 linea de texto a la vez
{
aux=br.readLine();
//leemos una linea de texto y la guardamos en la variable auxiliar
if(aux!=null){
  System.out.println(aux);
  Lista_meta [Contador]= aux;
  Contador++; 
}
else
break;
}
br.close();
lectorArchivo.close();
}catch(IOException e){
System.out.println("Error:"+e.getMessage());
}
System.out.println(Arrays.toString(Lista_meta));
return Lista_meta;
} 
public String leerDireccion(String ruta){
try{
File archivo;
FileReader lectorArchivo;
//Creamos el objeto del archivo que vamos a leer
archivo = new File(ruta);
//Creamos el objeto FileReader que abrira el flujo(Stream) de datos para realizar la lectura
lectorArchivo = new FileReader(archivo);
//Creamos un lector en buffer para recopilar datos a travez del flujo "lectorArchivo" que hemos creado
BufferedReader br = new BufferedReader(lectorArchivo);
aux=br.readLine();
}
catch(IOException e){
System.out.println("Error:"+e.getMessage());
}
return aux;
}
}