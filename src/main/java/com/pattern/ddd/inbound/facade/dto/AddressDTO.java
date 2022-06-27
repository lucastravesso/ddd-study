package com.pattern.ddd.inbound.facade.dto;

import lombok.Data;

@Data
public class AddressDTO {

    private Integer id;
    private String logradouro;
    private String complemento;
    private String cep;
    private String cidade;
    private String estado;
    private String numero;
    private Boolean isActive;

    private Integer userId;
}
