package com.pattern.ddd.inbound.facade.implement;

import com.pattern.ddd.core.service.OfficeService;
import com.pattern.ddd.inbound.facade.OfficeFacade;
import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import com.pattern.ddd.inbound.facade.mapper.OfficeMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class OfficeFacadeImpl implements OfficeFacade {

    private final OfficeService officeService;

    private final OfficeMapper officeMapper;

    public OfficeFacadeImpl(OfficeMapper officeMapper, OfficeService officeService) {
        this.officeMapper = officeMapper;
        this.officeService = officeService;
    }

    @Override
    public OfficeDTO officeCreate(OfficeDTO officeDTO) {
        return officeMapper.convertToDTO(officeService.officeCreate(officeMapper.convertToEntity(officeDTO)));
    }

    @Override
    public OfficeDTO officeUpdate(OfficeDTO officeDTO, Integer id) {
        return officeMapper.convertToDTO(officeService.officeUpdate(officeMapper.convertToEntity(officeDTO), id));
    }

    @Override
    public OfficeDTO officeDelete(Integer id) {
        return officeMapper.convertToDTO(officeService.officeDelete(id));
    }

    @Override
    public OfficeDTO officeFindById(Integer officeId) {
        return officeMapper.convertToDTO(officeService.officeFindById(officeId));
    }

    @Override
    public Page<OfficeDTO> officeFindAll(Pageable pageable) {
        return officeService.officeFindAll(pageable).map(officeMapper::convertToDTO);
    }
}