package com.pattern.ddd.inbound.controller;

import com.pattern.ddd.inbound.facade.UserFacade;
import com.pattern.ddd.inbound.facade.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value ="user")
public class UserController {

    private final UserFacade userFacade;

    @Autowired
    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.status(HttpStatus.CREATED).body(userFacade.create(userDTO));
    }

    @GetMapping
    public ResponseEntity<Page<UserDTO>> findAll(Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(userFacade.userFindAll(pageable));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> findOneById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userFacade.userFindById(id));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<UserDTO> deleteById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(userFacade.userDelete(id));
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<UserDTO> updateById(@RequestBody UserDTO user, @PathVariable("id") Integer id){
        return  ResponseEntity.status(HttpStatus.OK).body(userFacade.update(user, id));
    }
}
