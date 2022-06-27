package com.pattern.ddd.core.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends DomainEntity{

    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private LocalDateTime userBornDate;
    @OneToOne
    @JoinColumn(name = "user_office_id")
    private Office userOffice;

    private transient List<Address> addressList;

}
