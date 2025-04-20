package com.spring.base.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

  @Bean
  public OpenAPI customOpenAPI() {
    return new OpenAPI()
        .info(new Info()
            .title("Spring REST API Example")
            .version("1.0.0")
            .description("This is a sample Spring Boot REST API documented using springdoc-openapi and Swagger UI.")
            .contact(new Contact()
                .name("Rosemberg Lima")
                .url("https://github.com/RosembergLima"))
            .license(new License()
                .name("Apache 2.0")
                .url("https://www.apache.org/licenses/LICENSE-2.0")));
  }

}
