

package com.mycompany.unidad01_practica05;


public class Unidad01_Practica05 {

    public static String[] menu = {
        "Menu principal",
        "1.-Introducir numero de clientes",
        "2.-Introducir informacion del cliente",
        "3.-Tipo de Ordenamiento",
        "4.-Tipo de metodo de ordenamiento shell",
        "5.-Mostrar Clientes",
        "6.-Finalizar"
    };
        
    public static String[] menuOrd = {
        "Tipo de ordenamiento",
        "1.-Ascendente",
        "2.-Descendente"
    };
    
    public static String[] menuMet = {
        "Eliga un metodo de ordenamiento shell",
        "1.-Visto en clase",
        "2.-Tarea"
    };
    
    public static void main(String[] args) {
        String op,opOrd;
        String opMet = null;
        Cliente[] c = null;
        int N = 0;
        do{
            Libreria.mostrarMenus(menu);
            op = Libreria.validarString("Ingrese una opcion...:");
            
            switch(op){
                case "1" ->{
                    N = Libreria.validarInt("Ingrese el numero de Clientes");
                    c = new Cliente[N];
                }
                
                case "2" ->{
                    if(c != null)
                        for(int i = 0; i < N; i++){
                            System.out.println("Cliente #" + (i+1));
                            String Nombre = Libreria.validarString("Ingrese el Nombre del cliente...:");
                            String tel = Libreria.validarString("Imgrese el Telefono del cliente...:");
                            double saldo = Libreria.validarDouble("Ingrese el saldo del cliente...:");
                            c[i] = new Cliente(String.valueOf(i+1),Nombre,tel,saldo);
                        }
                    else System.out.println("No hay un numero de cliente establecido");
                }
                
                case "3" ->{
                    if(opMet != null){
                        Libreria.mostrarMenus(menuOrd);
                        opOrd = Libreria.validarString("Ingrese un tipo de Ordenamiento...:");
                        
                        switch(opMet){
                            case "1" -> OrdShellClase(c,N,opOrd);
                            case "2" -> OrdShellTarea(c,N,opOrd);
                        }
                    }else System.out.println("Primero seleccione un tipo de metodo de Ordenamiento Shell");
                }
                
                case "4" ->{
                    Libreria.mostrarMenus(menuMet);
                    opMet = Libreria.validarString("Ingrese un tipo de metodo de Ordenamiento");
                }
                
                case "5" ->{
                    if(c != null) for(Cliente e: c) {if(e != null)   System.out.println(e.toString());}
                    else System.out.println("No hay clientes. Ingrese unos");
                }
                
                case "6" -> System.out.println("Finalizando");
                    
            }
        }while(!"6".equals(op));
    }
    
    public static void OrdShellClase(Cliente[] A, int N,String op){
        int salto;
        boolean cambios;
        
        for(salto = N/2; salto != 0; salto/=2){
            cambios = true;
            while(cambios){
                cambios = false;
                for(int i = salto; i < N; i++)
                    switch(op){
                        case "1" -> {
                            if(A[i - salto].saldo > A[i].saldo){
                                cambiosA(A,i,(i-salto));
                                cambios = true;
                            }
                        }
                        case "2" -> {
                            if(A[i - salto].saldo < A[i].saldo){
                                cambiosA(A,i,(i-salto));
                                cambios = true;
                            }
                        }
                    }
            }
        }
    }
    
    public static void OrdShellTarea(Cliente[] A, int N, String op){
        for(int gap = N/2; gap > 0; gap /=2){
            for(int i = gap; i < N; i++){
                Cliente temp = A[i];
                int j;
                switch(op){
                    case "1" -> {
                        for(j = i; j >= gap && A[j-gap].saldo > temp.saldo; j -= gap)   A[j] = A[j - gap];
                        A[j] = temp;}
                    case "2" -> {
                        for(j = i; j >= gap && A[j-gap].saldo < temp.saldo; j -= gap)   A[j] = A[j - gap];
                        A[j] = temp;}
                }
            }
        }
    }
    
    public static void cambiosA(Cliente[] A, int i, int k){
        Cliente aux = A[i];
        A[i] = A[k];
        A[k] = aux;
    }
}
