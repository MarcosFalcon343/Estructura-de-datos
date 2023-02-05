/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unidad01_parctica02;

import java.util.Scanner;

public class Unidad01_Parctica02 {

    
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
        "2.-Por color",
        "3.-Por modelo"
    };
    
    public static void main(String[] args) {
        Auto[] autos = new Auto[50];
        Scanner sc = new Scanner(System.in);
        int op = 0, N = 0;
        do{
            mostrar(menu,menu.length);
            op = sc.nextInt();
            
            switch(op){
                
                case 1:
                    System.out.println("Ingrese la cantidad de autos a ingresar");
                    do{
                        N = sc.nextInt();
                        if(N < 0) System.out.println("El arreglo no puede tener posicones negativas. Ingrese otro valor");
                    }while(N < 0);
                    break;
                case 2:
                    for(int i = 0; i < N; i++){
                        System.out.println("Auto #" + 1);
                        autos[i].placa = validarString("Ingrese la placa del auto");
                        autos[i].color = validarString("Ingrese el color del auto");
                        autos[i].modelo = validarString("Ingrese el modelo del auto");
                        
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
            }
        }while(op != 6 && op > 0);
    }
    
    public static void mostrar(Object A[],int N){
        for(int i = 0; i < N; i++){
            System.out.println(A[i]);
        }
    }
    
    public static String validarString(String msg){
        Scanner sc = new Scanner(System.in);
        String valor;
        System.out.println(msg); 
        do{
            valor = sc.next();
            if(valor == null) System.out.println("El valor de puede ser nulo. " + msg);
        }while(valor == null);
        return valor;
    }
}
