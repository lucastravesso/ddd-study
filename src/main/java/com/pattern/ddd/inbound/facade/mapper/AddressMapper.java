package com.pattern.ddd.inbound.facade.mapper;

import com.pattern.ddd.core.entity.Address;
import com.pattern.ddd.inbound.facade.dto.AddressDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressDTO convertToDto(Address Address);
    Address convertToEntity(AddressDTO addressDTO);


}
