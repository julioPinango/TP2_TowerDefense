package edu.fiuba.algo3;




import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CasodeUso1 {    
   
    public static void Prueba01() throws IOException{
   
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

         String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";

        /*Map<Cordenada, Parcela> mapaParseado=parser.leerMapa(path);      

        Cordenada cor=new Cordenada(2, 2);

        var coordenada11MapaParseado=mapaParseado.values();    

        var roco=new Rocoso(cor);*/

        var camino=parser.formarCamino(path);


        String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosReducido.json";

        var enemigos=parser.desglosarEnemigos(path2,camino);

        String nul=null;
        //assertEquals(roco,coordenada11MapaParseado);
        
    }
}
