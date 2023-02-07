/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.unidad01_practica06;

/**
 *
 * @author Marcos
 */
public class Unidad01_Practica06 {

    static String[] menu = {
        "Menu Principal",
        "1.-Ingrese el tamaño del arreglo",
        "2.-Insertar datos",
        "3.-Ordenar datos de manera Ascendente",
        "4.-Mostrar datos",
        "5.-Finalizar"
    };
    
    static String[] datos = null;
    
    public static void main(String[] args) {
        String op;
        archivo file = new archivo("datos.txt");
        file.escribir("");
        int N = 0;
        do{
            Libreria.mostrarMenus(menu);
            op = Libreria.validarString("Ingrese una opcion...:");
            
            switch(op){
                case "1" -> N = Libreria.validarInt("Ingrese el tamaño del arreglo...:");
                case "2" -> {
                    if(N > 0){
                        file.escribir("");
                        for(int i = 0; i < N; i++){
                            String dato = String.valueOf(Libreria.validarInt("Ingrese el dato #" + (i+1)));
                            file.escribirSave(dato+",");
                        }
                    }
                    else System.out.println("Primero ingrese un tamaño del arreglo");
                }
                case "3" -> {
                    if(!file.isVacio()){
                        datos = file.datos();
                        QuickSortAsc(datos,0,N-1);
                        file.escribir("");
                        for(String e: datos) file.escribirSave(e + ",");
                    }else System.out.println("No hay datos que ordenar, ya que el archivo TXT esta vacio");
                }
                case "4" -> file.mostrarDatos();
                case "5" -> System.out.println("Finalizando");
            }
        }while(!op.equals("5"));
    }
    
    public static void QuickSortAsc(String[] A, int izq, int der){
        int pivote = Integer.parseInt(A[izq]);
        int i = izq;
        int j = der;
        String aux;
        
        while(i < j){
            while(Integer.parseInt(A[i]) <= pivote && i < j) i++;
            while(Integer.parseInt(A[j]) > pivote) j--;
            
            if(i < j){
                aux = A[i];
                A[i] = A[j];
                A[j] = aux;
            }
        }
        
        A[izq] = A[j];
        A[j] = String.valueOf(pivote);
        
        if(izq < j-1) QuickSortAsc(A,izq,j-1);
        if(j+1 < der) QuickSortAsc(A,j+1,der);
    }
    
    
    
}
