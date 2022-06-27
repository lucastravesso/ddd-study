package com.pattern.ddd.inbound.facade;


import com.pattern.ddd.inbound.facade.dto.AddressDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AddressFacade {

    AddressDTO create(AddressDTO addressDTO);
    AddressDTO update(AddressDTO addressDTO, Long id);
    AddressDTO delete(Long id);
    AddressDTO findOne(Long id);
    Page<AddressDTO> findAll(Pageable pageable);

}
