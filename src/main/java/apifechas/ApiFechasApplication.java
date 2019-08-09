package apifechas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import apifechas.config.SwaggerConfiguration;


@SpringBootApplication
@Import(SwaggerConfiguration.class)
public class ApiFechasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiFechasApplication.class, args);
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                 .addResourceLocations("classpath:/META-INF/resources/");
 }

}
