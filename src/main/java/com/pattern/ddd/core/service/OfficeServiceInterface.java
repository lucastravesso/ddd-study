package com.pattern.ddd.core.service;

import com.pattern.ddd.core.entity.Office;
import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfficeServiceInterface {

    Office officeCreate(Office office);
    Office officeUpdate(Office office);
    Office officeDelete(Integer id);
    Office officeFindById(Integer id);
    Page<Office> officeFindAll(Pageable pageable);
}
