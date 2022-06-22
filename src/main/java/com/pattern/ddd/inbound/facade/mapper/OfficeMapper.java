package com.pattern.ddd.inbound.facade.mapper;

import com.pattern.ddd.core.entity.Office;
import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface OfficeMapper {

    OfficeMapper INSTANCE = Mappers.getMapper(OfficeMapper.class);

    OfficeDTO convertToDTO(Office office);

    Office convertToEntity(OfficeDTO officeDTO);

}
