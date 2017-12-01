package net.gefco.cartaporte.util;

import java.util.HashMap;
import java.util.Map;

public class Form {
    
    private Map<Integer,Boolean> mapa = new HashMap<Integer, Boolean>();

    // KEY = {ruta.id} + "_" +  {entrega.id}
    private Map<String,Boolean> checksEntregas = new HashMap<String, Boolean>();
    
    public Map<Integer, Boolean> getMapa() {
          return mapa;
    }

    public void setMapa(Map<Integer, Boolean> mapa) {
          this.mapa = mapa;
    }

    public Map<String, Boolean> getChecksEntregas() {
          return checksEntregas;
    }

    public void setChecksEntregas(Map<String, Boolean> checksEntregas) {
          this.checksEntregas = checksEntregas;
    }


}

