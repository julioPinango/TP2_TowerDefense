package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import java.util.Objects;

public class Rocoso extends Parcela
{
   public Rocoso(Cordenada cordenada)
   {
      this.cordenadas=cordenada;
      this.TipoDeParcela="Rocoso";
   }

   public boolean puedoConstruirDefensa(Defensa defensaNueva) {
      return defensaNueva.puedoConstruirEnRocoso();
   }


}