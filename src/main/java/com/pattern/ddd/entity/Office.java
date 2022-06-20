package com.pattern.ddd.entity;

import com.pattern.ddd.enums.OfficeList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Office extends DomainEntity{

    private OfficeList officeName;
    private Double officeSalary;

}
