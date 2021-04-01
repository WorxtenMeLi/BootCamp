package com.meli.linktracker.dtos;

import lombok.Data;

import java.util.List;
@Data
public class BibliotecaLinksDTO {
    int referencia;
    List<LinkDTO> links;

}
