package com.pattern.ddd.core.config;

import com.pattern.ddd.core.service.OfficeServiceInterface;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackageClasses = {CoreConfig.class})
@EnableJpaRepositories(basePackages = "com.pattern.ddd.core.repository")
public class CoreConfig {


}
