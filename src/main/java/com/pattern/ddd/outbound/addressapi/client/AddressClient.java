package com.pattern.ddd.outbound.addressapi.client;

import com.pattern.ddd.outbound.addressapi.client.dto.AddressDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "addressapi", url ="http://localhost:8090/address")
public interface AddressClient {

    @PostMapping(value = "/new")
    AddressDTO create(@RequestBody AddressDTO addressDTO);

    @PutMapping(value = "/update/{id}")
    AddressDTO update(@RequestBody AddressDTO addressDTO, @PathVariable("id") Long id);

    @DeleteMapping(value = "/delete/{id}")
    AddressDTO delete(@PathVariable("id") Long id);

    @GetMapping(value = "/find/{id}")
    AddressDTO findOne(@PathVariable("id") Long id);

    @GetMapping(value = "/find")
    Page<AddressDTO> findAll(Pageable pageable);
}
