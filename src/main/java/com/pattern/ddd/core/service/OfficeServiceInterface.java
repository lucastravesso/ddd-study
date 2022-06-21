package com.pattern.ddd.core.service;

import com.pattern.ddd.core.entity.Office;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfficeServiceInterface {

    Office officeCreate(Office office);
    Office officeUpdate(Office office);
    Office officeDelete(Office office);
    Office officeFindById(Office office);
    Page<Office> officeFindAll(Pageable pageable);
}
