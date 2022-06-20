package com.pattern.ddd.service;

import com.pattern.ddd.entity.Office;
import com.pattern.ddd.entity.User;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface UserServiceInterface {

    User userCreate(User userDTO, Office officeDTO);
    User userUpdate(User userDTO);
    User userDelete(User userDTO);
    User userFindById(Integer userId);
    Page<User> userFindAll(Pageable pageable);

}
