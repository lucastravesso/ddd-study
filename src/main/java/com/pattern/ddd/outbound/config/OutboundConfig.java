package com.pattern.ddd.outbound.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan(basePackageClasses = OutboundConfig.class)
public class OutboundConfig {

}
