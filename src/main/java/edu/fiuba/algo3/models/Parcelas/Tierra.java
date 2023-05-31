package edu.fiuba.algo3.models.Parcelas;

public class Tierra extends Parcela
{

    private boolean libre=true;
   // private Defensa Models defensa;
    public boolean puedoConstruirDefensa() {
        return libre;
     }

}