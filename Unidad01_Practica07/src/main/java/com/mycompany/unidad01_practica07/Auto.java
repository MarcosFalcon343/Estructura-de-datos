/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unidad01_practica07;

/**
 *
 * @author Marcos
 */
public class Auto {
    
    public String id;
    public String color;
    public int NoAsientos;
    public String modelo;
    
    public Auto(String id,String color, int A, String modelo){
        this.id = id;
        this.color = color;
        this.NoAsientos = A;
        this.modelo = modelo;
    }
    
    @Override
    public String toString(){
        return "Auto #" + this.id + " Color: " + this.color + " No. Asientos: " + this.NoAsientos + " Modelo: " + this.modelo;
    }
}
