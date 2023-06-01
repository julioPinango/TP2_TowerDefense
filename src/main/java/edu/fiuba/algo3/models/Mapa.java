package edu.fiuba.algo3.models;

import edu.fiuba.algo3.models.Enemigos.Enemigo;
import edu.fiuba.algo3.models.Parcelas.Parcela;
import javafx.scene.layout.ColumnConstraints;
import edu.fiuba.algo3.models.Defensas.Defensa;
import edu.fiuba.algo3.models.Defensas.TorreBlanca;
import edu.fiuba.algo3.models.Defensas.TorrePlateada;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.text.StyledEditorKit.BoldAction;


public class Mapa
{
    private List<Parcela> listaParcelas;
    private List<Defensa> listaDefensas;
    private List<Enemigo> listaEnemigos;
    private int Columna;
    private int Fila;
    private Parcela[][] Parcelas;
    private Map<String, Defensa> tiposDeTorre = new HashMap<>();
    private int contadorHormigas=0; 

    public Mapa(int columnas, int filas){
        this.Columna=columnas;
        this.Fila=filas;
        this.Parcelas=new Parcela[filas][columnas];       
    }
    public void SiguienteTurno() {
        
    }

    private void colocarTipoParcela(Parcela parcela, int x, int y){
        this.Parcelas[x][y]=parcela;
    }
    boolean colocarDefensaEnEstaPosicion(int x,int y, String tipo){

        Cordenada cordenada=new Cordenada(x, y);

        tiposDeTorre.put("Torre Blanca", new TorreBlanca(cordenada));
        tiposDeTorre.put("Torre Plateada", new TorrePlateada(cordenada));

        Defensa defensaNueva=this.tiposDeTorre.get(tipo);

        return (this.Parcelas[x][y].puedoConstruirDefensa(defensaNueva));
    }
    public List<Enemigo> getEnemigos() {
        return listaEnemigos;
    }
    public boolean quedanEnemigos()
    {
        return getEnemigos().size()==0;
    }

}