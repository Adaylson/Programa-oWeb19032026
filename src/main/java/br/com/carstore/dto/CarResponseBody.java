package br.com.carstore.dto;

import java.util.ArrayList;
import java.util.List;

public class CarResponseBody {
    private List<CarDTO> lista;

    public CarResponseBody(List<CarDTO> lista){
        this.lista = lista;
    }

    public List<CarDTO> getLista() {
        return lista;
    }

    public void setLista(List<CarDTO> lista) {
        this.lista = lista;
    }
}
