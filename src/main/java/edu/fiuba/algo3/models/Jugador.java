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

   public Jugador(String nombreJugador){ 
      this.Vida=20;
      this.Creditos=100;
      this.Nombre=nombreJugador;
   }

   public int getVida() {
      return this.Vida;
   }
   public void setVida(int vida) {
      this.Vida = vida;
   }
   public int getCreditos() {
      return this.Creditos;
   }
   public void setCreditos(int creditos) {
      this.Creditos = creditos;
   }
   public String getNombre() {
      return this.Nombre;
   }
   public void setNombre(String nombre) {
      this.Nombre = nombre;
   }

   public boolean creditosSuficientes(Defensa torre) {   
      return getCreditos()>=torre.getCosto();
   }

   public void descontarCredito(int costo) {
      this.Creditos=Creditos-costo;
   }

public void recibirAtaque(Enemigo enemigo) {

   this.Vida=Vida-enemigo.getdanio();

}
}