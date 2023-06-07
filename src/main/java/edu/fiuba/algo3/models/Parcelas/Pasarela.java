package edu.fiuba.algo3.models.Parcelas;

import edu.fiuba.algo3.models.Cordenada;
import edu.fiuba.algo3.models.Defensas.Defensa;
import java.util.Objects;

public class Pasarela extends Parcela
{

   public Pasarela(Cordenada cordenada)
   {
      this.cordenadas=cordenada;
      this.TipoDeParcela="Pasarela";
   }

   public boolean puedoConstruirDefensa(Defensa defensaNueva) {
      return defensaNueva.puedoConstruirEnPasarela();
   }
   public boolean equals(Object obj) {
      if (this == obj) {
          return true;
      }
      if (obj == null || getClass() != obj.getClass()) {
          return false;
      }
      Pasarela otra = (Pasarela) obj;
      return Objects.equals(cordenadas, otra.cordenadas) &&
             Objects.equals(TipoDeParcela, otra.TipoDeParcela);
  }
}