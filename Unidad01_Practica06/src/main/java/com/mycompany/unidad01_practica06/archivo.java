/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unidad01_practica06;

/**
 *
 * @author Marcos
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class archivo {
    
    
    private File archivo;
    public String[] datos;
    
    
    public archivo(String url){
        this.archivo = new File(url);
        this.crearArchivo();
    }
    
    private void crearArchivo(){
        try{
            this.archivo.createNewFile();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void escribirSave(String datos){
        try{
            FileWriter esc = new FileWriter(this.archivo,true);
            esc.write(datos);
            esc.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void escribir(String datos){
        try{
            FileWriter esc = new FileWriter(this.archivo);
            esc.write(datos);
            esc.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void leerArchivo(){
        String linea = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(archivo));
            while(linea != null){
                linea = bf.readLine();
                if(linea != null){
                    datos = linea.split(",");
                }
            }      
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void mostrarDatos(){
        if(!this.isVacio()){
            this.leerArchivo();
            for(String e: datos) System.out.print(e + " ");
            System.out.println("");
        }
            else System.out.println("El archivo TXT esta vacio");
    }
    
    public void menuArchivo(){
        String[] menu = {
            "1.-Escribir en el archivo",
            "2.-Leer el archivo guardardando Informacion",
            "3.-Leer el archivo eliminado Informacion",
            "4.-Mostrar datos"
        };
        String op;
        Libreria.mostrarMenus(menu);
        do{
            Libreria.mostrarMenus(menu);
            op = Libreria.validarString("Ingrese una opcion");
            
            switch(op){
                case "1" -> this.leerArchivo();
                case "2" -> {
                    String dato = Libreria.validarString("Ingrese los datos a agregar");
                    this.escribir(dato);
                }
                case "3" -> {
                    String dato = Libreria.validarString("Ingrese los datos a agregar");
                    this.escribir(dato);
                }
                case "4" -> this.mostrarDatos();
            }
        }while(!op.equals("3"));
        
    }
    
    public String[] datos(){
        this.leerArchivo();
        return this.datos;
    }
    
    public boolean isVacio(){
        if(archivo.length() != 0) return false;
        else return true;
    }
    

}
