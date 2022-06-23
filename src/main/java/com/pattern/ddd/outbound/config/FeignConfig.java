package com.pattern.ddd.outbound.config;


import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = {"com.pattern.ddd.outbound.swapi.client"})
public class FeignConfig {
}
