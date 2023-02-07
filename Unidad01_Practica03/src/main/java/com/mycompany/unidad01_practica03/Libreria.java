
package com.mycompany.unidad01_practica03;

import java.util.Scanner;

/**
 *
 * @author Marcos
 */
public class Libreria {
    
    public static String validarString(String msg){
        Scanner sc = new Scanner(System.in);
        String valor;
        System.out.println(msg); 
        do{
            valor = sc.nextLine();
            if(valor == null || valor.length() <= 0) System.out.println("El valor No puede ser nulo. " + msg);
        }while(valor == null || valor.length() <= 0);
        return valor;
    }
    
    
    private static boolean IsInt(String text) {
        int n;
        try {
          n=Integer.parseInt(text);
          return true;
        } catch (NumberFormatException ex) {
           return false;
        }
    }
    
    public static int validarEnteros(){
        Scanner sc = new Scanner(System.in);
        String n;
        do{
           n = sc.nextLine();
           if(!IsInt(n)) System.out.println(n + " No es un numero entero, ingrese un Numero correcto");
        }while(!IsInt(n));
        return Integer.parseInt(n); 
    }
    
    public static double validarReales(String msg){
        Scanner sc = new Scanner(System.in);
        double num;
        System.out.println(msg);
        do{
            num = sc.nextDouble();
            if(num <= 0) System.out.println("El valor ingresado no debe ser igual o menor que 0");
        }while(num <= 0);
        return  num;
    }
    
    public static void mostrarMenus(Object A[],int N){
        for(int i = 0; i < N; i++){
            System.out.println(A[i]);
        }
    }
        
}
