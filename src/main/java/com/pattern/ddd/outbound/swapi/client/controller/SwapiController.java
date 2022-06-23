package com.pattern.ddd.outbound.swapi.client.controller;

import com.pattern.ddd.outbound.swapi.client.SwapiClient;
import com.pattern.ddd.outbound.swapi.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "starwars")
public class SwapiController {

    private final SwapiClient swapiClient;

    @Autowired
    public SwapiController(SwapiClient swapiClient) {
        this.swapiClient = swapiClient;
    }

    @GetMapping(value = "personagens/{id}")
    public ResponseEntity<PersonDTO> getOneById(@PathVariable("id") Integer id){
        return ResponseEntity.status(HttpStatus.OK).body(swapiClient.getPerson(id));
    }
}
