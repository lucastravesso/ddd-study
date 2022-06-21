package com.pattern.ddd.inbound.facade.interfaces;

import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfficeFacadeInterface {

    OfficeDTO officeCreate(OfficeDTO officeDTO);

    OfficeDTO officeUpdate(OfficeDTO officeDTO);

    OfficeDTO officeDelete(OfficeDTO officeDTO);

    OfficeDTO officeFindById(Integer officeId);

    Page<OfficeDTO> officeFindAll(Pageable pageable);
}
