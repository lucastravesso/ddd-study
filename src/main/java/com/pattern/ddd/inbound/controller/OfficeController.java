package com.pattern.ddd.inbound.controller;

import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import com.pattern.ddd.inbound.facade.interfaces.OfficeFacadeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "office")
public class OfficeController {

    private final OfficeFacadeInterface officeFacade;

    @Autowired
    public OfficeController(OfficeFacadeInterface officeFacade) {
        this.officeFacade = officeFacade;
    }

    @PostMapping
    public ResponseEntity<OfficeDTO> createOffice(@RequestBody OfficeDTO officeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(officeFacade.officeCreate(officeDTO));
    }
}
