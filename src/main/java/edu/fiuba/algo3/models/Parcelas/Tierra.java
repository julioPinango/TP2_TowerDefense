package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;

public class Tierra extends Parcela
{
   private boolean libre=true;


   public Tierra(Cordenada cordenada)
   {
      this.cordenadas=cordenada;
   }    
   // private Defensa Models defensa;
    public boolean puedoConstruirDefensa(Defensa defensaNueva) {
        boolean retorno=defensaNueva.puedoConstruirEnTierra(this.libre);        
        this.libre=false;
        return retorno;
     }

}