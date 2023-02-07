package com.mycompany.unidad01_practica03;

public class Unidad01_Practica03 {

    public static String[] menu = {
        "Menu Principal",
        "1.-Ingresar Articulo",
        "2.-Mostrar Articulos",
        "3.-Finalizar",
        "Ingrese una opcion...:"
    };
    
    public static String[] menuord = {
        "Seleccione su tipo de Ordenamiento",
        "1.-Ascendente",
        "2.-Descendente",
        "Ingrese una opcion...:"  
    };
    
    public static void main(String[] args) {
        String op;
        String opOrd;
        boolean s = true;
        do{
            Libreria.mostrarMenus(menuord,menuord.length);
            opOrd = Libreria.validarString("");
            if(opOrd.equals("1") || opOrd.equals("2")) s = false;
        }while(s);
        
        Articulo[] articulos = new Articulo[100];
        int N = -1;
        do{
            Libreria.mostrarMenus(menu, menu.length);
            op = Libreria.validarString("");
            
            switch(op){
                case "1":
                    if((N+1) != 100){
                        N++;
                        articulos[N] = new Articulo(String.valueOf((N+1)));

                        articulos[N].descripcion = Libreria.validarString("Ingrese la descripcion del producto #" + (N+1));
                        articulos[N].precio = Libreria.validarReales("Ingrese el precio del producto #" + (N+1));


                        switch(opOrd){
                            case "1": OrdBurbujaAsc(articulos,(N+1));   break;
                            case "2": OrdBurbujaDes(articulos,(N+1));   break;
                        }
                    }else System.out.println("Limite de productos alcanzados");
                    break;
                case "2":
                    if(!(N < 0)) for(int i = 0; i < (N+1); i++) System.out.println(articulos[i].toString());
                    else System.out.println("No hay articulos ingresados");
                    break;
                case "3":
                    System.out.println("Finalizado");
            }
        }while(!op.equals("3"));
    }
    
    public static void OrdBurbujaAsc(Articulo[] A,int N){
        for(int i = 0; i < N - 1; i++) {
				
            for(int k = i + 1; k < N; k++) {
                if(A[i].precio > A[k].precio) cambio(A, i, k);
            }
	}
    }
    
    public static void OrdBurbujaDes(Articulo[] A,int N){
        for(int i = 0; i < N - 1; i++) {	
            for(int k = i + 1; k < N; k++) {
                if(A[i].precio < A[k].precio) cambio(A, i, k);
            }
	}
    }
    
    public static void cambio(Object[] A, int i, int k){
        Object aux = A[i];
        A[i] = A[k];
        A[k] = aux;
    }
}
