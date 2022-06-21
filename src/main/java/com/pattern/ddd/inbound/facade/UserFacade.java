package com.pattern.ddd.inbound.facade;

import com.pattern.ddd.core.entity.Office;
import com.pattern.ddd.core.entity.User;
import com.pattern.ddd.core.service.UserServiceInterface;
import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import com.pattern.ddd.inbound.facade.dto.UserDTO;

import com.pattern.ddd.inbound.facade.interfaces.UserFacadeInterface;
import com.pattern.ddd.inbound.facade.mapper.OfficeMapper;
import com.pattern.ddd.inbound.facade.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.Objects;

@Component
public class UserFacade implements UserFacadeInterface {

    final UserServiceInterface userService;
    UserMapper userMapper;
    OfficeMapper officeMapper;

    @Autowired
    public UserFacade(UserServiceInterface userService) {
        this.userService = userService;
    }

    @Override
    public UserDTO create(UserDTO userDTO, OfficeDTO officeDTO) {
        if(Objects.nonNull(userDTO)) {
            User user = userMapper.convertToEntity(userDTO);
            if (Objects.nonNull(officeDTO)) {
                Office office = officeMapper.convertToEntity(officeDTO);
                userService.userCreate(user, office);
                return userMapper.convertToDTO(user);
            }
            return null;
        }
        return null;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        if(Objects.nonNull(userDTO)) {
            User user = userMapper.convertToEntity(userDTO);
            userService.userUpdate(user);
            return userMapper.convertToDTO(user);
        }
        return null;
    }

    @Override
    public UserDTO userDelete(UserDTO userDTO) {
        if(Objects.nonNull(userDTO)){
            User user = userMapper.convertToEntity(userDTO);
            userService.userDelete(user);
            return userMapper.convertToDTO(user);
        }
        return null;
    }

    @Override
    public UserDTO userFindById(Integer userId) {
        UserDTO userDTO = userMapper.convertToDTO(userService.userFindById(userId));
        if(Objects.nonNull(userDTO)){
            return userDTO;
        }
        return null;
    }

    @Override
    public Page<UserDTO> userFindAll(Pageable pageable) {
        Page<User> users = userService.userFindAll(pageable);
        if(!users.isEmpty()){
            return users.map(userMapper::convertToDTO);
        }
        return null;
    }
}