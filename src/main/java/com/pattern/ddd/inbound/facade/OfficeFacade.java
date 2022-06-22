package com.pattern.ddd.inbound.facade;

import com.pattern.ddd.core.entity.Office;
import com.pattern.ddd.core.service.OfficeServiceInterface;
import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import com.pattern.ddd.inbound.facade.interfaces.OfficeFacadeInterface;
import com.pattern.ddd.inbound.facade.mapper.OfficeMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;


import java.util.Objects;

@Component
public class OfficeFacade implements OfficeFacadeInterface {

    private final OfficeServiceInterface officeService;

    private final OfficeMapper officeMapper;

    public OfficeFacade(OfficeMapper officeMapper, OfficeServiceInterface officeService) {

        this.officeMapper = officeMapper;
        this.officeService = officeService;
    }

    @Override
    public OfficeDTO officeCreate(OfficeDTO officeDTO) {
        if(Objects.nonNull(officeDTO)){
            Office office = officeMapper.convertToEntity(officeDTO);
            officeService.officeCreate(office);
            return officeMapper.convertToDTO(office);
        }
        return null;
    }

    @Override
    public OfficeDTO officeUpdate(OfficeDTO officeDTO, Integer id) {
        if(Objects.nonNull(officeDTO)){
            Office office = officeMapper.convertToEntity(officeDTO);
            office.setId(officeService.officeFindById(id).getId());
            officeService.officeUpdate(office);
            return officeMapper.convertToDTO(office);
        }
        return null;
    }

    @Override
    public OfficeDTO officeDelete(Integer id) {
        if(id != null){
            return officeMapper.convertToDTO(officeService.officeDelete(id));
        }
        return null;
    }

    @Override
    public OfficeDTO officeFindById(Integer officeId) {
        if(officeId != null){
            OfficeDTO officeDTO = officeMapper.convertToDTO(officeService.officeFindById(officeId));
            return officeDTO;
        }
        return null;
    }

    @Override
    public Page<OfficeDTO> officeFindAll(Pageable pageable) {
        return officeService.officeFindAll(pageable).map(officeMapper::convertToDTO);
    }
}
