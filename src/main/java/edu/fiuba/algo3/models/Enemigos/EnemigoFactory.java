package edu.fiuba.algo3.models.Enemigos;

import edu.fiuba.algo3.models.Parcelas.Pasarela;

import java.util.HashMap;
import java.util.*;
import java.util.Queue;

public class EnemigoFactory
{
    private static Map<String, Enemigo> tiposDeEnemigos = new HashMap<>();


    public static Enemigo obtenerEnemigo(Queue<Pasarela> pasarelas, String tipo){
        tiposDeEnemigos.put("hormiga", new Hormiga(pasarelas));
        tiposDeEnemigos.put("arana", new Araña(pasarelas));
        tiposDeEnemigos.put("lechuza", new Lechuza(pasarelas));
        tiposDeEnemigos.put("topo", new Topo(pasarelas));

        return (tiposDeEnemigos.get(tipo));
    }
}