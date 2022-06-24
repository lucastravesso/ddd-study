package com.pattern.ddd.inbound.facade.implement;

import com.pattern.ddd.core.service.UserService;

import com.pattern.ddd.inbound.facade.UserFacade;
import com.pattern.ddd.inbound.facade.dto.UserDTO;

import com.pattern.ddd.inbound.facade.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserFacadeImpl(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @Override
    public UserDTO create(UserDTO userDTO) {
        return userMapper.convertToDTO(userService.userCreate(userMapper.convertToEntity(userDTO)));
    }

    @Override
    public UserDTO update(UserDTO userDTO, Integer id) {
        return userMapper.convertToDTO(userService.userUpdate(userMapper.convertToEntity(userDTO),id));
    }

    @Override
    public UserDTO userDelete(Integer id) {
        return userMapper.convertToDTO(userService.userDelete(id));
    }

    @Override
    public UserDTO userFindById(Integer userId) {
        return userMapper.convertToDTO(userService.userFindById(userId));
    }

    @Override
    public Page<UserDTO> userFindAll(Pageable pageable) {
        return userService.userFindAll(pageable).map(userMapper::convertToDTO);
    }
}