package edu.fiuba.algo3.models;

import java.util.function.BooleanSupplier;

import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;

public class Jugador{

   private int Vida;
   private int Creditos;
   private String Nombre;

   public Jugador()
   {
      this.Vida=20;
      this.Creditos=100;

   }

   public int getVida() {
      return Vida;
   }
   public void setVida(int vida) {
      Vida = vida;
   }
   public int getCreditos() {
      return Creditos;
   }
   public void setCreditos(int creditos) {
      Creditos = creditos;
   }
   public String getNombre() {
      return Nombre;
   }
   public void setNombre(String nombre) {
      Nombre = nombre;
   }

   public boolean creditosSuficientes(Defensa torre) {   
      return getCreditos()>=torre.getCosto();
   }

   public void descontarCredito(int costo) {
      Creditos=Creditos-costo;
   }

public void recibirAtaque(Enemigo enemigo) {

   Vida=Vida-enemigo.getdanio();

}
}