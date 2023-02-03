
package com.mycompany.unidadi_practica01;

import java.util.Scanner;


public class UnidadI_Practica01 {

    static String[] menu = {"\n1.-Ingrese el tamaño del arreglo",
                     "2.-Captura de datos",
                     "3.-Ordenamienro Ascendente",
                     "4.-Ordenamiento Descendente",
                     "5.-Visualizar Arreglo",
                     "6.-Terminar",
                     "Ingrese su opcion....:"};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int op = 0;
        int N = -1;
        int[] A = new int[100];
        String valor;
        do{
            for(String e: menu)
                System.out.println(e);
            op = sc.nextInt();
            
            switch(op){
                case 1:
                    do{
                        System.out.println("Ingrese el tamaño del arreglo");
                        N = sc.nextInt();
                        if(N < 0)
                            System.out.println("No se puede tener el tamaño " + N + " en un arreglo");
                    }while(N < 0);
                    break;
                case 2:
                    if(N != -1){
                        for(int i = 0; i < N; i++){
                            do{
                                System.out.println("Ingrese el valor #" + i);
                                valor = sc.next();
                            }while(null == valor);
                            A[i] = Integer.parseInt(valor);
                        }
                    }else{
                        System.out.println("Ingrese primero el tamaño del arreglo");
                    }
                    break;
                case 3:
                    OrdBurbujaAsc(A,N);
                    break;
                case 4:
                    OrdBurbujaDes(A,N);
                    break;
                case 5:
                    System.out.println("\n");
                    for(int i = 0; i < N; i++)
                        System.out.print(A[i] + " ");
                    break;
                case 6:
                    System.out.println("Adios");
                    break;
                    
            }
        }while(op != 6 && op > 0);
    }
    
    public static void OrdBurbujaAsc(int[] A,int N){
        int aux;
        for(int i = 0; i < N - 1; i++) {
				
            for(int k = i + 1; k < N; k++) {
                if(A[i] > A[k]) {
                    aux = A[i];
                    A[i] = A[k];
                    A[k] = aux;
                }
            }
	}
    }
    
    public static void OrdBurbujaDes(int[] A,int N){
        int aux;
        for(int i = 0; i < N - 1; i++) {
				
            for(int k = i + 1; k < N; k++) {
                if(A[i] < A[k]) {
                    aux = A[i];
                    A[i] = A[k];
                    A[k] = aux;
                }
            }
	}
    }
}
