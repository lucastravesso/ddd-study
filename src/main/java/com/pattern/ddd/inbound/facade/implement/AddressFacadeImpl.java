package com.pattern.ddd.inbound.facade.implement;

import com.pattern.ddd.inbound.facade.AddressFacade;
import com.pattern.ddd.inbound.facade.dto.AddressDTO;
import com.pattern.ddd.inbound.facade.mapper.AddressMapper;
import com.pattern.ddd.outbound.addressapi.service.AddressService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public class AddressFacadeImpl implements AddressFacade {

    private final AddressService addressService;

    private final AddressMapper addressMapper;

    public AddressFacadeImpl(AddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) {
        return addressMapper.convertToDto(addressService.create(addressMapper.convertToEntity(addressDTO)));
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO, Long id) {
        return addressMapper.convertToDto(addressService.update(addressMapper.convertToEntity(addressDTO), id));
    }

    @Override
    public AddressDTO delete(Long id) {
        return addressMapper.convertToDto(addressService.delete(id));
    }

    @Override
    public AddressDTO findOne(Long id) {
        return addressMapper.convertToDto(addressService.findOne(id));
    }

    @Override
    public Page<AddressDTO> findAll(Pageable pageable) {
        return addressService.findAll(pageable).map(addressMapper::convertToDto);
    }
}
