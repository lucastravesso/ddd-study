package com.pattern.ddd.inbound.config;

import com.pattern.ddd.core.service.OfficeServiceInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackageClasses = {InboundConfig.class, OfficeServiceInterface.class})
public class InboundConfig {


}
