package com.saludo.test.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Greeting {
    private int id;
    private String mssg;
    private String type;

}
