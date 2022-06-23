package com.pattern.ddd.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = {"com.pattern.ddd.core"})
@EnableJpaRepositories(basePackages = "com.pattern.ddd.core.repository")
public class CoreConfig {


}
