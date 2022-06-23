package com.pattern.ddd;

import com.pattern.ddd.core.config.CoreConfig;
import com.pattern.ddd.inbound.config.InboundConfig;
import com.pattern.ddd.outbound.config.OutboundConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DddApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(new Class[]{
				DddApplication.class,
				CoreConfig.class,
				InboundConfig.class,
				OutboundConfig.class
		}, args);

	}

}
