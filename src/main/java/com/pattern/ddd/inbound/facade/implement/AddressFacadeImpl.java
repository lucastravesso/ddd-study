package com.pattern.ddd.inbound.facade.implement;

import com.pattern.ddd.inbound.facade.AddressFacade;
import com.pattern.ddd.outbound.addressapi.service.dto.AddressDTO;
import com.pattern.ddd.outbound.addressapi.service.AddressService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class AddressFacadeImpl implements AddressFacade {

    private final AddressService addressService;

    public AddressFacadeImpl(AddressService addressService) {
        this.addressService = addressService;
    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) {
        return addressService.create(addressDTO);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO, Long id) {
        return addressService.update(addressDTO, id);
    }

    @Override
    public AddressDTO delete(Long id) {
        return addressService.delete(id);
    }

    @Override
    public AddressDTO findOne(Long id) {
        return addressService.findOne(id);
    }

    @Override
    public Page<AddressDTO> findAll(Pageable pageable) {
        return addressService.findAll(pageable);
    }
}
