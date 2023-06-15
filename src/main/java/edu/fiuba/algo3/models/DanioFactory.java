package edu.fiuba.algo3.models;

import java.util.*;

public class DanioFactory
{
    private static Map<String,Integer> tipodeDanio = new HashMap<>();

    public static int obtenerAtaque(String tipo,Turno turno){

        tipodeDanio.put("hormiga",1);
        tipodeDanio.put("arana", 2);
        tipodeDanio.put("lechuza",0);
        tipodeDanio.put("topo",2);
        
        if(tipo=="topo"&&!turno.esTurnoPar())            
        {
           return tipodeDanio.get(tipo)+3;
        }
        return (tipodeDanio.get(tipo));
    }
}


