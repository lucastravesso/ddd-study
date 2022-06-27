package com.pattern.ddd.outbound.addressapi.client;

import com.pattern.ddd.core.entity.Address;
import com.pattern.ddd.outbound.addressapi.service.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "addressapi", url ="http://localhost:8090/address")
public interface AddressClient {

    @PostMapping(value = "/new")
    Address create(@RequestBody Address address);

    @PutMapping(value = "/update/{id}")
    Address update(@RequestBody Address address, @PathVariable("id") Long id);

    @DeleteMapping(value = "/delete/{id}")
    Address delete(@PathVariable("id") Long id);

    @GetMapping(value = "/find/{id}")
    Address findOne(@PathVariable("id") Long id);

    @GetMapping(value = "/find")
    Page<Address> findAll(Pageable pageable);
}
