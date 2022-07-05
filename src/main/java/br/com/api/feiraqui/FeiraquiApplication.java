package br.com.api.feiraqui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class FeiraquiApplication {

	public static void main(String[] args) {

		SpringApplication.run(FeiraquiApplication.class, args);
	}

}
