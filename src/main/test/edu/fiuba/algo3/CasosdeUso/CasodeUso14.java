package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Mapa;
import edu.fiuba.algo3.models.Parser;

public class CasodeUso14 {    
    @Test
    public void Prueba01()throws Exception{
      
        String path2="src/main/java/edu/fiuba/algo3/models/ArchivosJson/mapaRoto.json";
        Parser parser = new Parser();

       assertThrows(Exception.class, () -> {parser.leerMapa(path2);});
    }

}
