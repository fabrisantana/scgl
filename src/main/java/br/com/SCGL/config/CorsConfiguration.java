/*
package br.com.SCGL.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
@EnableWebMvc
public class CorsConfiguration implements WebMvcConfigurer{

	@Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {		
		    @Override
		    public void addCorsMappings(CorsRegistry registry) {
		    	
		        registry.addMapping("/**")
		            .allowedOrigins("http://localhost:8080*")
		            //.allowedHeaders("http://localhost:8080")
		            .allowedMethods("*")
		            .allowCredentials(true);
		    }
        };
	}
}
*/
    
    