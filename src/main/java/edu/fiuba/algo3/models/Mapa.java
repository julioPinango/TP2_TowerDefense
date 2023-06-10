package edu.fiuba.algo3.models;

import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.DefensaFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa
{
    
    private List<Defensa> listaDefensas=new ArrayList<>();
    private List<List<Enemigo>> Spawn;
    private Map<Cordenada, Parcela> parcelas = new HashMap<>();
    private List<Enemigo> listaEnemigos=new ArrayList<>();




    public Mapa(Map<Cordenada, Parcela> parcelas2 , List<List<Enemigo>> spawn) {
        parcelas=parcelas2;
        Spawn=spawn;
    }

    public boolean colocarDefensaEnEstaPosicion(int x,int y, String tipo){

        Cordenada cordenada=new Cordenada(x, y); 
        Defensa defensaNueva= DefensaFactory.obtenerDefensa(cordenada,tipo);

        if(parcelas.get(cordenada).puedoConstruirDefensa(defensaNueva))
        {
            this.listaDefensas.add(defensaNueva);
            var log = Log.obtenetInstancia();
            log.imprimirConstruccion(defensaNueva,cordenada);
            return true;
        }
        return false;

    }
    public List<Enemigo> getEnemigos() {
        return listaEnemigos;
    }
    public boolean quedanEnemigos()
    {
        return getEnemigos().size()>0;
    }
    public void realizarTurno(Jugador jugador,int turno) {

        for (var torre : listaDefensas) {
                   torre.atacar(listaEnemigos); 
        }

        List<Enemigo> listaEnemigosVivos = new ArrayList<>();
        
        
        for(Enemigo enemigo:listaEnemigos)
        {
            if(enemigo.getEnergia()>0)
            { 
                listaEnemigosVivos.add(enemigo);
                enemigo.mover(jugador);
            }
            else
            {
                enemigo.atacarJugador(jugador);
                enemigo.otorgarCreditos(jugador);                
                enemigo.sumarEnemigoMuerto(jugador);
            }

           

        }

        listaEnemigos=listaEnemigosVivos;

        List<Enemigo> enemigos=Spawn.get(turno);

        for (Enemigo enemigo : enemigos) 
            listaEnemigos.add(enemigo);
            
            
        

        //CHEQUEO SI GANO.

        //SPAWN HACE COSAS.



    }

}