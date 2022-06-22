package com.pattern.ddd.inbound.facade.mapper;

import com.pattern.ddd.core.entity.User;
import com.pattern.ddd.inbound.facade.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO convertToDTO(User user);

    @Mapping(source = "email", target = "userEmail")
    User convertToEntity(UserDTO userDTO);

}
