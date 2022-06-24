package com.pattern.ddd.inbound.controller;

import com.pattern.ddd.inbound.facade.AddressFacade;
import com.pattern.ddd.outbound.addressapi.client.dto.AddressDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "address")
public class AddressController {

    private final AddressFacade addressFacade;

    @Autowired
    public AddressController(AddressFacade addressFacade) {
        this.addressFacade = addressFacade;
    }

    @PostMapping(value = "/new")
    public ResponseEntity<AddressDTO> create(@RequestBody AddressDTO addressDTO){
        return ResponseEntity.status(HttpStatus.OK).body(addressFacade.create(addressDTO));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity<AddressDTO> delete(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(addressFacade.delete(id));
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<AddressDTO> update(@RequestBody AddressDTO addressDTO, @PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(addressFacade.update(addressDTO,id));
    }

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<AddressDTO> findOneById(@PathVariable("id") Long id){
        return ResponseEntity.status(HttpStatus.OK).body(addressFacade.findOne(id));
    }

    @GetMapping(value = "/find")
    public ResponseEntity<Page<AddressDTO>> findAll(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body((addressFacade.findAll(pageable)));
    }
}
