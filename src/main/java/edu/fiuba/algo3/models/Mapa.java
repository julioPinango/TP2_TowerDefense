package edu.fiuba.algo3.models;

import edu.fiuba.algo3.models.Enemigos.Ataques.*;
import edu.fiuba.algo3.models.Enemigos.EnemigoFactory;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
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
    private Queue<Pasarela> caminoEnemigos = new LinkedList<>();

    public List<Defensa> getDefensas(){
        return listaDefensas;
    }

    public Mapa(String rutaArchivoEnemigos,String rutaArchivoMapa, Parser parser) {
        this.parcelas=inicializarParcelas(parser.leerMapa(rutaArchivoMapa));
        this.Spawn=inicializarEnemigos(parser.desglosarEnemigos(rutaArchivoEnemigos),parser.formarCamino(rutaArchivoMapa));
    }

    public Map<Cordenada, Parcela>  inicializarParcelas(List<List<String>> mapa){
        Map<Cordenada, Parcela> nuevoMapa= new HashMap<>();
        for (int i = 0; i < mapa.size(); i++) {
            List<String> columna=mapa.get(i);
            for (int j = 0; j < columna.size(); j++) {
                String parcela=columna.get(j);
                Cordenada nuevaCordenada= new Cordenada(j, i);
                Parcela nuevaParcela=ParcelaFactory.obtenerParcela(nuevaCordenada, parcela);
                nuevoMapa.put(nuevaCordenada, nuevaParcela);
            }
        }
        return nuevoMapa;
    }

    public Queue<Pasarela> inicializarCaminoDeEnemigos(List<List<String>>camino){
        Queue<Pasarela> nuevoCamino=new LinkedList<>(); 
        for (int i = 0; i < camino.size(); i++) {
            List<String> unaPasarela=camino.get(i);
                Cordenada nuevaCordenada= new Cordenada(Integer.parseInt(unaPasarela.get(1)),Integer.parseInt(unaPasarela.get(2)));
                Pasarela nuevaPasarela=(Pasarela)ParcelaFactory.obtenerParcela(nuevaCordenada, unaPasarela.get(0));
                nuevoCamino.add(nuevaPasarela);
        }
        caminoEnemigos=nuevoCamino;
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

    public boolean colocarDefensaEnEstaPosicion(int x,int y, String tipo,Jugador jugador){

        Cordenada cordenada=new Cordenada(x, y); 
        Defensa defensaNueva= DefensaFactory.obtenerDefensa(cordenada,tipo);
        var preuba=parcelas.get(cordenada);
        if(preuba.puedoConstruirDefensa(defensaNueva)
        &&posicionValida(cordenada)
        &&jugador.creditosSuficientes(defensaNueva.getCosto()))
        {

            jugador.descontarCredito(defensaNueva.getCosto());

            this.listaDefensas.add(defensaNueva);
            
            var log = Log.obtenetInstancia();
            log.imprimirConstruccion(defensaNueva,cordenada);
            return true;
        }
        return false;

    }


    private boolean posicionValida(Cordenada cordenada) {
        List<Pasarela> listaPasarelas = new ArrayList<>(caminoEnemigos);
        int tamaño = listaPasarelas.size();
        
        if(cordenada==listaPasarelas.get(0).getCordenada())
        {
            return false;
        }

        if(cordenada == listaPasarelas.get(tamaño - 1).getCordenada())
        {   
            return false;
        }

        return true;
        
    }

    public List<Enemigo> getEnemigos() {
        return listaEnemigos;
    }

    public List<List<Enemigo>> getSpawn() {
        return Spawn;
    }

    public Map<Cordenada, Parcela> getParcelas() {
        return parcelas;
    }
    
    public boolean quedanEnemigos()
    {
        return getEnemigos().size()>0;
    }
    

    private void turnoDeDefensas(){
        for (var torre : listaDefensas) {
            torre.atacar(listaEnemigos); 
        }
    }


    private void turnoAtaqueDeEnemigos(Enemigo enemigo, Turno turno, Jugador jugador){
        Ataque ataque=AtaqueFactory.obtenerAtaque(enemigo,turno,listaDefensas);
        enemigo.definirAtaque(ataque);
        enemigo.atacarJugador(jugador);
        enemigo.otorgarCreditos(jugador);                
        enemigo.sumarEnemigoMuerto(jugador);
    }

    
    private List<Enemigo> enemigosRestantes(List<Enemigo> enemigosActuales, Jugador jugador, Turno turno){
        List<Enemigo> listaEnemigosVivos = new ArrayList<>();   
        for(Enemigo enemigo:enemigosActuales)
        {
            if(enemigo.getEnergia()>0)
            { 
                listaEnemigosVivos.add(enemigo);
                enemigo.mover();
            }
            else
            {
                this.turnoAtaqueDeEnemigos(enemigo, turno, jugador);
            }
        }
        return listaEnemigosVivos;
    }

    private List<Defensa> defensasDisponibles(List<Defensa> defensasActuales){
        List<Defensa> defensasDisponibles= new ArrayList<>(); 

        for (Defensa defensa : defensasActuales) {

            if(defensa.destruido()==false)
                defensasDisponibles.add(defensa);
        }

        return defensasDisponibles;
    }

    public void realizarTurno(Jugador jugador,Turno turno) {
        this.turnoDeDefensas();
        listaEnemigos=this.enemigosRestantes(listaEnemigos,jugador, turno);
        if(Spawn.size()>turno.getTurno())
        {
            List<Enemigo> enemigos=Spawn.get(turno.getTurno());        

            for (Enemigo enemigo : enemigos) 
                listaEnemigos.add(enemigo);
        }
        listaDefensas=this.defensasDisponibles(listaDefensas);
    }

    public String obtenerTipoParcela(int x,int y){
        Cordenada cordenada = new Cordenada(x, y);
        return parcelas.get(cordenada).getTipo();
    }

}