package edu.fiuba.algo3.models.Enemigos;

import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Enemigos.Movimientos.*;

import java.util.HashMap;
import java.util.*;
import java.util.Queue;

public class EnemigoFactory
{
    private static Map<String, Enemigo> tiposDeEnemigos = new HashMap<>();


    public static Enemigo obtenerEnemigo(Queue<Pasarela> pasarelas, String tipo){
        tiposDeEnemigos.put("hormiga", new Hormiga(pasarelas,new MovimientoHormiga()));
        tiposDeEnemigos.put("arana", new Araña(pasarelas,new MovimientoAraña()));
        tiposDeEnemigos.put("lechuza", new Lechuza(pasarelas,new MovimientoLechuzaenL()));
        tiposDeEnemigos.put("topo", new Topo(pasarelas,new MovimientoTopo()));

        return (tiposDeEnemigos.get(tipo));
    }
}