package com.pattern.ddd.service;

import com.pattern.ddd.entity.Office;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfficeServiceInterface {

    Office officeCreate(Office officeDTO);
    Office officeUpdate(Office officeDTO);
    Office officeDelete(Office officeDTO);
    Office officeFindById(Office officeDTO);
    Page<Office> officeFindAll(Pageable pageable);
}
