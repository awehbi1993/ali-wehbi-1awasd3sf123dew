package anyrwrtest.micro;

//import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.security.SecurityScheme;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
//	@Bean
//	public OpenAPI springOpenAPI() {
//		return new OpenAPI()
//				.components(new Components().addSecuritySchemes("bearer-JWT",
//																new SecurityScheme().type(SecurityScheme.Type.HTTP)
//																.scheme("bearer").bearerFormat("JWT")
//																.in(SecurityScheme.In.HEADER).name("Authorization")))
//				.info(new Info().title("anywr test").description("anywr test"))
//				.addSecurityItem(new SecurityRequirement().addList("bearer-JWT", Arrays.asList("read", "write")));
//	}

}
