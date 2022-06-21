package com.pattern.ddd.inbound.facade.dto;

import com.pattern.ddd.core.enums.OfficeList;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OfficeDTO extends DTOEntity{

    private OfficeList officeName;
    private Double officeSalary;
}
