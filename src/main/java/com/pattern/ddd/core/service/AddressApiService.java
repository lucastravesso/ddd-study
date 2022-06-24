package com.pattern.ddd.core.service;

import com.pattern.ddd.outbound.addressapi.service.dto.AddressDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressApiService {

    AddressDTO create(AddressDTO addressDTO);
    AddressDTO update(AddressDTO addressDTO, Long id);
    AddressDTO delete(Long id);
    AddressDTO findOne(Long id);
    Page<AddressDTO> findAll(Pageable pageable);
}
