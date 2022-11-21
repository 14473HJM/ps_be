package ar.edu.utn.frc.tup.ps.psappbe.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDocConfig {

    private static final String LOCAL_URL = "http://localhost:8080";

    private static final String GITHUB_URL = "https://14473hjm.github.io/ps_be";

    @Bean
    public OpenAPI openApi (
        @Value("${app.name}") String appName,
        @Value("${app.desc}") String appDescription,
        @Value("${app.version}") String appVersion){

        Info info = new Info()
                .title(appName)
                .version(appVersion)
                .description(appDescription)
                .contact(
                        new Contact()
                                .name("Hernán Jesús Morais")
                                .email("104473@tecnicatura.frc.utn.edu.ar"));
        // String url =

        Server server = new Server()
                .url(LOCAL_URL)
                .description(appDescription);

        return new OpenAPI()
                .components(new Components())
                .info(info)
                .addServersItem(server);
    }

    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper) {
        return new ModelResolver(objectMapper);
    }

}
