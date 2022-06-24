package com.pattern.ddd.outbound.addressapi.service.implement;

import com.pattern.ddd.outbound.addressapi.client.AddressClient;
import com.pattern.ddd.outbound.addressapi.service.dto.AddressDTO;
import com.pattern.ddd.outbound.addressapi.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class AddressServiceImpl implements AddressService {

    private final AddressClient addressClient;

    @Autowired
    public AddressServiceImpl(AddressClient addressClient) {
        this.addressClient = addressClient;
    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) {
        return addressClient.create(addressDTO);
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO, Long id) {
        return addressClient.update(addressDTO, id);
    }

    @Override
    public AddressDTO delete(Long id) {
        return addressClient.delete(id);
    }

    @Override
    public AddressDTO findOne(Long id) {
        return addressClient.findOne(id);
    }

    @Override
    public Page<AddressDTO> findAll(Pageable pageable) {
        return addressClient.findAll(pageable);
    }
}
