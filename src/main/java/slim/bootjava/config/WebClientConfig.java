package slim.bootjava.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    private String baseUrl = "https://jsonplaceholder.typicode.com";

    @Bean
    public WebClient postWebClient() {
        return WebClient.create(baseUrl);
    }

}
