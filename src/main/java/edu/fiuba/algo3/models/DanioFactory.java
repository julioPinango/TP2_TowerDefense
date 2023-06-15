package edu.fiuba.algo3.models;

import java.util.*;

public class DanioFactory
{
    private static Map<String,Integer> tipodeDanio = new HashMap<>();

    public static int obtenerAtaque(String tipo,Turno turno){

        tipodeDanio.put("Hormiga",1);
        tipodeDanio.put("Araña", 2);
        tipodeDanio.put("Lechuza",0);
        tipodeDanio.put("Topo",2);
        
        if(tipo=="topo"&&!turno.esTurnoPar())            
        {
           return tipodeDanio.get(tipo)+3;
        }
        return (tipodeDanio.get(tipo));
    }
}


