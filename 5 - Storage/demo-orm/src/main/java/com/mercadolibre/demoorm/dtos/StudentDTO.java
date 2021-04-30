package com.mercadolibre.demoorm.dtos;

import lombok.Data;

@Data
public class StudentDTO {
    private Integer id;
    private String dni;
    private String name;
    private String lastName;
}
