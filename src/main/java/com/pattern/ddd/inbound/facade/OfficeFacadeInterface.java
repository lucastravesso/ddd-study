package com.pattern.ddd.inbound.facade;

import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfficeFacadeInterface {

    OfficeDTO officeCreate(OfficeDTO officeDTO);

    OfficeDTO officeUpdate(OfficeDTO officeDTO);

    OfficeDTO officeDelete(OfficeDTO officeDTO);

    OfficeDTO officeFindById(OfficeDTO officeDTO);

    Page<OfficeDTO> officeFindAll(Pageable pageable);
}
