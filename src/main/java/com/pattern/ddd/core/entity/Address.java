package com.pattern.ddd.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String numero;
    private Boolean isActive;

    private User user;

}
