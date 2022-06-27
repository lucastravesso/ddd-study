package com.pattern.ddd.core.service;

import com.pattern.ddd.core.entity.Address;
import com.pattern.ddd.core.entity.Office;
import com.pattern.ddd.core.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User userCreate(User user);
    User userUpdate(User user, Integer id);
    User userDelete(Integer id);
    User userFindById(Integer userId);
    Page<User> userFindAll(Pageable pageable);

}
