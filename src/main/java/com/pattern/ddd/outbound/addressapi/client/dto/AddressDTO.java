package com.pattern.ddd.outbound.addressapi.client.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Integer id;

    private String logradouro;

    private String complemento;

    private String cep;

    private String cidade;

    private String estado;

    private String numero;

    private Boolean isActive;
}
