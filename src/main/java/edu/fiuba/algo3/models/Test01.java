package edu.fiuba.algo3.models;


import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Juego;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;
import edu.fiuba.algo3.models.Enemigos.Lechuza;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import edu.fiuba.algo3.models.Parcelas.Pasarela;
import edu.fiuba.algo3.models.Parcelas.Rocoso;
import edu.fiuba.algo3.models.Parcelas.Tierra;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Test01 {    
   
    public static void Prueba01() throws IOException{
   
        //Pruebo que la lechuza se mueve en forma de L

            String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json";    
    
            var camino=Parser.formarCamino(path);          
    
            Lechuza lechuza=new Lechuza(camino);

            lechuza.volar();


           // assertEquals(lechuza.getCordenada().getX(),4);
           // assertEquals(lechuza.getCordenada().getY(),4);


    }
}
