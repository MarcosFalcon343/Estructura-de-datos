
package com.mycompany.unidad01_practica03;


public class Articulo {
    public String Id;
    public String descripcion;
    public double precio;
    
    public Articulo(String Id){
        this.Id = Id;
    }
    
    @Override
    public String toString(){
        return "Articulo #" + this.Id + " Descripcion: " + this.descripcion + " Precio: " + this.precio;
    }
}
