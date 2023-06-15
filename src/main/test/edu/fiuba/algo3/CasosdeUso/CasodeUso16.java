package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;

import java.util.ArrayList;
import java.util.List;

public class CasodeUso16 {    
    @Test
    public void Prueba01(){

                String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";
                String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosReducido.json";
                Parser parser = new Parser();
                Mapa mapa2=new Mapa(path2,path,parser);

                Mapa mapa=new Mapa(path2,path,parser);


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
            
                var mapa3=mapa2.inicializarParcelas(mapa);

                assertEquals(mapa3,mapa2);
    }
}
