package com.pattern.ddd.outbound.addressapi.service.implement;

import com.pattern.ddd.core.entity.Address;
import com.pattern.ddd.outbound.addressapi.client.AddressClient;
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
    public Address create(Address address) {
        return addressClient.create(address);
    }

    @Override
    public Address update(Address address, Long id) {
        return addressClient.update(address, id);
    }

    @Override
    public Address delete(Long id) {
        return addressClient.delete(id);
    }

    @Override
    public Address findOne(Long id) {
        return addressClient.findOne(id);
    }

    @Override
    public Page<Address> findAll(Pageable pageable) {
        return addressClient.findAll(pageable);
    }
}
