
package edu.fiuba.algo3.models;


public class Juego
{
    private Mapa mapa;
    private Jugador jugador;
    private int Turno;
    private String resultadoJuego="En proceso";
    private Log log= Log.obtenetInstancia();
    
    public Juego(Jugador jugador,Mapa mapa2){
        this.jugador=jugador;
        this.Turno=0;
        mapa=mapa2;
    }

    public String getResultado() {
        return resultadoJuego;
    }

    public int getTurno()
    {
        return Turno;
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

        mapa.realizarTurno(jugador,Turno);                   

        if(jugador.jugadorDerrotado())
        {
            terminarPartida(!jugador.jugadorDerrotado());
        }
        else if (mapa.quedanEnemigos()==false&&Turno!=0)
        {
            terminarPartida(!jugador.jugadorDerrotado());
        }
        Turno++;    
    }
}