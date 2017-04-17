package com.example;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class WebProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebProjectApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner printAll(ApplicationContext ctx) {
         return args -> {
            System.out.println("All beans provided by Spring Boot:");
            String[] beanNames = ctx.getBeanDefinitionNames();
            for (String beanName : beanNames)
                System.out.println(beanName);
        };
		
    }
	
	@Bean
	public CommandLineRunner printMessage(HelloWorld component){
		return args->{
			System.out.println("Print Message :");
			component.setMessage("Hello Component");
			component.printMessage();
		};
	}
}

