package com.pattern.ddd.core.service;

import com.pattern.ddd.core.entity.Office;
import com.pattern.ddd.core.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserServiceInterface {

    User userCreate(User user);
    User userUpdate(User user);
    User userDelete(User user);
    User userFindById(Integer userId);
    Page<User> userFindAll(Pageable pageable);

}
