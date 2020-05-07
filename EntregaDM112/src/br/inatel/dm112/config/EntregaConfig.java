package br.inatel.dm112.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import br.inatel.dm112.services.DeliveryService;

@Configuration
@EnableWebMvc
@ComponentScan("br.inatel.dm112")
public class EntregaConfig {

	@Bean
	public DeliveryService deliveryService() {
		return new DeliveryService();
	}

}
