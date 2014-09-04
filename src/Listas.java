
/**
 *Clase listas.y métodos que actuan sobre listas.
 * @author Jose Luis
 */
import java.io.*;
import java.util.Arrays;
public class Listas {
    //Declaración de variables..
    private int size;
    private int Maxsize;
    private String[]lista;
    private String[]lista1;
    private String direccion;
    /**
     * Constructores sin y con parámetros.
     */
public Listas()
{
   
    this.size=0;
    this.lista=new String[50];   
}
public Listas(int Tamaño)
{
    this.size=0;
    this.Maxsize=Tamaño;
    this.lista=new String[Tamaño];
}
/**
 * 
 * @param e representa el elemento a agregar en el arreglo.
 */
public void agregarele(String e)
{
 if(this.size<this.Maxsize)
 {
     this.lista[this.size]=e;
     this.size++;
 } 
 else
 {
     throw new Error("Lista fuera de rango");  
}
 
}
/**
 * 
 * @return el tamaño de la lista,es decir, la cantidad de elemento que posee..
 */
public int getsize()
{
    return this.size;
}
/**
 * 
 * @param capacidad representa un número entero que se utiliza para definir el tamaño máximo de la lista.. 
 * @return devuelve una lista con los datos originales de otra lista..
 */
public String[] imprimir(int capacidad)
{ 
   this.lista1 = new String [capacidad];
   int ind=0;
   while(ind<this.lista1.length)
   {
       this.lista1[ind]=this.lista[ind];            
       ++ind;    
   }
   
   return lista1;
}
/**
 * 
 * @return devuelve una lista..
 */
public String[] imprimelista()
{ 
   return lista;
}
public int cantdatos(String lista[])
{
    this.lista=lista;
    int i=0;
    while(i<this.size)
    {
       i++;
    }
    return i;
}
 /**
  * 
  * @param nombre cualquier String que se desea buscar en una lista.
  * @return verdadero en caso de encontrarse, falso en cualquier otro caso..
  */
public boolean encontrarele(String nombre)
{
    int i=0;
    while(i<this.size)
    {
        if(nombre==this.lista[i])
        {
            return true;
            
        }
        else
        {
            ++i;
        }
    }
    return false;
}
/**
 * Pone el tamaño de una lista en cero.
 */
public void vacio()
{
this.size=0;

}  
    
}
