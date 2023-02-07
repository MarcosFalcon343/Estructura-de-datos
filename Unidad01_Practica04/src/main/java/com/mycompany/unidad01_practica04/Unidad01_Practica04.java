/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unidad01_practica04;

/**
 *
 * @author marco
 */
public class Unidad01_Practica04 {

    public static String[] menu = {
        "Menu principal",
        "1.-Ingresar una nueva persona",
        "2.-Mostrar Personas",
        "3.-Finalizar"
    };
        
    public static String[] menuOrd = {
        "Metodos de ordenamiento",
        "1.-Ascendente",
        "2.-Descendente"
    };
    
    public static void main(String[] args) {
        boolean validar = true;
        String opOrd;
        do{
            Libreria.mostrarMenus(menuOrd, menuOrd.length);
            opOrd = Libreria.validarString("Eliga una opcion...:");
            if(opOrd.equals("1") || opOrd.equals("2")) validar = false;
            else System.out.println("Ingrese una opcion valida");
        }while(validar);
        
        Persona[] personas = new Persona[100];
        int N = -1;
        String op;
        do{
            Libreria.mostrarMenus(menu, menu.length);
            op = Libreria.validarString("Eliga una opcion...:");
            
            switch(op){
                case "1" -> {
                    if(N <= 99){
                        N++;
                        String nombre = Libreria.validarString("Ingrese el nombre de la persona");
                        int edad = Libreria.validarInt("Ingrese la edad de la persona");
                        personas[N] = new Persona(nombre, edad);
                        OrdBurbuja(personas,N,opOrd);
                    }
                }
                case "2" -> {
                    if((N+1) > 0)for(int i = 0; i < (N+1); i++) System.out.println(personas[i].ToString());
                    else System.out.println("No hay personas ingresadas");
                }
                case "3" -> System.out.println("Finalizando");
            }
        }while(!op.equals("3"));
    }
    
    public static void OrdBurbuja(Persona[] A,int N,String op){
        N++;
        for(int i = 0; i < N - 1; i++)		
            for(int k = i + 1; k < N; k++) 
                switch(op){
                    case "1" -> {if(A[i].edad > A[k].edad) cambio(A,i,k);}
                    case "2" -> {if(A[i].edad < A[k].edad) cambio(A,i,k);}
                }
    }
    
    public static void cambio(Persona[] A, int i, int k){
        Persona aux = A[i];
        A[i] = A[k];
        A[k] = aux;
    }
}
