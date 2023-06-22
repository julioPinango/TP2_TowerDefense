
package edu.fiuba.algo3.models;

import java.util.List;
import java.util.Map;

import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Parcelas.Parcela;

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
        return turno.getTurno();
    }

    public List<List<Enemigo>> getSpaw(){
        return mapa.getSpawn();        
    }

    public Map<Cordenada, Parcela> getParcelas(){
        return mapa.getParcelas();        
    }

    public int getTamañoParcelas(){
        return mapa.getTamañoParcelas();        
    }

    public String obtenerParcela(int x, int y){
        return mapa.obtenerTipoParcela(x,y);
    }
   
  
    public boolean colocarDefensas(int x, int y, String tipoDeTorre){

        if(!(this.mapa.colocarDefensaEnEstaPosicion(x,y,tipoDeTorre,jugador))){
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
    public int obtenerCantidadDeHormigasEliminadasPorElJugador(){
        return jugador.getHormigasDestruidas();
    }

    public int obtenerVidaRestanteDelJugador(){
        return jugador.getVida();
    }
    public String obtenerNombreDelJugador(){
        return jugador.getNombre();
    }
    public int obtenerCreditosDelJugador(){
        return jugador.getCreditos();
    }
    public void realizarTurno() {
       //Efectua un turno y deja el juego en el estado correspondiente.

        mapa.realizarTurno(jugador,turno);                   

        if(jugador.jugadorDerrotado())
        {
            terminarPartida(!jugador.jugadorDerrotado());
        }
        else if (mapa.quedanEnemigos()==false&&turno.getTurno()!=0)
        {
            terminarPartida(!jugador.jugadorDerrotado());
        }
        turno.pasarTurno();    
    }

    public boolean hayDefensa(int x, int y){
        boolean retorno = mapa.hayDefensaEnEstaPosicion(x, y);
        return retorno;
    }

    public String devolverDefensa(int x, int y){
        String retorno = mapa.obtenerTipoDefensa(x,y);
        return retorno;
    }
}