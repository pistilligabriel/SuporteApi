package br.com.api_suporte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ApiSuporteApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiSuporteApplication.class, args);
    }


    @Bean
    public WebMvcConfigurer corsLocalConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                        .allowedHeaders("Origin","X-Requested-With", "Content-Type", "Accept", "Authorization")
                        .allowedOrigins("http://localhost:4200");
            }
        };
    }

}
