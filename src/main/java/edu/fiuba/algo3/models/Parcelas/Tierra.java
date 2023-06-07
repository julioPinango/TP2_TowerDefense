package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import java.util.Objects;

public class Tierra extends Parcela
{
   private boolean libre=true;


   public Tierra(Cordenada cordenada)
   {
      this.cordenadas=cordenada;
      this.TipoDeParcela="Tierra";
   }    
   // private Defensa Models defensa;
   public boolean puedoConstruirDefensa(Defensa defensaNueva) {
      boolean retorno=defensaNueva.puedoConstruirEnTierra(this.libre);        
      this.libre=false;
      return retorno;
   }
   public boolean equals(Object obj) {
      if (this == obj) {
          return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
          return false;
      }
      Tierra otra = (Tierra) obj;
      return Objects.equals(cordenadas, otra.cordenadas) &&
             Objects.equals(TipoDeParcela, otra.TipoDeParcela);
  }

}