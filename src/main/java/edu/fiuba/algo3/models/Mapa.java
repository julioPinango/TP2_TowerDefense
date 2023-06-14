package edu.fiuba.algo3.models;

import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.EnemigoFactory;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.ParcelaFactory;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.DefensaFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Mapa
{
    
    private List<Defensa> listaDefensas=new ArrayList<>();
    private List<List<Enemigo>> Spawn;
    private Map<Cordenada, Parcela> parcelas = new HashMap<>();
    private List<Enemigo> listaEnemigos=new ArrayList<>();

    /*
    public Mapa(Map<Cordenada, Parcela> parcelas2 , List<List<Enemigo>> spawn) {
        parcelas=parcelas2;
        Spawn=spawn;
    }
    */
    public Mapa(String rutaArchivo, Parser parser) {
        this.parcelas=inicializarParcelas(parser.leerMapa(rutaArchivo));
        this.Spawn=inicializarEnemigos(parser.desglosarEnemigos(rutaArchivo),parser.formarCamino(rutaArchivo));
    }
    private Map<Cordenada, Parcela>  inicializarParcelas(List<List<String>> mapa){
        Map<Cordenada, Parcela> nuevoMapa= new HashMap<>();
        for (int i = 0; i < mapa.size(); i++) {
            List<String> columna=mapa.get(i);
            for (int j = 0; j < columna.size(); j++) {
                String parcela=columna.get(j);
                Cordenada nuevaCordenada= new Cordenada(i, j);
                Parcela nuevaParcela=ParcelaFactory.obtenerParcela(nuevaCordenada, parcela);
                nuevoMapa.put(nuevaCordenada, nuevaParcela);
            }
        }
        return nuevoMapa;
    }
    private Queue<Pasarela> inicializarCaminoDeEnemigos(List<List<String>>camino){
        Queue<Pasarela> nuevoCamino=new LinkedList<>(); 
        for (int i = 0; i < camino.size(); i++) {
            List<String> unaPasarela=camino.get(i);
                Cordenada nuevaCordenada= new Cordenada(Integer.parseInt(unaPasarela.get(1)),Integer.parseInt(unaPasarela.get(2)));
                var nuevaPasarela=ParcelaFactory.obtenerParcela(nuevaCordenada, unaPasarela.get(0));
                nuevoCamino.add((Pasarela) nuevaPasarela);
        }
        return nuevoCamino;

    }
    private List<List<Enemigo>>  inicializarEnemigos(List<List<String>> enemigos, List<List<String>> camino){
         Queue<Pasarela> nuevoCamino=this.inicializarCaminoDeEnemigos(camino);
        List<List<Enemigo>> Spawn =new ArrayList<>();
        for (int i = 0; i < enemigos.size(); i++) {
            List<String> enemigosDelTurno=enemigos.get(i);
            List<Enemigo> nuevosEnemigos=new ArrayList<>();
            for (int j = 0; j < enemigosDelTurno.size(); j++) {
                String enemigo=enemigosDelTurno.get(j);
                Enemigo nuevoEnemigo=EnemigoFactory.obtenerEnemigo(nuevoCamino,enemigo);
                nuevosEnemigos.add(nuevoEnemigo);
            }
            Spawn.add(nuevosEnemigos);
        }
        return Spawn;
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

        if(Spawn.size()>turno)
        {
            List<Enemigo> enemigos=Spawn.get(turno);        

            for (Enemigo enemigo : enemigos) 
                listaEnemigos.add(enemigo);
        }
    }

    public List<Defensa> defensasDisponibles()
    {
        return listaDefensas;
    }
}