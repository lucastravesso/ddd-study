package com.pattern.ddd.inbound.facade.dto;

import com.pattern.ddd.core.entity.Office;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO extends DTOEntity{

    private String firstName;
    private String lastName;
    private String email;
    private LocalDateTime bornDate;
    private OfficeDTO officeDTO;
}
