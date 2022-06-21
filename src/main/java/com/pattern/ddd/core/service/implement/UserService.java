package com.pattern.ddd.core.service.implement;

import com.pattern.ddd.core.entity.Office;
import com.pattern.ddd.core.entity.User;
import com.pattern.ddd.core.repository.OfficeRepository;
import com.pattern.ddd.core.repository.UserRepository;
import com.pattern.ddd.core.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;


@Service
public class UserService implements UserServiceInterface {

    private UserRepository userRepository;

    private OfficeRepository officeRepository;

    public UserService(UserRepository userRepository, OfficeRepository officeRepository){
        this.userRepository = userRepository;
        this.officeRepository = officeRepository;
    }

    @Override
    public User userCreate(User user, Office office) {
        user.setIsActive(true);
        user.setUserOffice(officeRepository.findById(office.getId()).get());
        userRepository.saveAndFlush(user);

        return user;
    }

    @Override
    public User userUpdate(User user) {
        userRepository.saveAndFlush(user);
        return user;
    }

    @Override
    public User userDelete(User user) {
        user.setIsActive(true);
        userRepository.save(user);
        Office office = officeRepository.findById(user.getUserOffice().getId()).get();
        office.setIsActive(false);
        officeRepository.saveAndFlush(office);

        return user;
    }

    @Override
    public User userFindById(Integer userId) {
        User user = userRepository.findById(userId).get();
        user.setUserOffice(officeRepository.findById(user.getUserOffice().getId()).get());
        return user;
    }

    @Override
    public Page<User> userFindAll(Pageable pageable) {
        Page<User> users =  userRepository.findAll(pageable);
        users.forEach(u -> {
            u.setUserOffice(officeRepository.findById(u.getUserOffice().getId()).get());
        });
        return users;
    }
}