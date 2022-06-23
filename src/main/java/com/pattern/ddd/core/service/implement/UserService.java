package com.pattern.ddd.core.service.implement;

import com.pattern.ddd.core.entity.User;
import com.pattern.ddd.core.repository.OfficeRepository;
import com.pattern.ddd.core.repository.UserRepository;
import com.pattern.ddd.core.service.UserServiceInterface;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;


@Service
public class UserService implements UserServiceInterface {

    private final UserRepository userRepository;

    private final OfficeRepository officeRepository;

    private final OfficeService officeService;

    public UserService(UserRepository userRepository, OfficeRepository officeRepository, OfficeService officeService) {
        this.userRepository = userRepository;
        this.officeRepository = officeRepository;
        this.officeService = officeService;
    }

    @Override
    public User userCreate(User user) {
        user.setIsActive(true);
        user.setUserOffice(officeRepository.findById(user.getUserOffice().getId()).get());
        userRepository.saveAndFlush(user);

        return user;
    }

    @Override
    public User userUpdate(User user, Integer id) {
        User optUser = userRepository.findById(id).orElse(null);
        if(optUser != null){
            aplicarDiferencas(user, optUser);
            userRepository.saveAndFlush(optUser);
        }
        return null;
    }

    private void aplicarDiferencas(User user, User optUser) {
        if(Objects.nonNull(user.getUserOffice())){
            officeService.officeUpdate(user.getUserOffice(), optUser.getUserOffice().getId());
        }
        else{user.setUserOffice(optUser.getUserOffice());}
        if(user.getUserEmail() == null){optUser.setUserEmail(optUser.getUserEmail());}
        else{optUser.setUserEmail(user.getUserEmail());}
        if(user.getUserBornDate() == null){optUser.setUserBornDate(optUser.getUserBornDate());}
        else{optUser.setUserBornDate(user.getUserBornDate());}
        if(user.getUserFirstName() == null){optUser.setUserFirstName(optUser.getUserFirstName());}
        else{optUser.setUserFirstName(user.getUserFirstName());}
        if(user.getUserLastName() == null){optUser.setUserLastName(optUser.getUserLastName());}
        else{optUser.setUserLastName(user.getUserLastName());}
        if(user.getIsActive() == null){optUser.setIsActive(optUser.getIsActive());}
        else{optUser.setIsActive(user.getIsActive());}
    }

    @Override
    public User userDelete(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            user.get().setIsActive(!user.get().getIsActive());
            return userRepository.saveAndFlush(user.get());
        }
        return null;
    }

    @Override
    public User userFindById(Integer userId) {
        User user = userRepository.findById(userId).get();
        user.setUserOffice(officeRepository.findById(user.getUserOffice().getId()).get());
        return user;
    }

    @Override
    public Page<User> userFindAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        users.forEach(u -> {
            u.setUserOffice(officeRepository.findById(u.getUserOffice().getId()).get());
        });
        return users;
    }
}
