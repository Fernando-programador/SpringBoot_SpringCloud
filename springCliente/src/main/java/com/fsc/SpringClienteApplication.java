package com.fsc;




import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;



@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@RibbonClient(name = "produto")
public class SpringClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringClienteApplication.class, args);
	}




	

}
