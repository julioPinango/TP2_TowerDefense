package edu.fiuba.algo3.models.Enemigos;

import edu.fiuba.algo3.models.Parcelas.Pasarela;

import java.util.HashMap;
import java.util.*;
import java.util.Queue;

public class EnemigoFactory
{
    private static Map<String, Enemigo> tiposDeEnemigos = new HashMap<>();


    public static Enemigo obtenerEnemigo(Queue<Pasarela> pasarelas, String tipo){
        tiposDeEnemigos.put("Hormiga", new Hormiga(pasarelas));
        tiposDeEnemigos.put("Araña", new Araña(pasarelas));
        return (tiposDeEnemigos.get(tipo));
    }
}