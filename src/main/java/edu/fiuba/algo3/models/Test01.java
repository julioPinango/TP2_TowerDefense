package edu.fiuba.algo3.models;

/*import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;
import edu.fiuba.algo3.models.Defensas.Estados.Estado;
import edu.fiuba.algo3.models.Enemigos.Ataque;
import edu.fiuba.algo3.models.Enemigos.Lechuza;

public class Test01 {    
   
    public static void Prueba01(){
        //Pruebo que la lechuza se mueve en forma de L

            String path="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapa.json"; 
            String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/enemigosLechuza.json";    
            Parser parser=new Parser();       

            Mapa mapa=new Mapa(path2, path, parser);
    
            var list= parser.formarCamino(path);

            var camino=mapa.inicializarCaminoDeEnemigos(list);          
    
           /* Lechuza lechuza=new Lechuza(camino);

            lechuza.recibirAtaque(4);            

            lechuza.volar();                        

            var cordenadax=lechuza.getCordenada().getX();
                        var cordenaday=lechuza.getCordenada().getY(); 

    }
}*/
