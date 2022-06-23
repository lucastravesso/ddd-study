package com.pattern.ddd.inbound.facade;

import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfficeFacade {

    OfficeDTO officeCreate(OfficeDTO officeDTO);

    OfficeDTO officeUpdate(OfficeDTO officeDTO, Integer id);

    OfficeDTO officeDelete(Integer id);

    OfficeDTO officeFindById(Integer officeId);

    Page<OfficeDTO> officeFindAll(Pageable pageable);
}
