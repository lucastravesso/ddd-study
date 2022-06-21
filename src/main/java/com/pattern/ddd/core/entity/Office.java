package com.pattern.ddd.core.entity;

import com.pattern.ddd.core.enums.OfficeList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Office extends DomainEntity{

    private OfficeList officeName;
    private Double officeSalary;


}
