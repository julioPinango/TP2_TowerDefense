package edu.fiuba.algo3.PruebasUnitarias;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Parcelas.Rocoso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CasodeUso1 {    
    @Test
    public void Prueba01() throws IOException{
   
        // Crear la lista de listas
        List<List<String>> mapa = new ArrayList<>();

        // Crear la primera lista y añadirla a la lista de listas
        List<String> primeraLista = new ArrayList<>();
        primeraLista.add("Rocoso");
        primeraLista.add("Pasarela");
        primeraLista.add("Tierra");
        mapa.add(primeraLista);

        // Crear la segunda lista y añadirla a la lista de listas
        List<String> segundaLista = new ArrayList<>();
        segundaLista.add("Tierra");
        segundaLista.add("Pasarela");
        segundaLista.add("Tierra");
        mapa.add(segundaLista);

        // Crear la tercera lista y añadirla a la lista de listas
        List<String> terceraLista = new ArrayList<>();
        terceraLista.add("Tierra");
        terceraLista.add("Pasarela");
        terceraLista.add("Tierra");
        mapa.add(terceraLista);

        Parser parser= new Parser();

        String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapaReducido.json";

        var mapaParseado=parser.leerMapa(path);      

        Cordenada cor=new Cordenada(1, 1);

        var coordenada11MapaParseado=mapaParseado.get(cor);    

        var roco=new Rocoso(cor);

        assertEquals(roco,coordenada11MapaParseado);
        
    }
}
