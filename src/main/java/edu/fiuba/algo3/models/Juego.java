
package edu.fiuba.algo3.models;


public class Juego
{
    private Mapa mapa;
    private Jugador jugador;
    private String resultadoJuego="En proceso";
    private Log log= Log.obtenetInstancia();
    private Turno turno;
    
    public Juego(Jugador jugador,Mapa mapa2, Turno turnoActual){
        this.jugador=jugador;
        mapa=mapa2;
        turno=turnoActual;
    }

    public String getResultado() {
        return resultadoJuego;
    }

    public int getTurno()
    {
        return jugador.getTurno();
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

   

    public void realizarTurno() {
       //Efectua un turno y deja el juego en el estado correspondiente.

        mapa.realizarTurno(jugador,turno);                   

        if(jugador.jugadorDerrotado())
        {
            terminarPartida(!jugador.jugadorDerrotado());
        }
        else if (mapa.quedanEnemigos()==false&&jugador.getTurno()!=0)
        {
            terminarPartida(!jugador.jugadorDerrotado());
        }
        jugador.pasarTurno();    
    }
}