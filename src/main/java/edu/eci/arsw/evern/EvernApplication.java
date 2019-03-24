package edu.eci.arsw.evern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("edu.eci")
public class EvernApplication {
	public static void main(String[] args) {
		SpringApplication.run(EvernApplication.class, args);
	}
}