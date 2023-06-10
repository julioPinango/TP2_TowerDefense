
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

   

   

    public void SiguienteTurno(Jugador jugador) {        
        do{
            mapa.realizarTurno(jugador,Turno);              
            Turno++;
        }
        while (!(jugador.jugadorDerrotado())&&(mapa.quedanEnemigos())) ;                          

        terminarPartida(!jugador.jugadorDerrotado()&&Turno!=0);//True es gano false es perdio.
        
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

            do{
                mapa.realizarTurno(jugador,Turno);              
                Turno++;
            }
            while (!(jugador.jugadorDerrotado())&&(mapa.quedanEnemigos())) ;                          
    
            terminarPartida(!jugador.jugadorDerrotado()&&Turno!=0);//True es gano false es perdio.
    }
}