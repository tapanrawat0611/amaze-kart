package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AmazeKartApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmazeKartApplication.class, args);
	}
	
//	 @Bean
//	    public ApplicationRunner runner(Publisher publisher) {
//	        return args -> {
//	            Thread.sleep(3000);
//	            for (int i = 0; i < 2; i++) {
//	                publisher.publishMessage(String.valueOf(i));
//	            }
//	        };
//	    }

}
