/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unidad01_practica07;

/**
 *
 * @author Marcos
 */
public class Unidad01_Practica07 {

    static String[] menu = {
        "Menu Principal",
        "1.-Ingrese numero de Autos",
        "2.-Insertar informacion de los autos",
        "3.-Buscar auto",
        "4.-Mostrar autos",
        "5.-Finalizar"
    };
    
    static String[] menuBus = {
        "Tipo de busqueda",
        "1.-Busqueda por Modelo",
        "2.-Busqueda por No Asientos"
    };
    
    public static void main(String[] args) {
        String op,opB;
        Auto[] autos = new Auto[100];
        int N = -1;
        do{
            Libreria.mostrarMenus(menu);
            op = Libreria.validarString("Ingrese una opcion...:");
            
            switch(op){
                case "1" -> {
                    if(N  != 99) N = Libreria.validarInt("Ingrese el numero de autos");
                    else System.out.println("Numero limite de autos alcanzados");
                }
                case "2" -> {
                    if(N > 0)
                        for(int i = 0; i < N; i++){
                            String color = Libreria.validarString("Ingrese el color del auto #" + (i+1));
                            int No = Libreria.validarInt("Ingrese el numero de asientos del auto #" + (i+1));
                            String mod = Libreria.validarString("Ingrese el modelo del auto #" + (i+1));
                            autos[i] = new Auto(String.valueOf(i+1),color,No,mod);
                        }
                    else System.out.println("Ingrese primero el numero de autos");
                }
                case "3" ->{
                    if(N > 0){
                        boolean check = true;
                        do{
                            Libreria.mostrarMenus(menuBus);
                            opB = Libreria.validarString("Ingrese una opcion");
                            switch(opB){
                                case "1" ->{
                                    String valor = Libreria.validarString("Ingrese el modelo del auto a buscar");
                                    busSecuencialModelo(autos,N,valor);
                                }
                                case "2" -> {
                                    int valor = Libreria.validarInt("Ingrese el N° de asientos del auto a buscar");
                                    busSecuencialAsientos(autos,N,valor);
                                }
                            }
                            if(opB.equals("1") || opB.equals("2")) check = false;
                        }while(check);
                    }else System.out.println("No hay autos registrados para buscar");
                }
                case "4" -> {
                    if(N > 0)
                        for(int i = 0; i < N; i++) System.out.println(autos[i].toString());
                    else System.out.println("No hay autos registrados");
                }
                case "5" -> System.out.println("Finalizando");
            }
        }while(!op.equals("5"));
    }
    
    public static void busSecuencialModelo(Auto A[],int N,String valor){
        int j = 0;
        for(int i = 0; i < N; i++)
            if (A[i].modelo.trim().equals(valor.trim())) {
                System.out.println(A[i].toString());
                j++;
            }
        if(j == 0) System.out.println("No hay Autos con las especificaciones buscadas");
    }
    
    public static void busSecuencialAsientos(Auto A[],int N,int valor){
        int j = 0;
        for(int i = 0; i < N; i++)
            if (A[i].NoAsientos == valor) {
                System.out.println(A[i].toString());
                j++;
            }
        if(j == 0) System.out.println("No hay Autos con las especificaciones buscadas");
    }
}
