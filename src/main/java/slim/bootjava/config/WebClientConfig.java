package slim.bootjava.config;

import java.net.InetSocketAddress;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import reactor.netty.http.client.HttpClient;
import reactor.netty.transport.ProxyProvider;
import slim.bootjava.domain.post.repository.PostHttpExchangeRepository;

@Configuration
public class WebClientConfig {

    private String baseUrl = "https://jsonplaceholder.typicode.com";

    private boolean proxyEnable = false;
    private String proxyHost = "127.0.0.1";
    private int proxyPost = 8080;

    @Bean
    public PostHttpExchangeRepository postHttpExchangeRepository(WebClient postWebClient) {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
            .builder(WebClientAdapter.forClient(postWebClient))
            .build();

        return factory.createClient(PostHttpExchangeRepository.class);
    }

    @Bean
    public WebClient postWebClient(WebClient.Builder builder) {
        builder = builder.clone();

        builder.baseUrl(baseUrl);

        if (proxyEnable) {
            builder.clientConnector(new ReactorClientHttpConnector(connector()));
        }

        return builder.build();
    }

    public HttpClient connector() {
        return HttpClient.create().proxy(options -> {
            options.type(ProxyProvider.Proxy.HTTP).address(new InetSocketAddress(proxyHost, proxyPost));
        });
    }
}
