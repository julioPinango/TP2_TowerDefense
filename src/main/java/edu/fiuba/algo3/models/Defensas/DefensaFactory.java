package edu.fiuba.algo3.models.Defensas;

import edu.fiuba.algo3.models.Cordenada;
import java.util.HashMap;
import java.util.Map;

public class DefensaFactory
{
    private static Map<String, Defensa> tiposDeTorre = new HashMap<>();


    public static Defensa obtenerDefensa(Cordenada cordenada, String tipo){
        tiposDeTorre.put("Torre Blanca", new TorreBlanca(cordenada));
        tiposDeTorre.put("Torre Plateada", new TorrePlateada(cordenada));
        return (tiposDeTorre.get(tipo));
    }
}
