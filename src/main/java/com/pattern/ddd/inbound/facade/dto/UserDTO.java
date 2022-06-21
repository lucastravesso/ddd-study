package com.pattern.ddd.inbound.facade.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO extends DTOEntity{

    private String firstName;
    private String lastName;
    private String email;

}
