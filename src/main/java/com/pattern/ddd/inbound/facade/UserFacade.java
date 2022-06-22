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
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import java.util.Objects;

@Component
public class UserFacade implements UserFacadeInterface {

    private final UserServiceInterface userService;
    private final UserMapper userMapper;
    private final OfficeMapper officeMapper;

    @Autowired
    public UserFacade(UserServiceInterface userService, UserMapper userMapper, OfficeMapper officeMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.officeMapper = officeMapper;
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        if(Objects.nonNull(userDTO)) {
            User user = userMapper.convertToEntity(userDTO);
            userService.userCreate(user);
            return userMapper.convertToDTO(user);
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
