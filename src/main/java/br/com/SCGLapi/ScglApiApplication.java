package br.com.SCGLapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ScglApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScglApiApplication.class, args);
		//System.out.print(new BCryptPasswordEncoder().encode("123"));
	}
	/*
	@Configuration
	public class CorsConfiguration {
	    @Bean
	    public WebMvcConfigurer corsConfigurer() {
	        return new WebMvcConfigurer() {
	            @Override
	            public void addCorsMappings(CorsRegistry registry) {
	                registry.addMapping("/**").allowedOrigins("http://localhost:8080");
	            }
	            
	        };
	    }
	}*/
}
