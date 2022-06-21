package com.pattern.ddd.inbound.controller;

import com.pattern.ddd.inbound.facade.dto.OfficeDTO;
import com.pattern.ddd.inbound.facade.dto.UserDTO;
import com.pattern.ddd.inbound.facade.interfaces.UserFacadeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {


    private final UserFacadeInterface userFacade;

    private final Pageable pageable;

    @Autowired
    public UserController(UserFacadeInterface userFacade, Pageable pageable) {
        this.userFacade = userFacade;
        this.pageable = pageable;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO, @RequestBody OfficeDTO officeDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userFacade.create(userDTO, officeDTO));
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(userFacade.userFindAll(pageable));
    }
}
