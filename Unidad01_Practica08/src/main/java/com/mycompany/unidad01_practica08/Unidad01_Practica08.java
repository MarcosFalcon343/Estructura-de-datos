/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unidad01_practica08;

/**
 *
 * @author Marcos
 */
public class Unidad01_Practica08 {

    static String[] menu = {
        "Menu Principal",
        "1.-Insertar informacion de los salones",
        "2.-Buscar salon",
        "3.-Mostrar salones",
        "4.-Finalizar"
    };
    
    static String[] menuBus = {
        "Tipo de busqueda",
        "1.-Busqueda por Piso",
        "2.-Busqueda por No Asientos"
    };
    
    public static void main(String[] args) {
        String op, opB;
        Salon[] s = new Salon[100];
        int N = -1;
        do{
            Libreria.mostrarMenus(menu);
            op = Libreria.validarString("Ingrese una opcion");
            
            switch(op){
                case "1" ->{
                    if((N-1) != 100){
                        N++;
                        int piso = Libreria.validarInt("Ingrese el numero de piso del salon #" + (N+1));
                        int n = Libreria.validarInt("Ingrese el N° de asientos del salon #" + (N+1));
                        s[N] = new Salon(String.valueOf(N+1),piso,n);
                        OrdShell(s,(N+1));
                    }else System.out.println("Numero maximo de salones alcanzado");
                }
                case "2" ->{
                    if(N > 0){
                        boolean ck = true;
                        do{
                            Libreria.mostrarMenus(menuBus);
                            opB = Libreria.validarString("Ingrese una opcion...:");
                            int valor,pos;
                            switch(opB){
                                case "1" ->{
                                    valor = Libreria.validarInt("Ingrese el piso del salon a buscar");
                                    pos = busBinariaPiso(s,N,valor);
                                    if(pos != -1) System.out.println("\n"+ s[pos] + "\n");
                                    else System.out.println("No existe salon con esa especificacion");
                                }
                                case "2" -> {
                                    valor = Libreria.validarInt("Ingrese el N° de sillas del salon a buscar");
                                    pos = busBinariaSillas(s,N,valor);
                                    if(pos != -1) System.out.println("\n"+ s[pos] + "\n");
                                    else System.out.println("No existe salon con esa especificacion");
                                }
                            }
                            if(opB.equals("1") || opB.equals("2")) ck = false;
                        }while(ck);
                    }else System.out.println("No hay salones registrados");
                }
                case "3" -> {
                    if(N >= 0)
                        for(int i = 0; i < (N+1); i++) System.out.println(s[i].toString());
                    else System.out.println("No hay salones registrados");
                }
                case "4" -> System.out.println("Finalizando");
            }
        }while(!op.equals("4"));
    }
    
    public static int busBinariaPiso(Salon[] A,int N,int valor){
        int l = 0, r = N -1;
        while(l <= r){
            int m = l + (r - 1) / 2;
            
            if(A[m].Piso == valor) return m;
            if(A[m].Piso < valor) l = m + 1;
            else r = m -1;
        }
        return -1;
    }
    
    public static int busBinariaSillas(Salon[] A,int N,int valor){
        int l = 0, r = N -1;
        while(l <= r){
            int m = l + (r - 1) / 2;
            
            if(A[m].NoSillas == valor) return m;
            if(A[m].NoSillas < valor) l = m + 1;
            else r = m -1;
        }
        return -1;
    }
    
    public static void OrdShell(Salon[] A, int N){
        int salto;
        boolean cambios;
        Salon aux;
        for(salto = N/2; salto != 0; salto/=2){
            cambios = true;
            while(cambios){
                cambios = false;
                for(int i = salto; i < N; i++)
                    if(A[i - salto].NoSillas > A[i].NoSillas){
                        aux = A[i];
                        A[i] = A[i - salto];
                        A[i-salto] = aux;
                        cambios = true;
                    }
            }
        }
    }
}
