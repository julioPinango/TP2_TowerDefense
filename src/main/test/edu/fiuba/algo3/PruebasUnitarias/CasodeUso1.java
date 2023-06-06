package edu.fiuba.algo3.PruebasUnitarias;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Parser;

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

        /*
        // Obtener el valor en la posición [1][2]
        String valor = Mapa.get(1).get(2);
        */

        Parser parser= new Parser();
        List<List<String>> mapaParseado=parser.leerMapaArchivoJson();
        //Boolean retorno = parser.leerArchivoMapa2();
        //Boolean retornoValido=true;
        String coordenada11Mapa=(mapa.get(0).get(0));
        assertTrue(mapaParseado.size()==3);
        assertTrue(mapaParseado.get(0).size()==3);
        assertTrue(mapaParseado.get(0).get(0)=="Mapa");

        //assertTrue(retornoValido==retorno);
        String coordenada11MapaParseado=(mapaParseado.get(0).get(0));
        //assertTrue(coordenada11MapaParseado=="fggsgs");
    
        //assertTrue("Pasarela"==coordenada11MapaParseado);

    }
}
