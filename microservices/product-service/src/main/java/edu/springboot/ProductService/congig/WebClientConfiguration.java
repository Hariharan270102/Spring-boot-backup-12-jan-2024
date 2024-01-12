package edu.springboot.ProductService.congig;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfiguration
{
	@Bean
	@LoadBalanced
	public WebClient.Builder webclientBuilder() {
		return WebClient.builder();
	}
	

}