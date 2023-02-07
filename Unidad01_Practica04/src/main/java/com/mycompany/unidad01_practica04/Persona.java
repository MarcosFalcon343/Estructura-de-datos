/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unidad01_practica04;

/**
 *
 * @author marco
 */
public class Persona {

    public String nombre;
    public int edad;
    
    public Persona(String nom, int edad){
        this.nombre = nom;
        this.edad = edad;
    }
    
    public String ToString(){
        return "Nombre: " + this.nombre + " Edad: " + this.edad;
    }
}
