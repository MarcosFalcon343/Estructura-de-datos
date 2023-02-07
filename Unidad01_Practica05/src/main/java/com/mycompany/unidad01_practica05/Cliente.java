
package com.mycompany.unidad01_practica05;


public class Cliente {
    
    public String id;
    public String nombre;
    public String telefono;
    public double saldo;
    
    public Cliente(String id,String nom, String tel, double saldo){
        this.id = id;
        this.nombre = nom;
        this.telefono = tel;
        this.saldo = saldo;
    }
    
    @Override
    public String toString(){
        return "\tCliente #" + this.id + "\n\tNombre: " + this.nombre + "\n\tTelefono: " + this.telefono + "\n\tSaldo: " + this.saldo;
    }
}
