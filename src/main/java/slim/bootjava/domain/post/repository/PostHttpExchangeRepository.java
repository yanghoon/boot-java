package slim.bootjava.domain.post.repository;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import reactor.core.publisher.Flux;
import slim.bootjava.domain.post.entity.Post;

/**
 * @see https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-http-interface
 */
@HttpExchange
public interface PostHttpExchangeRepository {
    
    @GetExchange("/posts")
    Flux<Post> findAll();

}
