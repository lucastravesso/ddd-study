package com.pattern.ddd.core.service;

import com.pattern.ddd.core.entity.Address;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressApiService {

    Address create(Address addressDTO);
    Address update(Address addressDTO, Long id);
    Address delete(Long id);
    Address findOne(Long id);
    Page<Address> findAll(Pageable pageable);
}
