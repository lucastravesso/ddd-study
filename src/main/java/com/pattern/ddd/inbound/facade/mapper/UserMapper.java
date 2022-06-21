package com.pattern.ddd.inbound.facade.mapper;

import com.pattern.ddd.core.entity.User;
import com.pattern.ddd.inbound.facade.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper getInstance = Mappers.getMapper(UserMapper.class);

    UserDTO convertToDTO(User user);

    User convertToEntity(UserDTO userDTO);

}
