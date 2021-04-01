package com.meli.linktracker.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
public class LinkDTO {
    private int ref;
    private String url;
    private int contador;
    private Boolean estado;
    public LinkDTO(){
        contador=0;
        estado=true;
    }
    public LinkDTO(String link) {
        this.url = link;
        contador=0;
        estado=true;
    }
    public void incrementar(){
        contador++;
    }
    public void setID(BibliotecaLinksDTO biblioteca){
        ref=biblioteca.getReferencia()+1;
    }
}
