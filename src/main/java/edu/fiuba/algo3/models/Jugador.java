package edu.fiuba.algo3.models;

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
}