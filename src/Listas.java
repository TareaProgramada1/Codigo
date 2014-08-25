/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author janeth
 */
import java.io.*;
import java.util.Arrays;
public class Listas {
    private int size;
    private int Maxsize;
    private String[]lista;
    private String[]lista1;
    private String direccion;
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
public int getsize()
{
    return this.size;
}

public String[] imprimir(int capacidad)
{ 
   this.lista1 = new String [capacidad];
   int ind=0;
   while(ind<this.size)
   {
       this.lista1[ind]=this.lista[ind];            
       ++ind;    
   }
   
   return lista1;
}
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
public void vacio()
{
this.size=0;

}  
    
}
