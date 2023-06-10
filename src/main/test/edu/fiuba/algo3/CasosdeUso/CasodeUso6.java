package edu.fiuba.algo3.CasosdeUso;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;
import edu.fiuba.algo3.models.Enemigos.Araña;
import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Enemigos.Hormiga;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class CasodeUso6 {    
    @Test
    public void Prueba01(){
              //Caso positivo

              Cordenada cordenaTorre=new Cordenada(2,2);
              Cordenada cordenaPasarela=new Cordenada(2,1);
      
              Queue<Pasarela> pasarelas = new LinkedList<>();
              var pasarela=new Pasarela(cordenaPasarela);
              pasarelas.add(pasarela);
              var enemigo=new Hormiga(pasarelas);
              var torre=new TorreBlanca(cordenaTorre);
      
              List<Enemigo> enemigos = new ArrayList<>();
              enemigos.add(enemigo);
      
              
              torre.atacar(enemigos);  
              torre.atacar(enemigos);     
              int energiaEnemigo=enemigo.getEnergia();
      
              assertEquals(energiaEnemigo,0);
    }
    @Test
    public void Prueba02(){
              //Caso positivo

              Cordenada cordenaTorre=new Cordenada(2,2);
              Cordenada cordenaPasarela=new Cordenada(2,1);
      
              Queue<Pasarela> pasarelas = new LinkedList<>();
              var pasarela=new Pasarela(cordenaPasarela);
              pasarelas.add(pasarela);
              var enemigo=new Araña(pasarelas);
              var torre=new TorrePlateada(cordenaTorre);
      
              List<Enemigo> enemigos = new ArrayList<>();
              enemigos.add(enemigo);
      
              
              torre.atacar(enemigos); 
              torre.atacar(enemigos);  
              torre.atacar(enemigos);      
              int energiaEnemigo=enemigo.getEnergia();
      
              assertEquals(energiaEnemigo,0);
    }
}
