
package edu.fiuba.algo3.models;


public class Juego
{
    private Mapa mapa;
    private Jugador Jugador;
    private int Turno;
    private String resultadoJuego="En proceso";
    private Log log= Log.obtenetInstancia();
    
    public Juego(Jugador jugador,Mapa mapa2){
        this.Jugador=jugador;
        this.Turno=0;
        mapa=mapa2;
    }

   

   

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


    public void terminarPartida(boolean gano)
    {
        if(gano)
            resultadoJuego="Gana";
        else
            resultadoJuego="Pierde";
            
        log.imprimirResultado(resultadoJuego);
    }

    public String resultado() {
        return resultadoJuego;
    }

    public int getTurno()
    {
        return Turno;
    }

    public void jugar(Jugador jugador) {

        
            while (!(jugador.jugadorDerrotado())&&(mapa.quedanEnemigos())) {

                mapa.realizarTurno(jugador);
                
                
                
                Turno++;
                
                

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
    
                    //gano
                // CONTRUIR Y PASAR TURNO
            }
    
            terminarPartida(!jugador.jugadorDerrotado());//True es gano false es perdio.
            
            
        


    }
}