package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;

public abstract class Parcela
{

   protected Cordenada cordenadas ;

   public boolean puedoConstruirDefensa(Defensa defensaNueva) {
      return false;
   }

   public Cordenada getCordenada() {
      return cordenadas;
  }
}
