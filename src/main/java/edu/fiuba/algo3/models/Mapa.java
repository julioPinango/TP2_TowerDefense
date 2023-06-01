package edu.fiuba.algo3.models;

import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa
{
    
    private List<Defensa> listaDefensas;
    private List<Enemigo> listaEnemigos;
    private Parcela[][] Parcelas;
    private Map<String, Defensa> tiposDeTorre = new HashMap<>();


    public Mapa(Parcela[][] parcelas2, List<Defensa> listaDefensas2, List<Enemigo> listaEnemigos2) {

        Parcelas=parcelas2;
        listaDefensas=listaDefensas2;
        listaEnemigos=listaEnemigos2;
    }
    public void SiguienteTurno() {

    }

    private void colocarTipoParcela(Parcela parcela, int x, int y){
        this.Parcelas[x][y]=parcela;
    }
    boolean colocarDefensaEnEstaPosicion(int x,int y, String tipo){

        Cordenada cordenada=new Cordenada(x, y);

        tiposDeTorre.put("Torre Blanca", new TorreBlanca(cordenada));
        tiposDeTorre.put("Torre Plateada", new TorrePlateada(cordenada));

        Defensa defensaNueva=this.tiposDeTorre.get(tipo);

        return (this.Parcelas[x][y].puedoConstruirDefensa(defensaNueva));
    }
    public List<Enemigo> getEnemigos() {
        return listaEnemigos;
    }
    public boolean quedanEnemigos()
    {
        return getEnemigos().size()>0;
    }
    public void realizarTurno(Jugador jugador) {
        
        for (var torre : listaDefensas) {
                   torre.realizarTurno(listaEnemigos); 
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
                enemigo.otorgarCreditos(jugador);                
                enemigo.sumarEnemigoMuerto(jugador);
            }

           

        }

        listaEnemigos=listaEnemigosVivos;





    }

}