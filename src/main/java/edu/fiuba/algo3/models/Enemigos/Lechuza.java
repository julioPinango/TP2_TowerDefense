package edu.fiuba.algo3.models.Enemigos;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Jugador;
import edu.fiuba.algo3.models.Log;
import edu.fiuba.algo3.models.Enemigos.Ataques.Ataque;
import edu.fiuba.algo3.models.Enemigos.Movimientos.Movimiento;
import edu.fiuba.algo3.models.Parcelas.Pasarela;

public class Lechuza extends Enemigo
{
    private Cordenada coordenadaActual;
    private Cordenada coordenadaObjetivo;

    public Lechuza(Queue<Pasarela> pasarelas,Movimiento mov)
    {
        this.Energia = 5;
        this.Velocidad = 5;

        this.nombre = "Lechuza";
        this.pasarelas=pasarelas; //se mueve por cualquier parcela
        this.movimiento=mov;


        List<Pasarela> listaPasarelas = new ArrayList<>(pasarelas);
        int tamaño = listaPasarelas.size();
        
        coordenadaActual=listaPasarelas.get(0).getCordenada();

        coordenadaObjetivo = listaPasarelas.get(tamaño - 1).getCordenada();
    }

    public void mover(Jugador jugador) {
        if (Cordenada.calcularDistancia(coordenadaActual.getX(), coordenadaActual.getY(),
         coordenadaObjetivo.getX(), coordenadaObjetivo.getY())<6)
            {
                Energia=0;
                llegoAlFinal=true;
            }
        else 
            {
                System.out.println("X:"+coordenadaActual.getX()+"Y:"+coordenadaActual.getY());

                coordenadaActual=movimiento.mover(coordenadaObjetivo,coordenadaActual);

                System.out.println("X:"+coordenadaActual.getX()+"Y:"+coordenadaActual.getY());

            }
           // volar();           
        
    }
    public void sumarEnemigoMuerto(Jugador jugador) {
    }

    public Cordenada getCordenada() {
        return coordenadaActual;
    }

    public void volar() {
        Integer mitadEnergia = 2;
        if (this.getEnergia() > mitadEnergia) 
            movimietoenL();
        else 
            movimientoenDiagonal();        
    }

    public boolean recibirAtaque(int danio) {
        Energia=Energia-danio;

        Integer mitadEnergia = 2;        
        
        this.movimiento=movimiento.obtenerMovimiento(Energia);

        return true;
    }

    private void movimientoenDiagonal() {        
        int distanciaX = coordenadaObjetivo.getX() - coordenadaActual.getX();
        int distanciaY = coordenadaObjetivo.getY() - coordenadaActual.getY();

        // Calcular el movimiento en X
        int pasoX = (distanciaX > 0) ? Math.min(distanciaX, 5) : Math.max(distanciaX, -5);

        // Calcular el movimiento en Y
        int pasoY = (distanciaY > 0) ? Math.min(distanciaY, 5) : Math.max(distanciaY, -5);

        int newCoordenadaX = coordenadaActual.getX() + pasoX;
        int newCoordenadaY = coordenadaActual.getY() + pasoY;

        coordenadaActual = new Cordenada(newCoordenadaX, newCoordenadaY);
    }

    private void movimietoenL() {  
            // Mover en forma de L hacia la meta
            int movimientosX = 2;
            int movimientosY = 3;

            int newCoordenadaX = coordenadaActual.getX();
            int newCoordenadaY = coordenadaActual.getY();

            if (coordenadaActual.getX() < coordenadaObjetivo.getX()) 
                newCoordenadaX=(coordenadaActual.getX() + movimientosX);
            else 
                newCoordenadaX=(coordenadaActual.getX() - movimientosX);                

            if (coordenadaActual.getY() < coordenadaObjetivo.getY())
                newCoordenadaY=(coordenadaActual.getY() + movimientosY);
            else 
                newCoordenadaY=(coordenadaActual.getY() - movimientosY);                
            

            coordenadaActual=new Cordenada(newCoordenadaX, newCoordenadaY);
    }
  

}
