/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unidad01_practica08;

/**
 *
 * @author Marcos
 */
public class Salon {
    String id;
    int Piso;
    int NoSillas;
    
    public Salon(String id, int piso, int No){
        this.id = id;
        this.Piso = piso;
        this.NoSillas = No;
    }
    
    @Override
    public String toString(){
        return "Salon #" + this.id + " Piso #" + this.Piso + " N° de sillas: " + this.NoSillas;
    }
    
}
