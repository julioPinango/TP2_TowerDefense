
package edu.fiuba.algo3.models;


public class Juego
{
    private Mapa mapa;
    private Jugador Jugador;
    private int Contador;
    
    public Juego(String nombreJugador){
        this.Jugador= new Jugador(nombreJugador);
        this.Contador=0;
    }

    public static Boolean jugadorDerrotado(Jugador jugador) {
        return (jugador.getVida()<=0);
    }

    /*private void flujoDeJuego(){
        while (!(jugadorDerrotado())) {
            //TURNO 0
            //CONSTRUYE defensa
            //se mueve enemigo
            //PASA TURNO

            //TURNO 1
            //defensa en construccion
            //se mueve enemigo
            //Contruir y pasar turno

            //TURNO 2
            //Defensa operativa: pega defensa
            //chequea si el enemimo murio: da creditos
            //se mueve enemigo
            // CONTRUIR Y PASAR TURNO
        }
    }*/

    public void SiguienteTurno() {
            /*
        this.mapa.realizarTurno();
        Coordenada Coordenada= this.jugador.ColocarDefensasNuevas();
        this.mapa.ColocarDefensasNuevas()=coordenadaNueva
        this.SiguienteTurno(); */
    }

    public boolean colocarDefensas(int x, int y, String tipoDeTorre){
        if(!(this.mapa.colocarDefensaEnEstaPosicion(x,y,tipoDeTorre))){
            return false;
        }
        return true;
    }
}