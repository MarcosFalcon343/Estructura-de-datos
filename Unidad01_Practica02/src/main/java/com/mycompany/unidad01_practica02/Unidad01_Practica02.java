/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unidad01_practica02;

import java.util.Scanner;

public class Unidad01_Practica02 {

    
    public static String[] menu = {
        "1.-Elegir tamaño de autos",
        "2.-Ingresar informacion de los autos",
        "3.-Ordenar Ascedente",
        "4.-Ordenar descedente",
        "5.-Mostrar Autos",
        "6.-Finalizar",
        "Ingrese una opcion...:"
    };
    
    public static String[] menuord = {
        "1.-Por placa",
        "2.-Por modelo",
        "3.-Por Color",
        "Ingrese una opcion...:"
         
    };
    
    public static void main(String[] args) {
        Auto[] autos = null;
        int op = 0, N = 0;
        do{
            mostrarMenus(menu,menu.length);
            op = num();
            
            switch(op){
                
                case 1:
                    System.out.println("Ingrese la cantidad de autos a ingresar");
                    do{
                        N = num();
                        if(N < 0) System.out.println("El arreglo no puede tener posicones negativas. Ingrese otro valor");
                    }while(N < 0);
                    autos = new Auto[N];
                    break;
                    
                case 2:
                    if(autos != null)
                        for(int i = 0; i < N; i++){
                            autos[i] = new Auto(i+1);
                            System.out.println("Auto #" + (i+1));
                            autos[i].placa = validarString("Ingrese la placa del auto");
                            autos[i].color = validarString("Ingrese el color del auto");
                            autos[i].modelo = validarString("Ingrese el modelo del auto");
                        }
                    else System.out.println("No hay autos ingresados. Ingrese Unos");
                    break;
                case 3:
                    if(autos != null)
                        do{
                            System.out.println("Ordenamiento Ascendente");
                            mostrarMenus(menuord,menuord.length);
                            op = num();
                            OrdAutosAsc(autos,N,op);
                        }while(op > 3 && op < 0);
                    else System.out.println("No hay autos ingresados. Ingrese Unos");
                    break;
                case 4:
                    if(autos != null)
                        do{
                            System.out.println("Ordenamiento Descendente");
                            mostrarMenus(menuord,menuord.length);
                            op = num();
                            OrdAutosDes(autos,N,op);
                        }while(op > 3 && op < 0);
                    else System.out.println("No hay autos ingresados. Ingrese Unos");
                    break;
                case 5:
                    if(autos != null)
                        for(int i = 0; i < N; i++) System.out.println(autos[i].toString());
                    else System.out.println("No hay autos ingresados. Ingrese Unos");
                    break;
            }
        }while(op != 6 && op > 0);
    }
    
    public static void mostrarMenus(Object A[],int N){
        for(int i = 0; i < N; i++){
            System.out.println(A[i]);
        }
    }
    
    
    public static void OrdAutosAsc(Auto A[],int N, int op){
        for(int i = 1; i <= N; i++) {		
            for(int k = 0; k < N-1; k++) {
                switch(op){
                    case 1:
                        if(A[k].placa.compareTo(A[k+1].placa) > 0) cambio(A,i,k);
                        break;
                    case 2:
                        if(A[k].modelo.compareTo(A[k+1].modelo) > 0) cambio(A,i,k);
                        break;
                    case 3:
                        if(A[k].color.compareTo(A[k+1].color) > 0) cambio(A,i,k);
                        break;
                }
            }
	}
    }
    
    public static void OrdAutosDes(Auto A[],int N, int op){
        for(int i = 1; i <= N; i++) {		
            for(int k = 0; k < N-1; k++) {
                switch(op){
                    case 1:
                        if(A[k].placa.compareTo(A[k+1].placa) < 0) cambio(A,i,k);
                        break;
                    case 2:
                        if(A[k].modelo.compareTo(A[k+1].modelo) < 0) cambio(A,i,k);
                        break;
                    case 3:
                        if(A[k].color.compareTo(A[k+1].color) < 0) cambio(A,i,k);
                        break;
                }
            }
	}
    }
    

    public static void cambio(Auto[] A, int i, int k){
        Auto aux = A[k];
        A[k] = A[k + 1];
        A[k + 1] = aux;
    }
    
    public static String validarString(String msg){
        Scanner sc = new Scanner(System.in);
        String valor;
        System.out.println(msg); 
        do{
            valor = sc.nextLine();
            if(valor == null) System.out.println("El valor de puede ser nulo. " + msg);
        }while(valor == null);
        return valor;
    }
    
    public static boolean IsInt(String text) {
        int n;
        try {
          n=Integer.parseInt(text);
          return true;
        } catch (NumberFormatException ex) {
           return false;
        }
    }
    
    public static int num(){
        Scanner sc = new Scanner(System.in);
        String n;
        do{
           n = sc.nextLine();
           if(!IsInt(n)) System.out.println(n + " No es una opcion validad, ingrese una correcta");
        }while(!IsInt(n));
        return Integer.parseInt(n); 
    }
}
