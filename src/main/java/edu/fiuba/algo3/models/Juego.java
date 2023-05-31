
package edu.fiuba.algo3.models;


public class Juego
{
    private Mapa mapa;
    private Jugador jugador;

    public static Boolean jugadorDerrotado(Jugador jugador) {
        return jugador.getVida()<=0;
    }
}