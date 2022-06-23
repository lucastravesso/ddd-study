package com.pattern.ddd.outbound.swapi.client;

import com.pattern.ddd.outbound.swapi.dto.PersonDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "swapi", url ="https://swapi.dev/api/")
public interface SwapiClient {

    @RequestMapping(method = RequestMethod.GET, value = "/people/{id}")
    PersonDTO getPerson(@PathVariable("id") Integer id);
}
