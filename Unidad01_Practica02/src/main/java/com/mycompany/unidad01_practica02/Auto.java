/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unidad01_practica02;

public class Auto {
   
    public int num;
    public String placa;
    public String color;
    public String modelo;
    
    public Auto(int num){
        this.num = num;
    }
    
    @Override
    public String toString(){
        return "Auto #" + this.num + " Placa: " + this.placa + " Modelo: " + this.modelo + " Color: " + this.color;
                
    }
    
    
}