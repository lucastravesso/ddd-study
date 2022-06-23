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
public class UserDTO {

    private String userFirstName;
    private String userLastName;
    private String email;
    private LocalDateTime bornDate;
    private OfficeDTO userOffice;
}
