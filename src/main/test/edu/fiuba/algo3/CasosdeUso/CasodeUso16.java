package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.models.Cordenada;
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
            
                String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapaReducido.json";
        
                var mapaParseado=Parser.leerMapa(path);      
        
                Cordenada cor0_0=new Cordenada(0, 0);
                Cordenada cor1_0=new Cordenada(1, 0);
                Cordenada cor2_0=new Cordenada(2, 0);
                Cordenada cor0_1=new Cordenada(0, 1);
                Cordenada cor1_1=new Cordenada(1, 1);
                Cordenada cor2_1=new Cordenada(2, 1);
                Cordenada cor0_2=new Cordenada(0, 2);
                Cordenada cor1_2=new Cordenada(1, 2);
                Cordenada cor2_2=new Cordenada(2, 2);
        
                
        
                Parcela coordenada0_0MapaParseado=mapaParseado.get(cor0_0); 
                Parcela coordenada1_0MapaParseado=mapaParseado.get(cor1_0);    
                Parcela coordenada2_0MapaParseado=mapaParseado.get(cor2_0);  
                Parcela coordenada0_1MapaParseado=mapaParseado.get(cor0_1);
                Parcela coordenada1_1MapaParseado=mapaParseado.get(cor1_1);
                Parcela coordenada2_1MapaParseado=mapaParseado.get(cor2_1);
                Parcela coordenada0_2MapaParseado=mapaParseado.get(cor0_2);
                Parcela coordenada1_2MapaParseado=mapaParseado.get(cor1_2);
                Parcela coordenada2_2MapaParseado=mapaParseado.get(cor2_2);
                
                Rocoso Rocoso_0_0=new Rocoso(cor0_0);
                Tierra Tierra_1_0=new Tierra(cor1_0);
                Tierra Tierra_2_0=new Tierra(cor2_0);
                Pasarela Pasarela_0_1=new Pasarela(cor0_1);
                Pasarela Pasarela_1_1=new Pasarela(cor1_1);
                Pasarela Pasarela_2_1=new Pasarela(cor2_1);
                Tierra Tierra_0_2=new Tierra(cor0_2);
                Tierra Tierra_1_2=new Tierra(cor1_2);
                Tierra Tierra_2_2=new Tierra(cor2_2);
        
                
                assertEquals(Rocoso_0_0,coordenada0_0MapaParseado);
                assertEquals(Tierra_1_0,coordenada1_0MapaParseado);
                assertEquals(Tierra_2_0,coordenada2_0MapaParseado);
                assertEquals(Pasarela_0_1,coordenada0_1MapaParseado);
                assertEquals(Pasarela_1_1, coordenada1_1MapaParseado);
                assertEquals(Pasarela_2_1,coordenada2_1MapaParseado);
                assertEquals(Tierra_0_2,coordenada0_2MapaParseado);
                assertEquals(Tierra_1_2,coordenada1_2MapaParseado);
                assertEquals(Tierra_2_2,coordenada2_2MapaParseado);
    }
}
