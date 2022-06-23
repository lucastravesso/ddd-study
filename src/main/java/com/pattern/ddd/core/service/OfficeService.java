package com.pattern.ddd.core.service;

import com.pattern.ddd.core.entity.Office;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OfficeService {

    Office officeCreate(Office office);
    Office officeUpdate(Office office, Integer id);
    Office officeDelete(Integer id);
    Office officeFindById(Integer id);
    Page<Office> officeFindAll(Pageable pageable);
}
