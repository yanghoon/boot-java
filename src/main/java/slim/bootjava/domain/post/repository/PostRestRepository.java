package slim.bootjava.domain.post.repository;

import org.springframework.web.reactive.function.client.WebClient;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import slim.bootjava.domain.common.repository.RestRepository;
import slim.bootjava.domain.post.entity.Post;

@RestRepository
@RequiredArgsConstructor
public class PostRestRepository {

    private final String URI_POSTS = "/posts";

    private final WebClient postWebClient;

    public Flux<Post> findAll() {
        // return postWebClient.get().uri(URI_POSTS).retrieve().bodyToFlux(Post.class);
        return getFlux(URI_POSTS, Post.class);
    }

    private <T> Flux<T> getFlux(String uri, Class<T> bodyType) {
        return postWebClient.get().uri(uri).retrieve().bodyToFlux(bodyType);
    }
    
}
