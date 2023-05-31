package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Cordenada;

public abstract class Parcela
{
   // private contenido 
   protected int idParcela ;
   protected Cordenada cordenadas ;

   public boolean puedoConstruirDefensa() {
      return false;
   }
}
