package com.pattern.ddd.outbound.addressapi.outbound;

import com.pattern.ddd.outbound.addressapi.client.dto.AddressDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressService {

    AddressDTO create(AddressDTO addressDTO);
    AddressDTO update(AddressDTO addressDTO, Long id);
    AddressDTO delete(Long id);
    AddressDTO findOne(Long id);
    Page<AddressDTO> findAll(Pageable pageable);


}
