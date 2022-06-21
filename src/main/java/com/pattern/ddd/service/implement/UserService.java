package com.pattern.ddd.service.implement;

import com.pattern.ddd.entity.Office;
import com.pattern.ddd.entity.User;
import com.pattern.ddd.repository.OfficeRepository;
import com.pattern.ddd.repository.UserRepository;
import com.pattern.ddd.service.UserServiceInterface;
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
    public User userCreate(User userDTO, Office officeDTO) {
        userDTO.setIsActive(true);
        userDTO.setUserOffice(officeRepository.findById(officeDTO.getId()).get());
        userRepository.saveAndFlush(userDTO);

        return userDTO;
    }

    @Override
    public User userUpdate(User userDTO) {
        return null;
    }

    @Override
    public User userDelete(User userDTO) {
        userDTO.setIsActive(true);
        userRepository.save(userDTO);
        Office office = officeRepository.findById(userDTO.getUserOffice().getId()).get();
        office.setIsActive(false);
        officeRepository.saveAndFlush(office);

        return userDTO;
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
