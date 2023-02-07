/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.unidad01_practica07;

import java.util.Scanner;

public class Libreria {
 
    private static final Scanner sc = new Scanner(System.in);
    
    public static String validarString(String msg){
        String valor = "";
        System.out.println(msg);
        do{
            valor = sc.nextLine();
            if(valor.length() <= 0 || valor == null) System.out.println("No se permiten datos Nulos." + msg);
        }while(valor.length() <= 0 || valor == null);
        return valor;
    }
    
    private static boolean esNumero(String num){
        try{
            Double.parseDouble(num);
            return true;
        }catch(NumberFormatException e){
            return false;
        }
    }
    
    public static int validarInt(String msg){
        String valor;
        System.out.println(msg);
        do{
            valor = sc.nextLine();
            if(!esNumero(valor)) System.out.println("El valor introducido " + valor + " NO es un numero");
            if(valor.equals("0")) System.out.println("No se perimiten valores menores o iguales a 0");
        }while(!esNumero(valor) && valor.equals("0"));
        
        return Integer.parseInt(valor);
    }
    
    public static double validarDouble(String msg){
        String valor;
        System.out.println(msg);
        do{
            valor = sc.nextLine();
            if(!esNumero(valor)) System.out.println("El valor introducido " + valor + " NO es un numero");
            
        }while(!esNumero(valor));
        return  Double.parseDouble(valor);
    }
    
    public static void mostrarMenus(String[] A){
        for(String e: A) System.out.println(e);
    }
}
