package com.pattern.ddd.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User  extends DomainEntity{

    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private Date userBornDate;
    @OneToOne
    @JoinColumn(name = "user_office_id")
    private Office userOffice;


}
